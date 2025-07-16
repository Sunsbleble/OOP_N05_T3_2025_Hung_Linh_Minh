import java.time.LocalDate;
import java.util.Map;
import java.util.Scanner;

public class CreateLoan {
    public static void createLoan(Map<String, Loan> loans, Map<String, Member> members, Map<String, Book> books) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập LoanID: ");
        String loanID = scanner.nextLine();

        if (loans.containsKey(loanID)) {
            System.out.println("LoanID đã tồn tại.");
            return;
        }

        System.out.print("Nhập MemberID: ");
        String memberID = scanner.nextLine();
        Member member = members.get(memberID);
        if (member == null) {
            System.out.println("Không tìm thấy người đọc.");
            return;
        }

        System.out.print("Nhập ngày mượn (YYYY-MM-DD): ");
        LocalDate borrowDate;
        try {
            borrowDate = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Ngày mượn không hợp lệ.");
            return;
        }

        System.out.print("Nhập ngày trả (YYYY-MM-DD): ");
        LocalDate returnDate;
        try {
            returnDate = LocalDate.parse(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Ngày trả không hợp lệ.");
            return;
        }

        Loan loan = new Loan(loanID, member, borrowDate, returnDate);

        while (true) {
            System.out.print("Nhập BookID muốn mượn (hoặc gõ 'done' để kết thúc): ");
            String bookID = scanner.nextLine();
            if (bookID.equalsIgnoreCase("done")) break;

            Book book = books.get(bookID);
            if (book == null) {
                System.out.println("Sách không tồn tại.");
                continue;
            }

            if (!book.isAvailable()) {
                System.out.println("Sách đã hết số lượng.");
                continue;
            }

            loan.addBook(book);
            book.borrowBook(); // giảm số lượng sách
            System.out.println("Đã thêm sách: " + book.getTitle());
        }

        if (loan.getBorrowedBooks().isEmpty()) {
            System.out.println("Chưa chọn sách nào để mượn, không tạo giao dịch.");
            return;
        }

        loans.put(loanID, loan);
        System.out.println("Tạo giao dịch mượn sách thành công.");
    }
}
