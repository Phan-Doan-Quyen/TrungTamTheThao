package controller;

import dal.SportDAO;
import model.Sport;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SportServlet")
public class SportServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SportDAO cd = new SportDAO();
		List<Sport> listSport = cd.getSportAll();
		request.setAttribute("dataSport", listSport);
		request.getRequestDispatcher("sportlist.jsp").forward(request, response);
	}
}