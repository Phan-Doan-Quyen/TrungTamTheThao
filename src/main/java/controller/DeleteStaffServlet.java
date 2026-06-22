package controller;

import dal.StaffDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteStaffServlet")
public class DeleteStaffServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String staffId_S = request.getParameter("staffId");
		int staffId = Integer.parseInt(staffId_S);
		
		StaffDAO cd = new StaffDAO();
		cd.delete(staffId);
		response.sendRedirect("StaffServlet");
	}
}
