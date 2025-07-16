import java.time.LocalDate;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class UpdateLoan {
    public static void updateLoan(Map<String, Loan> loans, Map<String, Book> books) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập LoanID cần sửa: ");
        String loanID = scanner.nextLine();

        Loan loan = loans.get(loanID);
        if (loan == null) {
            System.out.println("Không tìm thấy giao dịch.");
            return;
        }

        System.out.println("1. Sửa ngày mượn");
        System.out.println("2. Sửa ngày trả");
        System.out.println("3. Thêm sách mượn");
        System.out.println("4. Xóa sách khỏi danh sách mượn");
        System.out.print("Chọn thao tác cần thực hiện: ");
        int choice = Integer.parseInt(scanner.nextLine());

        switch (choice) {
            case 1 -> {
                System.out.print("Nhập ngày mượn mới (YYYY-MM-DD): ");
                try {
                    LocalDate newBorrowDate = LocalDate.parse(scanner.nextLine());
                    loan.setBorrowDate(newBorrowDate);
                    System.out.println("Cập nhật ngày mượn thành công.");
                } catch (Exception e) {
                    System.out.println("Ngày không hợp lệ.");
                }
            }
            case 2 -> {
                System.out.print("Nhập ngày trả mới (YYYY-MM-DD): ");
                try {
                    LocalDate newReturnDate = LocalDate.parse(scanner.nextLine());
                    loan.setReturnDate(newReturnDate);
                    System.out.println("Cập nhật ngày trả thành công.");
                } catch (Exception e) {
                    System.out.println("Ngày không hợp lệ.");
                }
            }
            case 3 -> {
                System.out.print("Nhập BookID muốn thêm: ");
                String bookID = scanner.nextLine();
                Book book = books.get(bookID);
                if (book == null) {
                    System.out.println("Sách không tồn tại.");
                    return;
                }
                if (!book.isAvailable()) {
                    System.out.println("Sách đã hết số lượng.");
                    return;
                }
                loan.addBook(book);
                book.borrowBook();
                System.out.println("Đã thêm sách: " + book.getTitle());
            }
            case 4 -> {
                System.out.print("Nhập BookID muốn xóa khỏi danh sách: ");
                String bookID = scanner.nextLine();
                Iterator<Book> iterator = loan.getBorrowedBooks().iterator();
                boolean found = false;
                while (iterator.hasNext()) {
                    Book book = iterator.next();
                    if (book.getBookID().equals(bookID)) {
                        iterator.remove();
                        book.returnBook();
                        System.out.println("Đã xóa sách: " + book.getTitle());
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Không tìm thấy sách trong danh sách mượn.");
                }
            }
            default -> System.out.println("Lựa chọn không hợp lệ.");
        }
    }
}
