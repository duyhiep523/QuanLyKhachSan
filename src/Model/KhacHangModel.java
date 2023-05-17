/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author hiep0
 */
public class KhacHangModel extends CSDL {

    private String maKH;
    private String tenKH;
    private Boolean gioiTinh;
    private String SDT;
    private String CMND;
    private String taiKhoan;
    private String matKhau;

    public KhacHangModel() {
    }

    public KhacHangModel(String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public KhacHangModel(String maKH, String tenKH, Boolean gioiTinh, String SDT, String CMND, String taiKhoan, String matKhau) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.CMND = CMND;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

// dang nhap
    public KhacHangModel dangNhap(String taiKhoan, String matKhau) {
        KhacHangModel kH = new KhacHangModel();
        try (Connection conn = this.getConnection()) {
            String sql = "select *from khach_hang where taiKhoan = ? and matKhau = ? ";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, taiKhoan);
            statement.setString(2, matKhau);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                kH.setMaKH(result.getString(1));
                kH.setTenKH(result.getString(2));
                kH.setGioiTinh(result.getBoolean(3));
                kH.setSDT(result.getString(4));
                kH.setCMND(result.getString(5));
                kH.setTaiKhoan(result.getString(6));
                kH.setMatKhau(result.getString(7));
                return kH;
            }
            return kH;
        } catch (SQLException e) {
            System.out.println("lỗi ở KhachHang model đăng nhập");
        }
        return kH;
    }
// dang nhap

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public String getTenKH() {
        return tenKH;
    }

    public void setTenKH(String tenKH) {
        this.tenKH = tenKH;
    }

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSDT() {
        return SDT;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public String getCMND() {
        return CMND;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public String getTaiKhoan() {
        return taiKhoan;
    }

    public void setTaiKhoan(String taiKhoan) {
        this.taiKhoan = taiKhoan;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

}
