package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.SportField;

public class SportFieldDAO extends DBContext {
	public List<SportField> getSportFieldAll() {
		List<SportField> list = new ArrayList<>();
		String sql = "select * from sportfields";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int sportFieldId, sportId, price;
				String sportFieldName, description, image, status;
				sportFieldId = rs.getInt("sportFieldId");
				sportFieldName = rs.getString("sportFieldName");
				sportId = rs.getInt("sportId");
				description = rs.getString("description");
				image = rs.getString("image");
				status = rs.getString("status");
				price = rs.getInt("price");
				SportField s = new SportField(sportFieldId, sportFieldName, sportId, description, image, status, price);
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public SportField getSportFieldById(int sportFieldId) {
		String sql = "select * from sportfields WHERE SportFieldId = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, sportFieldId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String sportFieldName, description, status, image;
				int sportId, price;
				sportFieldName = rs.getString("sportFieldName");
				sportId = rs.getInt("sportId");
				description = rs.getString("description");
				image = rs.getString("image");
				status = rs.getString("status");
				price = rs.getInt("price");
				SportField s = new SportField(sportFieldId, sportFieldName, sportId, description, image, status, price);
				return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(SportField c) {
		String sql = "INSERT INTO sportfields(SportFieldId,SportFieldName,SportId,Image,Status,Price) VALUES(?,?,?,?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, c.getSportFieldId());
			ps.setString(2, c.getSportFieldName());
			ps.setInt(3, c.getSportId());
			ps.setString(4, c.getImage());
			ps.setString(5, c.getStatus());
			ps.setInt(6, c.getPrice());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(SportField c) {
		String sql = "UPDATE sportfields SET `SportId` = ?, SportFieldName = ?, Image = ?, Status = ?, Price = ? WHERE SportFieldId =? ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, c.getSportId());
			ps.setString(2, c.getSportFieldName());
			ps.setString(3, c.getImage());
			ps.setString(4, c.getStatus());
			ps.setInt(5, c.getPrice());
			ps.setInt(6, c.getSportFieldId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int sportFieldId) {
		String sql = "DELETE from sportfields WHERE SportFieldId = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, sportFieldId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
