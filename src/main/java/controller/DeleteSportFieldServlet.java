package controller;

import dal.SportFieldDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteSportFieldServlet")
public class DeleteSportFieldServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sportFieldId_S = request.getParameter("sportFieldId");
		int sportFieldId = Integer.parseInt(sportFieldId_S);
		SportFieldDAO cd = new SportFieldDAO();
		cd.delete(sportFieldId);
		response.sendRedirect("SportFieldServlet");
	}
}
