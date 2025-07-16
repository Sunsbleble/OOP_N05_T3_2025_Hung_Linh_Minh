import bth.Book;

public class BookTest {
    public static void runTests() {
        System.out.println("Chạy test cho Book:");

        Book b = new Book("B001", "Lập trình Java", "Nguyễn Văn A", "NXB Trẻ", 2023, "CNTT", 10);

        System.out.println("Thông tin sách:");
        System.out.println(b);

        System.out.println("Giảm số lượng sách đi 2 cuốn.");
        b.setSoLuong(b.getSoLuong() - 2);
        System.out.println("Số lượng còn lại: " + b.getSoLuong());

        System.out.println("Tăng số lượng sách lên 5 cuốn.");
        b.setSoLuong(b.getSoLuong() + 5);
        System.out.println("Số lượng hiện tại: " + b.getSoLuong());
    }
}

