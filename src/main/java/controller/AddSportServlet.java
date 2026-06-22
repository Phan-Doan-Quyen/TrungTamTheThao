package controller;

import dal.SportDAO;
import model.Sport;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddSportServlet")
public class AddSportServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		SportDAO cd = new SportDAO();
		String sportId_S = request.getParameter("sportId");
		String sportName = request.getParameter("sportName");
		String description = request.getParameter("description");
		int sportId;
		sportId = Integer.parseInt(sportId_S);
		Sport c = cd.getSportById(sportId);
		if (c == null) {
			c = new Sport(sportId, sportName, description);
			cd.insert(c);
			response.sendRedirect("SportServlet");
		} else {
			String error = "ID = " + sportId + " Đã tồn tại, xin mời nhập ID khác";
			request.setAttribute("error", error);
			java.util.List<Sport> listSport = cd.getSportAll(); 
		    request.setAttribute("dataSport", listSport);
			request.getRequestDispatcher("sportlist.jsp").forward(request, response);
		}
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("sportlist.jsp").forward(request, response);
    }
}
