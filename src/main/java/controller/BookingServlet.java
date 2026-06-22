package controller;

import dal.BookingDAO;
import model.Booking;
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

@WebServlet("/BookingServlet")
public class BookingServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ClassDAO c = new ClassDAO();
		List<Class> listClass = c.getClassAll();
		request.setAttribute("dataClass", listClass);
		
		SportFieldDAO cd = new SportFieldDAO();
		List<SportField> listSportF = cd.getSportFieldAll();
		request.setAttribute("dataSportF", listSportF);
		
		String viewDate = request.getParameter("viewDate");
		String sportFieldId_S = request.getParameter("id");
		int sportFieldId = Integer.parseInt(sportFieldId_S);
		if (viewDate == null) {
		    viewDate = java.time.LocalDate.now().toString(); 
		}
		request.setAttribute("viewDate", viewDate);
		
		BookingDAO s = new BookingDAO();
		List<Booking> listBooking = s.getBookingByDate(sportFieldId, java.sql.Date.valueOf(viewDate));
		request.setAttribute("dataBooking", listBooking);
		request.getRequestDispatcher("booking.jsp").forward(request, response);
	}
}
