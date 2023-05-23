/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.HoaDonController;
import Model.HoaDonModel;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hiep0
 */
public class DSHoaDon extends javax.swing.JPanel {
//        ArrayList<HoaDonModel> arr = new HoaDonModel().getDuLieu();

    final String header[] = {"Mã hóa đơn", "Mã khách hàng", "Tên khách hàng", "Mã đặt phòng", "Tiền phòng", "Tiền dịch vụ", "Ngày tạo", "Tổng tiền"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);

    public final void taiTrang(ArrayList<HoaDonModel> arr) {
        tb.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String ngayTao = date.format(arr.get(i).getNgayTao());
            String str1 = String.valueOf(arr.get(i).getTienPhong());
            String str2 = String.valueOf(arr.get(i).getTienDichVu());
            String str3 = String.valueOf(arr.get(i).getTongTien());
            String nd[] = {arr.get(i).getMaHoaDon(), arr.get(i).getMaKhachHang(),
            arr.get(i).getTenKhachHang(), arr.get(i).getMaDatPhong(), str1, str2, ngayTao, str3};
            tb.addRow(nd);

        }
        DanhSachHoaDon.setModel(tb);
    }

    public DSHoaDon() {
        initComponents();
        new HoaDonController(this).hienthi();
    }
    
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        DanhSachHoaDon = new javax.swing.JTable();

        DanhSachHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã KH", "Tên KH", "Phòng thuê", "Tiền phòng", "Tiền dịch vụ", "Ngày làm", "Tông tiền"
            }
        ));
        jScrollPane1.setViewportView(DanhSachHoaDon);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1273, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                .addGap(24, 24, 24))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable DanhSachHoaDon;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
