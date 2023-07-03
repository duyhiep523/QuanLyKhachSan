/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.KhachHangController;
//import com.mysql.cj.jdbc.PreparedStatementWrapper;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.text.DateFormat;

/**
 *
 * @author hiep0
 */
public class DatPhongModel extends CSDL {

    private String maDP;
    private String maPhong;
    private String maKH;
    private Date thoiGianDat;
    private Date thoiGianBatDau;
    private ArrayList<DichVuModel> listDV;
    private float giaPhong;

    public DatPhongModel() {
    }

    public DatPhongModel(String maDP, String maPhong, String maKH, Date thoiGianDat, Date thoiGianBatDau, float giaPhong) {
        this.maDP = maDP;
        this.maPhong = maPhong;
        this.maKH = maKH;
        this.thoiGianDat = thoiGianDat;
        this.thoiGianBatDau = thoiGianBatDau;
        this.giaPhong = giaPhong;
    }

// them dat phong
    public Boolean themDatPhong(DatPhongModel dat) {
        try {
            Connection conn = this.getConnection();
            String sql = "insert into lich_dat_phong values(?,?,?,?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, dat.getMaDP());
            stm.setString(2, dat.getMaKH());
            stm.setString(3, dat.getMaPhong());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(dat.getThoiGianDat());
            stm.setString(4, dateString);
            dateString = formatter.format(dat.getThoiGianBatDau());
            stm.setString(5, dateString);
            stm.setFloat(6, dat.getGiaPhong());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateMuonPhong(DatPhongModel dat) {
        try {
            Connection conn = this.getConnection();
            String sql = "update phong set tinhTrang='1' where maPhong= ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, dat.getMaPhong());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

// them dat phong    
// huy dat phong khach
    public ArrayList<DatPhongModel> listDP() {
        ArrayList<DatPhongModel> dp = new ArrayList<>();
        try {
            Connection conn = this.getConnection();

            String sql = "select *from lich_dat_phong where maKhachHang= ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, KhachHangController.khOn.getMaKH());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                DatPhongModel dPhong = new DatPhongModel(rs.getString(1), rs.getString(3), rs.getString(2), rs.getDate(4), rs.getDate(5), rs.getFloat(6));
                dp.add(dPhong);
            }
            return dp;
        } catch (SQLException ex) {
            Logger.getLogger(PhongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }

    public boolean kiemTraPhong(DatPhongModel phong) {
        boolean result = false;
        try {
            Connection conn = this.getConnection();
            String query = "select tinhTrang from phong where maPhong=?";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, phong.getMaPhong());
            ResultSet rs = stm.executeQuery();

            while (rs.next()) {
                result = rs.getBoolean(1);
            }
            return result;
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    public boolean huyDP(DatPhongModel hdp) {
        try {
            Connection conn = this.getConnection();
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            sql = "delete from lich_dat_phong where maDatPhong=? and maKhachHang=? and maPhong=? and thoiGianDat=?and thoiGianBatDauSuDung=? and giaPhong=?";
            stm = conn.prepareStatement(sql);
            stm.setString(1, hdp.getMaDP());
            stm.setString(2, hdp.getMaKH());
            stm.setString(3, hdp.getMaPhong());
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String dateString = formatter.format(hdp.getThoiGianDat());
            stm.setString(4, dateString);
            dateString = formatter.format(hdp.getThoiGianBatDau());
            stm.setString(5, dateString);
            stm.setFloat(6, hdp.getGiaPhong());
            stm.executeUpdate();
            sql = "SET FOREIGN_KEY_CHECKS=1;";
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean updateHDP(DatPhongModel dat) {
        try {
            Connection conn = this.getConnection();
            String sql = "update phong set tinhTrang='0' where maPhong= ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, dat.getMaPhong());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    // huy dat phong khach    
// p
    // Nhan
    public ArrayList<DatPhongModel> getDulieu() {
        ArrayList<DatPhongModel> arr = new ArrayList<>();

        try {
            Connection conn = this.getConnection();

            String sql = "select * from lich_dat_phong";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DatPhongModel datP = new DatPhongModel(rs.getString(1), rs.getString(3),
                        rs.getString(2), rs.getDate(4), rs.getDate(5), rs.getFloat(6));
                arr.add(datP);
            }
            return arr;
        } catch (SQLException ex) {
            System.out.println("Khong thanh cong");
        }
        return arr;
    }

    public boolean addRoom1(DatPhongModel room) {
        Connection conn = this.getConnection();
        String query = "";
        try {
            Statement st = conn.createStatement();

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Chuyển đổi Date sang chuỗi
            String ngayDat = dateFormat.format(room.thoiGianDat);
            String ngayBD = dateFormat.format(room.thoiGianBatDau);

            query = "insert into lich_dat_phong value ('" + room.getMaDP() + "','" + room.getMaKH() + "','" + room.getMaPhong() + "','" + ngayDat
                    + "','" + ngayBD + "'," + room.getGiaPhong() + ")";
            st.executeUpdate(query);

            System.out.println(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(query);
            System.out.println("Khong thanh cong");
        }
        return false;

    }

    public boolean xoaP(DatPhongModel phong) throws SQLException {
        Connection conn = this.getConnection();
        String query = "";
        try {
            Statement st = conn.createStatement();
            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            query = "delete from lich_dat_phong where maDatPhong='" + phong.getMaDP() + "'";
            st.executeUpdate(query);
            System.out.println(query);
            sql = "SET FOREIGN_KEY_CHECKS=1;";
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println(query);
            System.out.println("Khong thanh cong");
        }
        return false;
    }

    public boolean update1(DatPhongModel room) {
        Connection conn = this.getConnection();
        String query = "";

        try {

            String sql = "SET FOREIGN_KEY_CHECKS=0;";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.executeUpdate();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Chuyển đổi Date sang chuỗi
            String ngayDat = dateFormat.format(room.thoiGianDat);
            String ngayBD = dateFormat.format(room.thoiGianBatDau);
            query = "update lich_dat_phong set maKhachHang =?, maPhong=?, thoiGianDat =?, thoiGianBatDauSuDung=?,giaPhong=? where maDatPhong =? ";
            PreparedStatement stm = conn.prepareStatement(query);
            stm.setString(1, room.getMaKH());
            stm.setString(2, room.getMaPhong());
            stm.setString(3, ngayDat);
            stm.setString(4, ngayBD);
            stm.setFloat(5, room.getGiaPhong());
            stm.setString(6, room.getMaDP());
            stm.executeUpdate();
            String sqlUP = "SET FOREIGN_KEY_CHECKS=1;";
            conn.prepareStatement(sqlUP);
            stmt.executeUpdate();
            System.out.println(query);
            return true;
        } catch (SQLException ex) {
            System.out.println(query);

            System.out.println("Khong thanh cong");
        }
        return false;
    }

    public String getMaDP() {
        return maDP;
    }

    public void setMaDP(String maDP) {
        this.maDP = maDP;
    }

    public String getMaPhong() {
        return maPhong;
    }

    public void setMaPhong(String maPhong) {
        this.maPhong = maPhong;
    }

    public String getMaKH() {
        return maKH;
    }

    public void setMaKH(String maKH) {
        this.maKH = maKH;
    }

    public Date getThoiGianDat() {
        return thoiGianDat;
    }

    public void setThoiGianDat(Date thoiGianDat) {
        this.thoiGianDat = thoiGianDat;
    }

    public Date getThoiGianBatDau() {
        return thoiGianBatDau;
    }

    public void setThoiGianBatDau(Date thoiGianBatDau) {
        this.thoiGianBatDau = thoiGianBatDau;
    }

    public ArrayList<DichVuModel> getListDV() {
        return listDV;
    }

    public void setListDV(ArrayList<DichVuModel> listDV) {
        this.listDV = listDV;
    }

    public float getGiaPhong() {
        return giaPhong;
    }

    public void setGiaPhong(float giaPhong) {
        this.giaPhong = giaPhong;
    }
}
