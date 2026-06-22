package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Booking;

public class BookingDAO extends DBContext {
	public List<Booking> getBookingByDate(int sportFieldId, Date viewDate) {
		List<Booking> list = new ArrayList<>();
		String sql = "select * from booking WHERE SportFieldId = ? AND CreateDate = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, sportFieldId);
	        ps.setDate(2, viewDate);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int bookingId, classId, price;
				String customerName, paymentMethod, time, status, phone;
				Date createDate;
				bookingId = rs.getInt("bookingId");
				classId = rs.getInt("classId");
				sportFieldId = rs.getInt("sportFieldId");
				customerName = rs.getString("customerName");
				phone = rs.getString("phone");
				createDate = rs.getDate("createDate");
				time = rs.getString("time");
				paymentMethod = rs.getString("paymentMethod");
				price = rs.getInt("price");
				status = rs.getString("status");
				Booking s = new Booking(bookingId, classId, sportFieldId, customerName, phone, createDate, time, paymentMethod, price, status);
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Booking getBookingById(int bookingId) {
		String sql = "select * from booking WHERE BookingId = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, bookingId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int sportFieldId, classId, price;
				String customerName, paymentMethod, time, status, phone;
				Date createDate;
				classId = rs.getInt("classId");
				sportFieldId = rs.getInt("sportFieldId");
				customerName = rs.getString("customerName");
				phone = rs.getString("phone");
				createDate = rs.getDate("createDate");
				time = rs.getString("time");
				paymentMethod = rs.getString("paymentMethod");
				price = rs.getInt("price");
				status = rs.getString("status");
				Booking s = new Booking(bookingId, classId, sportFieldId, customerName, phone, createDate, time, paymentMethod, price, status);
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(Booking c) {
		String sql = "INSERT INTO booking(BookingId, ClassId, SportFieldId, CustomerName, Phone, CreateDate, Time, PaymentMethod, Price, Status) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, c.getBookingId());
			if (c.getClassId() == 0) {
			    ps.setNull(2, java.sql.Types.INTEGER);
			} else {
			    ps.setInt(2, c.getClassId());
			}
			ps.setInt(3, c.getSportFieldId());
			ps.setString(4, c.getCustomerName());
			ps.setString(5, c.getPhone());
			ps.setDate(6, c.getCreateDate());
			ps.setString(7, c.getTime());
			ps.setString(8, c.getPaymentMethod());
			ps.setInt(9, c.getPrice());
			ps.setString(10, c.getStatus());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Booking c) {
		String sql = "UPDATE booking SET `ClassId` = ?, SportFieldId = ?, CustomerName = ?, Phone = ?, CreateDate = ?, Time = ?, PaymentMethod = ?, Price = ?, Status = ? WHERE BookingId =? ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			if (c.getClassId() == 0) {
			    ps.setNull(1, java.sql.Types.INTEGER);
			} else {
			    ps.setInt(1, c.getClassId());
			}
			ps.setInt(2, c.getSportFieldId());
			ps.setString(3, c.getCustomerName());
			ps.setString(4, c.getPhone());
			ps.setDate(5, c.getCreateDate());
			ps.setString(6, c.getTime());
			ps.setString(7, c.getPaymentMethod());
			ps.setInt(8, c.getPrice());
			ps.setString(9, c.getStatus());
			ps.setInt(10, c.getBookingId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int bookingId) {
		String sql = "DELETE from booking WHERE BookingId = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, bookingId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public int countAll() {
        String sql = "SELECT COUNT(*) FROM booking";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
	
	public int countBySportName(String sportName) {
        String sql = """
            SELECT COUNT(*) 
            FROM booking b
            JOIN sportfields sf ON b.SportFieldId = sf.SportFieldId
            JOIN sports s ON sf.SportId = s.SportId
            WHERE s.SportName LIKE ?
        """;
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setString(1, "%" + sportName + "%"); 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
