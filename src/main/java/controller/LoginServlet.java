package controller;

import dal.RoleDAO;
import dal.MD5;
import dal.StaffDAO;
import model.Role;
import model.Staff;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String u = request.getParameter("userName");
        String p = request.getParameter("passWord");
        String r = request.getParameter("remember");
        
        StaffDAO dao = new StaffDAO();
        Staff account = dao.checkLogin(u, p);

        if (account == null) {
            String pHash = MD5.getMd5(p);
            account = dao.checkLogin(u, pHash);
        }
        
        if (account != null) {
            HttpSession session = request.getSession();
            session.setAttribute("account", account);

        	RoleDAO rl = new RoleDAO();
            List<Role> listRole = rl.getRoleAll();
            session.setAttribute("dataRole", listRole);

            Cookie cu = new Cookie("cUser", u);
            Cookie cp = new Cookie("cPass", p);
            Cookie cr = new Cookie("cRem", r);

            if (r != null) {
                int age = 60 * 60 * 24 * 7; 
                cu.setMaxAge(age);
                cp.setMaxAge(age);
                cr.setMaxAge(age);
            } else {
                cu.setMaxAge(0);
                cp.setMaxAge(0);
                cr.setMaxAge(0);
            }

            response.addCookie(cu);
            response.addCookie(cp);
            response.addCookie(cr);

            response.sendRedirect("HomeServlet"); // Hoặc StaffServlet tùy trang chủ của bạn

        } else {
            request.setAttribute("error", "Tên đăng nhập hoặc mật khẩu không đúng!");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
