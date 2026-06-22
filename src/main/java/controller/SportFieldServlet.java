package controller;

import dal.SportDAO;
import model.Sport;
import dal.SportFieldDAO;
import model.SportField;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SportFieldServlet")
public class SportFieldServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SportFieldDAO cd = new SportFieldDAO();
		SportDAO s = new SportDAO();
		List<Sport> listSport = s.getSportAll();
		List<SportField> listSportF = cd.getSportFieldAll();
		request.setAttribute("dataSport", listSport);
		request.setAttribute("dataSportF", listSportF);
		request.getRequestDispatcher("sportfieldlist.jsp").forward(request, response);
	}
}
