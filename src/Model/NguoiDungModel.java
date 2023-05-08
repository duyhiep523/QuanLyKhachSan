/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiep0
 */
public class NguoiDungModel extends CSDL {

    private String hoTen;
    private Date ngaySinh;
    private String email;
    private String CMND;
    private String taiKhoan;
    private String matKhau;
    private Boolean gioiTinh;
    private String sdt;

    public NguoiDungModel(String hoTen, Date ngaySinh, String email, String CMND, String taiKhoan, String matKhau, Boolean gioiTinh) {
        this.hoTen = hoTen;
        this.ngaySinh = ngaySinh;
        this.email = email;
        this.CMND = CMND;
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
        this.gioiTinh = gioiTinh;
    }

    public NguoiDungModel(String taiKhoan, String matKhau) {
        this.taiKhoan = taiKhoan;
        this.matKhau = matKhau;
    }

    public NguoiDungModel() {
        this.hoTen = null;
        this.ngaySinh = null;
        this.email = null;
        this.CMND = null;
        this.taiKhoan = null;
        this.matKhau = null;
        this.gioiTinh = null;
    }
// check dang nhap

    public NguoiDungModel checkLogin(String taiKhoan, String matKhau) {
        NguoiDungModel nd = new NguoiDungModel();
        try (Connection conn = this.getConnection()) {
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery("SELECT * from quanly where taiKhoan = '" + taiKhoan + "' and matKhau='" + matKhau + "'");
            if (result.next()) {
                nd.setHoTen(result.getString(1));
                String s = result.getString(2);
                SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
                Date d = formatter.parse(s);
                nd.setNgaySinh(d);
                nd.setEmail(result.getString(3));
                nd.setSdt(result.getString(4));
                nd.setCMND(result.getString(5));
                nd.setTaiKhoan(result.getString(6));
                nd.setMatKhau(result.getString(7));
                nd.setGioiTinh(result.getBoolean(8));
                return nd;
            }
            return nd;
        } catch (SQLException e) {
        } catch (ParseException ex) {
            Logger.getLogger(NguoiDungModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nd;
    }
// check dang nhap
// add người dùng
    public 
// add người dùng

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public Date getNgaySinh() {
        return ngaySinh;
    }

    public void setNgaySinh(Date ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
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

    public Boolean getGioiTinh() {
        return gioiTinh;
    }

    public void setGioiTinh(Boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

}
