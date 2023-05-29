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
    
        public ArrayList<PhongModel> getPhongTheoMaKH() {
        ArrayList<PhongModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();

            String sql = "select phong.maPhong, phong.tenPhong, phong.loaiPhong, phong.GiaPhong from phong inner join lich_dat_phong ON \n" +
            "phong.maPhong =  lich_dat_phong.maPhong\n" +"where lich_dat_phong.maKhachHang = ?";
            PreparedStatement stm = conn.prepareStatement(sql); 
            stm.setString(1, KhachHangController.khOn.getMaKH());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhongModel phong = new PhongModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
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

            String sql = "select phong.maPhong, phong.tenPhong, phong.loaiPhong, phong.GiaPhong from phong inner join lich_dat_phong ON \n" +
            "phong.maPhong =  lich_dat_phong.maPhong\n" +"where lich_dat_phong.maKhachHang = ? and phong.loaiPhong = '"+key+"'";
            PreparedStatement stm = conn.prepareStatement(sql); 
            stm.setString(1, KhachHangController.khOn.getMaKH());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                PhongModel phong = new PhongModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getFloat(4));
                arr.add(phong);
            }
            System.out.println("hhhhhh");
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

            String sql = "select phong.maPhong, phong.tenPhong, phong.loaiPhong, phong.giaPhong from phong inner join lich_dat_phong ON \n" +
            "phong.maPhong =  lich_dat_phong.maPhong\n" +"where lich_dat_phong.maKhachHang = ? and phong.giaPhong = '"+ key+"'";
            PreparedStatement stm = conn.prepareStatement(sql); 
            stm.setString(1, KhachHangController.khOn.getMaKH());
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
    

    
    public int CountPhong(){
        int i = 1;
        try{
            Connection conn = this.getConnection();
            String sql = "select count(maPhong) from phong";
            PreparedStatement stmm = conn.prepareStatement(sql);
            ResultSet rs = stmm.executeQuery();
            while(rs.next()){
                i = rs.getInt(i);
            }
            return i;
        }catch(SQLException ex){
            System.out.println("Khong thong ke duoc phong");
        }
        return i;
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