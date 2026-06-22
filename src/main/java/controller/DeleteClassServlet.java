package controller;

import dal.ClassDAO;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteClassServlet")
public class DeleteClassServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String classId_S = request.getParameter("classId");
		int classId = Integer.parseInt(classId_S);
		ClassDAO cd = new ClassDAO();
		cd.delete(classId);
		response.sendRedirect("ClassServlet");
	}
}
