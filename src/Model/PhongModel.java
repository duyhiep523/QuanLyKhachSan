/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.KhachHangController;
import Controller.PhongController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hiep0
 */
public class PhongModel extends CSDL {

    private String maPhong;
    private String tenPhong;
    private String loaiPhong;
    private float giaPhong;
    private Boolean tinhTrang;

    public PhongModel() {
    }

    public PhongModel(String maPhong, String tenPhong, String loaiPhong, float giaPhong, Boolean tinhTrang) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
        this.tinhTrang = tinhTrang;
    }

    public PhongModel(String maPhong, String tenPhong, String loaiPhong, float giaPhong) {
        this.maPhong = maPhong;
        this.tenPhong = tenPhong;
        this.loaiPhong = loaiPhong;
        this.giaPhong = giaPhong;
    }

    public boolean timmatrung(PhongModel phong) {
        try {
            Connection conn = this.getConnection();
            String query = "select count(*) from phong where maPhong=?";

            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, phong.getMaPhong());
            ResultSet rs = stm.executeQuery();
            int n = 0;
            while (rs.next()) {
                n = rs.getInt(1);
            }
            return n == 0;
        } catch (SQLException ex) {
//            Logger.getLogger(DatPhongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public ArrayList<PhongModel> getPhong() {
        ArrayList<PhongModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();

            String sql = "select *from phong";

            PreparedStatement stm = conn.prepareStatement(sql);

            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhongModel phong = new PhongModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getBoolean(5));
                arr.add(phong);
            }
            return arr;
        } catch (SQLException ex) {
            Logger.getLogger(PhongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<PhongModel> getPhongTheoLoaiPhong(String key) {
        ArrayList<PhongModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();

            String sql = "select *from phong where loaiPhong = '" + key + "'";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhongModel phong = new PhongModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
                arr.add(phong);
            }
            return arr;
        } catch (SQLException ex) {
            System.out.println("ppppppppp");
            Logger.getLogger(PhongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<PhongModel> getPhongTheoGiaPhong(Float key) {
        ArrayList<PhongModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();

            String sql = "select *from phong where giaPhong = '" + key + "'";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhongModel phong = new PhongModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
                arr.add(phong);
            }
            return arr;
        } catch (SQLException ex) {
            System.out.println("ggggggg");
            Logger.getLogger(PhongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public ArrayList<PhongModel> getPhongTim(String key, int gioitinh) {
        ArrayList<PhongModel> arr = new ArrayList<>();
        String sql = "";
        try {
            Connection conn = this.getConnection();
//            sql = "select *from phong where maPhong like '% ? %' or tenPhong like '% ? %' or loaiPhong like '% ? %'";
            sql = "select *from phong where ( maPhong like '%" + key + "%' or tenPhong like '%" + key + "%' or loaiPhong like '%" + key + "%')";

            if (gioitinh == 1) {
                sql = sql.concat(" and tinhTrang='1'");
            }
            if (gioitinh == 0) {
                sql = sql.concat(" and tinhTrang='0'");
            }
            Statement stm = conn.createStatement();

            ResultSet rs = stm.executeQuery(sql);
            while (rs.next()) {
                PhongModel phong = new PhongModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4), rs.getBoolean(5));
                arr.add(phong);
            }
//            System.out.println(sql);
            return arr;
        } catch (SQLException ex) {
//            System.out.println(sql);
//            Logger.getLogger(PhongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return arr;
    }

    public int CountPhong() {
        int i = 1;
        try {
            Connection conn = this.getConnection();
            String sql = "select count(maPhong) from phong";
            PreparedStatement stmm = conn.prepareStatement(sql);
            ResultSet rs = stmm.executeQuery();
            while (rs.next()) {
                i = rs.getInt(i);
            }
            return i;
        } catch (SQLException ex) {
            System.out.println("Khong thong ke duoc phong");
        }
        return i;
    }

    //Nhàn
    public ArrayList<PhongModel> getDulieu() {
        ArrayList<PhongModel> arr = new ArrayList<>();

        try {
            Connection conn = this.getConnection();

            String sql = "select * from phong";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                PhongModel room = new PhongModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getFloat(4), rs.getBoolean(5));
                arr.add(room);
            }
            return arr;
        } catch (SQLException ex) {
            System.out.println("Đổ dữ liệu phòng không thành công");
        }
        return arr;
    }

    public boolean themPhong(PhongModel phong) {
        Connection conn = this.getConnection();
        try {
            Statement st = conn.createStatement();

            boolean tinhTrang = false;
            String query = "insert into phong value ('" + phong.getMaPhong() + "','" + phong.getTenPhong() + "','" + phong.getLoaiPhong() + "'," + phong.getGiaPhong() + "," + tinhTrang + ")";
            st.executeUpdate(query);
            return true;
        } catch (SQLException ex) {
            System.out.println("Khong thanh cong");
        }
        return false;
    }

    // Xóa phong
    public boolean xoaPhong(PhongModel phong) {
        Connection conn = this.getConnection();

        try {
            String sql0 = "SET FOREIGN_KEY_CHECKS=0;";
            PreparedStatement stm0 = conn.prepareStatement(sql0);
            stm0.executeUpdate();

            String sql = "delete from phong where maPhong = ?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, phong.getMaPhong());
            pst.executeUpdate();
            String sql1 = "SET FOREIGN_KEY_CHECKS=1;";
            PreparedStatement stm1 = conn.prepareStatement(sql1);
            stm1.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Xóa Khong thanh cong");

        }
        return false;
    }

    public boolean updateRoom(PhongModel phong) {
        try {
            Connection conn = this.getConnection();

            String sql = "update phong set tenPhong=?, loaiPhong=?, giaPhong=?, tinhTrang=? where maPhong=? ";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, phong.getTenPhong());
            pst.setString(2, phong.getLoaiPhong());
            pst.setFloat(3, phong.getGiaPhong());
            pst.setBoolean(4, phong.getTinhTrang());
            pst.setString(5, phong.getMaPhong());
            pst.executeUpdate();
            return true;

        } catch (SQLException ex) {
            System.out.println("Khong thanh cong");
        }
        return false;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getTenPhong() {
        return tenPhong;
    }

    public void setTenPhong(String tenPhong) {
        this.tenPhong = tenPhong;
    }

    public String getLoaiPhong() {
        return loaiPhong;
    }

    public void setLoaiPhong(String loaiPhong) {
        this.loaiPhong = loaiPhong;
    }

    public float getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(float giaPhong) {
        this.giaPhong = giaPhong;
    }

    public Boolean getTinhTrang() {
        return tinhTrang;
    }

    public void setTinhTrang(Boolean tinhTrang) {
        this.tinhTrang = tinhTrang;
    }

}
