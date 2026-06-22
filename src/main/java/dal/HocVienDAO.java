package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.HocVien;

public class HocVienDAO extends DBContext {

  
    public List<HocVien> getHocVienAll(int classId) {
        List<HocVien> list = new ArrayList<>();

        String sql = "SELECT * FROM tb_hocvien WHERE ClassId = ?"; 
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, classId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            	int MaHocVien;
				String TenHocVien, NgaySinh, GioiTinh;
				MaHocVien = rs.getInt("MaHocVien");
				classId = rs.getInt("classId");
				TenHocVien = rs.getString("TenHocVien");
				NgaySinh = rs.getString("NgaySinh");
				GioiTinh = rs.getString("GioiTinh");
                HocVien h = new HocVien(
                    MaHocVien,
                    classId,
                    TenHocVien,
                    NgaySinh,
                    GioiTinh
                );
                list.add(h);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public HocVien getHocVienById(int id) {
        String sql = "SELECT * FROM tb_hocvien WHERE MaHocVien = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id); 
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return new HocVien(
                    rs.getInt("MaHocVien"),
                    rs.getInt("classId"),
                    rs.getString("TenHocVien"),
                    rs.getString("NgaySinh"),
                    rs.getString("GioiTinh")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // Thêm mới
    public void insert(HocVien h) {
        String sql = "INSERT INTO tb_hocvien(MaHocVien, ClassId, TenHocVien, NgaySinh, GioiTinh) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, h.getMaHocVien());
            ps.setInt(2, h.getClassId());
            ps.setString(3, h.getTenHocVien());
            ps.setString(4, h.getNgaySinh());
            ps.setString(5, h.getGioiTinh());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Cập nhật
    public void update(HocVien h) {
        String sql = "UPDATE tb_hocvien SET ClassId=?, TenHocVien=?, NgaySinh=?, GioiTinh=? WHERE MaHocVien=?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, h.getClassId());
            ps.setString(2, h.getTenHocVien());
            ps.setString(3, h.getNgaySinh());
            ps.setString(4, h.getGioiTinh());
            ps.setInt(5, h.getMaHocVien());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    
    public void delete(int maHocVien) {
        String sql = "DELETE FROM tb_hocvien WHERE MaHocVien = ?";
        try {
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, maHocVien);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}