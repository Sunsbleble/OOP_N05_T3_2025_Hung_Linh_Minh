import java.util.Map;
import java.util.Scanner;

public class DeleteLoan {
    public static void deleteLoan(Map<String, Loan> loans) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập LoanID cần xóa: ");
        String loanID = scanner.nextLine();

        Loan loan = loans.get(loanID);
        if (loan == null) {
            System.out.println("Không tìm thấy giao dịch.");
            return;
        }

        // Trả lại số lượng sách
        for (Book book : loan.getBorrowedBooks()) {
            book.returnBook();
        }

        loans.remove(loanID);
        System.out.println("Xóa giao dịch mượn thành công.");
    }
}
