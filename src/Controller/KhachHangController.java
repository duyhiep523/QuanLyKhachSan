/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.DangNhapKhach;
import Model.*;
import View.TaoTaiKhoanKhach;
import View.TrangCuaKhach;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hiep0
 */
public class KhachHangController {

    private static DangNhapKhach dangNhap;
    public static KhachHangModel khOn;
    private static TaoTaiKhoanKhach TTK;

    public KhachHangController(TaoTaiKhoanKhach view) {
        KhachHangController.TTK = view;
    }
// dang nhap

    public void dangNhap() {
        KhachHangModel kh = dangNhap.getKH();
        if (kh.getTaiKhoan().equals("") || kh.getTaiKhoan().equals("")) {
            dangNhap.showMessageLogin("Tài khoản mật khẩu phải điền đủ thông tin");
        } else {
            KhachHangModel test = new KhachHangModel().dangNhap(kh.getTaiKhoan(), kh.getMatKhau());
            if (test.getMaKH() != null) {
                khOn = kh;
                TrangCuaKhach.run();
                dangNhap.dispose();
            } else {
                dangNhap.showMessageLogin("sai thông tin");
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

}
