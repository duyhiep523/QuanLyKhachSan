/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.DSHoaDon;
import Model.HoaDonModel;
import View.QLHoaDon;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hiep0
 */
public class HoaDonController {

    DSHoaDon dshoadon;
    QLHoaDon qlhoadon;

    public HoaDonController() {

    }

    public int laySoHoaDon() {
        return new HoaDonModel().demSoHoaDon();
    }

    public HoaDonController(DSHoaDon dshoadon) {
        this.dshoadon = dshoadon;
    }

    public HoaDonController(QLHoaDon qlhoadon) {
        this.qlhoadon = qlhoadon;
    }

    public void hienthi1() {
        qlhoadon.taiTrang(new HoaDonModel().getDuLieu());
    }

    public void hienthi() {
        dshoadon.taiTrang(new HoaDonModel().getDuLieu());
    }

//       tạo hóa đơn
    public String regexNgayTao = "\\d{4}[-]\\d{1,2}[-]\\d{1,2}";
    public String regexMaHoaDon = "^HD\\d{2,3}$";
    public String regexMaDP = "^DP\\d{2,3}$";

    public boolean Regex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public void taoHoaDon() {
        HoaDonModel hd = qlhoadon.getHoaDon();
        if (hd.getMaHoaDon().equals("")) {
            qlhoadon.showMessage("Mã hóa đơn không được để trống");
            return;
        }

        if (!Regex(hd.getMaHoaDon(), regexMaHoaDon)) {
            qlhoadon.showMessage("Mã hóa đơn phải đúng định dạng vd: HD01");
            return;
        }

        if (hd.getMaDatPhong().equals("")) {
            qlhoadon.showMessageOK("Mã đặt phòng không được để trống");
            return;

        }

        if (!Regex(hd.getMaDatPhong(), regexMaDP)) {
            qlhoadon.showMessage("Mã đặt phòng phải đúng định dạng vd: DP01");
            return;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String ngayTao = format.format(hd.getNgayTao());

        if (ngayTao.equals("2222-11-11")) {
            qlhoadon.showMessage("Ngày tạo không được để trống");
            return;
        }

        if (!Regex(ngayTao, regexNgayTao)) {
            qlhoadon.showMessage("Ngày tạo phải đúng định dạng vd: 2004-17-11");
            return;
        }

        boolean test = new HoaDonModel().addHoaDon(hd);
        if (test) {
            qlhoadon.showMessage("Thêm hóa đơn Thành công");
            qlhoadon.taiTrang(new HoaDonModel().getDuLieu());
        } else {
            qlhoadon.showMessage("Mã Hóa Đơn đã tồn tại OR Phòng không còn trống");
        }

    }

    public void suaHoaDon() {
        HoaDonModel hd = qlhoadon.getHoaDon();
        if (hd.getMaHoaDon().equals("")) {
            qlhoadon.showMessage("Mã hóa đơn không được để trống");
            return;
        }

        if (!Regex(hd.getMaHoaDon(), regexMaHoaDon)) {
            qlhoadon.showMessage("Mã hóa đơn phải đúng định dạng vd: HD01");
            return;
        }

        if (hd.getMaDatPhong().equals("")) {
            qlhoadon.showMessageOK("Mã đặt phòng không được để trống");
            return;

        }

        if (!Regex(hd.getMaDatPhong(), regexMaDP)) {
            qlhoadon.showMessage("Mã đặt phòng phải đúng định dạng vd: DP01");
            return;
        }

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String ngayTao = format.format(hd.getNgayTao());

        if (ngayTao.equals("2222-11-11")) {
            qlhoadon.showMessage("Ngày tạo không được để trống");
            return;
        }

        if (!Regex(ngayTao, regexNgayTao)) {
            qlhoadon.showMessage("Ngày tạo phải đúng định dạng vd: 2004-17-11");
            return;
        }

        boolean test = new HoaDonModel().suaHoaDon(hd);
        if (test) {
            qlhoadon.showMessage("Sửa hóa đơn Thành công");
            qlhoadon.taiTrang(new HoaDonModel().getDuLieu());
        } else {
            qlhoadon.showMessage("Thất bại sửa hóa đơn");
        }
    }

    public void xoaHoaDon() {
        HoaDonModel hd = qlhoadon.xoaHoaDon();
        if (hd.getMaHoaDon().equals("")) {
            qlhoadon.showMessage("Mã hóa đơn không được để trống");
            return;
        }

        if (!Regex(hd.getMaHoaDon(), regexMaHoaDon)) {
            qlhoadon.showMessage("Mã hóa đơn phải đúng định dạng vd: HD01");
            return;
        }

        boolean test = new HoaDonModel().xoaHoaDon(hd);
        if (test) {
            qlhoadon.showMessage("xóa hóa đơn Thành công");
            qlhoadon.taiTrang(new HoaDonModel().getDuLieu());

        } else {
            qlhoadon.showMessage("Thất bại sửa hóa đơn");
        }
    }

}