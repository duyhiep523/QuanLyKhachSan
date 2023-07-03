/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.KhachHangController;
import Model.KhachHangModel;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hiep0
 */
public class QLKhach extends javax.swing.JPanel {

    ArrayList<KhachHangModel> arr = new KhachHangModel().getCustomer();

    public QLKhach() {
        initComponents();
        taiTrang(layKHtheoYeuCau());
    }
    final String header[] = {"Mã Khách Hàng ", "Tên Khách Hàng", "Giới Tính",
        "SĐT", "CCCD", "tài khoản", "mật khẩu"};
    final DefaultTableModel df = new DefaultTableModel(header, 0);

    public final void taiTrang(ArrayList<KhachHangModel> arr) {
        df.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            boolean b = arr.get(i).getGioiTinh();
            String s = b ? "Nam" : "Nữ";
            String nd[] = {arr.get(i).getMaKH(),
                arr.get(i).getTenKH(), s,
                arr.get(i).getSDT(),
                arr.get(i).getCMND(),
                arr.get(i).getTaiKhoan(), arr.get(i).getMatKhau()
            };
            df.addRow(nd);
        }
        table.setModel(df);
    }

    public void Display(int i) {
        KhachHangModel kh = layKHtheoYeuCau().get(i);
        txt_mkh.setText(kh.getMaKH());
        txt_tenkh.setText(kh.getTenKH());
        if (arr.get(i).getGioiTinh().equals(true)) {

            txt_gt.setSelectedItem("Nam");
        } else {
            txt_gt.setSelectedItem("Nữ");
        }
        txt_sdt.setText(kh.getSDT());
        txt_cmnd.setText(kh.getCMND());
        txt_tk.setText(kh.getTaiKhoan());
        txt_mk.setText(kh.getMatKhau());

    }

    public void resetForm() {
        txt_mkh.setText("");
        txt_tenkh.setText("");
        txt_cmnd.setText("");
        txt_sdt.setText("");
        txt_tk.setText("");
        txt_mk.setText("");
    }
    public static boolean gt=false;

    public KhachHangModel getKH() {
        String maKH = txt_mkh.getText();
        String tenKH = txt_tenkh.getText();
        String SDT = txt_sdt.getText();
        String CMND = txt_cmnd.getText();
        String TK = txt_tk.getText();
        String MK = txt_mk.getText();
        boolean gioiTinh;
        if (txt_gt.getSelectedIndex() == 0) {
            gt = true;
            gioiTinh = false;

        }
        gioiTinh = txt_gt.getSelectedIndex() == 1;
        return new KhachHangModel(maKH, tenKH, gioiTinh, SDT, CMND, TK, MK);

    }

    ArrayList<KhachHangModel> layKHtheoYeuCau() {
        if (txt_s.equals("")) {
            return new KhachHangModel().getCustomer();

        }
        return new KhachHangModel().timkiem(txt_s.getText());
    }
    int result = 0;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        btn_add = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_dele = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txt_gt = new javax.swing.JComboBox<>();
        txt_mkh = new javax.swing.JTextField();
        txt_tenkh = new javax.swing.JTextField();
        txt_sdt = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        txt_cmnd = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txt_s = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_tk = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_mk = new javax.swing.JTextField();

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        table.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã khách hàng", "Tên khách hàng", "CMND", "Số điện thoại", "Giới tính", "Title 6", "Title 7"
            }
        ));
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(table);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));

        btn_add.setBackground(new java.awt.Color(0, 204, 255));
        btn_add.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_add.setText("Thêm");
        btn_add.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_addActionPerformed(evt);
            }
        });

        btn_edit.setBackground(new java.awt.Color(0, 204, 255));
        btn_edit.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_edit.setText("Sửa");
        btn_edit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_dele.setBackground(new java.awt.Color(0, 204, 255));
        btn_dele.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btn_dele.setText("Xóa");
        btn_dele.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btn_dele.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_deleActionPerformed(evt);
            }
        });

        jButton4.setBackground(new java.awt.Color(0, 204, 255));
        jButton4.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jButton4.setText("Làm mới");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(35, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btn_add, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_dele, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(btn_add)
                .addGap(35, 35, 35)
                .addComponent(btn_edit)
                .addGap(35, 35, 35)
                .addComponent(btn_dele)
                .addGap(35, 35, 35)
                .addComponent(jButton4)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Quản lý khách hàng");

        jLabel2.setText("Mã khách hàng");

        jLabel3.setText("Tên khách hàng");

        jLabel4.setText("Số điện thoại");

        jLabel5.setText("Giới tính");

        txt_gt.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "", "Nam", "Nữ" }));
        txt_gt.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        txt_gt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_gtActionPerformed(evt);
            }
        });

        jLabel6.setText("CMND");

        jLabel10.setText("Tìm Kiếm");

        txt_s.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_sKeyReleased(evt);
            }
        });

        jLabel7.setText("Tài Khoản");

        jLabel8.setText("Mật Khẩu");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 88, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_mkh)
                            .addComponent(txt_tenkh)
                            .addComponent(txt_sdt)
                            .addComponent(txt_gt, 0, 150, Short.MAX_VALUE)
                            .addComponent(txt_cmnd))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, 65, Short.MAX_VALUE))
                        .addGap(47, 47, 47)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_tk)
                            .addComponent(txt_mk, javax.swing.GroupLayout.DEFAULT_SIZE, 115, Short.MAX_VALUE))
                        .addGap(75, 75, 75)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(txt_s, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(249, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(txt_mkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_tk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txt_tenkh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)
                            .addComponent(txt_mk, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txt_gt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txt_sdt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(txt_cmnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txt_s, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(127, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 322, javax.swing.GroupLayout.PREFERRED_SIZE))
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

    private void txt_gtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_gtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_gtActionPerformed

    private void tableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableMouseClicked
        result = table.getSelectedRow();
        Display(result);

        // TODO add your handling code here:
    }//GEN-LAST:event_tableMouseClicked

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        resetForm();
        arr = new KhachHangModel().getCustomer();
        taiTrang(layKHtheoYeuCau());
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void btn_addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_addActionPerformed
        new KhachHangController(this).themKH();
        arr = new KhachHangModel().getCustomer();
        taiTrang(layKHtheoYeuCau());      // TODO add your handling code here:
    }//GEN-LAST:event_btn_addActionPerformed

    private void btn_deleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_deleActionPerformed
        int Tb = JOptionPane.showConfirmDialog(this, "bạn chắc xóa rồi chứ!", "thông báo", JOptionPane.YES_NO_OPTION);
        if (Tb == JOptionPane.YES_OPTION) {
            new KhachHangController(this).xoaKH();

        }        // TODO add your handling code here:
    }//GEN-LAST:event_btn_deleActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        new KhachHangController(this).suaKH();
        arr = new KhachHangModel().getCustomer();
        taiTrang(layKHtheoYeuCau());        // TODO add your handling code here:
    }//GEN-LAST:event_btn_editActionPerformed

    private void txt_sKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_sKeyReleased
        taiTrang(layKHtheoYeuCau());        // TODO add your handling code here:
    }//GEN-LAST:event_txt_sKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_add;
    private javax.swing.JButton btn_dele;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable table;
    private javax.swing.JTextField txt_cmnd;
    private javax.swing.JComboBox<String> txt_gt;
    private javax.swing.JTextField txt_mk;
    private javax.swing.JTextField txt_mkh;
    private javax.swing.JTextField txt_s;
    private javax.swing.JTextField txt_sdt;
    private javax.swing.JTextField txt_tenkh;
    private javax.swing.JTextField txt_tk;
    // End of variables declaration//GEN-END:variables
}
