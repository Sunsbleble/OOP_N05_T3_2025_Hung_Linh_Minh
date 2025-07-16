public class Book {
    private String bookID;          // Mã sách duy nhất
    private String title;           // Tên sách
    private String author;          // Tác giả
    private String publisher;       // Nhà xuất bản
    private int yearPublished;      // Năm xuất bản
    private String category;        // Thể loại sách
    private int quantity;           // Số lượng sách hiện có

    public Book(String bookID, String title, String author, String publisher, int yearPublished, String category, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.category = category;
        this.quantity = quantity;
    }

    // Getter và Setter
    public String getBookID() {
        return bookID;
    }

    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    // Hàm kiểm tra sách còn tồn kho hay không
    public boolean isAvailable() {
        return quantity > 0;
    }

    // Hàm giảm số lượng sách khi mượn
    public void borrowBook() {
        if (quantity > 0) {
            quantity--;
        }
    }

    // Hàm tăng số lượng sách khi trả
    public void returnBook() {
        quantity++;
    }
}
