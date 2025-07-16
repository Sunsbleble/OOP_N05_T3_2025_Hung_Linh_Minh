import java.util.Date;

import bth.Member;

public class MemberTest {
    public static void runTests() {
        System.out.println("\nChạy test cho Member:");

        Member m = new Member("M001", "Trần Thị B", "Hà Nội", "0987654321");
        System.out.println("Thông tin người đọc:");
        System.out.println(m);

        // Tạo sách giả để mượn
        Books b1 = new Books("B001", "Lập trình Java", "Nguyễn Văn A", "NXB Trẻ", 2023, "CNTT", 10);

        // Tạo phiếu mượn
        Borrowing br1 = new Borrowing("BR001", b1, m, new Date());

        // Người đọc mượn sách
        m.muonSach(br1);

        System.out.println("Sau khi mượn sách:");
        System.out.println(m);

        System.out.println("Danh sách phiếu mượn của người đọc:");
        for (Borrowing br : m.getDanhSachMuon()) {
            System.out.println(br);
        }
    }
}
