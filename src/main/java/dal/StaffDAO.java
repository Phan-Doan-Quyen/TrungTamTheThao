package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Staff;

public class StaffDAO extends DBContext {

    public List<Staff> getStaffAll() {
        List<Staff> list = new ArrayList<>();
        String sql = "SELECT * FROM tb_staff";

        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String userName, passWord, fullName, avatar;
                String gender, phone, email, address;
                int staffId, roleId;
                java.sql.Date birthday;

                staffId = rs.getInt("staffId");
                userName = rs.getString("userName");
                passWord = rs.getString("passWord");
                fullName = rs.getString("fullName");
                avatar = rs.getString("avatar");
                birthday = rs.getDate("birthday");
                gender = rs.getString("gender");
                phone = rs.getString("phone");
                email = rs.getString("email");
                address = rs.getString("address");
                roleId = rs.getInt("roleId");

                Staff s = new Staff(
                        staffId,
                        userName,
                        passWord,
                        fullName,
                        avatar,
                        birthday,
                        gender,
                        phone,
                        email,
                        address,
                        roleId
                );

                list.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

	public Staff getStaffById(int staffId) {
		String sql = "SELECT * FROM tb_staff WHERE StaffId = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, staffId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				String userName, passWord, fullName, avatar;
                String gender, phone, email, address;
                int roleId;
                java.sql.Date birthday;

                userName = rs.getString("userName");
                passWord = rs.getString("passWord");
                fullName = rs.getString("fullName");
                avatar = rs.getString("avatar");
                birthday = rs.getDate("birthday");
                gender = rs.getString("gender");
                phone = rs.getString("phone");
                email = rs.getString("email");
                address = rs.getString("address");
                roleId = rs.getInt("roleId");

                Staff s = new Staff(
                        staffId,
                        userName,
                        passWord,
                        fullName,
                        avatar,
                        birthday,
                        gender,
                        phone,
                        email,
                        address,
                        roleId
                );
                return s;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public void insert(Staff s) {
		String sql = """
				INSERT INTO tb_staff
				(StaffId, UserName, PassWord, RoleId)
				VALUES (?, ?, ?, ?)
				""";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, s.getStaffId());
			ps.setString(2, s.getUserName());
			ps.setString(3, s.getPassWord());
			ps.setInt(4, s.getRoleId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void update(Staff s) {
		String sql = """
				UPDATE tb_staff
				SET UserName = ?, PassWord = ?, RoleId = ?
				WHERE StaffId = ?
				""";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setString(1, s.getUserName());
			ps.setString(2, s.getPassWord());
			ps.setInt(3, s.getRoleId());
			ps.setInt(4, s.getStaffId());

			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void delete(int staffId) {
		String sql = "DELETE FROM tb_staff WHERE StaffId = ?";

		try {
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1, staffId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Staff checkLogin(String user, String pass) {
	    String sql = "SELECT * FROM tb_staff WHERE UserName = ? AND PassWord = ?";
	    try {
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setString(1, user);
	        ps.setString(2, pass);
	        ResultSet rs = ps.executeQuery();
	        if (rs.next()) {
	            Staff s = new Staff();
	            s.setStaffId(rs.getInt("StaffId"));
	            s.setUserName(rs.getString("UserName"));
	            s.setPassWord(rs.getString("PassWord"));
	            s.setFullName(rs.getString("FullName"));
	            s.setAvatar(rs.getString("Avatar"));       
	            s.setBirthday(rs.getDate("Birthday"));     
	            s.setGender(rs.getString("Gender"));      
	            s.setPhone(rs.getString("Phone"));        
	            s.setEmail(rs.getString("Email"));        
	            s.setAddress(rs.getString("Address"));
	            s.setRoleId(rs.getInt("RoleId"));
	            return s;
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return null;
	}
	
	public void updateInfo(Staff s) {
	    String sql = """
	            UPDATE tb_staff 
	            SET FullName = ?, Email = ?, Phone = ?, Gender = ?, Birthday = ?, Address = ?, Avatar = ?
	            WHERE StaffId = ?
	            """;
	    try {
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setString(1, s.getFullName());
	        ps.setString(2, s.getEmail());
	        ps.setString(3, s.getPhone());
	        ps.setString(4, s.getGender());
	        ps.setDate(5, s.getBirthday());
	        ps.setString(6, s.getAddress());
	        ps.setString(7, s.getAvatar());
	        ps.setInt(8, s.getStaffId());
	        
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
	public void changePassword(int staffId, String newPass) {
	    String sql = "UPDATE tb_staff SET PassWord = ? WHERE StaffId = ?";
	    try {
	        PreparedStatement ps = connection.prepareStatement(sql);
	        ps.setString(1, newPass);
	        ps.setInt(2, staffId);
	        ps.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}

