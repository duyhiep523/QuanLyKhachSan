/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;

import Controller.DatPhongController;
import Controller.KhachHangController;
import Model.DatPhongModel;
import Model.DichVuModel;
import Model.HoaDonModel;
import Model.KhachHangModel;
import Model.NguoiDungModel;
import Model.PhongModel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hiep0
 */
public final class TrangCuaKhach extends javax.swing.JFrame {

    public TrangCuaKhach() {
        initComponents();
        this.setLocationRelativeTo(null);
        this.kHName.setText(KhachHangController.khOn.getTenKH());
        taiTrang(layDSPhong());
        taiTrangHuyDatPhong(layDSDP());
        taiTrangHoaDon(layDSHoaDonTheoMaKhachHang());
        taiTrangPhong(getPhong());
        taiTrangDichVu(getDichVu());
        taiTrangNguoiDung(getNguoiDung());
        resetFormHuyDatPhong();
    }

    public ArrayList<HoaDonModel> layDSHoaDonTheoMaKhachHang() {
        return new HoaDonModel().layHoaDonTheoMaKhachHang();
    }

    public void setTenTrangChu(KhachHangModel kh) {
        this.kHName.setText(kh.getTenKH());
    }

    public final ArrayList<DichVuModel> layDSDichVuTheoTenDV() {
        if (JTextTenDV.equals("")) {
            return new DichVuModel().getService();
        } else {
            return new DichVuModel().getDichVuTheoTenDV(JTextTenDV.getText());
        }
    }

    public final ArrayList<PhongModel> layDSPhongTheoLoaiPhong() {
        int index = jCbLoaiPhong.getSelectedIndex();
        if (index > 0) {
            String selectedValue = jCbLoaiPhong.getItemAt(index);
            return new PhongModel().getPhongTheoLoaiPhong(selectedValue);
        }
        return new PhongModel().getPhong();

    }

    public ArrayList<DichVuModel> LayDSDichVuTheoGiaDV() {
        int index = jComBoxGiaDV.getSelectedIndex();
        if (index > 0) {
            String selectedVulue = jComBoxGiaDV.getItemAt(index);
            return new DichVuModel().getDichVuTheoGia(Float.valueOf(selectedVulue));

        }
        return new DichVuModel().getService();
    }

    public final ArrayList<PhongModel> layDSPhongTheoGiaPhong() {
        int index1 = jCbGiaPhong.getSelectedIndex();
        if (index1 > 0) {
            String selectedValue = jCbGiaPhong.getItemAt(index1);
            return new PhongModel().getPhongTheoGiaPhong(Float.valueOf(selectedValue));
        }
        return new PhongModel().getPhong();
    }
// thông báo

    public void showMessage(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Thông báo", JOptionPane.ERROR_MESSAGE);
    }

    public void showMessageOK(String msg) {
        JOptionPane.showMessageDialog(this, msg, "Thông báo", JOptionPane.INFORMATION_MESSAGE);
    }
// thông báo

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jTabbedPane2 = new javax.swing.JTabbedPane();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TBDatPhong = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JLabel();
        txtTenPhong = new javax.swing.JLabel();
        txtLoaiPhong = new javax.swing.JLabel();
        txtGiaPhong = new javax.swing.JLabel();
        txtTinhTrang = new javax.swing.JLabel();
        DatBtn = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();
        searchTinhTrang = new javax.swing.JComboBox<>();
        jLabel6 = new javax.swing.JLabel();
        txtTGBD = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txtMDP = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbPhongDaDat = new javax.swing.JTable();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        hdpMADP = new javax.swing.JLabel();
        hdpMaKh = new javax.swing.JLabel();
        hdpMaP = new javax.swing.JLabel();
        hdpTGD = new javax.swing.JLabel();
        hdpTGBD = new javax.swing.JLabel();
        huyDatPhongBtn = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        hdpGP = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        tbBangHoaDon = new javax.swing.JTable();
        jLabel36 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLTenKH = new javax.swing.JLabel();
        JLmaDatPhong = new javax.swing.JLabel();
        JLTienDV = new javax.swing.JLabel();
        jLTienPhong = new javax.swing.JLabel();
        jLTongTien = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel8 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TBPhong = new javax.swing.JTable();
        jCbGiaPhong = new javax.swing.JComboBox<>();
        jCbLoaiPhong = new javax.swing.JComboBox<>();
        jLabel14 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbDichVu = new javax.swing.JTable();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jComBoxGiaDV = new javax.swing.JComboBox<>();
        JTextTenDV = new javax.swing.JTextField();
        jPanel10 = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TBQuanLy = new javax.swing.JTable();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLTen = new javax.swing.JLabel();
        jLGioiTinh = new javax.swing.JLabel();
        jLEmail = new javax.swing.JLabel();
        jLSDT = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        kHName = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jTabbedPane2.setBackground(new java.awt.Color(255, 255, 255));
        jTabbedPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        TBDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Tên phòng", "Loại phòng", "Giá phòng", "Tình trạng"
            }
        ));
        TBDatPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBDatPhongMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(TBDatPhong);

        jLabel1.setText("Tên phòng");

        jLabel2.setText("Loại phòng");

        jLabel3.setText("Mã phòng");

        jLabel4.setText("Giá phòng");

        jLabel5.setText("Tình trạng");

        txtMaPhong.setText(".");

        txtTenPhong.setText(".");

        txtLoaiPhong.setText(".");

        txtGiaPhong.setText(".");

        txtTinhTrang.setText(".");

        DatBtn.setBackground(new java.awt.Color(255, 51, 51));
        DatBtn.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        DatBtn.setText("Đặt phòng");
        DatBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        DatBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DatBtnActionPerformed(evt);
            }
        });

        jLabel48.setText("Nhập để tìm kiếm");

        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });

        searchTinhTrang.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Đang thuê", "Chưa thuê" }));
        searchTinhTrang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchTinhTrangActionPerformed(evt);
            }
        });

        jLabel6.setText("Thời gian bắt đầu sử dụng");

        jLabel7.setText("Mã đặt phòng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(77, 77, 77))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 77, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)))
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(65, 65, 65)
                        .addComponent(searchTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTenPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(230, 230, 230)
                        .addComponent(DatBtn))
                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(txtMDP, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 213, Short.MAX_VALUE)
                        .addComponent(txtTGBD, javax.swing.GroupLayout.Alignment.LEADING)))
                .addGap(41, 41, 41)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(16, 16, 16))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtMaPhong))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtTenPhong))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtLoaiPhong)
                    .addComponent(DatBtn))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtGiaPhong))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtTinhTrang))
                .addGap(31, 31, 31)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(txtTGBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtMDP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(78, 78, 78)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel48, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtSearch, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE)
                        .addComponent(searchTinhTrang, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(114, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 585, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane2.addTab("Đặt phòng", jPanel2);

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));

        tbPhongDaDat.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Mã đặt phòng", "Mã khách hàng", "Mã phòng", "Thời gian đặt", "Thời gian bắt đầu sử dụng", "Giá phòng"
            }
        ));
        tbPhongDaDat.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbPhongDaDatMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tbPhongDaDat);

        jLabel15.setText("Mã đặt phòng");

        jLabel16.setText("Mã KH");

        jLabel17.setText("Mã phòng");

        jLabel18.setText("Thời gian đặt");

        jLabel19.setText("Thời gian bắt đầu sử dụng");

        hdpMADP.setText("jLabel20");

        hdpMaKh.setText("Phòng 102");

        hdpMaP.setText("Đơn");

        hdpTGD.setText("11111111");

        hdpTGBD.setText("1111-11-11");

        huyDatPhongBtn.setBackground(new java.awt.Color(0, 204, 255));
        huyDatPhongBtn.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        huyDatPhongBtn.setText("Hủy đặt phòng");
        huyDatPhongBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        huyDatPhongBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                huyDatPhongBtnActionPerformed(evt);
            }
        });

        jLabel8.setText("Giá phòng");

        hdpGP.setText("jLabel9");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel19, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(93, 93, 93)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(hdpMADP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hdpMaKh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hdpMaP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hdpTGD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(hdpTGBD, javax.swing.GroupLayout.DEFAULT_SIZE, 98, Short.MAX_VALUE)
                            .addComponent(hdpGP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap(122, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(huyDatPhongBtn)
                        .addGap(165, 165, 165))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(hdpMADP))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(hdpMaKh))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel17)
                            .addComponent(hdpMaP))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(hdpTGD))
                        .addGap(36, 36, 36)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(hdpTGBD))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(hdpGP))
                        .addGap(52, 52, 52)
                        .addComponent(huyDatPhongBtn))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(134, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Phòng đã đặt", jPanel4);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        tbBangHoaDon.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Mã HD", "MaKH", "Tên KH", "Phòng thuê", "Tiền dịch vụ", "Tiền phòng", "Tổng tiền", "Trạng thái"
            }
        ));
        tbBangHoaDon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbBangHoaDonMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tbBangHoaDon);

        jLabel36.setText("Tên KH");

        jLabel37.setText("Mã Đặt Phòng");

        jLabel38.setText("Tiền dịch vụ");

        jLabel39.setText("Tiền phòng");

        jLabel40.setText("Tổng tiền");

        jLTenKH.setText(".");

        JLmaDatPhong.setText(".");

        JLTienDV.setText(".");

        jLTienPhong.setText(".");

        jLTongTien.setText(".");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel39, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(82, 82, 82)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLTenKH, javax.swing.GroupLayout.DEFAULT_SIZE, 111, Short.MAX_VALUE)
                    .addComponent(JLmaDatPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JLTienDV, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLTienPhong, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLTongTien, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 709, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane6, javax.swing.GroupLayout.DEFAULT_SIZE, 591, Short.MAX_VALUE))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLTenKH))
                .addGap(34, 34, 34)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(JLmaDatPhong))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel38)
                    .addComponent(JLTienDV))
                .addGap(32, 32, 32)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLTienPhong))
                .addGap(33, 33, 33)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(jLTongTien))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane2.addTab("Hóa đơn", jPanel6);

        jTabbedPane1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        TBPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Mã phòng", "Tên phòng", "Loại phóng", "Giá phòng"
            }
        ));
        jScrollPane3.setViewportView(TBPhong);

        jCbGiaPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "50000.0", "80000.0", "150000.0" }));
        jCbGiaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbGiaPhongActionPerformed(evt);
            }
        });

        jCbLoaiPhong.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "Phòng Đơn", "Phòng Đôi", "Phòng Vip" }));
        jCbLoaiPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCbLoaiPhongActionPerformed(evt);
            }
        });

        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Loại phòng");

        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("Giá phòng");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(61, 61, 61)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(6, 6, 6)
                        .addComponent(jCbLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel25, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jCbGiaPhong, 0, 80, Short.MAX_VALUE))
                .addGap(158, 158, 158)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 713, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel25)
                            .addComponent(jLabel14))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCbGiaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jCbLoaiPhong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        jTabbedPane1.addTab("Danh sách phòng", jPanel8);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));

        tbDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Mã Dịch Vụ", "Tên dịch vụ", "Giá dịch vụ"
            }
        ));
        jScrollPane4.setViewportView(tbDichVu);

        jLabel26.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel26.setText("Lọc theo tên");

        jLabel27.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel27.setText("Lọc theo giá");

        jComBoxGiaDV.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Tất cả", "200000.0", "50000.0", "10000.0", "250000.0" }));
        jComBoxGiaDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComBoxGiaDVActionPerformed(evt);
            }
        });

        JTextTenDV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                JTextTenDVActionPerformed(evt);
            }
        });
        JTextTenDV.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                JTextTenDVKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addGap(93, 93, 93)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel26, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(JTextTenDV, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addGap(129, 129, 129)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel27, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jComBoxGiaDV, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 244, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane4)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGap(135, 135, 135)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel26)
                    .addComponent(jLabel27))
                .addGap(27, 27, 27)
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComBoxGiaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(JTextTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(360, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Danh sách dịch vụ", jPanel9);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));

        TBQuanLy.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Tên quản lý", "Giới tính", "Email", "Số điện thoại"
            }
        ));
        TBQuanLy.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TBQuanLyMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(TBQuanLy);

        jLabel28.setText("Tên");

        jLabel29.setText("Giới tính");

        jLabel30.setText("Email");

        jLabel31.setText("Số điện thoại");

        jLTen.setText(".");

        jLGioiTinh.setText(".");

        jLEmail.setText(".");

        jLSDT.setText(".");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel28, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel29, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel30, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel31, javax.swing.GroupLayout.DEFAULT_SIZE, 95, Short.MAX_VALUE))
                .addGap(34, 34, 34)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 122, Short.MAX_VALUE)
                    .addComponent(jLEmail, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 341, Short.MAX_VALUE)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 554, Short.MAX_VALUE))
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(69, 69, 69)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel28)
                    .addComponent(jLTen))
                .addGap(65, 65, 65)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel29)
                    .addComponent(jLGioiTinh))
                .addGap(65, 65, 65)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(jLEmail))
                .addGap(65, 65, 65)
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(jLSDT))
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("Liên hệ để được hỗ trợ", jPanel10);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPane1))
        );

        jTabbedPane2.addTab("Thống kê của khách sạn", jPanel7);

        jButton1.setBackground(new java.awt.Color(255, 0, 51));
        jButton1.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButton1.setText("Đăng xuất");
        jButton1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(153, 153, 153)));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        kHName.setBackground(new java.awt.Color(0, 204, 255));
        kHName.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        kHName.setText("Nguyễn Duy Hiệp");
        kHName.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        kHName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        kHName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kHNameActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(kHName, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addComponent(jTabbedPane2)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kHName, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane2))
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.setVisible(false);
        this.dispose();
        new DangNhapKhach().setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void kHNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kHNameActionPerformed
        new TTKhachHang(this).setVisible(true);
        this.setTenTrangChu(KhachHangController.khOn);
        // TODO add your handling code here:
    }//GEN-LAST:event_kHNameActionPerformed

// đặt phòng   
    final String header[] = {"Mã phòng", "Tên phòng", "Loại phòng", "Giá phòng", "Tình trạng"};
    final DefaultTableModel tbDP = new DefaultTableModel(header, 0);

    public final ArrayList<PhongModel> layDSPhong() {
        int tinhtrang = -1;
        if (searchTinhTrang.getSelectedItem().equals("Đang thuê")) {
            tinhtrang = 1;
        }
        if (searchTinhTrang.getSelectedItem().equals("Chưa thuê")) {
            tinhtrang = 0;
        }
        return new PhongModel().getPhongTim(txtSearch.getText(), tinhtrang);
    }

    public final void taiTrang(ArrayList<PhongModel> arr) {
        tbDP.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            String gia = String.valueOf(arr.get(i).getGiaPhong());
            String tinhTrang = arr.get(i).getTinhTrang() ? "Đang thuê" : "Chưa thuê";
            String nd[] = {arr.get(i).getMaPhong(), arr.get(i).getTenPhong(), arr.get(i).getLoaiPhong(), gia, tinhTrang};
            tbDP.addRow(nd);
        }
        TBDatPhong.setModel(tbDP);
    }
    public static boolean ngaySD = false;
    public static boolean checkempty = false;
    public static boolean checkMuon = false;
    public static boolean checkOld = false;
    public static boolean checkNghiepVu = false;

    public DatPhongModel getDatPhong() {
        if (txtTinhTrang.getText().equals("Đang thuê")) {
            checkMuon = true;
        }
        if (txtTGBD.getText().equals("")) {
            checkempty = true;
        }
        Date date = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date thoiGianBatDau = null;
        try {
            thoiGianBatDau = formatter.parse(txtTGBD.getText());
            int comparison = (new Date()).compareTo(thoiGianBatDau);
            if (comparison > 0) {
                checkOld = true;
            }
            long timeInMillis = (new Date()).getTime();
            long addedTimeInMillis = 2 * 24 * 60 * 60 * 1000L;
            Date ngaySau = new Date(timeInMillis + addedTimeInMillis);
            int soSanh = thoiGianBatDau.compareTo(ngaySau);
            if (soSanh > 0) {
                System.out.println(thoiGianBatDau + " > " + ngaySau);
                checkNghiepVu = true;
            }
        } catch (ParseException ex) {
            ngaySD = true;
            System.out.println("wrong format");
        }

        return new DatPhongModel(txtMDP.getText(), txtMaPhong.getText(), KhachHangController.khOn.getMaKH(), date, thoiGianBatDau, Float.parseFloat(txtGiaPhong.getText()));

    }

    public void resetForm() {
        txtTGBD.setText("");
        txtMDP.setText("");
        txtMaPhong.setText("");
        txtTenPhong.setText("");
        txtLoaiPhong.setText("");
        txtGiaPhong.setText("");
        txtTinhTrang.setText("");
    }
    int hientai = 0;
    private void TBDatPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBDatPhongMouseClicked
        hientai = TBDatPhong.getSelectedRow();
        Display(hientai);        // TODO add your handling code here:
    }//GEN-LAST:event_TBDatPhongMouseClicked
    public void Display(int i) {
        PhongModel phong = layDSPhong().get(i);
        txtMaPhong.setText(phong.getMaPhong());
        txtTenPhong.setText(phong.getTenPhong());
        txtGiaPhong.setText(String.valueOf(phong.getGiaPhong()));
        txtLoaiPhong.setText(phong.getLoaiPhong());
        txtTinhTrang.setText(phong.getTinhTrang() ? "Đang thuê" : "Chưa thuê");
    }
    private void DatBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DatBtnActionPerformed
        new DatPhongController(this).addDatPhong();        // TODO add your handling code here:
    }//GEN-LAST:event_DatBtnActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased

        taiTrang(layDSPhong());
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSearchKeyReleased

    private void searchTinhTrangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchTinhTrangActionPerformed
        taiTrang(layDSPhong());  // TODO add your handling code here:
    }//GEN-LAST:event_searchTinhTrangActionPerformed
    int hientaiHDP = 0;
    private void tbPhongDaDatMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbPhongDaDatMouseClicked
        hientaiHDP = tbPhongDaDat.getSelectedRow();
        DisplayHDP(hientaiHDP);     // TODO add your handling code here:
    }//GEN-LAST:event_tbPhongDaDatMouseClicked

    private void huyDatPhongBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_huyDatPhongBtnActionPerformed
        new DatPhongController(this).huyDatPhong();        // TODO add your handling code here:
    }//GEN-LAST:event_huyDatPhongBtnActionPerformed
    int hientaiHoaDon = 0;
    private void tbBangHoaDonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbBangHoaDonMouseClicked
        // TODO add your handling code here:
        hientaiHoaDon = tbBangHoaDon.getSelectedRow();
        DisplayHoaDon(hientaiHoaDon);
    }//GEN-LAST:event_tbBangHoaDonMouseClicked
    int hientaiNguoiDung = 0;
    private void TBQuanLyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TBQuanLyMouseClicked
        // TODO add your handling code here:
        hientaiNguoiDung = TBQuanLy.getSelectedRow();
        displayNguoiDung(hientaiNguoiDung);

    }//GEN-LAST:event_TBQuanLyMouseClicked

    private void jComBoxGiaDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComBoxGiaDVActionPerformed
        // TODO add your handling code here:
        taiTrangDichVu(LayDSDichVuTheoGiaDV());
    }//GEN-LAST:event_jComBoxGiaDVActionPerformed

    private void JTextTenDVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_JTextTenDVActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_JTextTenDVActionPerformed

    private void jCbGiaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbGiaPhongActionPerformed
        taiTrangPhong(layDSPhongTheoGiaPhong());
    }//GEN-LAST:event_jCbGiaPhongActionPerformed

    private void jCbLoaiPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCbLoaiPhongActionPerformed
        // TODO add your handling code here:
        taiTrangPhong(layDSPhongTheoLoaiPhong());
    }//GEN-LAST:event_jCbLoaiPhongActionPerformed

    private void JTextTenDVKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_JTextTenDVKeyReleased
        // TODO add your handling code here:
        taiTrangDichVu(layDSDichVuTheoTenDV());
    }//GEN-LAST:event_JTextTenDVKeyReleased

    public void displayNguoiDung(int i) {
        NguoiDungModel nd = getNguoiDung().get(i);
        jLTen.setText(nd.getHoTen());
        String gioiTinh = nd.getGioiTinh() ? "Nam" : "Nữ";
        jLGioiTinh.setText(gioiTinh);
        jLEmail.setText(nd.getEmail());
        jLSDT.setText(nd.getSdt());
    }

    public void DisplayHoaDon(int i) {
        HoaDonModel hd = layDSHoaDon().get(i);
        jLTenKH.setText(hd.getTenKhachHang());
        JLmaDatPhong.setText(hd.getMaDatPhong());
        String str1 = Float.toString(hd.getTienDichVu());
        String str2 = Float.toString(hd.getTienPhong());
        String str3 = Float.toString(hd.getTongTien());
        JLTienDV.setText(str1);
        jLTienPhong.setText(str2);
        jLTongTien.setText(str3);

    }

    public void DisplayHDP(int i) {
        DatPhongModel hdp = layDSDP().get(i);
        hdpMADP.setText(hdp.getMaDP());
        hdpMaKh.setText(hdp.getMaKH());
        String str1 = Float.toString(hdp.getGiaPhong());
        hdpGP.setText(str1);
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String tGD = formatter.format(hdp.getThoiGianDat());
        hdpTGD.setText(tGD);
        tGD = formatter.format(hdp.getThoiGianBatDau());
        hdpTGBD.setText(tGD);
        hdpMaP.setText(hdp.getMaPhong());

    }
// đặt phòng  
// hủy đặt phòng
    final String headerr[] = {"Mã đặt phòng", "Mã KH", "Mã phòng", "Thời gian đặt", "Thời gian bắt đầu SD", "Giá phòng"};
    final DefaultTableModel TBHDP = new DefaultTableModel(headerr, 0);

    public final ArrayList<DatPhongModel> layDSDP() {
        return new DatPhongModel().listDP();
    }

    public final void taiTrangHuyDatPhong(ArrayList<DatPhongModel> arr) {
        TBHDP.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            String TGD = formatter.format(arr.get(i).getThoiGianDat());
            String TGBD = formatter.format(arr.get(i).getThoiGianBatDau());
            String giaTien = String.valueOf(arr.get(i).getGiaPhong());
            String nd[] = {arr.get(i).getMaDP(), arr.get(i).getMaKH(), arr.get(i).getMaPhong(), TGD, TGBD, giaTien};
            TBHDP.addRow(nd);
        }
        tbPhongDaDat.setModel(TBHDP);
    }

    final String header2[] = {"Mã phòng", "Tên phòng", "Loại phòng", "Giá phòng"};
    final DefaultTableModel df2 = new DefaultTableModel(header2, 0);

    public final void taiTrangPhong(ArrayList<PhongModel> arr) {
        df2.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            String gia = String.valueOf(arr.get(i).getGiaPhong());
            String nd[] = {arr.get(i).getMaPhong(), arr.get(i).getTenPhong(), arr.get(i).getLoaiPhong(), gia};
            df2.addRow(nd);
        }
        TBPhong.setModel(df2);
    }

    public ArrayList<PhongModel> getPhong() {
        return new PhongModel().getPhong();
    }
//    xuất hóa đơn 

    public ArrayList<HoaDonModel> layDSHoaDon() {
        return new HoaDonModel().layHoaDonTheoMaKhachHang();
    }

    final String header1[] = {"Mã hóa đơn", "Mã khách hàng", "Tên khách hàng", "Mã đặt phòng", "Tiền phòng", "Tiền dịch vụ", "Ngày tạo", "Tổng tiền"};
    final DefaultTableModel tb = new DefaultTableModel(header1, 0);

    public final void taiTrangHoaDon(ArrayList<HoaDonModel> arr) {
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
        tbBangHoaDon.setModel(tb);

    }

    public final void resetFormHuyDatPhong() {
        hdpMADP.setText("");
        hdpMaKh.setText("");
        hdpMaP.setText("");
        hdpTGBD.setText("");
        hdpTGD.setText("");
        hdpGP.setText("");
    }

    public DatPhongModel getHuyDatPhong() {

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        Date thoiGianBatDau = null;
        Date date = null;
        try {
            date = formatter.parse(hdpTGD.getText());
            thoiGianBatDau = formatter.parse(hdpTGBD.getText());
        } catch (ParseException ex) {
            System.out.println("sai định dạng huy dp");
        }
        return new DatPhongModel(hdpMADP.getText(), hdpMaP.getText(), KhachHangController.khOn.getMaKH(), date, thoiGianBatDau, Float.parseFloat(hdpGP.getText()));

    }

    public ArrayList<DichVuModel> getDichVu() {
        return new DichVuModel().getService();
    }

    final String header4[] = {"Mã Dịch Vụ ", "Tên Dịch Vụ", "Giá Dịch Vụ"};
    final DefaultTableModel df = new DefaultTableModel(header4, 0);

    public final void taiTrangDichVu(ArrayList<DichVuModel> arr) {
        df.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            String gia = String.valueOf(arr.get(i).getServicePrice());
            String nd[] = {arr.get(i).getServiceId(), arr.get(i).getServiceName(), gia};
            df.addRow(nd);
        }
        tbDichVu.setModel(df);
    }

    public ArrayList<NguoiDungModel> getNguoiDung() {
        return new NguoiDungModel().getNguoiDung();
    }

    final String header5[] = {"Tên người Quản Lý", "Giới Tính", "email", "Số điện thoại"};
    final DefaultTableModel df6 = new DefaultTableModel(header5, 0);

    public final void taiTrangNguoiDung(ArrayList<NguoiDungModel> arr) {
        df6.getDataVector().removeAllElements();
        for (int i = 0; i < arr.size(); i++) {
            String gioiTinh = arr.get(i).getGioiTinh() ? "Nam" : "Nữ";
            String nd[] = {arr.get(i).getHoTen(), gioiTinh, arr.get(i).getEmail(), arr.get(i).getSdt()};
            df6.addRow(nd);
        }
        TBQuanLy.setModel(df6);
    }

// hủy đặt phòng    
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
            java.util.logging.Logger.getLogger(DangNhap.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> {
            new TrangCuaKhach().setVisible(true);

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton DatBtn;
    private javax.swing.JLabel JLTienDV;
    private javax.swing.JLabel JLmaDatPhong;
    private javax.swing.JTextField JTextTenDV;
    private javax.swing.JTable TBDatPhong;
    private javax.swing.JTable TBPhong;
    private javax.swing.JTable TBQuanLy;
    private javax.swing.JLabel hdpGP;
    private javax.swing.JLabel hdpMADP;
    private javax.swing.JLabel hdpMaKh;
    private javax.swing.JLabel hdpMaP;
    private javax.swing.JLabel hdpTGBD;
    private javax.swing.JLabel hdpTGD;
    private javax.swing.JButton huyDatPhongBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jCbGiaPhong;
    private javax.swing.JComboBox<String> jCbLoaiPhong;
    private javax.swing.JComboBox<String> jComBoxGiaDV;
    private javax.swing.JLabel jLEmail;
    private javax.swing.JLabel jLGioiTinh;
    private javax.swing.JLabel jLSDT;
    private javax.swing.JLabel jLTen;
    private javax.swing.JLabel jLTenKH;
    private javax.swing.JLabel jLTienPhong;
    private javax.swing.JLabel jLTongTien;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTabbedPane jTabbedPane2;
    private javax.swing.JButton kHName;
    private javax.swing.JComboBox<String> searchTinhTrang;
    private javax.swing.JTable tbBangHoaDon;
    private javax.swing.JTable tbDichVu;
    private javax.swing.JTable tbPhongDaDat;
    private javax.swing.JLabel txtGiaPhong;
    private javax.swing.JLabel txtLoaiPhong;
    private javax.swing.JTextField txtMDP;
    private javax.swing.JLabel txtMaPhong;
    private javax.swing.JTextField txtSearch;
    private javax.swing.JTextField txtTGBD;
    private javax.swing.JLabel txtTenPhong;
    private javax.swing.JLabel txtTinhTrang;
    // End of variables declaration//GEN-END:variables
}
