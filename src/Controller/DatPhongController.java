/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DatPhongModel;
//import Model.PhongModel;
import View.TrangCuaKhach;
//import java.text.SimpleDateFormat
import java.util.Date;

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

    // huy dat phong
}
