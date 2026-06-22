package controller;

import dal.SportDAO;
import dal.SportFieldDAO;
import dal.ClassDAO;
import model.Sport;
import model.SportField;
import model.Class;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddClassServlet")
public class AddClassServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassDAO cl = new ClassDAO();
		String classId_S = request.getParameter("classId");
		String className = request.getParameter("className");
		String sportId_S = request.getParameter("sportId");
		String sportFieldId_S = request.getParameter("sportFieldId");
		String image = request.getParameter("image");
		String quantity_S = request.getParameter("quantity");
		String quantityMax_S = request.getParameter("quantityMax");
		String monthlyTuition_S = request.getParameter("monthlyTuition");
		String months_S = request.getParameter("months");
		String time = request.getParameter("time");
		int classId, sportFieldId, sportId, quantity, quantityMax, monthlyTuition, months;
		sportFieldId = Integer.parseInt(sportFieldId_S);
		sportId = Integer.parseInt(sportId_S);
		classId = Integer.parseInt(classId_S);
		quantity = Integer.parseInt(quantity_S);
		quantityMax = Integer.parseInt(quantityMax_S);
		monthlyTuition = Integer.parseInt(monthlyTuition_S);
		months = Integer.parseInt(months_S);
		Class c = cl.getClassById(classId);
		if (c == null) {
			c = new Class(classId, className, sportId, sportFieldId, image, quantity, quantityMax, monthlyTuition, months, time);
			cl.insert(c);
			response.sendRedirect("ClassServlet");
		} else {
			String error = "ID = " +classId + " Đã tồn tại, xin mời nhập ID khác";
			request.setAttribute("error", error);
			SportDAO s = new SportDAO();
			List<Sport> listSport = s.getSportAll();
			request.setAttribute("dataSport", listSport);
			SportFieldDAO cd = new SportFieldDAO();
			List<SportField> listSportF = cd.getSportFieldAll();
			request.setAttribute("dataSportF", listSportF);
			java.util.List<Class> listClass = cl.getClassAll(); 
		    request.setAttribute("dataClass", listClass);
			request.getRequestDispatcher("classlist.jsp").forward(request, response);
		}
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("classlist.jsp").forward(request, response);
    }
}
