/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DatPhongModel;
import Model.PhongModel;
import View.TrangCuaKhach;

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
        boolean test = new DatPhongModel().themDatPhong(datphong);
        if (test) {
            trangCuaKhach.showMessageOK("Đặt thành công");
            new DatPhongModel().updateMuonPhong(datphong);
            trangCuaKhach.taiTrang(new PhongModel().getPhong());
            trangCuaKhach.resetForm();
        } else {
            trangCuaKhach.showMessage("Mã đặt phòng đã tồn tại");
        }

    }
    // tạo mới đặt phòng
}
