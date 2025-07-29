package com.example.servingwebcontent.Controller;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class QuanLyMayTinh {
    private List<MayTinh> danhSachMayTinh;

    public QuanLyMayTinh() {
        this.danhSachMayTinh = new ArrayList<>();
    }

    public void themMayTinh(MayTinh mayTinh) {
        danhSachMayTinh.add(mayTinh);
    }

    public boolean xoaMayTinh(int id) {
        return danhSachMayTinh.removeIf(may -> may.getId() == id);
    }

    public MayTinh timMayTinh(int id) {
        return danhSachMayTinh.stream()
                .filter(may -> may.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public List<MayTinh> getDanhSachMayTinh() {
        return new ArrayList<>(danhSachMayTinh);
    }

    public boolean capNhatGiaMayTinh(int id, double giaMoi) {
        MayTinh may = timMayTinh(id);
        if (may != null) {
            may.setGiaTienTheoGio(giaMoi);
            return true;
        }
        return false;
    }
    public boolean themPhanMemVaoMay(int idMay, String tenPhanMem) {
        MayTinh may = timMayTinh(idMay);
        if (may != null) {
            may.themPhanMem(tenPhanMem);
            return true;
        }
        return false;
    }
    public boolean xoaPhanMemKhoiMay(int idMay, String tenPhanMem) {
        MayTinh may = timMayTinh(idMay);
        if (may != null) {
            may.xoaPhanMem(tenPhanMem);
            return true;
        }
        return false;
    }

    public boolean batDauSuDungMay(int id, String maKhachHang) {
        MayTinh may = timMayTinh(id);
        if (may != null && may.getTrangThai() == MayTinh.TrangThaiMay.DANG_RANH) {
            may.setTrangThai(MayTinh.TrangThaiMay.DANG_SU_DUNG);
            may.setThoiGianBatDau(LocalDateTime.now());
            may.setMaKhachHangDangSuDung(maKhachHang);
            return true;
        }
        return false;
    }

    public double ketThucSuDungMay(int id) {
        MayTinh may = timMayTinh(id);
        if (may != null && may.getTrangThai() == MayTinh.TrangThaiMay.DANG_SU_DUNG) {
            may.setThoiGianKetThuc(LocalDateTime.now());
            may.setTrangThai(MayTinh.TrangThaiMay.DANG_RANH);
            
            long phutSuDung = Duration.between(may.getThoiGianBatDau(), may.getThoiGianKetThuc()).toMinutes();
            double thanhTien = (phutSuDung / 60.0) * may.getGiaTienTheoGio();
            
            may.setMaKhachHangDangSuDung(null);
            return thanhTien;
        }
        return 0;
    }
}