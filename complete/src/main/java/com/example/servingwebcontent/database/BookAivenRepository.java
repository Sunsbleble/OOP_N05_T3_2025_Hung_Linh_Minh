package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Book;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class BookAivenRepository {

    private final MyDBConnection mydb;

    public BookAivenRepository(MyDBConnection mydb) {
        this.mydb = mydb;
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS books (" +
                "book_id VARCHAR(255) PRIMARY KEY," +
                "title VARCHAR(255)," +
                "author VARCHAR(255)," +
                "publisher VARCHAR(255)," +
                "year_published INT," +
                "category VARCHAR(255)," +
                "quantity INT" +
                ")";
        try (Statement st = conn.createStatement()) {
            st.execute(sql);
        }
    }

    public List<Book> findAll() {
        List<Book> list = new ArrayList<>();
        String sql = "SELECT * FROM books ORDER BY title";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public Optional<Book> findById(String id) {
        String sql = "SELECT * FROM books WHERE book_id = ?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) return Optional.of(mapRow(rs));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public boolean save(Book book) {
        String sql = "INSERT INTO books (book_id,title,author,publisher,year_published,category,quantity) VALUES (?,?,?,?,?,?,?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getBookID());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublisher());
            ps.setInt(5, book.getYearPublished());
            ps.setString(6, book.getCategory());
            ps.setInt(7, book.getQuantity());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean update(String id, Book book) {
        String sql = "UPDATE books SET title=?, author=?, publisher=?, year_published=?, category=?, quantity=? WHERE book_id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setInt(4, book.getYearPublished());
            ps.setString(5, book.getCategory());
            ps.setInt(6, book.getQuantity());
            ps.setString(7, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM books WHERE book_id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Book mapRow(ResultSet rs) throws SQLException {
        return new Book(
                rs.getString("book_id"),
                rs.getString("title"),
                rs.getString("author"),
                rs.getString("publisher"),
                rs.getInt("year_published"),
                rs.getString("category"),
                rs.getInt("quantity")
        );
    }
}
