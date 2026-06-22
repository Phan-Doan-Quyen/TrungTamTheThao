package controller;

import dal.BookingDAO;
import dal.SportFieldDAO;
import dal.ClassDAO;
import model.Booking;
import model.SportField;
import model.Class;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/AddBookingServlet")
public class AddBookingServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	    response.setCharacterEncoding("UTF-8");
	    
		BookingDAO b = new BookingDAO();
		String bookingId_S = request.getParameter("bookingId");
		String classId_S = request.getParameter("classId");
		String sportFieldId_S = request.getParameter("sportFieldId");
		String customerName = request.getParameter("customerName");
		String phone = request.getParameter("phone");
		String viewDate = request.getParameter("createDate");
		String time = request.getParameter("time");
		String paymentMethod = request.getParameter("paymentMethod");
		String price_S = request.getParameter("price");
		String status = request.getParameter("status");
		
		int bookingId, classId, sportFieldId, price;
		
		bookingId = Integer.parseInt(bookingId_S);
		if (classId_S != null && !classId_S.isEmpty()) {
		    classId = Integer.parseInt(classId_S);
		} else {
		    classId = 0;
		}
		sportFieldId = Integer.parseInt(sportFieldId_S);
		price = Integer.parseInt(price_S);
		
		Booking c = b.getBookingById(bookingId);
		if (c == null) {
			c = new Booking(bookingId, classId, sportFieldId, customerName, phone, java.sql.Date.valueOf(viewDate), time, paymentMethod, price, status);
			b.insert(c);
			response.sendRedirect("BookingServlet?id="+ sportFieldId);
		} else {
			String error = "ID = " + bookingId + " Đã tồn tại, xin mời nhập ID khác";
			request.setAttribute("error", error);
			
			SportFieldDAO sf = new SportFieldDAO();
			List<SportField> listSportF = sf.getSportFieldAll();
			request.setAttribute("dataSportF", listSportF);
			
			ClassDAO cl = new ClassDAO();
			java.util.List<Class> listClass = cl.getClassAll(); 
		    request.setAttribute("dataClass", listClass);
		    
			List<Booking> listBooking = b.getBookingByDate(sportFieldId, java.sql.Date.valueOf(viewDate));
			request.setAttribute("dataBooking", listBooking);
		    
			request.getRequestDispatcher("addbooking.jsp").forward(request, response);
		}
	}
	
	@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		SportFieldDAO sf = new SportFieldDAO();
		List<SportField> listSportF = sf.getSportFieldAll();
		request.setAttribute("dataSportF", listSportF);
		
		ClassDAO cl = new ClassDAO();
		java.util.List<Class> listClass = cl.getClassAll(); 
	    request.setAttribute("dataClass", listClass);
	    
        request.getRequestDispatcher("addbooking.jsp").forward(request, response);
    }
}
