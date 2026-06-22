package controller;

import dal.SportDAO;
import dal.SportFieldDAO;
import model.Sport;
import model.SportField;
import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddSportFieldServlet")
public class AddSportFieldServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SportFieldDAO cd = new SportFieldDAO();
		String sportFieldId_S = request.getParameter("sportFieldId");
		String sportFieldName = request.getParameter("sportFieldName");
		String sportId_S = request.getParameter("sportId");
		String description = request.getParameter("description");
		String image = request.getParameter("image");
		String status = request.getParameter("status");
		String price_S = request.getParameter("price");
		int sportFieldId, sportId, price;
		sportFieldId = Integer.parseInt(sportFieldId_S);
		sportId = Integer.parseInt(sportId_S);
		price = Integer.parseInt(price_S);
		SportField c = cd.getSportFieldById(sportFieldId);
		if (c == null) {
			c = new SportField(sportFieldId, sportFieldName,sportId, description, image, status, price);
			cd.insert(c);
			response.sendRedirect("SportFieldServlet");
		} else {
			String error = "ID = " +sportFieldId + " Đã tồn tại, xin mời nhập ID khác";
			request.setAttribute("error", error);
			SportDAO s = new SportDAO();
			List<Sport> listSport = s.getSportAll();
			request.setAttribute("dataSport", listSport);
			java.util.List<SportField> listSportF = cd.getSportFieldAll(); 
		    request.setAttribute("dataSportF", listSportF);
			request.getRequestDispatcher("sportfieldlist.jsp").forward(request, response);
		}
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("sportfieldlist.jsp").forward(request, response);
    }
}
