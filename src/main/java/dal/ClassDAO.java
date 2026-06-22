package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Class;

public class ClassDAO extends DBContext {
	public List<Class> getClassAll() {
		List<Class> list = new ArrayList<>();
		String sql = "select * from class";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int sportFieldId, sportId, classId, quantity, quantityMax, monthlyTuition, months;
				String className, image, time;
				classId = rs.getInt("classId");
				className = rs.getString("ClassName");
				sportId = rs.getInt("sportId");
				sportFieldId = rs.getInt("sportFieldId");
				image = rs.getString("image");
				quantity = rs.getInt("quantity");
				quantityMax = rs.getInt("quantityMax");
				monthlyTuition = rs.getInt("monthlyTuition");
				months = rs.getInt("months");
				time = rs.getString("time");
				Class s = new Class(classId, className, sportId, sportFieldId, image, quantity, quantityMax, monthlyTuition, months, time);
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Class getClassById(int classId) {
		String sql = "select * from class WHERE ClassId = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, classId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				int sportFieldId, sportId, quantity, quantityMax, monthlyTuition, months;
				String className, image, time;
				className = rs.getString("ClassName");
				sportId = rs.getInt("sportId");
				sportFieldId = rs.getInt("sportFieldId");
				image = rs.getString("image");
				quantity = rs.getInt("quantity");
				quantityMax = rs.getInt("quantityMax");
				monthlyTuition = rs.getInt("monthlyTuition");
				months = rs.getInt("months");
				time = rs.getString("time");
				Class s = new Class(classId, className, sportId, sportFieldId, image, quantity, quantityMax, monthlyTuition, months, time);
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Class c) {
		String sql = "INSERT INTO class(ClassId, ClassName, SportId, SportFieldId, Image, Quantity, QuantityMax, MonthlyTuition, Months, Time) VALUES(?,?,?,?,?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, c.getClassId());
			ps.setString(2, c.getClassName());
			ps.setInt(3, c.getSportId());
			ps.setInt(4, c.getSportFieldId());
			ps.setString(5, c.getImage());
			ps.setInt(6, c.getQuantity());
			ps.setInt(7, c.getQuantityMax());
			ps.setInt(8, c.getMonthlyTuition());
			ps.setInt(9, c.getMonths());
			ps.setString(10, c.getTime());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Class c) {
		String sql = "UPDATE class SET `ClassName` = ?,`SportId` = ?, SportFieldId = ?, Image = ?, Quantity = ?, QuantityMax = ?, MonthlyTuition = ?, Months = ?, Time = ? WHERE ClassId =? ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getClassName());
			ps.setInt(2, c.getSportId());
			ps.setInt(3, c.getSportFieldId());
			ps.setString(4, c.getImage());
			ps.setInt(5, c.getQuantity());
			ps.setInt(6, c.getQuantityMax());
			ps.setInt(7, c.getMonthlyTuition());
			ps.setInt(8, c.getMonths());
			ps.setString(9, c.getTime());
			ps.setInt(10, c.getClassId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int classId) {
		String sql = "DELETE from class WHERE ClassId = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, classId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
