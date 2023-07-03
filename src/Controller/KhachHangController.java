/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.DangNhapKhach;
import Model.*;
import View.TTKhachHang;
import View.TaoTaiKhoanKhach;
import View.TrangCuaKhach;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import View.QLKhach;

/**
 *
 * @author hiep0
 */
public class KhachHangController {

    private static DangNhapKhach dangNhap;
    public static KhachHangModel khOn;
    private static TaoTaiKhoanKhach TTK;
    private static TTKhachHang ttKH;
    private static QLKhach khach;

    public KhachHangController(QLKhach view) {
        KhachHangController.khach = view;
    }

    public KhachHangController(TaoTaiKhoanKhach view) {
        KhachHangController.TTK = view;
    }

    public KhachHangController(TTKhachHang view) {
        KhachHangController.ttKH = view;
    }
// dang nhap

    public void dangNhap() {
        KhachHangModel kh = dangNhap.getKH();
        if (kh.getTaiKhoan().equals("") || kh.getTaiKhoan().equals("")) {
            dangNhap.showMessageLogin("Tài khoản mật khẩu phải điền đủ thông tin");
        } else {
            KhachHangModel test = new KhachHangModel().dangNhap(kh.getTaiKhoan(), kh.getMatKhau());
            if (test.getMaKH() != null) {
                khOn = test;
//                System.out.println(khOn.getTenKH());
                TrangCuaKhach.run();////
                dangNhap.dispose();
            } else {
                dangNhap.showMessageLogin("Sai thông tin");
            }
        }
    }
// dang nhap
// tao tai khoan
    public String regexSDT = "^[0-9]{8,}$";
    public String regexTND = "^[a-zA-Z]+$";

    public boolean Regex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public void taoTaiKhoan() {
        KhachHangModel kh = TTK.getKhacHang();
        if (kh.getMaKH().equals("")) {
            TTK.showMessage("Mã không được để rỗng");
            return;
        }
        if (kh.getTenKH().equals("")) {
            TTK.showMessage("Tên không được để rỗng");
            return;
        }
        if (kh.getSDT().equals("")) {
            TTK.showMessage("Số điện thoại không được để rỗng");
            return;
        }
        if (!Regex(kh.getSDT(), regexSDT)) {
            TTK.showMessage("Số điện thoại sai định dạng");
            return;

        }
        if (kh.getCMND().equals("")) {
            TTK.showMessage("Chứng minh nhân dân không được để rỗng");
            return;
        }
        if (!Regex(kh.getCMND(), regexSDT)) {
            TTK.showMessage("Chứng minh nhân dân sai định dạng");
            return;

        }
        if (kh.getTaiKhoan().equals("")) {
            TTK.showMessage("Tài khoản không được để rỗng");
            return;
        }
        if (!Regex(kh.getTaiKhoan(), regexTND)) {
            TTK.showMessage("Tài khoản phải viết liền không dấu");
            return;

        }
        if (kh.getMatKhau().equals("")) {
            TTK.showMessage("Mật khẩu không được để rỗng");
            return;
        }
        boolean test = new KhachHangModel().taoTaiKhoan(kh);
        if (test) {
            TTK.showMessageOK("Tạo thành công");
            TTK.resetForm();
        } else {
            TTK.showMessage("Người dùng đã tồn tại");
        }
    }
// tao tai khoan
// cap nhat thong tin nguoidung

    public void updateTT(TrangCuaKhach t) {
        KhachHangModel kh = ttKH.getTT();

        if (kh.getTenKH().equals("")) {
            ttKH.showMessage("Tên không được để rỗng");
            return;
        }
        if (kh.getSDT().equals("")) {
            ttKH.showMessage("Số điện thoại không được để rỗng");
            return;
        }
        if (!Regex(kh.getSDT(), regexSDT)) {
            ttKH.showMessage("Số điện thoại sai định dạng");
            return;

        }
        if (kh.getCMND().equals("")) {
            ttKH.showMessage("Chứng minh nhân dân không được để rỗng");
            return;
        }
        if (!Regex(kh.getCMND(), regexSDT)) {
            ttKH.showMessage("Chứng minh nhân dân sai định dạng");
            return;
        }
        boolean test = new KhachHangModel().doiThongTin(kh);
        if (test) {
            khOn = kh;
            ttKH.showMessageOK("Cập nhật thành công");
            t.setTenTrangChu(khOn);

        } else {
            ttKH.showMessage("Người dùng đã tồn tại");
        }
    }
// cap nhat thong tin nguoidung
// đổi mật khẩu người dùng

    public void doiMatKhau() {
        KhachHangModel kh = ttKH.getMK();
        if (TTKhachHang.checkEmptyPassCu) {
            ttKH.showMessage("Phải điền mật khẩu hiện tại");
            TTKhachHang.checkEmptyPassCu = false;
            return;
        }
        if (!TTKhachHang.MKCUKI.equals(khOn.getMatKhau())) {
            ttKH.showMessage("Sai mật khẩu");
            return;
        }
        if (TTKhachHang.checkEmptyPassMoi1) {
            ttKH.showMessage("Phải điền mật khẩu mới");
            TTKhachHang.checkEmptyPassMoi1 = false;
            return;
        }
        if (TTKhachHang.checkEmptyPassMoi2) {
            ttKH.showMessage("Phải điền lại mật khẩu mới");
            TTKhachHang.checkEmptyPassMoi2 = false;
            return;
        }

        if (TTKhachHang.checkPass) {
            ttKH.showMessage("Mật khẩu nhập lại không đúng");
            TTKhachHang.checkPass = false;
            return;
        }
        if (TTKhachHang.change) {
            ttKH.showMessage("Mật khẩu mới phải khác với mật khẩu cũ");
            TTKhachHang.change = false;
            return;
        }
        boolean test = new KhachHangModel().doiMatKhau(kh);
        if (test) {
            ttKH.showMessageOK("đổi pass thành công");
            khOn = kh;
            ttKH.resetFormPass();
        } else {
            ttKH.showMessage("đã có lỗi xảy ra");
        }
    }
// đổi mật khẩu người dùng

    public KhachHangController(DangNhapKhach view) {
        KhachHangController.dangNhap = view;
    }

    public static DangNhapKhach getDangNhap() {
        return dangNhap;
    }

    public static void setDangNhap(DangNhapKhach dangNhap) {
        KhachHangController.dangNhap = dangNhap;
    }

    public static TaoTaiKhoanKhach getTTK() {
        return TTK;
    }

    public static void setTTK(TaoTaiKhoanKhach TTK) {
        KhachHangController.TTK = TTK;
    }

    public static TTKhachHang getTtKH() {
        return ttKH;
    }

    public static void setTtKH(TTKhachHang ttKH) {
        KhachHangController.ttKH = ttKH;
    }

    public int ThongKeKhachHang() {
        return new KhachHangModel().countKhach();
    }
    public String regexKH = "^KH\\d+$";

    public void themKH() {

        KhachHangModel kh = khach.getKH();

        if (kh.getMaKH().equals("")) {
            JOptionPane.showMessageDialog(khach, "Mã Khách Hàng không được để trống.");
            return;
        }
        if (!Regex(kh.getMaKH(), regexKH)) {
            JOptionPane.showMessageDialog(khach, "Mã Khách Hàng phải có định dạng KHxxx.");
            return;
        }

        if (kh.getTenKH().equals("")) {
            JOptionPane.showMessageDialog(khach, "Tên không được để rỗng");
            return;
        }
        if (QLKhach.gt) {
            JOptionPane.showMessageDialog(khach, "gt không được để trống");
            QLKhach.gt = false;
            return;
        }
        if (kh.getSDT().equals("")) {
            JOptionPane.showMessageDialog(khach, "SĐT không được để trống");
            return;
        }
        if (!Regex(kh.getSDT(), regexSDT)) {
            JOptionPane.showMessageDialog(khach, "SĐt  sai định dạng.");
            return;
        }

        if (kh.getCMND().equals("")) {
            JOptionPane.showMessageDialog(khach, "CMND không được để trống");
            return;
        }
        if (!Regex(kh.getCMND(), regexSDT)) {
            JOptionPane.showMessageDialog(khach, "CMND  sai định dạng.");
            return;
        }
        if (kh.getTaiKhoan().equals("")) {
            JOptionPane.showMessageDialog(khach, "TK không được để trống");
            return;
        }
        if (kh.getMatKhau().equals("")) {
            JOptionPane.showMessageDialog(khach, "MK không được để trống");
            return;
        }

        boolean add = new KhachHangModel().them(kh);
        if (add) {
            JOptionPane.showMessageDialog(khach, "thêm khách hàng thành công.");

        } else {
            JOptionPane.showMessageDialog(khach, "thêm khách hàng thất bại do trùng thông tin .");
        }
    }

    public void xoaKH() {
        KhachHangModel kh = khach.getKH();
        boolean dele = new KhachHangModel().deleteKH(kh);
        if (dele) {
            JOptionPane.showMessageDialog(khach, "xóa Khách hàng thành công.");
            khach.taiTrang(new KhachHangModel().getCustomer());
            khach.resetForm();

        } else {
            JOptionPane.showMessageDialog(khach, "xóa Khách hàng thất bại.");
        }
    }

    public void suaKH() {
        KhachHangModel kh = khach.getKH();

        if (kh.getMaKH().equals("")) {
            JOptionPane.showMessageDialog(khach, "Mã Khách Hàng không được để trống.");
            return;
        }
        if (!Regex(kh.getMaKH(), regexKH)) {
            JOptionPane.showMessageDialog(khach, "Mã Khách Hàng phải có định dạng KHxxx.");
            return;
        }

        if (kh.getTenKH().equals("")) {
            JOptionPane.showMessageDialog(khach, "Tên không được để rỗng");
            return;
        }
        if (QLKhach.gt) {
            JOptionPane.showMessageDialog(khach, "gioi tinh không được để trống");
            QLKhach.gt = false;
            return;
        }
        if (kh.getSDT().equals("")) {
            JOptionPane.showMessageDialog(khach, "SĐT không được để trống");
            return;
        }
        if (!Regex(kh.getSDT(), regexSDT)) {
            JOptionPane.showMessageDialog(khach, "SĐT  sai định dạng.");
            return;
        }

        if (kh.getCMND().equals("")) {
            JOptionPane.showMessageDialog(khach, "CMND không được để trống");
            return;
        }
        if (!Regex(kh.getCMND(), regexSDT)) {
            JOptionPane.showMessageDialog(khach, "CMND  sai định dạng.");
            return;
        }
        if (kh.getTaiKhoan().equals("")) {
            JOptionPane.showMessageDialog(khach, "TK không được để trống");
            return;
        }
        if (kh.getMatKhau().equals("")) {
            JOptionPane.showMessageDialog(khach, "MK không được để trống");
            return;
        }
        boolean add = new KhachHangModel().sua(kh);
        if (add) {
            JOptionPane.showMessageDialog(khach, "Sửa Khách thành công.");

        } else {
            JOptionPane.showMessageDialog(khach, " Sửa Khách thất bại do đã trùng thông tin.");
        }
    }

}
