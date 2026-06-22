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

@WebServlet("/UpdateStaffServlet")
public class UpdateStaffServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StaffDAO sd = new StaffDAO();
        String id_raw = request.getParameter("id");

        if (id_raw != null && !id_raw.isEmpty()) {
            try {
                int id = Integer.parseInt(id_raw);
                Staff s = sd.getStaffById(id);
                request.setAttribute("staffEdit", s);
            } catch (Exception e) {
                System.out.println(e);
            }
        }
        
        RoleDAO r = new RoleDAO();
		List<Role> listRole = r.getRoleAll();
		request.setAttribute("dataRole", listRole);

        List<Staff> listStaff = sd.getStaffAll();
        request.setAttribute("dataStaff", listStaff);

        request.getRequestDispatcher("stafflist.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StaffDAO sd = new StaffDAO();

        String staffId_S = request.getParameter("staffId");
        String userName = request.getParameter("userName");
        String passWord = request.getParameter("passWord");
        String fullName = request.getParameter("fullName");
        String avatar = request.getParameter("avatar");
        String birthday = request.getParameter("birthday");
        String gender = request.getParameter("gender");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        String roleId_S = request.getParameter("roleId");
        
        int staffId = Integer.parseInt(staffId_S);
        int roleId = Integer.parseInt(roleId_S);

        Staff s = new Staff(
                staffId,
                userName,
                passWord,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                roleId
        );

        sd.update(s);
        response.sendRedirect("StaffServlet");
    }
}
