# OOP_N05_T3_2025_GROUP_Hung_Linh_Minh
Ứng dụng quản lý sách thư viện

## Sơ đồ chức năng:
<img width="603" height="379" alt="Untitled (1)" src="https://github.com/user-attachments/assets/95a95a80-605d-402f-8ee9-b737d1a094bf" />


## Sơ đồ thuật toán:
BookCRUD:
<img width="1836" height="701" alt="w" src="https://github.com/user-attachments/assets/924231f0-713a-4de2-a654-f2696fdc9ba8" />
Membercrud:

<img width="491" height="534" alt="Untitled (1)" src="https://github.com/user-attachments/assets/e76b95a2-96df-4db4-816c-c6f2b3880208" />

LoanCRUD:
<img width="926" height="706" alt="Untitled" src="https://github.com/user-attachments/assets/9e888296-ea51-4f53-92c8-be65c93d00e6" />



# Describe and Analyse the Project
## Đối tượng:
### 1. Sách (Book)

+ Mã sách (bookID): Mỗi sách sẽ có một mã duy nhất.

+ Tên sách (title): Tên của cuốn sách.


+ Tác giả (author): Tác giả của cuốn sách.

+ Nhà xuất bản (publisher): Nhà xuất bản của sách.

+ Năm xuất bản (yearPublished): Năm xuất bản.

+ Thể loại (category): Thể loại sách (ví dụ: văn học, khoa học, lịch sử, ...).

+ Số lượng (quantity): Số lượng sách có trong thư viện.

### 2. Thư viện (Library)

+ Tên thư viện (libraryName): Tên của thư viện.

+ Địa chỉ (address): Địa chỉ của thư viện.

+ Danh sách sách (books): Danh sách các cuốn sách có trong thư viện.

+ Danh sách bạn đọc (members): Danh sách người sử dụng thư viện.

### 3. Người đọc (Member)

+ Mã người đọc (memberID): Mã duy nhất của bạn đọc.

+ Tên (name): Tên của người đọc.

+ Địa chỉ (address): Địa chỉ của người đọc.

+ Số điện thoại (phone): Số điện thoại liên hệ

### 4. Mượn sách (Loan)

+ Mã mượn (loanID): Mã duy nhất của giao dịch mượn sách.

+ Sách mượn (book): Sách được mượn.

+ Người đọc (member): Người mượn sách.

+ Ngày mượn (borrowDate): Ngày sách được mượn.

+ Ngày trả (returnDate): Ngày sách cần phải trả.

 + Danh sách sách mượn (borrowedBooks): Danh sách các sách mà người đọc đã mượn

### 5. Quản lý hệ thống (SystemManager)

+ Danh sách thư viện (libraries): Danh sách các thư viện (nếu có hệ thống quản lý nhiều thư viện).

+ Danh sách bạn đọc (members): Danh sách các bạn đọc trong hệ thống.

### 6. Phạt (Fine)

+ Mã phạt (fineID): Mã duy nhất của khoản phạt.

+ Người đọc (member): Người bị phạt.

+ Số tiền phạt (amount): Số tiền phạt.

+ Lý do (reason): Lý do phạt (ví dụ: trả sách trễ).



Code class:
+ Book class:
package com.example;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String bookID;
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private String category;
    private int quantity;

    public Book(String bookID, String title, String author, String publisher, int yearPublished, String category, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.category = category;
        this.quantity = quantity;
    }
    public String getBookID() { return bookID; }
    public void setBookID(String bookID) { this.bookID = bookID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getYearPublished() { return yearPublished; }
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void displayBookInfo() {
        System.out.println("Book ID     : " + bookID);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Publisher   : " + publisher);
        System.out.println("Year        : " + yearPublished);
        System.out.println("Category    : " + category);
        System.out.println("Quantity    : " + quantity);
        System.out.println("----------------------------");
    }
}

public class BookCRUD {
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== BOOK MANAGEMENT =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Book by ID");
            System.out.println("3. Update Book by ID");
            System.out.println("4. Delete Book by ID");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBook();
                case 3 -> updateBook();
                case 4 -> deleteBook();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    private static void addBook() {
        System.out.println("=== Add New Book ===");
        System.out.print("Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Year Published: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        Book newBook = new Book(id, title, author, publisher, year, category, quantity);
        bookList.add(newBook);
        System.out.println(" Book added successfully!");
    }

    private static void viewBook() {
        System.out.print("Enter Book ID to view: ");
        String id = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getBookID().equalsIgnoreCase(id)) {
                book.displayBookInfo();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String id = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getBookID().equalsIgnoreCase(id)) {
                System.out.println("Leave empty if no change.");

                System.out.print("New Title (" + book.getTitle() + "): ");
                String title = scanner.nextLine();
                if (!title.isEmpty()) book.setTitle(title);

                System.out.print("New Author (" + book.getAuthor() + "): ");
                String author = scanner.nextLine();
                if (!author.isEmpty()) book.setAuthor(author);

                System.out.print("New Publisher (" + book.getPublisher() + "): ");
                String publisher = scanner.nextLine();
                if (!publisher.isEmpty()) book.setPublisher(publisher);

                System.out.print("New Year (" + book.getYearPublished() + "): ");
                String year = scanner.nextLine();
                if (!year.isEmpty()) book.setYearPublished(Integer.parseInt(year));

                System.out.print("New Category (" + book.getCategory() + "): ");
                String category = scanner.nextLine();
                if (!category.isEmpty()) book.setCategory(category);

                System.out.print("New Quantity (" + book.getQuantity() + "): ");
                String quantity = scanner.nextLine();
                if (!quantity.isEmpty()) book.setQuantity(Integer.parseInt(quantity));

                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String id = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getBookID().equalsIgnoreCase(id)) {
                bookList.remove(book);
                System.out.println(" Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
+ Member class:

import java.util.ArrayList;
import java.util.Scanner;

public class MemberCRUD {
    // Lớp đại diện cho Người đọc
    static class Member {
        private String id;
        private String name;
        private String email;

        public Member(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
        }

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        @Override
        public String toString() {
            return "ID: " + id + ", Tên: " + name + ", Email: " + email;
        }
    }

    // Danh sách người đọc
    static ArrayList<Member> members = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n===== QUẢN LÝ NGƯỜI ĐỌC (Member CRUD) =====");
            System.out.println("1. Tạo người đọc");
            System.out.println("2. Đọc thông tin người đọc");
            System.out.println("3. Sửa thông tin người đọc");
            System.out.println("4. Xoá người đọc");
            System.out.println("5. Thoát");
            System.out.print("Chọn thao tác: ");
            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            switch (choice) {
                case 1 -> createMember();
                case 2 -> readMember();
                case 3 -> updateMember();
                case 4 -> deleteMember();
                case 5 -> {
                    System.out.println(">> Kết thúc chương trình.");
                    return;
                }
                default -> System.out.println(">> Lựa chọn không hợp lệ!");
            }
        }
    }

    // Thêm người đọc
    public static void createMember() {
        System.out.print("Nhập ID: ");
        String id = sc.nextLine();
        System.out.print("Nhập tên: ");
        String name = sc.nextLine();
        System.out.print("Nhập email: ");
        String email = sc.nextLine();

        members.add(new Member(id, name, email));
        System.out.println(">> Đã thêm người đọc.");
    }

    // Đọc thông tin người đọc
    public static void readMember() {
        System.out.print("Nhập ID cần tìm: ");
        String id = sc.nextLine();
        Member m = findById(id);
        if (m != null) {
            System.out.println(">> Thông tin người đọc:");
            System.out.println(m);
        } else {
            System.out.println(">> Không tìm thấy người đọc.");
        }
    }

    // Sửa thông tin
    public static void updateMember() {
        System.out.print("Nhập ID cần sửa: ");
        String id = sc.nextLine();
        Member m = findById(id);
        if (m != null) {
            System.out.print("Nhập tên mới: ");
            m.setName(sc.nextLine());
            System.out.print("Nhập email mới: ");
            m.setEmail(sc.nextLine());
            System.out.println(">> Đã cập nhật thông tin.");
        } else {
            System.out.println(">> Không tìm thấy người đọc.");
        }
    }

    // Xoá người đọc
    public static void deleteMember() {
        System.out.print("Nhập ID cần xoá: ");
        String id = sc.nextLine();
        Member m = findById(id);
        if (m != null) {
            members.remove(m);
            System.out.println(">> Đã xoá người đọc.");
        } else {
            System.out.println(">> Không tìm thấy người đọc.");
        }
    }

    // Tìm người đọc theo ID
    public static Member findById(String id) {
        for (Member m : members) {
            if (m.getId().equalsIgnoreCase(id)) {
                return m;
            }
        }
        return null;
    }
}
+Loan Class:
import java.util.*;

class Book {
    private String bookID;
    private String title;
    private int quantity;

    public Book(String bookID, String title, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.quantity = quantity;
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
    private List<Book> borrowedBooks = new ArrayList<>();

    public Member(String memberID, String name) {
        this.memberID = memberID;
        this.name = name;
    }

    public String getMemberID() { return memberID; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }

    @Override
    public String toString() {
        return "[" + memberID + "] " + name + " (Đang mượn: " + borrowedBooks.size() + " sách)";
    }
}

class Loan {
    private String loanID;
    private Book book;
    private Member member;
    private Date borrowDate;
    private Date returnDate;

    public Loan(String loanID, Book book, Member member, Date borrowDate, Date returnDate) {
        this.loanID = loanID;
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getLoanID() { return loanID; }
    public Book getBook() { return book; }
    public Member getMember() { return member; }

    @Override
    public String toString() {
        return "[" + loanID + "] " + member.getName() + " mượn '" + book.getTitle() + "' từ " + borrowDate + " đến " + returnDate;
    }
}

public class LibraryLoanManager {
    private static Map<String, Book> books = new HashMap<>();
    private static Map<String, Member> members = new HashMap<>();
    private static Map<String, Loan> loans = new HashMap<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Thêm dữ liệu mẫu
        books.put("B01", new Book("B01", "Lập trình Java", 3));
        books.put("B02", new Book("B02", "Cấu trúc dữ liệu", 2));
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

        Book book = books.get(bookID);
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

        System.out.println("Mượn sách thành công.");
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
        System.out.println("Đã cập nhật thông tin mượn sách.");
    }

    private static void deleteLoan() {
        System.out.print("Nhập LoanID cần xóa/trả: ");
        String loanID = sc.nextLine();
        Loan loan = loans.get(loanID);
        if (loan == null) {
            System.out.println("Không tìm thấy giao dịch.");
            return;
        }

        Book book = loan.getBook();
        Member member = loan.getMember();

        book.increaseQuantity();
        member.returnBook(book);
        loans.remove(loanID);

        System.out.println("Trả sách thành công.");
    }
}
# Thành viên:
1. Trần Gia Hưng, MSV: 24100078
2. Nguyễn Xuân Minh, MSV: 24100172
3. Bùi Đoàn Phương Linh, MSV: 24100234
4. Nguyễn Lệ Thu
