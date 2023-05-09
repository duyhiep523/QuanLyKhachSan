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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public String regexMail = "^[a-z][a-z0-9_\\.]{2,32}@[a-z0-9]{2,}(\\.[a-z0-9]{2,4}){1,2}$";
    public String regexSDT = "^[0-9]{8,}$";
    public String regexTND = "^[a-zA-Z]+$";

    public boolean Regex(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);
        return matcher.matches();
    }

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
        if (!Regex(nd.getSdt(), regexSDT)) {
            ttk.showMessage("Sai định dạng số điện thoại");
            return;
        }
        if (nd.getCMND().equals("")) {
            ttk.showMessage("Chứng minh nhân dân không được bỏ trống");
            return;
        }
          if (!Regex(nd.getSdt(), regexSDT)) {
            ttk.showMessage("Sai định dạng chứng minh nhân dân");
            return;
        }
        if (nd.getEmail().equals("")) {
            ttk.showMessage("Email không được bỏ trống");
            return;
        }
        if (!Regex(nd.getEmail(), regexMail)) {
            ttk.showMessage("Email sai định dạng");
            return;

        }
        if (nd.getTaiKhoan().equals("")) {
            ttk.showMessage("Tài khoản không được bỏ trống");
            return;
        }
        if (!Regex(nd.getTaiKhoan(), regexTND)) {
            ttk.showMessage("Tên người dùng phải viết liền không dấu");
            return;

        }
        if (nd.getMatKhau().equals("")) {
            ttk.showMessage("Mật khẩu không được bỏ trống");
            return;
        }
        if (!ttk.checkDOB) {
            ttk.showMessage("nhập sai ngày sinh");
            ttk.checkDOB = true;
            return;
        }
        if (ttk.checkPass == false) {
            ttk.showMessage("mật khẩu nhập lại không đúng");
            return;
        }

        boolean test = new NguoiDungModel().addNguoiDung(nd);
        if (test) {
            ttk.showMessageOK("Tạo thành công");
            ttk.resetForm();
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
