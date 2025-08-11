import java.time.LocalDate;

public class PhieuMuon {
private String maKhachHang;
private String maSach;
private LocalDate ngayMuon;
private LocalDate hanTra;

public PhieuMuon(String maKhachHang, String maSach, LocalDate ngayMuon, LocalDate hanTra) {
this.maKhachHang = maKhachHang;
this.maSach = maSach;
this.ngayMuon = ngayMuon;
this.hanTra = hanTra;
}

public String getMaKhachHang() { return maKhachHang; }
public String getMaSach() { return maSach; }
public LocalDate getNgayMuon() { return ngayMuon; }
public LocalDate getHanTra() { return hanTra; }

@Override
public String toString() {
return "Mã KH: " + maKhachHang + ", Mã sách: " + maSach +
", Ngày mượn: " + ngayMuon + ", Hạn trả: " + hanTra;
}
}