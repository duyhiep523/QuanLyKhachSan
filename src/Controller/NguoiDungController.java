/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.NguoiDungModel;
import View.DangNhap;
import View.DoiMatKhau;
import View.ManHinhChinh;
import View.NguoiDung;
import View.TTUser;
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
    private static TTUser ttus;
    private static DoiMatKhau doipass;

    public NguoiDungController(DangNhap view) {
        NguoiDungController.dnview = view;
    }

    public NguoiDungController(TaotaiKhoan view) {
        NguoiDungController.ttk = view;
    }

    public NguoiDungController(TTUser view) {
        NguoiDungController.ttus = view;
    }

    public NguoiDungController(DoiMatKhau view) {
        NguoiDungController.doipass = view;
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
            ttk.showMessage("Người dùng đã tồn tại");
        }
    }

// them nguoi dung
// update tt
    public void updateNguoiDung(NguoiDung nguoidung) {
        NguoiDungModel nd = ttus.getNDMD();
        String error = "";
        if (nd.getHoTen().equals("")) {
            error = error.concat("Tên không được bỏ trống\n");
        }
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String strDate = formatter.format(nd.getNgaySinh());
        if (strDate.equals("")) {
            error = error.concat("Ngày sinh không được bỏ trống\n");
        }
        if (nd.getSdt().equals("")) {
            error = error.concat("Số điện thoại không được bỏ trống\n");
        }
        if (!Regex(nd.getSdt(), regexSDT)) {
            error = error.concat("Sai định dạng số điện thoại\n");
        }
        if (nd.getCMND().equals("")) {
            error = error.concat("Chứng minh nhân dân không được bỏ trống\n");
        }
        if (!Regex(nd.getSdt(), regexSDT)) {
            error = error.concat("Sai định dạng chứng minh nhân dân\n");
        }
        if (nd.getEmail().equals("")) {
            error = error.concat("Email không được bỏ trống\n");
        }
        if (!Regex(nd.getEmail(), regexMail)) {
            error = error.concat("Email sai định dạng\n");
        }

        if (!ttus.checkDOB) {
            error = error.concat("Nhập sai ngày sinh \n");
            ttus.checkDOB = true;
        }

        if (error.equals("")) {
            boolean test = new NguoiDungModel().updateNguoiDung(nd);
            if (test) {
                ndOn = nd;
                ttus.showMessageOK("update thành công ");
                ttus.setTT();
                nguoidung.updateNguoidung();
            } else {
                ttus.showMessage("Đã có lỗi sảy ra");
            }
        } else {
            ttus.showMessage(error);
        }
    }

// update tt
// doi natkhau
    public void updateMatKhau() {
        NguoiDungModel nd = doipass.getMK();
        if (DoiMatKhau.checkEmptyPassCu) {
            doipass.showMessage("Phải điền mật khẩu hiện tại");
            DoiMatKhau.checkEmptyPassCu = false;
            return;
        }
        if (!DoiMatKhau.MKCUKI.equals(ndOn.getMatKhau())) {
            doipass.showMessage("Sai mật khẩu");
            return;
        }
        if (DoiMatKhau.checkEmptyPassMoi1) {
            doipass.showMessage("Phải điền mật khẩu mới");
            DoiMatKhau.checkEmptyPassMoi1 = false;
            return;
        }
        if (DoiMatKhau.checkEmptyPassMoi2) {
            doipass.showMessage("Phải điền lại mật khẩu mới");
            DoiMatKhau.checkEmptyPassMoi2 = false;
            return;
        }
        if (DoiMatKhau.checkPass) {
            doipass.showMessage("Mật khẩu nhập lại không đúng");
            DoiMatKhau.checkPass = false;
            return;
        }
        if (DoiMatKhau.change) {
            doipass.showMessage("Mật khẩu mới phải khác với mật khẩu cũ");
            DoiMatKhau.change = false;
            return;
        }
        boolean test = new NguoiDungModel().updatePass(nd);
        if (test) {
            doipass.showMessageOK("đổi pass thành công");
            NguoiDungController.ndOn = nd;
            doipass.resetForm();
        } else {
            doipass.showMessage("đã có lỗi xảy ra");
        }
    }
// doi matkhau    

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

    public static TTUser getTtus() {
        return ttus;
    }

    public static void setTtus(TTUser ttus) {
        NguoiDungController.ttus = ttus;
    }

    public static DoiMatKhau getDoipass() {
        return doipass;
    }

    public static void setDoipass(DoiMatKhau doipass) {
        NguoiDungController.doipass = doipass;
    }
}
