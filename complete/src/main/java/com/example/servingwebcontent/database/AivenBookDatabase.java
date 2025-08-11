package com.example.servingwebcontent.database;
import com.example.servingwebcontent.model.Book;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// filepath: /workspaces/OOP_N05_T3_2025_Hung_Linh_Minh/complete/src/main/java/com/example/servingwebcontent/database/AivenBookDatabase.java



public class AivenBookDatabase {
    // Replace with your Aiven PostgreSQL connection details
    private static final String URL = "jdbc:mysql://avnadmin:AVNS_RE3O2bhYZ_1_6ER7YK7@mysql-14737a33-nglthu-4e05.k.aivencloud.com:17237/defaultdb?ssl-mode=REQUIRED";
    private static final String USER = "avnadmin";
    private static final String PASSWORD = "AVNS_RE3O2bhYZ_1_6ER7YK7";

    static {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement()) {
            String sql = "CREATE TABLE IF NOT EXISTS books (" +
                    "book_id VARCHAR(255) PRIMARY KEY," +
                    "title VARCHAR(255)," +
                    "author VARCHAR(255)," +
                    "publisher VARCHAR(255)," +
                    "year_published INT," +
                    "category VARCHAR(255)" +
                    ")";
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Create
    public static void addBook(Book book) {
        String sql = "INSERT INTO books (book_id, title, author, publisher, year_published, category) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getBookID());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4, book.getPublisher());
            pstmt.setInt(5, book.getYearPublished());
            pstmt.setString(6, book.getCategory());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Read all
    public static List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        String sql = "SELECT * FROM books";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                books.add(new Book(
                        rs.getString("book_id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getInt("year_published"),
                        rs.getString("category")
                ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return books;
    }

    // Read by ID
    public static Optional<Book> getBookByID(String bookID) {
        String sql = "SELECT * FROM books WHERE book_id = ?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bookID);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Book(
                            rs.getString("book_id"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getString("publisher"),
                            rs.getInt("year_published"),
                            rs.getString("category")
                    ));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    // Update
    public static boolean updateBook(String bookID, Book updatedBook) {
        String sql = "UPDATE books SET title=?, author=?, publisher=?, year_published=?, category=? WHERE book_id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, updatedBook.getTitle());
            pstmt.setString(2, updatedBook.getAuthor());
            pstmt.setString(3, updatedBook.getPublisher());
            pstmt.setInt(4, updatedBook.getYearPublished());
            pstmt.setString(5, updatedBook.getCategory());
            pstmt.setString(6, bookID);
            int affected = pstmt.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Delete
    public static boolean deleteBook(String bookID) {
        String sql = "DELETE FROM books WHERE book_id=?";
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bookID);
            int affected = pstmt.executeUpdate();
            return affected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}