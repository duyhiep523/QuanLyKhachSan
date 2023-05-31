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
    private String serviceName;
    private float servicePrice;

    public DichVuModel(String serviceId, String serviceName, float servicePrice) {
        this.serviceId = serviceId;
        this.serviceName = serviceName;
        this.servicePrice = servicePrice;
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
            String sql = "select*from dich_vu";
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
    
            public ArrayList<DichVuModel> getDichVuTheoGia(Float gia) {
        ArrayList<DichVuModel> arr = new ArrayList<>();
        try {
            Connection conn = this.getConnection();
            String sql = "select * from dich_vu where giaDichVu = '"+gia+"'";
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
            String sql = "select * from dich_vu where tenDichVu like '%"+key+"%'";
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
        
    public Boolean them(DichVuModel dv) {
        try {
            Connection conn = this.getConnection();
            String sql = "select count(*) from dich_vu where maDichVu = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, dv.getServiceId());
            ResultSet rs = stm.executeQuery();
            if (rs.next()) {
                int count = rs.getInt(1);
                if (count == 0) {
                    // Nếu count == 0 nghĩa là mã dịch vụ chưa tồn tại
                    sql = "insert into dich_vu value (?, ?, ?)";
                    stm = conn.prepareStatement(sql);
                    stm.setString(1, dv.getServiceId());
                    stm.setString(2, dv.getServiceName());
                    stm.setDouble(3, dv.getServicePrice());
                    stm.executeUpdate();
                    return true;
                } else {
                    return false;
                }

            }
            return false;

        } catch (SQLException ex) {
            Logger.getLogger(DichVuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public boolean deleteDV(DichVuModel dv) {
        String sql = "";
        try {
            Connection conn = this.getConnection();
            sql = "delete from dich_vu where maDichVu =?";
            PreparedStatement st = conn.prepareStatement(sql);
            st = conn.prepareStatement(sql);
            st.setString(1, dv.serviceId);
            st.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DichVuModel.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    public Boolean sua(DichVuModel dv) {

        try {
            Connection conn = this.getConnection();
            String sql = "UPDATE dich_vu SET tenDichVu = ?, giaDichVu = ? WHERE maDichVu = ?";
            PreparedStatement stm = conn.prepareStatement(sql);
            stm.setString(1, dv.getServiceName());
            stm.setDouble(2, dv.getServicePrice());
            stm.setString(3, dv.getServiceId());
            stm.executeUpdate();
            return true;

        } catch (SQLException ex) {
            Logger.getLogger(DichVuModel.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public int CountDichVu(){
        int i = 1;
        try{
            Connection conn = this.getConnection();
            String sql = "select count(maDichVu) from dich_vu";
            PreparedStatement stm = conn.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                i = rs.getInt(i);
            }
            return i;
        }catch(SQLException ex){
             System.out.println("Không thống kê được dịch vụ");
             
        }
        return i;
    }

}