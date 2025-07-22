import java.time.LocalDate;
import java.util.*;

public class QuanLyThuVien {
private List<Sach> dsSach = new ArrayList<>();
private List<PhieuMuon> dsPhieuMuon = new ArrayList<>();

public void themSach(Sach sach) {
dsSach.add(sach);
}

public String muonSach(String maSach, String maKhachHang) {
for (Sach s : dsSach) {
if (s.getMaSach().equalsIgnoreCase(maSach)) {
if (s.isDaMuon()) {
return "Sách đã được mượn.";
} else {
s.setDaMuon(true);
LocalDate ngayMuon = LocalDate.now();
LocalDate hanTra = ngayMuon.plusDays(14); // hạn 14 ngày
dsPhieuMuon.add(new PhieuMuon(maKhachHang, maSach, ngayMuon, hanTra));
return "Mượn sách thành công.";
}
}
}
return "Không tìm thấy mã sách.";
}

public List<PhieuMuon> getDsPhieuMuon() {
return dsPhieuMuon;
}
}