package controller;

import dal.StaffDAO;
import model.Staff;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig; 
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part; 

@WebServlet("/UpdateProfileServlet")
@MultipartConfig(
    fileSizeThreshold = 1024 * 1024 * 2,
    maxFileSize = 1024 * 1024 * 10,      
    maxRequestSize = 1024 * 1024 * 50    
)
public class UpdateProfileServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        Staff currentAccount = (Staff) session.getAttribute("account");

        if (currentAccount == null) {
            response.sendRedirect("login.jsp");
            return;
        }

        try {
            String fullName = request.getParameter("fullName");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String gender = request.getParameter("gender");
            String address = request.getParameter("address");
            String birthday_S = request.getParameter("birthday");

            Date birthday = null;
            if (birthday_S != null && !birthday_S.isEmpty()) {
                birthday = Date.valueOf(birthday_S);
            }

            String avatarPath = currentAccount.getAvatar(); 
            Part filePart = request.getPart("avatarFile");
            
            if (filePart != null && filePart.getSize() > 0) {
                String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString();
                if (fileName != null && !fileName.isEmpty()) {
                    String uploadPath = getServletContext().getRealPath("") + File.separator + "images" + File.separator + "avatar";
                    File uploadDir = new File(uploadPath);
                    if (!uploadDir.exists()) uploadDir.mkdirs();

                    String saveFileName = currentAccount.getStaffId() + "_" + System.currentTimeMillis() + "_" + fileName;
                    filePart.write(uploadPath + File.separator + saveFileName);
                    avatarPath = "images/avatar/" + saveFileName;
                }
            }

            Staff updatedStaff = new Staff();
            updatedStaff.setStaffId(currentAccount.getStaffId());
            updatedStaff.setFullName(fullName);
            updatedStaff.setEmail(email);
            updatedStaff.setPhone(phone);
            updatedStaff.setGender(gender);
            updatedStaff.setAddress(address);
            updatedStaff.setBirthday(birthday);
            updatedStaff.setAvatar(avatarPath);

            StaffDAO dao = new StaffDAO();
            dao.updateInfo(updatedStaff);

            Staff refreshAccount = dao.getStaffById(currentAccount.getStaffId());
            session.setAttribute("account", refreshAccount);

            request.setAttribute("message", "Cập nhật hồ sơ thành công!");
            request.getRequestDispatcher("profile.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error", "Lỗi: " + e.getMessage());
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        }
    }
}