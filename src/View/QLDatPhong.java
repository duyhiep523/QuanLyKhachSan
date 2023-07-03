/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.DatPhongController;
import Model.DatPhongModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hiep0
 */
public class QLDatPhong extends javax.swing.JPanel {

    public QLDatPhong() {

        initComponents();
        taiTrang(getDatPhongQL());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TableDatPHONG = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtDP = new javax.swing.JTextField();
        txtMaphong = new javax.swing.JTextField();
        txtMaKH = new javax.swing.JTextField();
        txtGiaPhong = new javax.swing.JTextField();
        txtNgayDat = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtNgayBatDau = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Quản lý đặt phòng");

        TableDatPHONG.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã đặt phòng", "Mã phòng", "Tên người đặt", "Loại phòng", "Số điện thoại", "Căn cước", "Ngày đặt"
            }
        ));
        TableDatPHONG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TableDatPHONGMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TableDatPHONG);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jButton1.setBackground(new java.awt.Color(0, 204, 255));
        jButton1.setText("Thêm");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(0, 204, 255));
        jButton2.setText("Sửa ");
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(0, 204, 255));
        jButton3.setText("Xóa");
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton3MouseClicked(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 204, 255));
        jButton4.setText("Làm mới");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton4MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
                .addGap(24, 24, 24))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jButton1)
                .addGap(30, 30, 30)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jButton3)
                .addGap(30, 30, 30)
                .addComponent(jButton4)
                .addGap(10, 10, 10))
        );

        jLabel2.setText("Mã DP");

        jLabel3.setText("Mã phòng");

        jLabel4.setText("Mã KH");

        jLabel5.setText("Giá phòng");

        jLabel6.setText("Ngày đặt");

        jLabel7.setText("Ngày bắt đầu");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel5))
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtDP, javax.swing.GroupLayout.DEFAULT_SIZE, 189, Short.MAX_VALUE)
                            .addComponent(txtMaphong)
                            .addComponent(txtMaKH)
                            .addComponent(txtGiaPhong)
                            .addComponent(txtNgayDat)
                            .addComponent(txtNgayBatDau))
                        .addGap(71, 71, 71)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(276, 742, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtMaphong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txtNgayDat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(txtNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 66, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
public static boolean checkFL = false;
    public static boolean checkF2L = false;
    public static boolean checkn1 = false;
    public static boolean checkn2 = false;
    public static boolean checkOld = false;

    public DatPhongModel getPhong() {
        String ngayDat = txtNgayDat.getText();
        String ngayBD = txtNgayBatDau.getText();
        if (txtGiaPhong.getText().equals("")) {
            checkFL = true;
        }
        float gia;
        try {
            gia = Float.parseFloat(txtGiaPhong.getText());
            if (gia < 0) {
                checkF2L = true;
            }
        } catch (NumberFormatException ex) {
            gia = 0;
            checkF2L = true;
            System.out.println("hic");
        }
        Date date1 = null;
        Date date2 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(ngayDat);
        } catch (ParseException ex) {
            date1 = new Date();
            checkn1 = true;
            System.out.println("chiu roi");
        }
        try {
            date2 = new SimpleDateFormat("yyyy-MM-dd").parse(ngayBD);
        } catch (ParseException ex) {
            date2 = new Date();
            checkn2 = true;
            System.out.println("chiu roi");
        }
        if (!checkn2 && !checkn1) {
            int comparison = (date1).compareTo(date2);
            if (comparison > 0) {
                checkOld = true;
            }
        }
        return new DatPhongModel(txtDP.getText(), txtMaphong.getText(), txtMaKH.getText(), date1, date2, gia);
    }

    public ArrayList<DatPhongModel> getDatPhongQL() {
        return new DatPhongModel().getDulieu();

    }

    final String header[] = {"Mã Đặt Phòng", "Mã Phòng", "Mã Khách Hàng", "Thời Gian Đặt", "Thời gian bắt đầu sử dụng", "Giá phòng"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);

    public final void taiTrang(ArrayList<DatPhongModel> arr) {
        tb.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            float giaP = arr.get(i).getGiaPhong();
            String giaPhong = Float.toString(giaP);
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String thoigiandat = date.format(arr.get(i).getThoiGianDat());
            String tgianbdsd = date.format(arr.get(i).getThoiGianBatDau());
//            System.out.println(thoigiandat + "   " + tgianbdsd);
            String nd[] = {arr.get(i).getMaDP(), arr.get(i).getMaPhong(),
                arr.get(i).getMaKH(), thoigiandat, tgianbdsd, giaPhong};
            tb.addRow(nd);

        }
        TableDatPHONG.setModel(tb);
    }

    int hientai1 = 0;

    public void Display(int hientai) {
        DatPhongModel dp = getDatPhongQL().get(hientai);
        float giaP = dp.getGiaPhong();
        String giaPhong = String.valueOf(giaP);
        txtDP.setText(dp.getMaDP());
        txtMaphong.setText(dp.getMaPhong());
        txtMaKH.setText(dp.getMaKH());
        txtGiaPhong.setText(giaPhong);

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String ngayDat = format.format(dp.getThoiGianDat());
        String ngayBatDau = format.format(dp.getThoiGianBatDau());
        txtNgayDat.setText(ngayDat);
        txtNgayBatDau.setText(ngayBatDau);
    }

    public void reset() {
        txtDP.setText("");
        txtMaphong.setText("");
        txtMaKH.setText("");
        txtGiaPhong.setText("");
        txtNgayDat.setText("");
        txtNgayBatDau.setText("");
    }
    private void jButton4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton4MouseClicked
        // TODO add your handling code here:
        txtDP.setText("");
        txtMaphong.setText("");
        txtMaKH.setText("");
        txtGiaPhong.setText("");
        txtNgayDat.setText("");
        txtNgayBatDau.setText("");
    }//GEN-LAST:event_jButton4MouseClicked

    private void TableDatPHONGMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TableDatPHONGMouseClicked
        // TODO add your handling code here:
        hientai1 = TableDatPHONG.getSelectedRow();
        Display(hientai1);
    }//GEN-LAST:event_TableDatPHONGMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        new DatPhongController(this).QLDatPhong();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        new DatPhongController(this).updateRoom1();
    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseClicked
        // TODO add your handling code here:
        new DatPhongController(this).removeRoom();
    }//GEN-LAST:event_jButton3MouseClicked

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TableDatPHONG;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtDP;
    private javax.swing.JTextField txtGiaPhong;
    private javax.swing.JTextField txtMaKH;
    private javax.swing.JTextField txtMaphong;
    private javax.swing.JTextField txtNgayBatDau;
    private javax.swing.JTextField txtNgayDat;
    // End of variables declaration//GEN-END:variables
public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Thông báo", JOptionPane.ERROR_MESSAGE);
    }

    public void showMessageOK(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
}
