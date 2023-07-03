/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import Controller.KhachHangController;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Date;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import View.QLHoaDon;

/**
 *
 * @author tu
 */
public class HoaDonModel extends CSDL {

    private String maHoaDon;
    private String maDatPHong;
    private Date ngayTao;
    private String maKhachHang;
    private String TenKhachHang;
    private float TienPhong;
    private float TienDichVu;
    private float TongTien;
    private int count;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public HoaDonModel() {

    }

    public HoaDonModel(int count) {
        this.count = count;
    }

    public HoaDonModel(String maHoaDon, String maKhachHang, String TenKhachHang,
            String maDatPHong, float TienPhong, float TienDichVu, Date ngayTao, float TongTien) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.TenKhachHang = TenKhachHang;
        this.maDatPHong = maDatPHong;
        this.TienPhong = TienPhong;
        this.TienDichVu = TienDichVu;
        this.ngayTao = ngayTao;
        this.TongTien = TongTien;
    }

    public HoaDonModel(String maHoaDon, String maDatPHong, Date ngayTao) {
        this.maHoaDon = maHoaDon;
        this.maDatPHong = maDatPHong;
        this.ngayTao = ngayTao;
    }

//    lấy dữ liệu tính tiền

    public ArrayList<HoaDonModel> getDuLieu() {
        ArrayList<HoaDonModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            Statement stm = conn.createStatement();
            ResultSet rs = stm.executeQuery("select * from danh_sach_hoa_don;");
            while (rs.next()) {
                HoaDonModel hd = new HoaDonModel();
                hd.setMaHoaDon(rs.getString(1));
                hd.setMaKhachHang(rs.getString(2));
                hd.setTenKhachHang(rs.getString(3));
                hd.setMaDatPhong(rs.getString(4));
                hd.setTienPhong(rs.getFloat(5));
                hd.setTienDichVu(rs.getFloat(6));
                hd.setNgayTao(rs.getDate(7));
                hd.setTongTien(rs.getFloat(8));
                arr.add(hd);
            }

            return arr;
        } catch (SQLException ex) {
            System.out.println("Khong the do du lieu len !!!");
        }
        return arr;
    }

    public String getMaHoaDon() {
        return maHoaDon;
    }

    public void setMaHoaDon(String maHoaDon) {
        this.maHoaDon = maHoaDon;
    }

    public String getMaDatPhong() {
        return maDatPHong;
    }

    public void setMaDatPhong(String maDatPHong) {
        this.maDatPHong = maDatPHong;
    }

    public Date getNgayTao() {
        return ngayTao;
    }

    public void setNgayTao(Date ngayTao) {
        this.ngayTao = ngayTao;
    }

    public String getMaKhachHang() {
        return maKhachHang;
    }

    public void setMaKhachHang(String maKhachHang) {
        this.maKhachHang = maKhachHang;
    }

    public String getTenKhachHang() {
        return TenKhachHang;
    }

    public void setTenKhachHang(String TenKhachHang) {
        this.TenKhachHang = TenKhachHang;
    }

    public float getTienPhong() {
        return TienPhong;
    }

    public void setTienPhong(float TienPhong) {
        this.TienPhong = TienPhong;
    }

    public float getTienDichVu() {
        return TienDichVu;
    }

    public void setTienDichVu(float TienDichVu) {
        this.TienDichVu = TienDichVu;
    }

    public float getTongTien() {
        return TongTien;
    }

    public void setTongTien(float TongTien) {
        this.TongTien = TongTien;
    }

    public boolean addHoaDon(HoaDonModel hd) {
        try {
            Connection conn = this.getConnection();
            String sql0 = "SET FOREIGN_KEY_CHECKS=0;";
            PreparedStatement stm0 = conn.prepareStatement(sql0);
            stm0.executeUpdate();
            String query = "select count(maHoaDon) from hoa_don where maHoaDon = '" + hd.getMaHoaDon() + "'";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                i = rs.getInt(1);
            }
            if (i > 0) {
                new QLHoaDon().showMessageFail("Mã Hóa đơn đã tồn tại");
                return false;
            }

            query = "select count(maDatPhong) from hoa_don where maDatPhong = '" + hd.getMaDatPhong() + "'";
            rs = s.executeQuery(query);
            while (rs.next()) {
                i = rs.getInt(1);
            }
            if (i > 0) {
                new QLHoaDon().showMessageFail("Mã Đặt Phòng đã tồn tại trong Hóa Đơn");
                return false;
            }

//            String query1 = "SELECT count(hoa_don.maDatPhong) from hoa_don inner join lich_dat_phong on hoa_don.maDatPhong = lich_dat_phong.maDatPhong \n"
//                    + "where hoa_don.maDatPhong = '" + hd.getMaDatPhong() + "' and '"+ hd.getNgayTao()+"' < lich_dat_phong.thoiGianBatDauSuDung;";
//            rs = s.executeQuery(query1);
//            while (rs.next()) {
//                i = rs.getInt(1);
//                System.out.println("i === " + i);
//                System.out.println(query1);
//            }
//            if (i > 0) {
//                
//                
//                
//                new QLHoaDon().showMessageFail("Ngày tạo Hóa đơn nhỏ hơn ngày bắt đầu sử dụng phòng !");
//               
//                return false;
//            }

            query = "select count(maDatPhong) from lich_dat_phong where maDatPhong = '" + hd.getMaDatPhong() + "'";
            rs = s.executeQuery(query);
            while (rs.next()) {
                i = rs.getInt(1);
            }
            if (i <= 0) {
                new QLHoaDon().showMessageFail("Mã Đặt Phòng ko tồn tại trong Lịch Đặt Phòng");
                return false;
            }

            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String ngayTao = format.format(hd.getNgayTao());
            String sql = "insert into hoa_don(maHoaDon, maDatPhong, ngayTao) values(?,?,?)";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, hd.getMaHoaDon());
            stm.setString(2, hd.getMaDatPhong());
            stm.setString(3, ngayTao);
            stm.executeUpdate();
            sql = "SET FOREIGN_KEY_CHECKS=1;";
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            System.out.println("loi tao hoa don");
            Logger.getLogger(HoaDonModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean suaHoaDon(HoaDonModel hd) {
        try {
            Connection conn = this.getConnection();
            String sql0 = "SET FOREIGN_KEY_CHECKS=0;";
            PreparedStatement stm0 = conn.prepareStatement(sql0);
            stm0.executeUpdate();
            String sql = "update hoa_don set maDatPhong = ?, ngayTao = ? where maHoaDon = '" + hd.getMaHoaDon() + "'";
            PreparedStatement stm = conn.prepareStatement(sql);
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            String ngayTao = format.format(hd.getNgayTao());
            stm.setString(1, hd.getMaDatPhong());
            stm.setString(2, ngayTao);
            stm.executeUpdate();
            
            String query = "select count(maDatPhong) from hoa_don where maDatPhong = '" + hd.getMaDatPhong() + "'";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                i = rs.getInt(1);
            }
                        sql = "SET FOREIGN_KEY_CHECKS=1;";
            stm = conn.prepareStatement(sql);
            stm.executeUpdate();
            if (i > 1) {
                new QLHoaDon().showMessageFail("Mã Đặt Phòng đã tồn tại trong Hóa đơn");
                return false;
            }
            return true;
        } catch (SQLException ex) {
            System.out.println("error in HoaDonModel suaHoaDon");
            Logger.getLogger(KhachHangModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean xoaHoaDon(HoaDonModel hd) {
        try {
            Connection conn = this.getConnection();
            String query = "select count(maHoaDon) from hoa_don where maHoaDon = '" + hd.getMaHoaDon() + "'";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);
            int i = 0;
            while (rs.next()) {
                i = rs.getInt(1);
            }
            if (i <= 0) {
                new QLHoaDon().showMessageFail("Không có hóa đơn này!");
                return false;
            }

            String sql = "delete from hoa_don WHERE maHoaDon = '" + hd.getMaHoaDon() + "'";
            Statement stm = conn.createStatement();
            stm.executeUpdate(sql);
            return true;
        } catch (SQLException ex) {
            System.out.println("error in HoaDonModel xoaHoaDon");
            Logger.getLogger(KhachHangModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;

    }

    public HoaDonModel(String maHoaDon) {
        this.maHoaDon = maHoaDon;

    }

    public ArrayList<HoaDonModel> timKiemHoaDon(String key1) {
        ArrayList<HoaDonModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "select * from danh_sach_hoa_don where maHoaDon like '%" + key1 + "%'";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDonModel hoadon = new HoaDonModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getDate(7), rs.getFloat(8));
                arr.add(hoadon);
            }
            return arr;

        } catch (SQLException ex) {
            System.out.println("khong tim kiem duoc hoa don");
        }
        return arr;
    }

    public ArrayList<HoaDonModel> timKiemKhachHang(String key1) {
        ArrayList<HoaDonModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "select * from danh_sach_hoa_don where maKhachHang like '%" + key1 + "%'";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDonModel hoadon = new HoaDonModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getDate(7), rs.getFloat(8));
                arr.add(hoadon);
            }
            return arr;

        } catch (SQLException ex) {
            System.out.println("khong tim kiem duoc ma khach han");
        }
        return arr;
    }

    public ArrayList<HoaDonModel> timKiemDatPhong(String key1) {
        ArrayList<HoaDonModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "select * from danh_sach_hoa_don where maDatPhong like '%" + key1 + "%'";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDonModel hoadon = new HoaDonModel(rs.getString(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getFloat(6), rs.getDate(7), rs.getFloat(8));
                arr.add(hoadon);
            }
            return arr;

        } catch (SQLException ex) {
            System.out.println("khong tim kiem duoc ma Dat Phong");
        }
        return arr;
    }

    public int demSoHoaDon() {
        int i = 1;
        try {

            Connection conn = this.getConnection();
            String query = "select count(maHoaDon) from hoa_don";
            Statement s = conn.createStatement();
            ResultSet rs = s.executeQuery(query);

            while (rs.next()) {
                i = rs.getInt(i);
            }
            return i;
        } catch (SQLException ex) {
            System.out.println("khong thong ke duoc hoa don");
            Logger.getLogger(HoaDonModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i;
    }

    public ArrayList<HoaDonModel> layHoaDonTheoMaKhachHang() {
        ArrayList<HoaDonModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "select * from danh_sach_hoa_don where maKhachHang = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, KhachHangController.khOn.getMaKH());
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                HoaDonModel hd = new HoaDonModel();
                hd.setMaHoaDon(rs.getString(1));
                hd.setMaKhachHang(rs.getString(2));
                hd.setTenKhachHang(rs.getString(3));
                hd.setMaDatPhong(rs.getString(4));
                hd.setTienPhong(rs.getFloat(5));
                hd.setTienDichVu(rs.getFloat(6));
                hd.setNgayTao(rs.getDate(7));
                hd.setTongTien(rs.getFloat(8));
                arr.add(hd);
            }
            return arr;
        } catch (SQLException ex) {
            System.out.println("Không lấy được mã hóa đơn đổ lên TrinhTrangKhachHang");
        }
        return arr;
    }
}