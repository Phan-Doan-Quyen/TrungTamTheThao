package controller;

import dal.ClassDAO;
import dal.HocVienDAO;
import model.Class;
import model.HocVien;
import java.io.IOException;
import java.util.List;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/HocVienServlet")
public class HocVienServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
    	ClassDAO c = new ClassDAO();
		List<Class> listClass = c.getClassAll();
		request.setAttribute("dataClass", listClass);
		
		String classId_S = request.getParameter("id");
		int classId = Integer.parseInt(classId_S);
    	
        HocVienDAO dao = new HocVienDAO();       
        List<HocVien> listHocVien = dao.getHocVienAll(classId);
        request.setAttribute("dataHocVien", listHocVien);
        request.getRequestDispatcher("hocvienlist.jsp").forward(request, response);
    }
}