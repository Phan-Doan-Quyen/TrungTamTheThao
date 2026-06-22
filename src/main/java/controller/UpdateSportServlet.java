package controller;

import dal.SportDAO;
import model.Sport;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/UpdateSportServlet")
public class UpdateSportServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SportDAO cd = new SportDAO();
		String id_raw = request.getParameter("id");
	    if (id_raw != null && !id_raw.isEmpty()) {
	        try {
	            int id = Integer.parseInt(id_raw);
	            Sport s = cd.getSportById(id);
	            request.setAttribute("sportEdit", s);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	    List<Sport> listSport = cd.getSportAll();
	    request.setAttribute("dataSport", listSport);
	    request.getRequestDispatcher("sportlist.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SportDAO cd = new SportDAO();
		String id_S = request.getParameter("sportId");
		String name = request.getParameter("sportName");
		String describe = request.getParameter("description");
		int id;
		id = Integer.parseInt(id_S);
		Sport c = new Sport(id, name, describe);
		cd.update(c);
		response.sendRedirect("SportServlet");
	}
}
