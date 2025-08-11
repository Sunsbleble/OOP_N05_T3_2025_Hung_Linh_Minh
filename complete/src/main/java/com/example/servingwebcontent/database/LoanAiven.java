package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class LoanAiven {

    @Autowired
    private MyDBConnection mydb;

    private void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS loan (" +
                "loanID VARCHAR(50) PRIMARY KEY," +
                "bookID VARCHAR(50) REFERENCES book(bookID)," +
                "memberID VARCHAR(50) REFERENCES member(memberID)," +
                "borrowDate VARCHAR(50)," +
                "returnDate VARCHAR(50)" +
                ")";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        }
    }

    public List<Loan> getAllLoans() {
        List<Loan> loans = new ArrayList<>();
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
            String sql = "SELECT * FROM loan";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    loans.add(new Loan(
                            rs.getString("loanID"),
                            rs.getString("bookID"),
                            rs.getString("memberID"),
                            rs.getString("borrowDate"),
                            rs.getString("returnDate")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loans;
    }

    public boolean addLoan(Loan loan) {
        String sql = "INSERT INTO loan (loanID, bookID, memberID, borrowDate, returnDate) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, loan.getLoanID());
            pstmt.setString(2, loan.getBookID());
            pstmt.setString(3, loan.getMemberID());
            pstmt.setString(4, loan.getBorrowDate());
            pstmt.setString(5, loan.getReturnDate());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateLoan(String loanID, Loan loan) {
        String sql = "UPDATE loan SET bookID=?, memberID=?, borrowDate=?, returnDate=? WHERE loanID=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, loan.getBookID());
            pstmt.setString(2, loan.getMemberID());
            pstmt.setString(3, loan.getBorrowDate());
            pstmt.setString(4, loan.getReturnDate());
            pstmt.setString(5, loanID);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteLoan(String loanID) {
        String sql = "DELETE FROM loan WHERE loanID=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, loanID);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
