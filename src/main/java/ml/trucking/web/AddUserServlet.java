package ml.trucking.web;

import ml.trucking.dao.ConnectPool;
import ml.trucking.dao.UserDao;
import ml.trucking.services.UserDaoImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.sql.*;


@WebServlet("/adduser")
public class AddUserServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AddUserServlet.class);
    private Connection connection;



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            connection = ConnectPool.getDataSource().getConnection();

        } catch (SQLException e) {
            LOG.error("Some problem was occurred while getting connection to BD \n" + e);
        }
        resp.setContentType("text/html;charset=UTF-8");
        req.setCharacterEncoding("UTF-8");
        String name = req.getParameter("username");
        String phone = req.getParameter("userphone");
        String email = req.getParameter("useremail");
        String password = req.getParameter("userpassword");


        try {

            UserDao dao = new UserDaoImpl(connection);
            dao.addUser(name, phone, email, password);
            LOG.info("user added");
        } finally {
            try {
                connection.close();
                LOG.info("connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/afterRegister.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            LOG.error("afterRegister not find");
            e.printStackTrace();
        }


    }
}