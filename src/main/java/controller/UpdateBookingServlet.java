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

@WebServlet("/UpdateBookingServlet")
public class UpdateBookingServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookingDAO b = new BookingDAO();
		String id_s = request.getParameter("id");
		int id = Integer.parseInt(id_s);
		
	    ClassDAO cl = new ClassDAO();
		List<Class> listClass = cl.getClassAll();
		request.setAttribute("dataClass", listClass);
		
		SportFieldDAO cd = new SportFieldDAO();
		List<SportField> listSportF = cd.getSportFieldAll();
		request.setAttribute("dataSportF", listSportF);
		
	    Booking bk = b.getBookingById(id);
	    request.setAttribute("booking", bk);
	    request.getRequestDispatcher("updatebooking.jsp").forward(request, response);
	}
	
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
		String createDate = request.getParameter("createDate");
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
		Booking c = new Booking(bookingId, classId, sportFieldId, customerName, phone, java.sql.Date.valueOf(createDate), time, paymentMethod, price, status);
		b.update(c);
		response.sendRedirect("BookingServlet?id="+ sportFieldId);
	}
}
