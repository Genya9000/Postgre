package ml.trucking.web;

import org.apache.log4j.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/language")
public class LanguageServlet extends HttpServlet {
    private static final Logger LOG = Logger.getLogger(LanguageServlet.class);
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
String locale = req.getParameter("locale");

    req.getServletContext().setAttribute("locale", locale);

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
        dispatcher.forward(req, resp);
        LOG.info("locale changed");
}

    }

