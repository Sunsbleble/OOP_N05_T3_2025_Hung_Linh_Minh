import java.util.List;

public class QuanLyThuVienTest {
    public void testHienThiSachTheoTheLoaiHoacTacGia() {
        QuanLyThuVien qltv = new QuanLyThuVien();

        // Thêm dữ liệu mẫu
        qltv.themSach(new Sach("S001", "Lập trình Java", "Nguyễn Văn A", "CNTT"));
        qltv.themSach(new Sach("S002", "Cấu trúc dữ liệu", "Trần Văn B", "CNTT"));
        qltv.themSach(new Sach("S003", "Văn học Việt Nam", "Lê Thị C", "Văn học"));

        // Tìm sách theo thể loại
        System.out.println("Tìm sách thể loại 'CNTT':");
        List<Sach> ketQua1 = qltv.hienThiSachTheoTheLoaiHoacTacGia("CNTT");
        ketQua1.forEach(System.out::println);

        // Tìm sách theo tác giả
        System.out.println("\nTìm sách tác giả 'Lê Thị C':");
        List<Sach> ketQua2 = qltv.hienThiSachTheoTheLoaiHoacTacGia("Lê Thị C");
        ketQua2.forEach(System.out::println);

        // Tìm sách không có kết quả
        System.out.println("\nTìm sách thể loại 'Toán học':");
        List<Sach> ketQua3 = qltv.hienThiSachTheoTheLoaiHoacTacGia("Toán học");
        if (ketQua3.isEmpty()) {
            System.out.println("Không tìm thấy sách phù hợp.");
        }
    }
}
