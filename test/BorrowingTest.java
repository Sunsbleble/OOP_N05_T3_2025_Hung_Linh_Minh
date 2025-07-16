import java.util.Date;

import bth.Member;

public class BorrowingTest {
    public static void runTests() {
        System.out.println("\nChạy test cho Borrowing:");

        Member m = new Member("M002", "Lê Văn C", "Hồ Chí Minh", "0912345678");
        Books b = new Books("B002", "Cấu trúc dữ liệu", "Phạm Văn D", "NXB Khoa học", 2022, "CNTT", 5);

        Borrowing borrowing = new Borrowing("BR002", b, m, new Date());

        System.out.println("Thông tin phiếu mượn:");
        System.out.println(borrowing);
    }
}
