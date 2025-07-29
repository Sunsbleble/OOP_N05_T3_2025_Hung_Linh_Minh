package com.example.servingwebcontent.Controller;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class QuanLyThanhToan {
    private QuanLyKhachHang quanLyKhachHang;
    private QuanLyMayTinh quanLyMayTinh;
    private List<ThanhToan> danhSachHoaDon;

    public QuanLyThanhToan(QuanLyKhachHang quanLyKhachHang, QuanLyMayTinh quanLyMayTinh) {
        this.quanLyKhachHang = quanLyKhachHang;
        this.quanLyMayTinh = quanLyMayTinh;
        this.danhSachHoaDon = new ArrayList<>();
    }

    public List<ThanhToan> getDanhSachHoaDon() {
        return new ArrayList<>(danhSachHoaDon);
    }

    public boolean thanhToan(String maKhachHang, int idMayTinh) {
        KhachHang kh = quanLyKhachHang.timKhachHang(maKhachHang);
        MayTinh may = quanLyMayTinh.timMayTinh(idMayTinh);
        
        if (kh != null && may != null && may.getTrangThai() == MayTinh.TrangThaiMay.DANG_SU_DUNG 
            && may.getMaKhachHangDangSuDung().equals(maKhachHang)) {
            
            double thanhTien = quanLyMayTinh.ketThucSuDungMay(idMayTinh);
            if (kh.truTien(thanhTien)) {
                String maHoaDon = "HD" + UUID.randomUUID().toString().substring(0, 8);
                ThanhToan hoaDon = new ThanhToan(maHoaDon, maKhachHang, idMayTinh, 
                                               may.getThoiGianBatDau(), may.getThoiGianKetThuc(), 
                                               thanhTien);
                danhSachHoaDon.add(hoaDon);
                kh.themLichSuDichVu("Sử dụng máy " + idMayTinh + " - " + thanhTien + " VND");
                return true;
            }
        }
        return false;
    }
}
