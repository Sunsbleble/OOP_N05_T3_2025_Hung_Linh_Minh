import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Loan {
    private String loanID;               // Mã mượn duy nhất
    private Member member;               // Người mượn
    private List<Book> borrowedBooks;    // Danh sách sách mượn
    private LocalDate borrowDate;        // Ngày mượn
    private LocalDate returnDate;        // Ngày phải trả

    public Loan(String loanID, Member member, LocalDate borrowDate, LocalDate returnDate) {
        this.loanID = loanID;
        this.member = member;
        this.borrowedBooks = new ArrayList<>();
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    // Thêm sách vào danh sách mượn
    public void addBook(Book book) {
        borrowedBooks.add(book);
    }

    // Xóa sách khỏi danh sách mượn
    public void removeBook(Book book) {
        borrowedBooks.remove(book);
    }

    // Getters và Setters
    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }
}
