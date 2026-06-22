package controller;

import dal.RoleDAO;
import dal.StaffDAO;
import model.Role;
import model.Staff;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/StaffServlet")
public class StaffServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        StaffDAO s = new StaffDAO();
        List<Staff> listStaff = s.getStaffAll();
        request.setAttribute("dataStaff", listStaff);

        RoleDAO r = new RoleDAO();
		List<Role> listRole = r.getRoleAll();
		request.setAttribute("dataRole", listRole);
        
        request.getRequestDispatcher("stafflist.jsp").forward(request, response); 
    }
}

