/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.PhongModel;
import View.QLPhong;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hiep0
 */
public class PhongController {

    public static PhongModel phong;
    private static QLPhong qlP;

    public int thongkePhong() {
        return new PhongModel().CountPhong();
    }

    public PhongController(QLPhong room) {
        PhongController.qlP = room;
    }

    public PhongController() {
    }
    public String regexMaPhong = "^P\\d{2,5}$";

    public boolean Regex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public void addRoom() {
        PhongModel phong = qlP.getPhong();

        if (phong.getMaPhong().equals("")) {
            qlP.showMessage("Ma phong bi trong. Vui long nhap ma phong!");
            return;
        }
        if (!Regex(phong.getMaPhong(), regexMaPhong)) {
            qlP.showMessage("Mã phòng phải đúng định dạng vd: P01");
            return;
        }
        if (phong.getTenPhong().equals("")) {
            qlP.showMessage("Ten phong bi trong. Vui long nhap ten phong!");
            return;
        }

        if (QLPhong.chekgia) {
            qlP.showMessage("Gia phong bi trong. Vui long nhap gia phong!");
            QLPhong.chekgia = false;
            return;
        }
        if (phong.getLoaiPhong().equals("")) {

            qlP.showMessage("Loai phong bi trong. Vui long nhap loai phong!");
            return;
        }

        boolean test = new PhongModel().themPhong(phong);
        if (test) {
            qlP.showMessageOK("Them thanh cong");
            qlP.taiTrang(new PhongModel().getDulieu());
        } else {
            qlP.showMessage("Khong Thanh cong!");
        }

    }
    // Xóa phòng

    public void xoaPhong() {
        PhongModel phong = qlP.getPhong();
        if (phong.getMaPhong().equals("")) {
            qlP.showMessage("Ma phong bi trong, vui long nhap ten phong");
            return;
        }
        boolean test = new PhongModel().xoaPhong(phong);
        if (test) {
            qlP.showMessageOK("Xoa phong thanh cong");
            qlP.taiTrang(new PhongModel().getDulieu());

        } else {
            qlP.showMessage("Xoa phong khong thanh cong");

        }

    }
    // sửa phòng

    public void updateRoom() {
        PhongModel phong = qlP.getUPPhong();
        if (phong.getMaPhong().equals("")) {
            qlP.showMessage("Ma phong bi trong. Vui long nhap ma phong!");
            return;
        }
        if (phong.getTenPhong().equals("")) {
            qlP.showMessage("Ten phong bi trong. Vui long nhap ten phong!");
            return;

        }
        if (QLPhong.chekgia) {
            qlP.showMessage("Gia phong không được trống và phải đúng định dạng!");
            QLPhong.chekgia = false;
            return;
        }
        if (phong.getLoaiPhong().equals("")) {

            qlP.showMessage("Loai phong bi trong. Vui long nhap loai phong!");
            return;
        }

        boolean test = new PhongModel().updateRoom(phong);
        if (test) {
            qlP.showMessageOK("Update phong thanh cong");
            qlP.taiTrang(new PhongModel().getDulieu());

        } else {
            qlP.showMessage("Update phong khong thanh cong");

        }

    }

}
