import java.util.*;
import java.util.stream.Collectors;

public class QuanLyThuVien {
    private List<Sach> dsSach = new ArrayList<>();

    // Phương thức thêm sách (hỗ trợ)
    public void themSach(Sach sach) {
        dsSach.add(sach);
    }

    // Phương thức hiển thị sách theo thể loại hoặc tác giả
    public List<Sach> hienThiSachTheoTheLoaiHoacTacGia(String input) {
        String search = input.toLowerCase();
        return dsSach.stream()
            .filter(s -> s.getTheLoai().toLowerCase().contains(search) 
                      || s.getTacGia().toLowerCase().contains(search))
            .collect(Collectors.toList());
    }
}
