package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Fine;
import com.example.servingwebcontent.model.Member;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
public class FineAivenRepository {

    private final MyDBConnection mydb;
    private final MemberAivenRepository memberRepo;

    public FineAivenRepository(MyDBConnection mydb, MemberAivenRepository memberRepo) {
        this.mydb = mydb;
        this.memberRepo = memberRepo;
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS fines (" +
                "fine_id VARCHAR(255) PRIMARY KEY," +
                "member_id VARCHAR(255)," +
                "amount NUMERIC," +
                "reason VARCHAR(1000)" +
                ")";
        try (Statement st = conn.createStatement()) { st.execute(sql); }
    }

    public List<Fine> findAll() {
        List<Fine> list = new ArrayList<>();
        String sql = "SELECT * FROM fines ORDER BY fine_id";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                String fineId = rs.getString("fine_id");
                String memberId = rs.getString("member_id");
                Member member = memberRepo.findById(memberId).orElse(null);
                double amount = rs.getDouble("amount");
                String reason = rs.getString("reason");
                list.add(new Fine(fineId, member, amount, reason));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public boolean save(Fine fine) {
        String sql = "INSERT INTO fines (fine_id, member_id, amount, reason) VALUES (?,?,?,?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, fine.getFineID());
            ps.setString(2, fine.getMember() != null ? fine.getMember().getMemberID() : null);
            ps.setDouble(3, fine.getAmount());
            ps.setString(4, fine.getReason());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(String id, Fine fine) {
        String sql = "UPDATE fines SET member_id=?, amount=?, reason=? WHERE fine_id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, fine.getMember() != null ? fine.getMember().getMemberID() : null);
            ps.setDouble(2, fine.getAmount());
            ps.setString(3, fine.getReason());
            ps.setString(4, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM fines WHERE fine_id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }
}
