/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.NguoiDungModel;
import View.DangNhap;
import View.ManHinhChinh;
import View.TaotaiKhoan;

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
// dang nhap
// them nguoi dung
    
    public void addNguoiDung(){
        
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
