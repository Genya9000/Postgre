package ml.trucking.web;

import ml.trucking.dao.ConnectPool;
import ml.trucking.services.InvoiceDaoImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;


    @WebServlet("/logout")
    public class PayServlet extends HttpServlet{

        private static final Logger LOG = Logger.getLogger(PayServlet.class);

        private Connection connection;









        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) {

            try {
                connection = ConnectPool.getDataSource().getConnection();

            } catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            String state = req.getParameter("state");
            if ("paid".equals(state)){
                HttpSession session = req.getSession(true);
                session.setAttribute("state", state);
                InvoiceDaoImpl invoiceDao= new InvoiceDaoImpl(connection);
                Integer orderId = (Integer) session.getAttribute("orderId");
                invoiceDao.updateInvoice(orderId);
                LOG.info("bills paid");
            }
            RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/cabinet.jsp");
            try {
                try {
                    dispatcher.forward(req, resp);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (ServletException e) {

                e.printStackTrace();
            }
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        }
    }

