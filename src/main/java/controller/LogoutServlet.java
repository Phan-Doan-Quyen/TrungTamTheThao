package controller;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // 1. Lấy phiên làm việc hiện tại
        HttpSession session = request.getSession();

        // 2. Hủy session (Xóa attribute "account", "dataRole"...)
        session.invalidate();

        // 3. (Tùy chọn) Nếu bạn muốn đăng xuất là xoá luôn cả Cookie nhớ mật khẩu
        // thì bỏ comment đoạn code dưới đây. 
        // Còn mặc định ta giữ Cookie để lần sau họ vào lại vẫn nhớ User/Pass.
        /*
        Cookie cu = new Cookie("cUser", "");
        Cookie cp = new Cookie("cPass", "");
        Cookie cr = new Cookie("cRem", "");
        cu.setMaxAge(0);
        cp.setMaxAge(0);
        cr.setMaxAge(0);
        response.addCookie(cu);
        response.addCookie(cp);
        response.addCookie(cr);
        */

        // 4. Chuyển hướng về trang đăng nhập
        response.sendRedirect("LoginServlet");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
