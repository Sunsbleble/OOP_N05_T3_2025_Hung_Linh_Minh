package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Fine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class FineAiven {

    @Autowired
    private MyDBConnection mydb;

    private void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS fine (" +
                "fineID VARCHAR(50) PRIMARY KEY," +
                "memberID VARCHAR(50) REFERENCES member(memberID)," +
                "amount DOUBLE PRECISION," +
                "reason VARCHAR(255)" +
                ")";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        }
    }

    public List<Fine> getAllFines() {
        List<Fine> fines = new ArrayList<>();
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
            String sql = "SELECT * FROM fine";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    fines.add(new Fine(
                            rs.getString("fineID"),
                            rs.getString("memberID"),
                            rs.getDouble("amount"),
                            rs.getString("reason")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fines;
    }

    public boolean addFine(Fine fine) {
        String sql = "INSERT INTO fine (fineID, memberID, amount, reason) VALUES (?, ?, ?, ?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fine.getFineID());
            pstmt.setString(2, fine.getMemberID());
            pstmt.setDouble(3, fine.getAmount());
            pstmt.setString(4, fine.getReason());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateFine(String fineID, Fine fine) {
        String sql = "UPDATE fine SET memberID=?, amount=?, reason=? WHERE fineID=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fine.getMemberID());
            pstmt.setDouble(2, fine.getAmount());
            pstmt.setString(3, fine.getReason());
            pstmt.setString(4, fineID);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteFine(String fineID) {
        String sql = "DELETE FROM fine WHERE fineID=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, fineID);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
