import java.util.*;

class Book {
    private String bookID;
    private String title;
    private int quantity;

    public Book(String bookID, String title, String string, String string2, int quantity, String string3, int i) {
        this.bookID = bookID;
        this.title = title;
        this.quantity = quantity;
    }

    public Book(String string, String string2) {
        //TODO Auto-generated constructor stub
    }

    public String getBookID() { return bookID; }
    public String getTitle() { return title; }
    public int getQuantity() { return quantity; }
    public void decreaseQuantity() { quantity--; }
    public void increaseQuantity() { quantity++; }

    @Override
    public String toString() {
        return "[" + bookID + "] " + title + " (Còn: " + quantity + ")";
    }
}

class Member {
    private String memberID;
    private String name;
    private List<Books> borrowedBooks = new ArrayList<>();

    public Member(String memberID, String name, String string, String string2) {
        this.memberID = memberID;
        this.name = name;
    }

    public String getMemberID() { return memberID; }
    public String getName() { return name; }
    public List<Books> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Books book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Books book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "[" + memberID + "] " + name + " (Đang mượn: " + borrowedBooks.size() + " sách)";
    }
}

class Loan {
    private String loanID;
    private Books book;
    private Member member;
    private Date borrowDate;
    private Date returnDate;

    public Loan(String loanID, Books book, Member member, Date borrowDate, Date returnDate) {
        this.loanID = loanID;
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getLoanID() { return loanID; }
    public Books getBook() { return book; }
    public Member getMember() { return member; }

    @Override
    public String toString() {
        return "[" + loanID + "] " + member.getName() + " mượn '" + book.getTitle() + "' từ " + borrowDate + " đến " + returnDate;
    }
}

public class LibraryLoanManager {
    private static Map<String, Books> books = new HashMap<>();
    private static Map<String, Member> members = new HashMap<>();
    private static Map<String, Loan> loans = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm dữ liệu mẫu
        books.put("B01", new Books("B01", "Lập trình Java", 3));
        books.put("B02", new Books("B02", "Cấu trúc dữ liệu", 2));
        members.put("M01", new Member("M01", "Nguyễn Văn A"));
        members.put("M02", new Member("M02", "Trần Thị B"));

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tạo giao dịch mượn sách");
            System.out.println("2. Xem giao dịch mượn sách");
            System.out.println("3. Sửa giao dịch mượn sách");
            System.out.println("4. Xóa (trả) giao dịch mượn sách");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int choice = sc.nextInt();
            sc.nextLine(); // Clear buffer

            switch (choice) {
                case 1 -> createLoan();
                case 2 -> readLoan();
                case 3 -> updateLoan();
                case 4 -> deleteLoan();
                case 5 -> {
                    System.out.println("Tạm biệt!");
                    return;
                }
                default -> System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }

    private static void createLoan() {
        System.out.print("Nhập LoanID: ");
        String loanID = sc.nextLine();
        System.out.print("Nhập MemberID: ");
        String memberID = sc.nextLine();
        System.out.print("Nhập BookID: ");
        String bookID = sc.nextLine();

        Member member = members.get(memberID);
        if (member == null) {
            System.out.println("Không tìm thấy bạn đọc.");
            return;
        }

        Books book = books.get(bookID);
        if (book == null) {
            System.out.println("Không tìm thấy sách.");
            return;
        }

        if (book.getQuantity() <= 0) {
            System.out.println("Sách đã hết.");
            return;
        }

        Date borrowDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 14); // trả sau 14 ngày
        Date returnDate = cal.getTime();

        Loan loan = new Loan(loanID, book, member, borrowDate, returnDate);
        loans.put(loanID, loan);
        book.decreaseQuantity();
        member.borrowBook(book);

        System.out.println("✅ Mượn sách thành công.");
    }

    private static void readLoan() {
        System.out.print("Nhập LoanID cần xem: ");
        String loanID = sc.nextLine();
        Loan loan = loans.get(loanID);
        if (loan == null) {
            System.out.println("Không tìm thấy giao dịch.");
        } else {
            System.out.println(loan);
        }
    }

    private static void updateLoan() {
        System.out.print("Nhập LoanID cần sửa: ");
        String loanID = sc.nextLine();
        Loan loan = loans.get(loanID);
        if (loan == null) {
            System.out.println("Không tìm thấy giao dịch.");
            return;
        }

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7); // gia hạn thêm 7 ngày
        Date newReturnDate = cal.getTime();

        loans.put(loanID, new Loan(loan.getLoanID(), loan.getBook(), loan.getMember(), new Date(), newReturnDate));
        System.out.println("✅ Đã cập nhật thông tin mượn sách.");
    }

    private static void deleteLoan() {
        System.out.print("Nhập LoanID cần xóa/trả: ");
        String loanID = sc.nextLine();
        Loan loan = loans.get(loanID);
        if (loan == null) {
            System.out.println("Không tìm thấy giao dịch.");
            return;
        }

        Books book = loan.getBook();
        Member member = loan.getMember();

        book.increaseQuantity();
        member.returnBook(book);
        loans.remove(loanID);

        System.out.println("✅ Trả sách thành công.");
    }
}