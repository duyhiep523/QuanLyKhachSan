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
import View.QLThemDV;

/**
 *
 * @author hiep0
 */
public class DichVuController {

    private static QLDichVu QLDV;
    private static QLThemDV QLTDV;


    public DichVuController(QLDichVu view) {
        DichVuController.QLDV = view;

    }

    public DichVuController(QLThemDV view) {
        DichVuController.QLTDV = view;

    }

    public String regexTDV = "^DV\\d+$";
    public String regexDP = "^DP\\d+$";
    public String regexPDV = "^\\d+$";

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

        if (dv.getServiceId().isEmpty()) {
            JOptionPane.showMessageDialog(QLDV, "ID không được bỏ trống.");
            return;
        }
        if (!dv.getServiceId().matches(regexTDV)) {
            JOptionPane.showMessageDialog(QLDV, "ID phải có định dạng DVxxx.");
            return;
        }
        if (dv.getServiceName().isEmpty()) {
            JOptionPane.showMessageDialog(QLDV, "Tên không được bỏ trống.");
            return;
        }

        if (gia.isEmpty()) {
            JOptionPane.showMessageDialog(QLDV, "Giá không được để trống.");
        }

        boolean result = new DichVuModel().them(dv);
        if (result) {
            JOptionPane.showMessageDialog(QLDV, "Thêm dịch vụ thành công.");
            QLDV.resetForm();
        } else {
            JOptionPane.showMessageDialog(QLDV, "Thêm dịch vụ không thành công. Mã dịch vụ đã tồn tại trong cơ sở dữ liệu.");
        }
    }

    public void themDVV() {
        DichVuModel dv = QLTDV.getDV();
        String gia = String.valueOf(dv.getServicePrice());
        String sl = String.valueOf(dv.getSoLuong());
        if (dv.getServiceId() == null || dv.getServiceId().isEmpty()) {
            QLTDV.showMessage("Mã Dịch Vụ không được bỏ trống");
            return;
        }
        if (!dv.getIdR().matches(regexDP)) {
            JOptionPane.showMessageDialog(QLTDV, "Mã Phòng phải có định dạng DPxxx.");
            return;
        }

        if (sl == null || sl.isEmpty()) {
            QLTDV.showMessage("Số lượng không được bỏ trống");
            return;
        }

        boolean result = new DichVuModel().themDV(dv);
        if (result) {
            JOptionPane.showMessageDialog(QLTDV, "Thêm dịch vụ thành công.");
        } else {
            JOptionPane.showMessageDialog(QLTDV, "lỗi ");
        }

    }

    public void xoaDV() {
        DichVuModel dv = QLDV.getDV();
        boolean dele = new DichVuModel().deleteDV(dv);
        if (dele) {
            JOptionPane.showMessageDialog(QLDV, "Xóa dịch vụ thành công.");

        } else {
            JOptionPane.showMessageDialog(QLDV, "Xóa dịch vụ thất bại.");
        }
    }

    public void xoaDV2() {
        DichVuModel dv = QLTDV.getDV();
        boolean dele = new DichVuModel().deleteDV2(dv);
        if (dele) {
            JOptionPane.showMessageDialog(QLTDV, "Xóa dịch vụ thành công.");

        } else {
            JOptionPane.showMessageDialog(QLTDV, "Xóa dịch vụ thất bại.");
        }
    }

    public void suaDV() {
        DichVuModel dv = QLTDV.getDV();
        String gia = String.valueOf(dv.getServicePrice());
        String sl = String.valueOf(dv.getSoLuong());
        if (dv.getServiceId() == null || dv.getServiceId().isEmpty()) {
            QLTDV.showMessage("Mã Dịch Vụ không được bỏ trống");
            return;
        }
        if (!dv.getIdR().matches(regexDP)) {
            JOptionPane.showMessageDialog(QLTDV, "Mã Phòng phải có định dạng DPxxx.");
            return;
        }

        if (sl == null || sl.isEmpty()) {
            QLTDV.showMessage("Số lượng không được bỏ trống");
            return;
        }

        boolean result = new DichVuModel().themDV(dv);
        if (result) {
            JOptionPane.showMessageDialog(QLTDV, "Sửa dịch vụ thành công.");
        } else {
            JOptionPane.showMessageDialog(QLTDV, "lỗi");
        }

    }

    public void suaDVV() {
        DichVuModel dv = QLTDV.getDV();
        String gia = String.valueOf(dv.getServicePrice());
        String sl = String.valueOf(dv.getSoLuong());
        // Kiểm tra điều kiện trước khi thêm dịch vụ
        if (dv.getServiceId().isEmpty()) {
            JOptionPane.showMessageDialog(QLTDV, "ID không được bỏ trống.");
            return;
        }
        if (!dv.getServiceId().matches(regexTDV)) {
            JOptionPane.showMessageDialog(QLTDV, "ID phải có định dạng DVxxx.");
            return;
        }
        if (dv.getServiceName().isEmpty()) {
            JOptionPane.showMessageDialog(QLTDV, "Tên không được bỏ trống.");
            return;
        }

        if (gia.isEmpty()) {
            JOptionPane.showMessageDialog(QLTDV, "Giá không được bỏ trống.");
        }
        if (sl.isEmpty()) {
            JOptionPane.showMessageDialog(QLTDV, "Số Lượng không được bỏ trống.");
        }
        boolean edit = new DichVuModel().suaDV(dv);

        if (edit) {
            JOptionPane.showMessageDialog(QLTDV, "Sửa dịch vụ thành công.");
        } else {
            JOptionPane.showMessageDialog(QLTDV, "Sửa dịch vụ thất bại.");
        }
    }

    public int CountDichVu() {
        return new DichVuModel().CountDichVu();
    }
}
