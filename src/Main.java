import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    // Dữ liệu mẫu
    static Map<String, Loan> loans = new HashMap<>();
    static Map<String, Book> books = new HashMap<>();
    static Map<String, Member> members = new HashMap<>();

    public static void main(String[] args) {
        // Khởi tạo dữ liệu mẫu
        books.put("B001", new Book("B001", "Cuốn sách 1", "Tác giả 1", "NXB A", 2020, "Văn học", 10));
        books.put("B002", new Book("B002", "Cuốn sách 2", "Tác giả 2", "NXB B", 2018, "Khoa học", 5));

        members.put("M001", new Member("M001", "Nguyễn Văn A", "Hà Nội", "0987654321"));
        members.put("M002", new Member("M002", "Trần Thị B", "Hồ Chí Minh", "0912345678"));

        while (true) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Tạo giao dịch mượn sách");
            System.out.println("2. Đọc thông tin giao dịch mượn");
            System.out.println("3. Sửa thông tin giao dịch mượn");
            System.out.println("4. Xóa giao dịch mượn");
            System.out.println("0. Thoát");
            System.out.print("Chọn thao tác: ");

            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> CreateLoan.createLoan(loans, members, books);
                case 2 -> ReadLoan.readLoan(loans);
                case 3 -> UpdateLoan.updateLoan(loans, books);
                case 4 -> DeleteLoan.deleteLoan(loans);
                case 0 -> {
                    System.out.println("Thoát chương trình.");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}
