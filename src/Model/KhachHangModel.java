/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiep0
 */
public class KhachHangModel extends CSDL {

    private String maKH;
    private String tenKH;
    private Boolean gioiTinh;
    private String SDT;
    private String CMND;
    private String taiKhoan;
    private String matKhau;

    public KhachHangModel() {
    }

    public KhachHangModel(String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public KhachHangModel(String maKH, String tenKH, Boolean gioiTinh, String SDT, String CMND, String taiKhoan, String matKhau) {
        this.maKH = maKH;
        this.tenKH = tenKH;
        this.gioiTinh = gioiTinh;
        this.SDT = SDT;
        this.CMND = CMND;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

// dang nhap
    
    public ArrayList<KhachHangModel> getKhachHang(){
        ArrayList<KhachHangModel> arr = new ArrayList<>();
        try{
            Connection conn = this.getConnection();
            String sql = "select * from khach_hang";
            Statement stm = conn.createStatement();
            ResultSet result = stm.executeQuery(sql);
            while (result.next()){
                KhachHangModel kh = new KhachHangModel();
                kh.setMaKH(result.getString(1));
                kh.setTenKH(result.getString(2));
                kh.setGioiTinh(result.getBoolean(3));
                kh.setSDT(result.getString(4));
                kh.setCMND(result.getString(5));
                kh.setTaiKhoan(result.getString(6));
                kh.setMatKhau(result.getString(7));
                arr.add(kh);
            }
            return arr;
        }catch(SQLException ex){
            System.out.println("khong do khach_hang len giao dien");
        }
        return arr;
    }
    
    
    public KhachHangModel dangNhap(String taiKhoan, String matKhau) {
        KhachHangModel kH = new KhachHangModel();
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
// Tao tai khoan

    public boolean taoTaiKhoan(KhachHangModel kh) {
        try {
            Connection conn = this.getConnection();
            String query = "select count(maKhachHang) from khach_hang where maKhachHang='" + kh.getMaKH() + "'";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            int i = -1;
            while (rs.next()) {
                i = rs.getInt(1);
            }
            if (i > 0) {
                return false;
            }
            query = "select count(taiKhoan) from khach_hang where taiKhoan='" + kh.getTaiKhoan() + "'";
            rs = s.executeQuery(query);
            while (rs.next()) {
                i = rs.getInt(1);
            }
            if (i > 0) {
                return false;
            }
            String sql = "insert into khach_hang values (?,?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, kh.getMaKH());
            stm.setString(2, kh.getTenKH());
            stm.setBoolean(3, kh.getGioiTinh());
            stm.setString(4, kh.getSDT());
            stm.setString(5, kh.getCMND());
            stm.setString(6, kh.getTaiKhoan());
            stm.setString(7, kh.getMatKhau());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("lỗi tạo tài khoản khách hàng model");

            Logger.getLogger(KhachHangModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
// Tao tai khoan
// Doi thong tin

    public boolean doiThongTin(KhachHangModel kh) {
        try {
            Connection conn = this.getConnection();
            String sql = "update khach_hang set tenKhachHang= ? ,gioiTinh= ? ,soDienThoai= ?,canCuocCongDan= ? where maKhachHang= ? and taiKhoan=?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, kh.getTenKH());
            stm.setBoolean(2, kh.getGioiTinh());
            stm.setString(3, kh.getSDT());
            stm.setString(4, kh.getCMND());
            stm.setString(5, kh.getMaKH());
            stm.setString(6, kh.getTaiKhoan());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("lỗi đổi thông tin khách hàng model");
            Logger.getLogger(KhachHangModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
// Doi thong tin  
// Doi mat khau 

    public boolean doiMatKhau(KhachHangModel kh) {
        try {
            Connection conn = this.getConnection();
            String sql = "update khach_hang set matkhau= ?  where maKhachHang=? and taiKhoan= ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, kh.getMatKhau());
            stm.setString(2, kh.getMaKH());
            stm.setString(3, kh.getTaiKhoan());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("lỗi đổi thông tin khách hàng model");
            Logger.getLogger(KhachHangModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
// Doi mat khau

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
