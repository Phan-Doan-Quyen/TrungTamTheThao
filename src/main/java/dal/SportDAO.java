package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Sport;

public class SportDAO extends DBContext {
	public List<Sport> getSportAll() {
		List<Sport> list = new ArrayList<>();
		String sql = "select * from sports";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int sportId;
				String sportName, description;
				sportId = rs.getInt("sportId");
				sportName = rs.getString("sportName");
				description = rs.getString("description");
				Sport s = new Sport(sportId, sportName, description);
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Sport getSportById(int sportId) {
		String sql = "SELECT * FROM sports WHERE SportId = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, sportId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String sportName, description;
				sportName = rs.getString("sportName");
				description = rs.getString("description");
				Sport c = new Sport(sportId, sportName, description);
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Sport c) {
		String sql = "INSERT INTO sports(SportId,SportName,`Description`) VALUES(?,?,?)";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, c.getSportId());
			ps.setString(2, c.getSportName());
			ps.setString(3, c.getDescription());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void update(Sport c) {
		String sql = "UPDATE sports SET `Description` = ?, SportName = ? WHERE SportId =? ";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, c.getDescription());
			ps.setString(2, c.getSportName());
			ps.setInt(3, c.getSportId());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void delete(int sportId) {
		String sql = "DELETE from sports WHERE SportId = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, sportId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}