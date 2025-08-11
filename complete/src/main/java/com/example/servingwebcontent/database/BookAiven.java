package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class BookAiven {

    @Autowired
    private MyDBConnection mydb; // class này bạn đã có

    private void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS book (" +
                "bookID VARCHAR(50) PRIMARY KEY," +
                "title VARCHAR(255)," +
                "author VARCHAR(255)," +
                "publisher VARCHAR(255)," +
                "yearPublished INT," +
                "category VARCHAR(100)," +
                "quantity INT" +
                ")";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        }
    }

    public List<Book> getAllBooks() {
        List<Book> books = new ArrayList<>();
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
            String sql = "SELECT * FROM book";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    books.add(new Book(
                            rs.getString("bookID"),
                            rs.getString("title"),
                            rs.getString("author"),
                            rs.getString("publisher"),
                            rs.getInt("yearPublished"),
                            rs.getString("category"),
                            rs.getInt("quantity")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return books;
    }

    public Book getBookById(String bookID) {
        try (Connection conn = mydb.getOnlyConn()) {
            String sql = "SELECT * FROM book WHERE bookID = ?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, bookID);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return new Book(
                                rs.getString("bookID"),
                                rs.getString("title"),
                                rs.getString("author"),
                                rs.getString("publisher"),
                                rs.getInt("yearPublished"),
                                rs.getString("category"),
                                rs.getInt("quantity")
                        );
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addBook(Book book) {
        String sql = "INSERT INTO book (bookID, title, author, publisher, yearPublished, category, quantity) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getBookID());
            pstmt.setString(2, book.getTitle());
            pstmt.setString(3, book.getAuthor());
            pstmt.setString(4, book.getPublisher());
            pstmt.setInt(5, book.getYearPublished());
            pstmt.setString(6, book.getCategory());
            pstmt.setInt(7, book.getQuantity());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateBook(String bookID, Book book) {
        String sql = "UPDATE book SET title=?, author=?, publisher=?, yearPublished=?, category=?, quantity=? WHERE bookID=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.getTitle());
            pstmt.setString(2, book.getAuthor());
            pstmt.setString(3, book.getPublisher());
            pstmt.setInt(4, book.getYearPublished());
            pstmt.setString(5, book.getCategory());
            pstmt.setInt(6, book.getQuantity());
            pstmt.setString(7, bookID);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteBook(String bookID) {
        String sql = "DELETE FROM book WHERE bookID=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, bookID);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
