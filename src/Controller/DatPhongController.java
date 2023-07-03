/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DatPhongModel;
import View.QLDatPhong;
import static View.QLDatPhong.checkFL;
import View.QLPhong;
import View.TrangCuaKhach;
//import java.text.SimpleDateFormat
import java.sql.SQLException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hiep0
 */
public class DatPhongController {

    private static TrangCuaKhach trangCuaKhach;

    public DatPhongController(TrangCuaKhach view) {
        DatPhongController.trangCuaKhach = view;
    }

    // tạo mới đặt phòng
    public void addDatPhong() {
        DatPhongModel datphong = trangCuaKhach.getDatPhong();
        if (TrangCuaKhach.checkMuon) {
            trangCuaKhach.showMessage("Phòng này đã được mượn");
            TrangCuaKhach.checkMuon = false;
            return;
        }
        if (datphong.getMaDP().equals("")) {
            trangCuaKhach.showMessage("Vui lòng điền mã đặt phòng");
            return;
        }
        if (TrangCuaKhach.checkempty) {
            trangCuaKhach.showMessage("ngày bắt đầu sử dụng không được bỏ trống");
            TrangCuaKhach.checkempty = false;
            return;
        }
        if (TrangCuaKhach.ngaySD || datphong.getThoiGianBatDau() == null) {
            trangCuaKhach.showMessage("sai định dạng ngày");
            TrangCuaKhach.ngaySD = false;
            return;
        }
        if (TrangCuaKhach.checkOld) {
            trangCuaKhach.showMessage("Ngày bắt đầu sử dụng không thể là ngày trong quá khứ");
            TrangCuaKhach.checkOld = false;
            return;
        }
        if (TrangCuaKhach.checkNghiepVu) {
            trangCuaKhach.showMessage("Ngày bắt đầu sử dụng không thể lớn hơn 2 ngày ");
            TrangCuaKhach.checkNghiepVu = false;
            return;
        }

        boolean test = new DatPhongModel().themDatPhong(datphong);
        if (test) {
            trangCuaKhach.showMessageOK("Đặt thành công");
            new DatPhongModel().updateMuonPhong(datphong);
            trangCuaKhach.taiTrang(trangCuaKhach.layDSPhong());
            trangCuaKhach.taiTrangHuyDatPhong(trangCuaKhach.layDSDP());
            trangCuaKhach.resetForm();
        } else {
            trangCuaKhach.showMessage("Mã đặt phòng đã tồn tại");
        }

    }
    // tạo mới đặt phòng

    // huy dat phong
    public void huyDatPhong() {
        DatPhongModel datphong = trangCuaKhach.getHuyDatPhong();
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date currentDate = new Date();
        int comparison = currentDate.compareTo(datphong.getThoiGianBatDau());
        if (comparison > 0) {
            trangCuaKhach.showMessage("Phòng bạn đã sử dụng không thể hủy");
            return;
        }
        boolean test = new DatPhongModel().huyDP(datphong);
        if (test) {
            trangCuaKhach.showMessageOK("xóa thành công");
            trangCuaKhach.taiTrangHuyDatPhong(trangCuaKhach.layDSDP());
            new DatPhongModel().updateHDP(datphong);
            trangCuaKhach.taiTrang(trangCuaKhach.layDSPhong());
            trangCuaKhach.resetFormHuyDatPhong();
            trangCuaKhach.resetForm();
        } else {
            trangCuaKhach.showMessage("đã có lỗi xảy ra");
        }
    }

    // NHÀN
    public static QLDatPhong qlDP;

    public String regexMaDP = "^DP\\d{2,5}$";
    public String regexMaPhong = "^P\\d{2,5}$";
    public String regexKhachHang = "KH\\d{2,5}$";

    public boolean Regex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public DatPhongController(QLDatPhong ql) {

        DatPhongController.qlDP = ql;
    }

    public void QLDatPhong() {

        DatPhongModel addRoom = qlDP.getPhong();
        String gia = String.valueOf(addRoom.getGiaPhong());
        if (addRoom.getMaDP().equals("")) {
            qlDP.showMessage("Mã đặt phòng trống. Vui lòng nhập lại!");
            return;
        }
        if (!Regex(addRoom.getMaDP(), regexMaDP)) {
            qlDP.showMessage("Mã đặt phòng phải đúng định dạng vd: DP01");
            return;
        }
        if (addRoom.getMaPhong().equals("")) {
            qlDP.showMessage("Mã phòng bị trống. Vui lòng nhập lại");
            return;
        }
        if (!Regex(addRoom.getMaPhong(), regexMaPhong)) {
            qlDP.showMessage("Mã phòng phải đúng định dạng vd: P01");
            return;
        }
        if (new DatPhongModel().kiemTraPhong(addRoom)) {
            qlDP.showMessage("Mã phòng này đang được thuê vui lòng chọn phòng khác!");
            return;
        }
        if (addRoom.getMaKH().equals("")) {
            qlDP.showMessage("Mã khách hàng trống. Vui lòng nhập lại!");
            return;
        }

        if (!Regex(addRoom.getMaKH(), regexKhachHang)) {
            qlDP.showMessage("Mã khách hàng phải đúng định dạng vd: KH01");
            return;
        }

        if (gia.equals("") || QLDatPhong.checkFL) {
            checkFL = false;
            qlDP.showMessage("giá phòng bị trống. Vui lòng nhập lại!");
            return;
        }
        if (QLDatPhong.checkF2L) {
            QLDatPhong.checkF2L = false;
            qlDP.showMessage("giá phòng không được âm và phải đúng định dạng!");
            return;
        }
        if (QLDatPhong.checkn1) {
            qlDP.showMessage("Thời gian đặt phòng bị trống hoặc sai định dạng!");
            QLDatPhong.checkn1 = false;
            return;
        }

        if (QLDatPhong.checkn2) {
            qlDP.showMessage("thời gian bắt đầu thuê bị trống hoặc sai định dạng!");
            QLDatPhong.checkn2 = false;
            return;
        }
        if (QLDatPhong.checkOld) {
            qlDP.showMessage("Ngày bắt đầu không được nhỏ hơn ngày đặt!");
            QLDatPhong.checkOld = false;
            return;
        }
        boolean test = new DatPhongModel().addRoom1(addRoom);
        if (test) {
            qlDP.showMessageOK("Them thanh cong");
            addRoom.updateMuonPhong(addRoom);
            qlDP.taiTrang(new DatPhongModel().getDulieu());
            qlDP.reset();
        } else {
            qlDP.showMessage("Them Phong Khong Thanh cong!");
        }
    }
    //Xóa phong

    public void removeRoom() {
        DatPhongModel removeRoom = qlDP.getPhong();
        if (removeRoom.getMaDP().equals("")) {
            qlDP.showMessage("Ma dat phong bi trong. Vui long nhaap ma dat phong!");
            return;
        }
        boolean test;
        try {
            test = new DatPhongModel().xoaP(removeRoom);
            if (test) {
                qlDP.showMessageOK("Xoa thanh cong");
                removeRoom.updateHDP(removeRoom);
                qlDP.taiTrang(new DatPhongModel().getDulieu());
                qlDP.reset();

            } else {
                qlDP.showMessage("Khong Thanh cong!");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DatPhongController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // UPDATE PHONG
    public void updateRoom1() {

        DatPhongModel updateRoom = qlDP.getPhong();
        String gia = String.valueOf(updateRoom.getGiaPhong());
        if (updateRoom.getMaDP().equals("")) {
            qlDP.showMessage("Ma dat phong bi trong. Vui long nhap ma dat phong!");
            return;
        }
        if (updateRoom.getMaPhong().equals("")) {
            qlDP.showMessage("Ma phong bi trong. Vui long nhap ma phong!");
            return;
        }
        if (updateRoom.getMaKH().equals("")) {
            qlDP.showMessage("Ma khach hang bi trong. Vui long nhap ma khach hang!");
            return;
        }
        if (gia.equals("")) {

            qlDP.showMessage("Gia phong bi trong. Vui long nhap gia phong!");
            return;
        }
        if (QLDatPhong.checkF2L) {
            QLDatPhong.checkF2L = false;
            qlDP.showMessage("giá phòng không được âm và phải đúng định dạng!");
            return;
        }
        if (QLDatPhong.checkn1) {
            qlDP.showMessage("Thời gian đặt phòng bị trống hoặc sai định dạng!");
            QLDatPhong.checkn1 = false;
            return;
        }

        if (QLDatPhong.checkn2) {
            qlDP.showMessage("thời gian bắt đầu thuê bị trống hoặc sai định dạng!");
            QLDatPhong.checkn2 = false;
            return;
        }
        if (QLDatPhong.checkOld) {
            qlDP.showMessage("Ngày bắt đầu không được nhỏ hơn ngày đặt!");
            QLDatPhong.checkOld = false;
            return;
        }
        boolean test = new DatPhongModel().update1(updateRoom);
        if (test) {
            qlDP.showMessageOK("Update phong thanh cong");
            qlDP.taiTrang(new DatPhongModel().getDulieu());
            qlDP.reset();

        } else {
            qlDP.showMessage("Update phong khong thanh cong");

        }

    }
}
