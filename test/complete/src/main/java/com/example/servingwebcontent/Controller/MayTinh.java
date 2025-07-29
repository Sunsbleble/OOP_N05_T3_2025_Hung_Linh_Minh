package com.example.servingwebcontent.Controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class MayTinh {
    private int id;
    private double giaTienTheoGio;
    private TrangThaiMay trangThai;
    private List<String> danhSachPhanMem;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;
    private String maKhachHangDangSuDung;

    public enum TrangThaiMay {
        DANG_RANH, DANG_SU_DUNG, DANG_BAO_TRI
    }

    public MayTinh(int id, double giaTienTheoGio) {
        this.id = id;
        this.giaTienTheoGio = giaTienTheoGio;
        this.trangThai = TrangThaiMay.DANG_RANH;
        this.danhSachPhanMem = new ArrayList<>();
    }

    // Getter & Setter
    public int getId() { return id; }
    public double getGiaTienTheoGio() { return giaTienTheoGio; }
    public void setGiaTienTheoGio(double gia) { this.giaTienTheoGio = gia; }
    public TrangThaiMay getTrangThai() { return trangThai; }
    public void setTrangThai(TrangThaiMay trangThai) { this.trangThai = trangThai; }
    public List<String> getDanhSachPhanMem() { return danhSachPhanMem; }
    public LocalDateTime getThoiGianBatDau() { return thoiGianBatDau; }
    public void setThoiGianBatDau(LocalDateTime time) { this.thoiGianBatDau = time; }
    public LocalDateTime getThoiGianKetThuc() { return thoiGianKetThuc; }
    public void setThoiGianKetThuc(LocalDateTime time) { this.thoiGianKetThuc = time; }
    public String getMaKhachHangDangSuDung() { return maKhachHangDangSuDung; }
    public void setMaKhachHangDangSuDung(String maKH) { this.maKhachHangDangSuDung = maKH; }

    public void themPhanMem(String phanMem) {
        if (!danhSachPhanMem.contains(phanMem)) {
            danhSachPhanMem.add(phanMem);
        }
    }

    public void xoaPhanMem(String phanMem) {
        danhSachPhanMem.remove(phanMem);
    }
}