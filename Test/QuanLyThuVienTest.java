public class QuanLyThuVienTest {

    public void testPhuongThucMuonSach() {
        QuanLyThuVien qltv = new QuanLyThuVien();

        // Thêm sách
        qltv.themSach(new Sach("S001", "Lập trình Java", "Nguyễn Văn A", "CNTT"));
        qltv.themSach(new Sach("S002", "Cơ sở dữ liệu", "Trần Văn B", "CNTT"));

        // Mượn sách
        System.out.println(qltv.muonSach("S001", "KH001"));
        System.out.println(qltv.muonSach("S001", "KH002"));

        // Hiển thị phiếu mượn
        System.out.println("\nDanh sách phiếu mượn:");
        for (PhieuMuon pm : qltv.getDsPhieuMuon()) {
            System.out.println(pm);
        }
    }
}
