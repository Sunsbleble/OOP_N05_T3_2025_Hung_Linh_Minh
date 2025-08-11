package com.example.servingwebcontent.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Book {
    private String bookID;
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private String category;
    private int quantity;

    // In-memory store
    private static final List<Book> books = new ArrayList<>();

    static {
        // ví dụ dữ liệu khởi tạo
        books.add(new Book("B001", "Lập trình Java", "Nguyễn Văn A", "NXB A", 2022, "Công nghệ", 5));
        books.add(new Book("B002", "Spring Boot Cơ bản", "Trần Thị B", "NXB B", 2023, "Công nghệ", 3));
    }

    // <-- Thêm constructor không đối số để Thymeleaf / @ModelAttribute có thể khởi tạo -->
    public Book() {}

    // Constructor đầy đủ
    public Book(String bookID, String title, String author, String publisher,
                int yearPublished, String category, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.category = category;
        this.quantity = quantity;
    }

    // CRUD in-memory
    public static void addBook(Book book) {
        books.add(book);
    }

    public static List<Book> getAllBooks() {
        return new ArrayList<>(books); // trả bản sao
    }

    public static Optional<Book> getBookByID(String bookID) {
        return books.stream().filter(b -> b.getBookID().equals(bookID)).findFirst();
    }

    public static boolean updateBook(String bookID, Book updatedBook) {
        Optional<Book> bookOpt = getBookByID(bookID);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPublisher(updatedBook.getPublisher());
            book.setYearPublished(updatedBook.getYearPublished());
            book.setCategory(updatedBook.getCategory());
            book.setQuantity(updatedBook.getQuantity());
            return true;
        }
        return false;
    }

    public static boolean deleteBook(String bookID) {
        return books.removeIf(b -> b.getBookID().equals(bookID));
    }

    // --- Getters & Setters (gốc) ---
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

    // --- Alias getters/setters để tương thích với template dùng book.id / book.year ---
    public String getId() { return this.bookID; }
    public void setId(String id) { this.bookID = id; }

    public int getYear() { return this.yearPublished; }
    public void setYear(int year) { this.yearPublished = year; }
}
