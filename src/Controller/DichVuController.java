/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.DichVuModel;
import View.QLDichVu;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

/**
 *
 * @author hiep0
 */
public class DichVuController {

    private static QLDichVu QLDV;

    public DichVuController(QLDichVu view) {
        DichVuController.QLDV = view;

    }
  public String regexTDV = "^DV+[0-9]$";
     public String regexPDV = "^[0-9]$";

    public DichVuController() {
    }

public boolean Regex(String input, String regex) {
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(input);
    return matcher.matches();
}

public void themDV() {
    DichVuModel dv = QLDV.getDV();
    String gia = String.valueOf(dv.getServicePrice());
    
    // Kiểm tra điều kiện trước khi thêm dịch vụ
    if (dv.getServiceId() == null || dv.getServiceId().isEmpty()) {
        JOptionPane.showMessageDialog(QLDV, "ID không được bỏ trống.");
        return;
    }
    if (Regex(dv.getServiceId(), regexTDV)) {
        JOptionPane.showMessageDialog(QLDV, "ID phải có định dạng DVxxx.");
        return;
    }
    if (dv.getServiceName() == null || dv.getServiceName().isEmpty()) {
        JOptionPane.showMessageDialog(QLDV, "Tên không được bỏ trống.");
        return;
    }
    if (gia == null || gia.isEmpty()) {
        JOptionPane.showMessageDialog(QLDV, "Giá không được bỏ trống.");
        return;
    }
    if (Regex(gia, regexPDV)) {
        JOptionPane.showMessageDialog(QLDV, "Giá phải là một số.");
        return;
    }
    
    boolean result = new DichVuModel().them(dv);
    if (result) {
        JOptionPane.showMessageDialog(QLDV, "Thêm dịch vụ thành công.");
        QLDV.taiTrang(new DichVuModel().getService());
        QLDV.resetForm();
    } else {
        JOptionPane.showMessageDialog(QLDV, "Thêm dịch vụ không thành công. Mã dịch vụ đã tồn tại trong cơ sở dữ liệu.");
    }
}


    public void xoaDV() {
        DichVuModel dv = QLDV.getDV();
        boolean dele = new DichVuModel().deleteDV(dv);
        if (dele) {
            JOptionPane.showMessageDialog(QLDV, "xóa dịch vụ thành công.");
            QLDV.taiTrang(new DichVuModel().getService());
            QLDV.resetForm();

        } else {
            JOptionPane.showMessageDialog(QLDV, "xóa dịch vụ thất bại.");
        }
    }

    public void suaDV() {
        DichVuModel dv = QLDV.getDV();
        boolean edit = new DichVuModel().sua(dv);
       
        if (edit) {
            JOptionPane.showMessageDialog(QLDV, "sửa dịch vụ thành công.");
            QLDV.taiTrang(new DichVuModel().getService());
            QLDV.resetForm();
        } else {
            JOptionPane.showMessageDialog(QLDV, "sửa dịch vụ thất bại.");
        }
    }
    
    public int CountDichVu(){
        return new DichVuModel().CountDichVu();
    }
}