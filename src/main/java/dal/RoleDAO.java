package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Role;

public class RoleDAO extends DBContext {
	public List<Role> getRoleAll() {
		List<Role> list = new ArrayList<>();
		String sql = "select * from roles";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int roleId;
				String role;
				roleId = rs.getInt("roleId");
				role = rs.getString("role");
				Role s = new Role(roleId, role);
				list.add(s);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public Role getRoleById(int roleId) {
		String sql = "SELECT * FROM roles WHERE RoleId = ?";
		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, roleId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				String role;
				role = rs.getString("role");
				Role c = new Role(roleId, role);
				return c;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void insert(Role c) {
	    String sql = "INSERT INTO roles (SportId,Role) VALUES (?,?)";
	    try {
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setInt(1, c.getRoleId());
	        ps.setString(2, c.getRole());
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}
