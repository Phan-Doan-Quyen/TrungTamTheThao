package controller;

import dal.SportDAO;
import dal.SportFieldDAO;
import dal.ClassDAO;
import model.Sport;
import model.SportField;
import model.Class;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.util.List;

@WebServlet("/UpdateClassServlet")
public class UpdateClassServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassDAO cl = new ClassDAO();
		String id_raw = request.getParameter("id");
	    if (id_raw != null && !id_raw.isEmpty()) {
	        try {
	            int id = Integer.parseInt(id_raw);
	            Class s = cl.getClassById(id);
	            request.setAttribute("sportEdit", s);
	        } catch (Exception e) {
	            System.out.println(e);
	        }
	    }
	    SportDAO s = new SportDAO();
		List<Sport> listSport = s.getSportAll();
		request.setAttribute("dataSport", listSport);
		SportFieldDAO cd = new SportFieldDAO();
		List<SportField> listSportF = cd.getSportFieldAll();
		request.setAttribute("dataSportF", listSportF);
	    List<Class> listClass = cl.getClassAll();
	    request.setAttribute("dataClass", listClass);
	    request.getRequestDispatcher("classlist.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassDAO cd = new ClassDAO();
		String classId_S = request.getParameter("classId");
		String name = request.getParameter("className");
		String sportid_S = request.getParameter("sportId");
		String id_S = request.getParameter("sportFieldId");
		String image = request.getParameter("image");
		String quantity_S = request.getParameter("quantity");
		String quantityMax_S = request.getParameter("quantityMax");
		String monthlyTuition_S = request.getParameter("monthlyTuition");
		String months_S = request.getParameter("months");
		String time = request.getParameter("time");
		int id, sportid, quantity, classId, quantityMax, monthlyTuition, months;
		classId = Integer.parseInt(classId_S);
		id = Integer.parseInt(id_S);
		sportid = Integer.parseInt(sportid_S);
		quantity = Integer.parseInt(quantity_S);
		quantityMax = Integer.parseInt(quantityMax_S);
		monthlyTuition = Integer.parseInt(monthlyTuition_S);
		months = Integer.parseInt(months_S);
		Class c = new Class(classId, name, sportid, id, image, quantity, quantityMax, monthlyTuition, months, time);
		cd.update(c);
		response.sendRedirect("ClassServlet");
	}
}
