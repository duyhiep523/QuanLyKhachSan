/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import View.DSHoaDon;
import Model.HoaDonModel;
import View.QLHoaDon;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author hiep0
 */
public class HoaDonController {

    static DSHoaDon dshoadon;
    static QLHoaDon qlhoadon;

    public HoaDonController() {

    }

    public int laySoHoaDon() {
        return new HoaDonModel().demSoHoaDon();
    }

    public HoaDonController(DSHoaDon dshoadon) {
        HoaDonController.dshoadon = dshoadon;
    }

    public HoaDonController(QLHoaDon qlhoadon) {
        HoaDonController.qlhoadon = qlhoadon;
    }

    public void hienthi() {
        dshoadon.taiTrang(new HoaDonModel().getDuLieu());
    }

//       tạo hóa đơn
    public String regexNgayTao = "\\d{4}[-]\\d{1,2}[-]\\d{1,2}";
    public String regexMaHoaDon = "^HD\\d{2,5}$";
    public String regexMaDP = "^DP\\d{2,5}$";

    public boolean Regex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

    public void themHoaDon() {
        HoaDonModel hd = qlhoadon.getHoaDon();
        if (hd.getMaHoaDon().equals("")) {
            qlhoadon.showMessageFail("Mã hóa đơn không được để trống");
            return;
        }

        if (!Regex(hd.getMaHoaDon(), regexMaHoaDon)) {
            qlhoadon.showMessageFail("Mã hóa đơn phải đúng định dạng vd: HD01");
            return;
        }

        if (hd.getMaDatPhong().equals("")) {
            qlhoadon.showMessageFail("Mã đặt phòng không được để trống");
            return;

        }

        if (!Regex(hd.getMaDatPhong(), regexMaDP)) {
            qlhoadon.showMessageFail("Mã đặt phòng phải đúng định dạng vd: DP01");
            return;
        }
        
        
        
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String ngayTao = format.format(hd.getNgayTao());
        
        
        LocalDate curentDate = LocalDate.now();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        ngayTao = formatter.format(curentDate);

        boolean test = new HoaDonModel().addHoaDon(hd);
        if (test) {
            qlhoadon.showMessageSuccess("Thêm hóa đơn Thành công");
            qlhoadon.taiTrang(qlhoadon.layDSHoaDon());
            qlhoadon.reset();

        } else {
            qlhoadon.showMessageFail("Thêm hóa đơn thật bại");
        }

    }

    public void suaHoaDon() {
        HoaDonModel hd = qlhoadon.getHoaDon();
        if (hd.getMaHoaDon().equals("")) {
            qlhoadon.showMessageFail("Mã hóa đơn không được để trống");
            return;
        }

        if (!Regex(hd.getMaHoaDon(), regexMaHoaDon)) {
            qlhoadon.showMessageFail("Mã hóa đơn phải đúng định dạng vd: HD01");
            return;
        }

        if (hd.getMaDatPhong().equals("")) {
            qlhoadon.showMessageFail("Mã đặt phòng không được để trống");
            return;

        }

        if (!Regex(hd.getMaDatPhong(), regexMaDP)) {
            qlhoadon.showMessageFail("Mã đặt phòng phải đúng định dạng vd: DP01");
            return;
        }

//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
//        String ngayTao = format.format(hd.getNgayTao());
//
//        if (ngayTao.equals("2222-11-11")) {
//            qlhoadon.showMessageFail("Ngày tạo không được để trống");
//            return;
//        }
//
//        if (!Regex(ngayTao, regexNgayTao)) {
//            qlhoadon.showMessageFail("Ngày tạo phải đúng định dạng vd: 2004-17-11");
//            return;
//        }

        boolean test = new HoaDonModel().suaHoaDon(hd);
        if (test) {
            qlhoadon.showMessageSuccess("Sửa hóa đơn Thành công");
            qlhoadon.taiTrang(qlhoadon.layDSHoaDon());
            qlhoadon.reset();
        } else {
            qlhoadon.showMessageFail("Thất bại sửa hóa đơn");
        }
    }

    public void xoaHoaDon() {
        HoaDonModel hd = qlhoadon.xoaHoaDon();
        if (hd.getMaHoaDon().equals("")) {
            qlhoadon.showMessageFail("Mã hóa đơn không được để trống");
            return;
        }

        if (!Regex(hd.getMaHoaDon(), regexMaHoaDon)) {
            qlhoadon.showMessageFail("Mã hóa đơn phải đúng định dạng vd: HD01");
            return;
        }

        boolean test = new HoaDonModel().xoaHoaDon(hd);
        if (test) {
            qlhoadon.showMessageSuccess("xóa hóa đơn Thành công");
            qlhoadon.taiTrang(qlhoadon.layDSHoaDon());
            qlhoadon.reset();
        } else {
            qlhoadon.showMessageFail("Thất bại sửa hóa đơn");
        }
    }

}