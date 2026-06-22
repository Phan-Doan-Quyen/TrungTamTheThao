package controller;

import dal.BookingDAO;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DeleteBookingServlet")
public class DeleteBookingServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String bookingId_S = request.getParameter("bookingId");
		int bookingId = Integer.parseInt(bookingId_S);
		
		String sportFieldId_S = request.getParameter("sportFieldId");
		int sportFieldId = Integer.parseInt(sportFieldId_S);
		
		BookingDAO cd = new BookingDAO();
		cd.delete(bookingId);
		response.sendRedirect("BookingServlet?id="+ sportFieldId);
	}
}
