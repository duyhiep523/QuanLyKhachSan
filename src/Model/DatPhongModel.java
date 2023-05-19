/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.KhachHangController;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

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
