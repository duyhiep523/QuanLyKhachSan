/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.NguoiDungModel;
import View.DangNhap;
import View.ManHinhChinh;

/**
 *
 * @author hiep0
 */
public class NguoiDungController {

    private static DangNhap dnview;
    public static NguoiDungModel ndOn;

    public NguoiDungController(DangNhap view) {
        NguoiDungController.dnview = view;
    }

    public void doLogin() {
        {
            NguoiDungModel nd = dnview.getUserLogin();
            if (nd.getTaiKhoan().equals("") || nd.getMatKhau().equals("")) {
                dnview.showMessageLogin("Vui lòng điền đầy đủ thông tin \n");
            } else {
                NguoiDungModel ndc = new NguoiDungModel().checkLogin(nd.getTaiKhoan(), nd.getMatKhau());
                if (ndc.getEmail() != null) {
                    
                    ManHinhChinh.run();
                    ndOn = ndc;
                    dnview.dispose();
                    
                } else {
                    dnview.showMessageLogin("Sai thông tin đăng nhập \n");
                }
            }
        }
    }

    public static DangNhap getDnview() {
        return dnview;
    }

    public static void setDnview(DangNhap dnview) {
        NguoiDungController.dnview = dnview;
    }

}
