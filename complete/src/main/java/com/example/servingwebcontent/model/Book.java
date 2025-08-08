import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

package com.example.servingwebcontent.model;


public class Book {
    private String bookID;
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private String category;

    public Book(String bookID, String title, String author, String publisher, int yearPublished, String category) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.category = category;
    }

    // Getters and Setters
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

    // CRUD operations (in-memory for demonstration)
    private static final List<Book> books = new ArrayList<>();

    // Create
    public static void addBook(Book book) {
        books.add(book);
    }

    // Read
    public static List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    public static Optional<Book> getBookByID(String bookID) {
        return books.stream().filter(b -> b.getBookID().equals(bookID)).findFirst();
    }

    // Update
    public static boolean updateBook(String bookID, Book updatedBook) {
        Optional<Book> bookOpt = getBookByID(bookID);
        if (bookOpt.isPresent()) {
            Book book = bookOpt.get();
            book.setTitle(updatedBook.getTitle());
            book.setAuthor(updatedBook.getAuthor());
            book.setPublisher(updatedBook.getPublisher());
            book.setYearPublished(updatedBook.getYearPublished());
            book.setCategory(updatedBook.getCategory());
            return true;
        }
        return false;
    }

    // Delete
    public static boolean deleteBook(String bookID) {
        return books.removeIf(b -> b.getBookID().equals(bookID));
    }
}