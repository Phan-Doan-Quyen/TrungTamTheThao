package controller;

import dal.SportDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteSportServlet")
public class DeleteSportServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sportId_S = request.getParameter("sportId");
		int sportId = Integer.parseInt(sportId_S);
		SportDAO cd = new SportDAO();
		cd.delete(sportId);
		response.sendRedirect("SportServlet");
	}
}
