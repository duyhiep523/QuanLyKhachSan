/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.NguoiDungController;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/**
 *
 * @author hiep0
 */
public class ManHinhChinh extends javax.swing.JFrame {

    private static JButton btnQL;

    public ManHinhChinh() {
        this.setTitle("Màn hình chính");
        initComponents();
        AnhNgoai a = new AnhNgoai();
        a.setSize(1320, 820);
        a.setLocation(0, 0);
        content.removeAll();
        content.add(a, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();

        this.btnTT.setText(NguoiDungController.ndOn.getHoTen());

    }

    public void updateTTAVT() {
        this.btnTT.setText(NguoiDungController.ndOn.getHoTen());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        phongBtn = new javax.swing.JButton();
        HoaDonBtn = new javax.swing.JButton();
        dichVuBtn = new javax.swing.JButton();
        thongKeBtn = new javax.swing.JButton();
        khachBtn = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        datPhongBtn = new javax.swing.JButton();
        btnTT = new javax.swing.JToggleButton();
        DatDVBtn = new javax.swing.JButton();
        content = new javax.swing.JPanel();

        jPopupMenu1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(245, 245, 245));

        phongBtn.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        phongBtn.setText("Quản lý phòng");
        phongBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        phongBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                phongBtnActionPerformed(evt);
            }
        });

        HoaDonBtn.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        HoaDonBtn.setText("Hóa đơn");
        HoaDonBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        HoaDonBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HoaDonBtnActionPerformed(evt);
            }
        });

        dichVuBtn.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        dichVuBtn.setText("Dịch vụ");
        dichVuBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        dichVuBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dichVuBtnActionPerformed(evt);
            }
        });

        thongKeBtn.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        thongKeBtn.setText("Thống kê");
        thongKeBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        thongKeBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                thongKeBtnActionPerformed(evt);
            }
        });

        khachBtn.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        khachBtn.setText("Quản lý khách");
        khachBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        khachBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                khachBtnActionPerformed(evt);
            }
        });

        jButton6.setBackground(new java.awt.Color(255, 51, 51));
        jButton6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jButton6.setText("Đăng xuất");
        jButton6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 0));
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        datPhongBtn.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        datPhongBtn.setText("Đặt phòng");
        datPhongBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        datPhongBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                datPhongBtnActionPerformed(evt);
            }
        });

        btnTT.setBackground(new java.awt.Color(0, 204, 255));
        btnTT.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        btnTT.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/666201 (1).png"))); // NOI18N
        btnTT.setText("Nguyễn Duy Hiệp");
        btnTT.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnTT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTTActionPerformed(evt);
            }
        });

        DatDVBtn.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        DatDVBtn.setText("Đặt dịch vụ");
        DatDVBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DatDVBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatDVBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(btnTT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 209, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(thongKeBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(dichVuBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(HoaDonBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(khachBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(datPhongBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(phongBtn, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DatDVBtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(btnTT)
                .addGap(27, 27, 27)
                .addComponent(phongBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(datPhongBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(khachBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25)
                .addComponent(HoaDonBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(dichVuBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31)
                .addComponent(DatDVBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(thongKeBtn, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        content.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout contentLayout = new javax.swing.GroupLayout(content);
        content.setLayout(contentLayout);
        contentLayout.setHorizontalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1649, Short.MAX_VALUE)
        );
        contentLayout.setVerticalGroup(
            contentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(content, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(content, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        JOptionPane.showConfirmDialog(this, "Xác nhận đăng xuất", "Thông báo", JOptionPane.YES_NO_OPTION);
        this.setVisible(false);
        new DangNhap().setVisible(true);
        this.dispose();//
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void khachBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_khachBtnActionPerformed
        if (btnQL != null) {
            btnQL.setBackground(Color.white);
            btnQL.setForeground(Color.black);
        }
        QLKhach qlk = new QLKhach();
        qlk.setSize(1285, 800);
        qlk.setLocation(0, 0);
        content.removeAll();
        content.add(qlk, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        Color cl = new Color(51, 102, 255);
        khachBtn.setBackground(cl);
        khachBtn.setForeground(Color.white);
        btnQL = khachBtn;
        // TODO add your handling code here:
    }//GEN-LAST:event_khachBtnActionPerformed

    private void phongBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_phongBtnActionPerformed
        if (btnQL != null) {
            btnQL.setBackground(Color.white);
            btnQL.setForeground(Color.black);
        }
        QLPhong qlp = new QLPhong();
        qlp.setSize(1285, 800);
        qlp.setLocation(0, 0);
        content.removeAll();
        content.add(qlp, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        Color cl = new Color(51, 102, 255);
        phongBtn.setBackground(cl);
        phongBtn.setForeground(Color.white);
        btnQL = phongBtn;
    }//GEN-LAST:event_phongBtnActionPerformed

    private void datPhongBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_datPhongBtnActionPerformed
        if (btnQL != null) {
            btnQL.setBackground(Color.white);
            btnQL.setForeground(Color.black);
        }
        QLDatPhong qldp = new QLDatPhong();
        qldp.setSize(1285, 800);
        qldp.setLocation(0, 0);
        content.removeAll();
        content.add(qldp, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        Color cl = new Color(51, 102, 255);
        datPhongBtn.setBackground(cl);
        datPhongBtn.setForeground(Color.white);
        btnQL = datPhongBtn;
        // TODO add your handling code here:        
    }//GEN-LAST:event_datPhongBtnActionPerformed

    private void btnTTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTTActionPerformed
        NguoiDung n1 = new NguoiDung(this);
        n1.setLocationRelativeTo(null);
        n1.setVisible(true);
        this.updateTTAVT();
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTTActionPerformed

    private void HoaDonBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HoaDonBtnActionPerformed
        if (btnQL != null) {
            btnQL.setBackground(Color.white);
            btnQL.setForeground(Color.black);
        }
        QLHoaDon qlhd = new QLHoaDon();
        qlhd.setSize(1285, 800);
        qlhd.setLocation(0, 0);
        content.removeAll();
        content.add(qlhd, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        Color cl = new Color(51, 102, 255);
        HoaDonBtn.setBackground(cl);
        HoaDonBtn.setForeground(Color.white);
        btnQL = HoaDonBtn;        // TODO add your handling code here:
    }//GEN-LAST:event_HoaDonBtnActionPerformed

    private void dichVuBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dichVuBtnActionPerformed
        if (btnQL != null) {
            btnQL.setBackground(Color.white);
            btnQL.setForeground(Color.black);
        }
        QLDichVu qldv = new QLDichVu();
        qldv.setSize(1285, 800);
        qldv.setLocation(0, 0);
        content.removeAll();
        content.add(qldv, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        Color cl = new Color(51, 102, 255);
        dichVuBtn.setBackground(cl);
        dichVuBtn.setForeground(Color.white);
        btnQL = dichVuBtn;        // TODO add your handling code here:
    }//GEN-LAST:event_dichVuBtnActionPerformed

    private void thongKeBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_thongKeBtnActionPerformed
        if (btnQL != null) {
            btnQL.setBackground(Color.white);
            btnQL.setForeground(Color.black);
        }
        QLThongKe qltk = new QLThongKe();
        qltk.setSize(1285, 800);
        qltk.setLocation(0, 0);
        content.removeAll();
        content.add(qltk, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        Color cl = new Color(51, 102, 255);
        thongKeBtn.setBackground(cl);
        thongKeBtn.setForeground(Color.white);
        btnQL = thongKeBtn;  // TODO add your handling code here:
    }//GEN-LAST:event_thongKeBtnActionPerformed

    private void DatDVBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatDVBtnActionPerformed
        if (btnQL != null) {
            btnQL.setBackground(Color.white);
            btnQL.setForeground(Color.black);
        }
        QLThemDV qltdv = new QLThemDV();
        qltdv.setSize(1285, 800);
        qltdv.setLocation(0, 0);
        content.removeAll();
        content.add(qltdv, BorderLayout.CENTER);
        content.revalidate();
        content.repaint();
        Color cl = new Color(51, 102, 255);
        DatDVBtn.setBackground(cl);
        DatDVBtn.setForeground(Color.white);
        btnQL = DatDVBtn;  // TODO add your handling code here:

    }//GEN-LAST:event_DatDVBtnActionPerformed

    public static void run() {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DangNhap.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new ManHinhChinh().setVisible(true);

        });
    }

    public static void main(String[] args) {
        new ManHinhChinh().setVisible(true);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DatDVBtn;
    private javax.swing.JButton HoaDonBtn;
    private javax.swing.JToggleButton btnTT;
    private javax.swing.JPanel content;
    private javax.swing.JButton datPhongBtn;
    private javax.swing.JButton dichVuBtn;
    private javax.swing.JButton jButton6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JButton khachBtn;
    private javax.swing.JButton phongBtn;
    private javax.swing.JButton thongKeBtn;
    // End of variables declaration//GEN-END:variables

}
