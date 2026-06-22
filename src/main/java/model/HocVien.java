package model;

public class HocVien {
    private int maHocVien;          
    private int classId;    
    private String tenHocVien;
    private String ngaySinh;
    private String gioiTinh;  

    public HocVien() {
    }

    public HocVien(int maHocVien, int classId, String tenHocVien, String ngaySinh, String gioiTinh) {
        this.maHocVien = maHocVien;
        this.classId = classId;
        this.tenHocVien = tenHocVien;
        this.ngaySinh = ngaySinh;
        this.gioiTinh = gioiTinh;
    }

    public int getMaHocVien() { return maHocVien; }
    public void setMaHocVien(int maHocVien) { this.maHocVien = maHocVien; }

    public int getClassId() { return classId; }
    public void setClassId(int maLopHuanLuyen) { this.classId = classId; }

    public String getTenHocVien() { return tenHocVien; }
    public void setTenHocVien(String tenHocVien) { this.tenHocVien = tenHocVien; }

    public String getNgaySinh() { return ngaySinh; }
    public void setNgaySinh(String ngaySinh) { this.ngaySinh = ngaySinh; }

    public String getGioiTinh() { return gioiTinh; }
    public void setGioiTinh(String gioiTinh) { this.gioiTinh = gioiTinh; }
}