package controller;

import dal.RoleDAO;
import dal.StaffDAO;
import model.Role;
import model.Staff;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddStaffServlet")
public class AddStaffServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StaffDAO sd = new StaffDAO();

        String staffId_S = request.getParameter("staffId");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String roleId_S = request.getParameter("roleId");

        String fullName = null;
        String avatar = null;
        java.sql.Date birthday = null;
        String gender = null;
        String phone = null;
        String email = null;
        String address = null;
        
        int staffId = Integer.parseInt(staffId_S);
        int roleId = Integer.parseInt(roleId_S);

        Staff s = sd.getStaffById(staffId);

        if (s == null) {
            s = new Staff(staffId, userName, passWord, fullName, avatar, birthday, gender, phone, email, address, roleId);
            sd.insert(s);
            response.sendRedirect("StaffServlet");
        } else {
            String error = "Staff ID = " + staffId + " đã tồn tại, vui lòng nhập ID khác";
            request.setAttribute("error", error);

            RoleDAO r = new RoleDAO();
    		List<Role> listRole = r.getRoleAll();
    		request.setAttribute("dataRole", listRole);
            
            List<Staff> listStaff = sd.getStaffAll();
            request.setAttribute("dataStaff", listStaff);

            request.getRequestDispatcher("stafflist.jsp").forward(request, response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("stafflist.jsp").forward(request, response);
    }
}
