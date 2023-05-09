/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.NguoiDungModel;
import View.DangNhap;
import View.ManHinhChinh;
import View.TaotaiKhoan;
import java.text.SimpleDateFormat;

/**
 *
 * @author hiep0
 */
public class NguoiDungController {

    private static DangNhap dnview;
    public static NguoiDungModel ndOn;
    private static TaotaiKhoan ttk;

    public NguoiDungController(DangNhap view) {
        NguoiDungController.dnview = view;
    }

    public NguoiDungController(TaotaiKhoan view) {
        NguoiDungController.ttk = view;
    }
// dang nhap

    public void doLogin() {
        {
            NguoiDungModel nd = dnview.getUserLogin();
            if (nd.getTaiKhoan().equals("") || nd.getMatKhau().equals("")) {
                dnview.showMessageLogin("Vui lòng điền đầy đủ thông tin \n");
            } else {
                NguoiDungModel ndc = new NguoiDungModel().checkLogin(nd.getTaiKhoan(), nd.getMatKhau());
                if (ndc.getCMND() != null) {
                    ManHinhChinh.run();
                    ndOn = ndc;
                    dnview.dispose();
                } else {
                    dnview.showMessageLogin("Sai thông tin đăng nhập \n");
                }
            }
        }
    }
// dang nhap
// them nguoi dung

    public void addNguoiDung() {
        NguoiDungModel nd = ttk.getNDMD();
        if (nd.getHoTen().equals("")) {
            ttk.showMessage("Tên không được bỏ trống");
            return;
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(nd.getNgaySinh());
        if (strDate.equals("")) {
            ttk.showMessage("Ngày sinh không được bỏ trống");
            return;
        }
        if (nd.getSdt().equals("")) {
            ttk.showMessage("Số điện thoại không được bỏ trống");
            return;
        }
        if (nd.getEmail().equals("")) {
            ttk.showMessage("Email không được bỏ trống");
            return;
        }
        if (nd.getCMND().equals("")) {
            ttk.showMessage("Cứng minh nhân dân không được bỏ trống");
            return;
        }
        if (nd.getTaiKhoan().equals("")) {
            ttk.showMessage("Tài khoản không được bỏ trống");
            return;
        }
        if (nd.getMatKhau().equals("")) {
            ttk.showMessage("Mật khẩu không được bỏ trống");
            return;
        }
        String sex = nd.getGioiTinh() ? "1" : "0";
        if (sex.equals("")) {
            ttk.showMessage("Giới tính không được bỏ trống");
            return;
        }
        if (ttk.checkDOB == false) {
            ttk.showMessage("nhập sai ngày sinh");
        }
        if (ttk.checkPass == false) {
            ttk.showMessage("mật khẩu nhập lại không đúng");
            return;
        }
        boolean test = new NguoiDungModel().addNguoiDung(nd);
        if (test) {
            ttk.showMessage("Tạo thành công");
        } else {
            ttk.showMessage("người dùng đã tồn tại");
        }

    }

// them nguoi dung
    public static DangNhap getDnview() {
        return dnview;
    }

    public static void setDnview(DangNhap dnview) {
        NguoiDungController.dnview = dnview;
    }

    public static TaotaiKhoan getTtk() {
        return ttk;
    }

    public static void setTtk(TaotaiKhoan ttk) {
        NguoiDungController.ttk = ttk;
    }

}
