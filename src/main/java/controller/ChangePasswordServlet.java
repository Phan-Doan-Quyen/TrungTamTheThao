package controller;

import dal.StaffDAO;
import dal.MD5;
import model.Staff;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/ChangePasswordServlet")
public class ChangePasswordServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        Staff currentAccount = (Staff) session.getAttribute("account");

        if (currentAccount == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        String currentPass = request.getParameter("currentPass");
        String newPass = request.getParameter("newPass");
        String confirmPass = request.getParameter("confirmPass");

        String error = null;
        
        boolean isCurrentPassCorrect = false;
        
        if (currentPass.equals(currentAccount.getPassWord())) {
            isCurrentPassCorrect = true;
        }
        else if (MD5.getMd5(currentPass).equals(currentAccount.getPassWord())) {
        	isCurrentPassCorrect = true;
        }
        
        if (!isCurrentPassCorrect) {
            error = "Mật khẩu hiện tại không đúng!";
        }
        else if (!newPass.equals(confirmPass)) {
            error = "Mật khẩu xác nhận không khớp!";
        }

        if (error != null) {
            request.setAttribute("error", error);
            
            request.setAttribute("activeTab", "password"); 
            
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } else {
        	String newPassHash = MD5.getMd5(newPass);
        	
            StaffDAO dao = new StaffDAO();
            dao.changePassword(currentAccount.getStaffId(), newPassHash);

            currentAccount.setPassWord(newPassHash);
            session.setAttribute("account", currentAccount);

            request.setAttribute("message", "Đổi mật khẩu thành công!");
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        }
    }
}