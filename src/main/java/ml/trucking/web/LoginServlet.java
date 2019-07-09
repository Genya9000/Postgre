package ml.trucking.web;

import ml.trucking.dao.ConnectPool;
import ml.trucking.dao.UserDao;
import ml.trucking.model.User;

import ml.trucking.services.UserDaoImpl;
import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.IOException;
import java.sql.*;


@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(LoginServlet.class);
    private Connection connection;
    private static String page;


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)  {
        String a = req.getParameter("a");
        HttpSession session = req.getSession(false);

        if ("exit".equals(a) && (session != null)) {
            session.removeAttribute("userId");
            session.removeAttribute("orderId");

            session.invalidate();
            LOG.info("user logout");

            try {
                resp.sendRedirect("index.jsp");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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
        String email = req.getParameter("useremail");
        String password = req.getParameter("userpassword");


        try {

            UserDao dao = new UserDaoImpl(connection);
            User user = dao.getUser(email, password);
if (user==null ) {


    LOG.info("Invalid email or Password");
        page = "/jsp/errorLogin.jsp";


}
else      if ("admin@i.ua".equals(email)){
    page="/jsp/admin.jsp";


}
else  {
    Integer id = user.getId();
    HttpSession session = req.getSession(true);
    session.setAttribute("userId", id);
    session.setAttribute("userName", user.getName());
    Cookie idCookie = new Cookie("userId", Integer.toString(id));
    resp.addCookie(idCookie);
    LOG.info("new user login");
     page="/jsp/cabinet.jsp";
}




        } finally {
            try {
                connection.close();
                LOG.info("connection closed");
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(page);
        try {
            dispatcher.forward(req, resp);
        } catch (ServletException e) {
            LOG.error("cabinet not find");
            e.printStackTrace();
        }


    }
}