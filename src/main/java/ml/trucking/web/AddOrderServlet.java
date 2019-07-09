package ml.trucking.web;

import ml.trucking.dao.ConnectPool;

import ml.trucking.model.Order;
import ml.trucking.model.State;
import ml.trucking.model.User;

import ml.trucking.services.AddressDaoImpl;
import ml.trucking.services.InvoiceDaoImpl;
import ml.trucking.services.OrderDaoImpl;

import org.apache.log4j.Logger;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

@WebServlet("/addorder")
public class AddOrderServlet extends HttpServlet {

    private static final Logger LOG = Logger.getLogger(AddOrderServlet.class);

    private Connection connection;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        int limit1 = Integer.parseInt(req.getParameter("limit1"));
        int limit2 = Integer.parseInt(req.getParameter("limit2"));
        if (limit1 != 0) {
            try {
                connection = ConnectPool.getDataSource().getConnection();

            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            resp.setContentType("text/html");

            try {

                OrderDaoImpl dao = new OrderDaoImpl(connection);
                List<Order> list = dao.getAll(limit1, limit2);
                HttpSession session = req.getSession(true);
                session.setAttribute("lists", list);


            } finally {
                try {
                    connection.close();
                    LOG.info("connection admin close");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/admin.jsp");
            try {
                try {
                    dispatcher.forward(req, resp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (ServletException e) {
                LOG.error("cabinet not find");
                e.printStackTrace();
            }


        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {


        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String type = req.getParameter("usertype");
        Integer weight = Integer.parseInt(req.getParameter("userweight"));
        String date = req.getParameter("userdate");
        String addressFrom = req.getParameter("useraddress1");
        String addressWhere = req.getParameter("useraddress2");
        Integer distance = Integer.parseInt(req.getParameter("userdistance"));


        double sum = weight * distance / 10 + 200;
        int price = (int) sum;
        HttpSession session = req.getSession(true);
        session.setAttribute("price", price);
        Integer id = (Integer) session.getAttribute("userId");
        try {
            connection = ConnectPool.getDataSource().getConnection();

            connection.setAutoCommit(false);


            OrderDaoImpl orderDao = new OrderDaoImpl(connection);


            orderDao.addOrder(id, type, weight, date);
            LOG.info("order add");
            Order order = new Order();
            Integer orderId = order.getId();
            session.setAttribute("orderId", orderId);

            AddressDaoImpl dao = new AddressDaoImpl(connection);

            dao.addAddress(orderId, addressFrom, addressWhere, distance);


            LOG.info("address add");
            InvoiceDaoImpl invoiceDao = new InvoiceDaoImpl(connection);
            invoiceDao.addInvoice(orderId, price, String.valueOf(State.notPaid));
            LOG.info("invoice add");
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
     finally

    {
        try {
            connection.close();
            LOG.info("connection closed");
        } catch (SQLException e) {
            e.printStackTrace();
            LOG.error("already not");
        }
    }


        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/cabinet.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            LOG.error("cabinet not find");
            e.printStackTrace();
        }
    }
}
