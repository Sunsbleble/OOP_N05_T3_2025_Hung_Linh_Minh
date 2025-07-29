package com.example.servingwebcontent.Controller;

import java.time.LocalDateTime;

public class ThanhToan {
    private String maHoaDon;
    private String maKhachHang;
    private int idMayTinh;
    private LocalDateTime thoiGianBatDau;
    private LocalDateTime thoiGianKetThuc;
    private LocalDateTime thoiGianThanhToan;
    private double thanhTien;

    public ThanhToan(String maHoaDon, String maKhachHang, int idMayTinh, 
                    LocalDateTime thoiGianBatDau, LocalDateTime thoiGianKetThuc, 
                    double thanhTien) {
        this.maHoaDon = maHoaDon;
        this.maKhachHang = maKhachHang;
        this.idMayTinh = idMayTinh;
        this.thoiGianBatDau = thoiGianBatDau;
        this.thoiGianKetThuc = thoiGianKetThuc;
        this.thoiGianThanhToan = LocalDateTime.now();
        this.thanhTien = thanhTien;
    }

    // Getter
    public String getMaHoaDon() { return maHoaDon; }
    public String getMaKhachHang() { return maKhachHang; }
    public int getIdMayTinh() { return idMayTinh; }
    public LocalDateTime getThoiGianBatDau() { return thoiGianBatDau; }
    public LocalDateTime getThoiGianKetThuc() { return thoiGianKetThuc; }
    public LocalDateTime getThoiGianThanhToan() { return thoiGianThanhToan; }
    public double getThanhTien() { return thanhTien; }
}
