package ml.trucking.web;

import ml.trucking.dao.ConnectPool;

import ml.trucking.services.MessageDaoImpl;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

@WebServlet("/addmessage")
public class AddMessageServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(AddMessageServlet.class);
    private Connection connection;



    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            connection = ConnectPool.getDataSource().getConnection();

        } catch (SQLException e) {
            LOG.error("Some problem was occurred while getting connection to BD \n" + e);
        }
        req.setCharacterEncoding("UTF-8");
        String email = req.getParameter("useremail");
        String message = req.getParameter("usermessage");


        try {

            MessageDaoImpl dao = new MessageDaoImpl(connection);
            dao.addMessage(email, message);

        } finally {
            try {
                connection.close();
                LOG.info("connection addmessage close");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/jsp/afterMessage.jsp");
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }
}
