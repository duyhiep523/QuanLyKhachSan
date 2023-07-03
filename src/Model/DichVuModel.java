package Model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DichVuModel extends CSDL {

    private String serviceId;
    private String IdR;
    private String serviceName;
    private float servicePrice;
    private int soLuong;

    public DichVuModel(String serviceId, String IdR, String serviceName, float servicePrice, int soLuong) {
        this.serviceId = serviceId;
        this.IdR = IdR;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
        this.soLuong = soLuong;
    }

    public DichVuModel(String serviceId, String serviceName, float servicePrice) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;

    }

    public String getIdR() {
        return IdR;
    }

    public void setIdR(String IdR) {
        this.IdR = IdR;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public float getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(float servicePrice) {
        this.servicePrice = servicePrice;
    }

    public DichVuModel() {
    }

    public ArrayList<DichVuModel> getService() {
        ArrayList<DichVuModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "select*from dich_vu ORDER BY maDichVu ASC";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DichVuModel dv = new DichVuModel();
                dv.setServiceId(rs.getString(1));
                dv.setServiceName(rs.getString(2));
                dv.setServicePrice(rs.getFloat(3));
                arr.add(dv);
            }
            rs.close();
            statement.close();
            conn.close();
            return arr;
        } catch (SQLException ex) {
            System.out.println("noop");
        }
        return arr;
    }

    public ArrayList<DichVuModel> getService1() {
        ArrayList<DichVuModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "select*from chi_tiet_dich_vu ORDER BY maDatPhong ASC";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DichVuModel dv = new DichVuModel();
                dv.setServiceId(rs.getString(1));
                dv.setIdR(rs.getString(2));
                dv.setServiceName(rs.getString(3));
                dv.setServicePrice(rs.getFloat(4));
                dv.setSoLuong(rs.getInt(5));
                arr.add(dv);
            }
            rs.close();
            statement.close();
            conn.close();
            return arr;
        } catch (SQLException ex) {
            System.out.println("noop");
        }
        return arr;
    }

    public ArrayList<DichVuModel> getDichVuTheoGia(Float gia) {
        ArrayList<DichVuModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "select * from dich_vu where giaDichVu = '" + gia + "'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DichVuModel dv = new DichVuModel();
                dv.setServiceId(rs.getString(1));
                dv.setServiceName(rs.getString(2));
                dv.setServicePrice(rs.getFloat(3));
                arr.add(dv);
            }
            return arr;
        } catch (SQLException ex) {
            System.out.println("noop");
        }
        return arr;
    }

    public ArrayList<DichVuModel> getDichVuTheoTenDV(String key) {
        ArrayList<DichVuModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "select * from dich_vu where tenDichVu like '%" + key + "%'";
            PreparedStatement statement = conn.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                DichVuModel dv = new DichVuModel();
                dv.setServiceId(rs.getString(1));
                dv.setServiceName(rs.getString(2));
                dv.setServicePrice(rs.getFloat(3));
                arr.add(dv);
            }
            return arr;
        } catch (SQLException ex) {
            System.out.println("noop");
        }
        return arr;
    }

    public boolean them(DichVuModel dv) {

        try {
            Connection conn = this.getConnection();
            String sql = "SELECT COUNT(*) FROM dich_vu WHERE maDichVu = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, dv.getServiceId());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count == 0) {
                    // Nếu count == 0 nghĩa là mã dịch vụ chưa tồn tại
                    sql = "INSERT INTO dich_vu VALUES (?, ?, ?)";
//                    System.out.println(sql);
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, dv.getServiceId());
                    stm.setString(2, dv.getServiceName());
                    stm.setFloat(3, dv.getServicePrice());
                    stm.executeUpdate();
                    return true;
                } else {
                    return false;
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DichVuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean themDV(DichVuModel dv) {
        String sql;
        try {
            Connection conn = this.getConnection();
            sql = "INSERT INTO chi_tiet_dich_vu VALUES (?, ?, ?, ?, ?)";
            PreparedStatement stm = conn.prepareStatement(sql);
//            System.out.println(sql);
            stm.setString(1, dv.getServiceId());
            stm.setString(2, dv.getIdR());
            stm.setString(3, dv.getServiceName());
            stm.setFloat(4, dv.getServicePrice());
            stm.setInt(5, dv.getSoLuong());
            stm.executeUpdate();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(DichVuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteDV(DichVuModel dv) {
        String sql = "";
        try {
            Connection conn = this.getConnection();
            String re = "SET FOREIGN_KEY_CHECKS=0;";
            PreparedStatement stm = conn.prepareStatement(re);
            stm.executeUpdate();
            sql = "delete from dich_vu where maDichVu =?";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, dv.serviceId);
            st.executeUpdate();
            re = "SET FOREIGN_KEY_CHECKS=1;";
            stm = conn.prepareStatement(re);
            stm.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DichVuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteDV2(DichVuModel dv) {
        String sql = "";
        try {

            Connection conn = this.getConnection();
            String re = "SET FOREIGN_KEY_CHECKS=0;";
            PreparedStatement stm = conn.prepareStatement(re);
            stm.executeUpdate();
            sql = "delete from chi_tiet_dich_vu where maDichVu =?";
            PreparedStatement st = conn.prepareStatement(sql);

            st.setString(1, dv.serviceId);
            st.executeUpdate();
            re = "SET FOREIGN_KEY_CHECKS=1;";
            stm = conn.prepareStatement(re);
            stm.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DichVuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean sua(DichVuModel dv) {

        try {
            Connection conn = this.getConnection();
            String sql = "UPDATE dich_vu SET tenDichVu = ?, giaDichVu = ? WHERE maDichVu = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, dv.getServiceName());
            stm.setFloat(2, dv.getServicePrice());
            stm.setString(3, dv.getServiceId());
            stm.executeUpdate();
            return true;

        } catch (SQLException ex) {

            Logger.getLogger(DichVuModel.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public Boolean suaDV(DichVuModel dv) {

        try {
            Connection conn = this.getConnection();
            String sql = "UPDATE chi_tiet_dich_vu SET tenDichVu = ?,maDatPhong=?, giaTien = ?,soLuong=? WHERE maDichVu = ?";
//            System.out.println(sql);
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, dv.getServiceName());
            stm.setString(2, dv.getIdR());
            stm.setFloat(3, dv.getServicePrice());
            stm.setInt(4, dv.getSoLuong());
            stm.setString(5, dv.getServiceId());
            stm.executeUpdate();
            return true;

        } catch (SQLException ex) {

            Logger.getLogger(DichVuModel.class.getName()).log(Level.SEVERE, null, ex);

        }
        return false;
    }

    public ArrayList<DichVuModel> timkiem(String key) {
        ArrayList<DichVuModel> arr1 = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "SELECT * FROM dich_vu WHERE maDichVu LIKE '%" + key + "%' or tenDichVu LIKE '%" + key + "%' or giaDichVu LIKE '%" + key + "%'";
//            System.out.println(sql);
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                DichVuModel foundDv = new DichVuModel();
                foundDv.setServiceId(rs.getString(1));
                foundDv.setServiceName(rs.getString(2));
                foundDv.setServicePrice(rs.getFloat(3));
                arr1.add(foundDv);
            }
            return arr1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arr1;
    }

    public ArrayList<DichVuModel> timkiemdv(String key) {
        ArrayList<DichVuModel> arr1 = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "SELECT * FROM chi_tiet_dich_vu WHERE maDatPhong LIKE '%" + key + "%' ";
            System.out.println(sql);
            PreparedStatement st = conn.prepareStatement(sql);
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                DichVuModel foundDv = new DichVuModel();
                foundDv.setServiceId(rs.getString(1));
                foundDv.setIdR(rs.getString(2));
                foundDv.setServiceName(rs.getString(3));
                foundDv.setServicePrice(rs.getFloat(4));
                foundDv.setSoLuong(rs.getInt(5));
                arr1.add(foundDv);
            }
            System.out.println(sql);
            return arr1;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return arr1;
    }

    public int CountDichVu() {
        int i = 1;
        try {
            Connection conn = this.getConnection();
            String sql = "select count(maDichVu) from dich_vu";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                i = rs.getInt(i);
            }
            return i;
        } catch (SQLException ex) {
            System.out.println("Không thống kê được dịch vụ");

        }
        return i;
    }

}
