/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.DangNhapKhach;
import Model.*;
import View.TrangCuaKhach;

/**
 *
 * @author hiep0
 */
public class KhachHangController {

    private static DangNhapKhach dangNhap;
    public static KhacHangModel khOn;
// dang nhap

    public void dangNhap() {
        KhacHangModel kh = dangNhap.getKH();
        if (kh.getTaiKhoan().equals("") || kh.getTaiKhoan().equals("")) {
            dangNhap.showMessageLogin("Tài khoản mật khẩu phải điền đủ thông tin");
        } else {
            KhacHangModel test = new KhacHangModel().dangNhap(kh.getTaiKhoan(), kh.getMatKhau());
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

    public KhachHangController(DangNhapKhach view) {
        KhachHangController.dangNhap = view;
    }

    public static DangNhapKhach getDangNhap() {
        return dangNhap;
    }

    public static void setDangNhap(DangNhapKhach dangNhap) {
        KhachHangController.dangNhap = dangNhap;
    }

}
