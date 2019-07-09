package ml.trucking.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig)  {
        this.filterConfig = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {


        HttpServletRequest req = (HttpServletRequest) request;

        HttpSession session = req.getSession(false);

        if (session != null && !session.isNew()) {
            chain.doFilter(request, response);
        } else {

            RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
            dispatcher.forward(request, response);
        }
    }

    @Override
    public void destroy() {
        this.filterConfig = null;
    }
}