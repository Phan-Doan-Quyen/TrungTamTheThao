package controller;

import dal.BookingDAO;
import dal.ClassDAO;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	BookingDAO bookingDAO = new BookingDAO();
    	
    	int luotDat = bookingDAO.countAll();
    	int luotDatSan = luotDat + 0;
        int nguoiDangKy = 45;
        
        int slBongDa = bookingDAO.countBySportName("Bóng đá");
        int slPickleball = bookingDAO.countBySportName("Pickleball");
        int slKhac = luotDatSan - (slBongDa + slPickleball);
        if (slKhac < 0) slKhac = 0;
        
        int tiLeBongDa = 0;
        int tiLePickleball = 0;
        int tiLeKhac = 0;
        
        if (luotDatSan > 0) {
            tiLeBongDa = (slBongDa * 100) / luotDatSan;
            tiLePickleball = (slPickleball * 100) / luotDatSan;
            tiLeKhac = 100 - (tiLeBongDa + tiLePickleball);
        }

        request.setAttribute("luotDatSan", luotDatSan);
        request.setAttribute("nguoiDangKy", nguoiDangKy);
        
        request.setAttribute("tiLeBongDa", tiLeBongDa);
        request.setAttribute("tiLePickleball", tiLePickleball);
        request.setAttribute("tiLeKhac", tiLeKhac);
        
        String[] labels7Days = {"Thứ 2", "Thứ 3", "Thứ 4", "Thứ 5", "Thứ 6", "Thứ 7", "CN"};
        int[] data7Days = {15, 22, 18, 25, 30, 45, 40};
        
        request.setAttribute("chartLabels", labels7Days);
        request.setAttribute("chartData", data7Days);
        
        request.setAttribute("recentBookings", "dummy"); 
        request.getRequestDispatcher("home.jsp").forward(request, response);
    }
}
