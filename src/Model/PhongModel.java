/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
