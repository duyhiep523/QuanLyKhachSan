/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View;

import Controller.HoaDonController;
import Model.HoaDonModel;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hiep0
 */
public class QLHoaDon extends javax.swing.JPanel {

    final String header[] = {"Mã hóa đơn", "Mã khách hàng", "Tên khách hàng", "Mã đặt phòng", "Tiền phòng", "Tiền dịch vụ", "Ngày tạo", "Tổng tiền"};
    final DefaultTableModel tb = new DefaultTableModel(header, 0);

    public final void taiTrang(ArrayList<HoaDonModel> arr) {

        tb.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
            String ngayTao = date.format(arr.get(i).getNgayTao());
            BigDecimal tienPhong = new BigDecimal(arr.get(i).getTienPhong());
            BigDecimal tienDichVu = new BigDecimal(arr.get(i).getTienPhong());
            BigDecimal tongTien = new BigDecimal(arr.get(i).getTienPhong());
            String str1 = String.valueOf(tienPhong.doubleValue());
            String str2 = String.valueOf(tienDichVu.doubleValue());
            String str3 = String.valueOf(tongTien.doubleValue());
            String nd[] = {arr.get(i).getMaHoaDon(), arr.get(i).getMaKhachHang(),
                arr.get(i).getTenKhachHang(), arr.get(i).getMaDatPhong(), str1, str2, ngayTao, str3};
            tb.addRow(nd);

        }
        DanhSachHoaDon.setModel(tb);
    }

    public void showMessageFail(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Thông báo", JOptionPane.ERROR_MESSAGE);
    }

    public void showMessageSuccess(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }

    public QLHoaDon() {
        initComponents();
        taiTrang(layDSHoaDon());

    }

    public void reset() {
        TxtmaHD.setText("");
        TxtmaDatPhong.setText("");
        TxtngayTao.setText("");
    }

    public final ArrayList<HoaDonModel> layDSHoaDon() {
        return new HoaDonModel().getDuLieu();
    }
//    lấy dữ liệu để THÊM HÓA ĐƠN

    public HoaDonModel getHoaDon() {
        String maHD = TxtmaHD.getText();
        String maDatPhong = TxtmaDatPhong.getText();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date ngayTao = new Date();
        try {
            ngayTao = format.parse(TxtngayTao.getText());
        } catch (ParseException ex) {
//            System.out.println("kill it");
//            try {
//                ngayTao = format.parse("2222-11-11");
//            } catch (ParseException ex1) {
//                Logger.getLogger(QLHoaDon.class.getName()).log(Level.SEVERE, null, ex1);
//                System.out.println("Error ngayTao in QLHoaDon");
//
//            }
        }
        return new HoaDonModel(maHD, maDatPhong, ngayTao);
    }

    private ArrayList<HoaDonModel> timKiemHoaDon() {
        if (jtextTimMaHoaDon.equals("")) {
            return new HoaDonModel().getDuLieu();
        } else {
            return new HoaDonModel().timKiemHoaDon(jtextTimMaHoaDon.getText());
        }
    }

    private ArrayList<HoaDonModel> timKiemKhachHang() {
        if (jTextMaKH.equals("")) {
            return new HoaDonModel().getDuLieu();
        } else {
            return new HoaDonModel().timKiemKhachHang(jTextMaKH.getText());
        }
    }

    public ArrayList<HoaDonModel> timKiemDatPhong() {
        if (jTextMaDP.equals("")) {
            return new HoaDonModel().getDuLieu();
        } else {
            return new HoaDonModel().timKiemDatPhong(jTextMaDP.getText());
        }
    }

    private ArrayList<HoaDonModel> timkiem() {
        if (jtextTimMaHoaDon.equals("")) {
            if (jTextMaKH.equals("")) {
                if (jTextMaDP.equals("")) {
                    return new HoaDonModel().getDuLieu();
                }
                return new HoaDonModel().timKiemDatPhong(jTextMaDP.getText());
            }
            return new HoaDonModel().timKiemKhachHang(jTextMaKH.getText());
        }
        return new HoaDonModel().timKiemHoaDon(jtextTimMaHoaDon.getText());
    }

    public HoaDonModel xoaHoaDon() {
        String maHD = TxtmaHD.getText();

        return new HoaDonModel(maHD);
    }

    int hientai = 0;

        public void setEnabledTRUE() {
        TxtmaHD.setEnabled(true);
        TxtmaDatPhong.setEnabled(true);
        TxtngayTao.setEnabled(true);
    }    
    
    public void SetsetEditableTrue() {
        TxtmaHD.setEditable(true);
        TxtmaDatPhong.setEditable(true);
        TxtngayTao.setEditable(true);
    }

    public void SetsetEditableFalse() {
        TxtmaHD.setEditable(false);
        TxtmaDatPhong.setEditable(false);
        TxtngayTao.setEditable(false);
    }

    public void Display(int i) {
        HoaDonModel hd = layDSHoaDon().get(i);
        TxtmaHD.setText(hd.getMaHoaDon());
        TxtmaDatPhong.setText(hd.getMaDatPhong());
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String ngayTao = format.format(hd.getNgayTao());
        TxtngayTao.setText(ngayTao);
        this.SetsetEditableFalse();
    }

    public void resetJtextField() {
        jTextMaDP.setText("");
        jTextMaKH.setText("");
        jtextTimMaHoaDon.setText("");
    }

    public void HienThiNgayTaoONutThem() {
        LocalDate curentDate = LocalDate.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        String ngayTao = formatter.format(curentDate);
        TxtngayTao.setText(ngayTao);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DanhSachHoaDon = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        ButtonADD = new javax.swing.JButton();
        ButtonDELETE = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        ButtonEDIT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        TxtmaHD = new javax.swing.JTextField();
        TxtmaDatPhong = new javax.swing.JTextField();
        TxtngayTao = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jtextTimMaHoaDon = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextMaDP = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jTextMaKH = new javax.swing.JTextField();

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setText("Hóa đơn");

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
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "Mã KH", "Tên KH", "Phòng thuê", "Tiền phòng", "Tiền dịch vụ", "Ngày làm", "Tổng tiền"
            }
        ));
        DanhSachHoaDon.setSelectionBackground(new java.awt.Color(204, 204, 204));
        DanhSachHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DanhSachHoaDonMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(DanhSachHoaDon);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        ButtonADD.setBackground(new java.awt.Color(0, 204, 255));
        ButtonADD.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonADD.setText("Thêm");
        ButtonADD.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonADD.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonADDActionPerformed(evt);
            }
        });

        ButtonDELETE.setBackground(new java.awt.Color(0, 204, 255));
        ButtonDELETE.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonDELETE.setText("Xóa");
        ButtonDELETE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        ButtonDELETE.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonDELETEActionPerformed(evt);
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

        ButtonEDIT.setBackground(new java.awt.Color(0, 204, 255));
        ButtonEDIT.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        ButtonEDIT.setText("Sửa");
        ButtonEDIT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButtonEDITActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonDELETE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonADD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ButtonEDIT, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(28, 28, 28))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(ButtonADD)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(ButtonEDIT)
                .addGap(25, 25, 25)
                .addComponent(ButtonDELETE)
                .addGap(25, 25, 25)
                .addComponent(jButton4)
                .addGap(15, 15, 15))
        );

        jLabel2.setText("Ma HD");

        jLabel4.setText("Mã DP");

        jLabel5.setText("Ngày tạo");

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jtextTimMaHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtextTimMaHoaDonMouseClicked(evt);
            }
        });
        jtextTimMaHoaDon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtextTimMaHoaDonActionPerformed(evt);
            }
        });
        jtextTimMaHoaDon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtextTimMaHoaDonKeyReleased(evt);
            }
        });

        jLabel6.setText("Mã HD");

        jLabel7.setText("Mã DP");

        jTextMaDP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextMaDPMouseClicked(evt);
            }
        });
        jTextMaDP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMaDPActionPerformed(evt);
            }
        });
        jTextMaDP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextMaDPKeyReleased(evt);
            }
        });

        jLabel8.setText("Mã KH");

        jTextMaKH.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTextMaKHMouseClicked(evt);
            }
        });
        jTextMaKH.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextMaKHActionPerformed(evt);
            }
        });
        jTextMaKH.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jTextMaKHKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtextTimMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaDP, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jtextTimMaHoaDon, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextMaKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 51, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextMaDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addGap(81, 81, 81))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(61, 61, 61)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(TxtmaHD)
                                    .addComponent(TxtmaDatPhong)
                                    .addComponent(TxtngayTao, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE))
                                .addGap(72, 72, 72)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(193, 193, 193)
                                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 214, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 1243, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TxtmaHD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(TxtmaDatPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(37, 37, 37)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TxtngayTao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(5, 5, 5)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(33, 33, 33))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(37, 37, 37))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jtextTimMaHoaDonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtextTimMaHoaDonActionPerformed
        // TODO add your handling code here:
        taiTrang(timKiemHoaDon());
    }//GEN-LAST:event_jtextTimMaHoaDonActionPerformed

    private void ButtonADDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonADDActionPerformed
        this.SetsetEditableTrue();
        TxtngayTao.setEnabled(true);
        TxtmaDatPhong.setEnabled(true);
        this.HienThiNgayTaoONutThem();
        TxtngayTao.setEditable(false);
        new HoaDonController(this).themHoaDon();
    }//GEN-LAST:event_ButtonADDActionPerformed

    private void ButtonEDITActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonEDITActionPerformed
        this.SetsetEditableTrue();
        TxtngayTao.setEnabled(true);
        TxtmaDatPhong.setEnabled(true);
        TxtngayTao.setEnabled(false);
        new HoaDonController(this).suaHoaDon();
    }//GEN-LAST:event_ButtonEDITActionPerformed

    private void ButtonDELETEActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButtonDELETEActionPerformed
        this.SetsetEditableTrue();
        TxtngayTao.setEnabled(false);
        TxtmaDatPhong.setEnabled(false);
        new HoaDonController(this).xoaHoaDon();
    }//GEN-LAST:event_ButtonDELETEActionPerformed


    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        this.SetsetEditableFalse();
        this.setEnabledTRUE();
        reset();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jtextTimMaHoaDonKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtextTimMaHoaDonKeyReleased
        // TODO add your handling code here:
        taiTrang(timKiemHoaDon());
    }//GEN-LAST:event_jtextTimMaHoaDonKeyReleased

    private void DanhSachHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_DanhSachHoaDonMouseClicked
        // TODO add your handling code here:
        hientai = DanhSachHoaDon.getSelectedRow();
        Display(hientai);
    }//GEN-LAST:event_DanhSachHoaDonMouseClicked

    private void jTextMaDPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMaDPActionPerformed
        // TODO add your handling code here:
        taiTrang(timKiemDatPhong());
    }//GEN-LAST:event_jTextMaDPActionPerformed

    private void jTextMaDPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMaDPKeyReleased
        // TODO add your handling code here:
        taiTrang(timKiemDatPhong());
    }//GEN-LAST:event_jTextMaDPKeyReleased

    private void jTextMaKHActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextMaKHActionPerformed
        // TODO add your handling code here:
        taiTrang(timKiemKhachHang());
    }//GEN-LAST:event_jTextMaKHActionPerformed

    private void jTextMaKHKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextMaKHKeyReleased
        // TODO add your handling code here:
        taiTrang(timKiemKhachHang());
    }//GEN-LAST:event_jTextMaKHKeyReleased

    private void jTextMaKHMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextMaKHMouseClicked
        // TODO add your handling code here:
        this.resetJtextField();
        jTextMaKH.setEnabled(true);
        jtextTimMaHoaDon.setEnabled(false);
        jTextMaDP.setEnabled(false);
    }//GEN-LAST:event_jTextMaKHMouseClicked

    private void jtextTimMaHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtextTimMaHoaDonMouseClicked
        // TODO add your handling code here:
        this.resetJtextField();

        jtextTimMaHoaDon.setEnabled(true);
        jTextMaKH.setEnabled(false);
        jTextMaDP.setEnabled(false);
    }//GEN-LAST:event_jtextTimMaHoaDonMouseClicked

    private void jTextMaDPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTextMaDPMouseClicked
        // TODO add your handling code here:

        this.resetJtextField();

        jTextMaDP.setEnabled(true);
        jtextTimMaHoaDon.setEnabled(false);
        jTextMaKH.setEnabled(false);
    }//GEN-LAST:event_jTextMaDPMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButtonADD;
    private javax.swing.JButton ButtonDELETE;
    private javax.swing.JButton ButtonEDIT;
    private javax.swing.JTable DanhSachHoaDon;
    private javax.swing.JTextField TxtmaDatPhong;
    private javax.swing.JTextField TxtmaHD;
    private javax.swing.JTextField TxtngayTao;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextMaDP;
    private javax.swing.JTextField jTextMaKH;
    private javax.swing.JTextField jtextTimMaHoaDon;
    // End of variables declaration//GEN-END:variables
}
