package controller;

import dal.RoleDAO;
import model.Role;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddRoleServlet")
public class AddRoleServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoleDAO cd = new RoleDAO();
		String roleId_S = request.getParameter("roleId");
		String role = request.getParameter("role");
		int roleId;
		roleId = Integer.parseInt(roleId_S);
		Role c = cd.getRoleById(roleId);
		if (c == null) {
			c = new Role(roleId, role);
			cd.insert(c);
			response.sendRedirect("RoleServlet");
		} else {
			String error = "ID = " + roleId + " Đã tồn tại, xin mời nhập ID khác";
			request.setAttribute("error", error);
			java.util.List<Role> listRole = cd.getRoleAll(); 
		    request.setAttribute("dataRole", listRole);
			request.getRequestDispatcher("role.jsp").forward(request, response);
		}
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("role.jsp").forward(request, response);
    }
}
