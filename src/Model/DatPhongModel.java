/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
