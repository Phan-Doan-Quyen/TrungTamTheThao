package controller;

import dal.SportDAO;
import model.Sport;
import dal.ClassDAO;
import model.Class;
import dal.SportFieldDAO;
import model.SportField;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ClassServlet")
public class ClassServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		ClassDAO c = new ClassDAO();
		List<Class> listClass = c.getClassAll();
		request.setAttribute("dataClass", listClass);
		
		SportDAO s = new SportDAO();
		List<Sport> listSport = s.getSportAll();
		request.setAttribute("dataSport", listSport);
		
		SportFieldDAO cd = new SportFieldDAO();
		List<SportField> listSportF = cd.getSportFieldAll();
		request.setAttribute("dataSportF", listSportF);
		
		request.getRequestDispatcher("classlist.jsp").forward(request, response);
	}
}
