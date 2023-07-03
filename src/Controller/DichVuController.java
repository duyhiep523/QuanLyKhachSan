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

        if (gia == null || gia.isEmpty()) {
            QLDV.showMessage("Giá không được bỏ trống");
        }

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
        if (QLDichVu.TestGia) {
            JOptionPane.showMessageDialog(QLDV, "giá không được bỏ trống và đúng định dạng.");
            QLDichVu.TestGia = false;
            return;
        }
        if (Float.parseFloat(gia) < 0) {
            JOptionPane.showMessageDialog(QLDV, "Giá không được âm.");
            return;
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
        if (Float.parseFloat(gia) < 0) {
            JOptionPane.showMessageDialog(QLTDV, "Giá không được âm.");
            return;
        }
        if (sl == null || sl.isEmpty()) {
            JOptionPane.showMessageDialog(QLTDV, "Số lượng không được rỗng.");
            return;
        }
        if (Integer.parseInt(sl) < 0) {
            JOptionPane.showMessageDialog(QLTDV, "Số lượng không được âm.");
            return;
        }
        if (!dv.getIdR().matches(regexDP)) {
            JOptionPane.showMessageDialog(QLTDV, "Mã Phòng phải có định dạng DPxxx.");
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
        DichVuModel dv = QLDV.getDV();
        String gia = String.valueOf(dv.getServicePrice());

        if (gia == null || gia.isEmpty()) {
            QLDV.showMessage("Giá không được bỏ trống");
        }

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
        if (QLDichVu.TestGia) {
            JOptionPane.showMessageDialog(QLDV, "giá không được bỏ trống và đúng định dạng.");
            QLDichVu.TestGia = false;
            return;
        }
        if (Float.parseFloat(gia) < 0) {
            JOptionPane.showMessageDialog(QLDV, "Giá không được âm.");
            return;
        }
        boolean edit = new DichVuModel().sua(dv);

        if (edit) {
            JOptionPane.showMessageDialog(QLTDV, "Sửa dịch vụ thành công.");
        } else {
            JOptionPane.showMessageDialog(QLTDV, "Sửa dịch vụ thất bại.");
        }

    }

    public void suaDVV() {
        DichVuModel dv = QLTDV.getDV();
        String gia = String.valueOf(dv.getServicePrice());
        String sl = String.valueOf(dv.getSoLuong());
        // Kiểm tra điều kiện trước khi thêm dịch vụ
        if (dv.getServiceId() == null || dv.getServiceId().isEmpty()) {
            QLTDV.showMessage("Mã Dịch Vụ không được bỏ trống");
            return;
        }
        if (QLThemDV.TestGia) {
            JOptionPane.showMessageDialog(QLTDV, "giá không được bỏ trống và đúng định dạng.");
            QLThemDV.TestGia = false;
            return;
        }
        if (QLThemDV.Testsl) {
            JOptionPane.showMessageDialog(QLTDV, "số lượng không được bỏ trống và đúng định dạng.");
            QLThemDV.Testsl = false;
            return;
        }
        if (dv.getIdR() == null || dv.getIdR().isEmpty()) {
            QLTDV.showMessage("mã phòng không được bỏ trống");
            return;
        }

        if (!dv.getIdR().matches(regexDP)) {
            JOptionPane.showMessageDialog(QLTDV, "Mã Phòng phải có định dạng DPxxx.");
            return;
        }
        if (Float.parseFloat(gia) < 0) {
            JOptionPane.showMessageDialog(QLTDV, "Giá không được âm.");
            return;
        }
        if (sl == null || sl.isEmpty()) {
            JOptionPane.showMessageDialog(QLTDV, "Số lượng không được rỗng.");
            return;
        }
        if (Integer.parseInt(sl) < 0) {
            JOptionPane.showMessageDialog(QLTDV, "Số lượng không được âm.");
            return;
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
