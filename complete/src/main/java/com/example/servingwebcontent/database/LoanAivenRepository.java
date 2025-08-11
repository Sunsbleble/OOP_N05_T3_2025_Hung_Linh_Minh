package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Loan;
import com.example.servingwebcontent.model.Book;
import com.example.servingwebcontent.model.Member;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class LoanAivenRepository {

    private final MyDBConnection mydb;
    private final BookAivenRepository bookRepo;
    private final MemberAivenRepository memberRepo;

    public LoanAivenRepository(MyDBConnection mydb, BookAivenRepository bookRepo, MemberAivenRepository memberRepo) {
        this.mydb = mydb;
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS loans (" +
                "loan_id VARCHAR(255) PRIMARY KEY," +
                "book_id VARCHAR(255)," +
                "member_id VARCHAR(255)," +
                "borrow_date DATE," +
                "return_date DATE" +
                ")";
        try (Statement st = conn.createStatement()) { st.execute(sql); }
    }

    public List<Loan> findAll() {
        List<Loan> list = new ArrayList<>();
        String sql = "SELECT * FROM loans ORDER BY borrow_date DESC";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String loanId = rs.getString("loan_id");
                String bookId = rs.getString("book_id");
                String memberId = rs.getString("member_id");
                Date borrowDate = rs.getDate("borrow_date");
                Date returnDate = rs.getDate("return_date");
                Book book = bookRepo.findById(bookId).orElse(null);
                Member member = memberRepo.findById(memberId).orElse(null);
                Loan loan = new Loan(loanId, book, member,
                        borrowDate != null ? borrowDate.toLocalDate() : null,
                        returnDate != null ? returnDate.toLocalDate() : null);
                list.add(loan);
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public boolean save(Loan loan) {
        String sql = "INSERT INTO loans (loan_id, book_id, member_id, borrow_date, return_date) VALUES (?,?,?,?,?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, loan.getLoanID());
            ps.setString(2, loan.getBook() != null ? loan.getBook().getBookID() : null);
            ps.setString(3, loan.getMember() != null ? loan.getMember().getMemberID() : null);
            ps.setDate(4, loan.getBorrowDate() != null ? Date.valueOf(loan.getBorrowDate()) : null);
            ps.setDate(5, loan.getReturnDate() != null ? Date.valueOf(loan.getReturnDate()) : null);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(String id, Loan loan) {
        String sql = "UPDATE loans SET book_id=?, member_id=?, borrow_date=?, return_date=? WHERE loan_id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, loan.getBook() != null ? loan.getBook().getBookID() : null);
            ps.setString(2, loan.getMember() != null ? loan.getMember().getMemberID() : null);
            ps.setDate(3, loan.getBorrowDate() != null ? Date.valueOf(loan.getBorrowDate()) : null);
            ps.setDate(4, loan.getReturnDate() != null ? Date.valueOf(loan.getReturnDate()) : null);
            ps.setString(5, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM loans WHERE loan_id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }
}
