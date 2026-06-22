package controller;

import java.io.IOException;
import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Staff;


@WebFilter(urlPatterns = { 
    "/AddStaffServlet", 
    "/DeleteStaffServlet", 
    "/UpdateStaffServlet"
}) 
public class AuthorizationFilter extends HttpFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;

        HttpSession session = request.getSession();
        Staff account = (Staff) session.getAttribute("account");

        if (account != null && account.getRoleId() == 2) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "home.jsp"); 
        }
    }

    public void init(FilterConfig fConfig) throws ServletException {}
    public void destroy() {}
}