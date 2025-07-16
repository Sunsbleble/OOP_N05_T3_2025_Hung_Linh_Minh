import java.util.Map;
import java.util.Scanner;

public class ReadLoan {
    public static void readLoan(Map<String, Loan> loans) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập LoanID cần xem: ");
        String loanID = scanner.nextLine();

        Loan loan = loans.get(loanID);
        if (loan == null) {
            System.out.println("Không tìm thấy giao dịch.");
            return;
        }

        System.out.println("LoanID: " + loan.getLoanID());
        System.out.println("Người mượn: " + loan.getMember().getName() + " (ID: " + loan.getMember().getMemberID() + ")");
        System.out.println("Ngày mượn: " + loan.getBorrowDate());
        System.out.println("Ngày trả: " + loan.getReturnDate());
        System.out.println("Danh sách sách mượn:");

        for (Book book : loan.getBorrowedBooks()) {
            System.out.println(" - " + book.getTitle() + " (ID: " + book.getBookID() + ")");
        }
    }
}
