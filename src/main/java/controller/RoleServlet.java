package controller;

import dal.RoleDAO;
import model.Role;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RoleServlet")
public class RoleServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RoleDAO cd = new RoleDAO();
		List<Role> listRole = cd.getRoleAll();
		request.setAttribute("dataRole", listRole);
		request.getRequestDispatcher("role.jsp").forward(request, response);
	}
}
