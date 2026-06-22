package controller;

import dal.SportDAO;
import dal.SportFieldDAO;
import model.Sport;
import model.SportField;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/UpdateSportFieldServlet")
public class UpdateSportFieldServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SportFieldDAO cd = new SportFieldDAO();
		String id_raw = request.getParameter("id");
	    if (id_raw != null && !id_raw.isEmpty()) {
	        try {
	            int id = Integer.parseInt(id_raw);
	            SportField s = cd.getSportFieldById(id);
	            request.setAttribute("sportEdit", s);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	    
	    SportDAO s = new SportDAO();
		List<Sport> listSport = s.getSportAll();
		request.setAttribute("dataSport", listSport);
		
	    List<SportField> listSportF = cd.getSportFieldAll();
	    request.setAttribute("dataSportF", listSportF);
	    request.getRequestDispatcher("sportfieldlist.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SportFieldDAO cd = new SportFieldDAO();
		String id_S = request.getParameter("sportFieldId");
		String name = request.getParameter("sportFieldName");
		String sportid_S = request.getParameter("sportId");
		String describe = request.getParameter("description");
		String image = request.getParameter("image");
		String status = request.getParameter("status");
		String price_S = request.getParameter("price");
		int id, sportid, price;
		id = Integer.parseInt(id_S);
		sportid = Integer.parseInt(sportid_S);
		price = Integer.parseInt(price_S);
		SportField c = new SportField(id, name, sportid, describe, image, status, price);
		cd.update(c);
		response.sendRedirect("SportFieldServlet");
	}
}
