package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Member;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class MemberAivenRepository {

    private final MyDBConnection mydb;

    public MemberAivenRepository(MyDBConnection mydb) {
        this.mydb = mydb;
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
        } catch (SQLException e) { e.printStackTrace(); }
    }

    private void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS members (" +
                "member_id VARCHAR(255) PRIMARY KEY," +
                "name VARCHAR(255)," +
                "address VARCHAR(255)," +
                "phone VARCHAR(50)" +
                ")";
        try (Statement st = conn.createStatement()) { st.execute(sql); }
    }

    public List<Member> findAll() {
        List<Member> list = new ArrayList<>();
        String sql = "SELECT * FROM members ORDER BY name";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Member(
                        rs.getString("member_id"),
                        rs.getString("name"),
                        rs.getString("address"),
                        rs.getString("phone")
                ));
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return list;
    }

    public boolean save(Member m) {
        String sql = "INSERT INTO members (member_id,name,address,phone) VALUES (?,?,?,?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getMemberID());
            ps.setString(2, m.getName());
            ps.setString(3, m.getAddress());
            ps.setString(4, m.getPhone());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean update(String id, Member m) {
        String sql = "UPDATE members SET name=?, address=?, phone=? WHERE member_id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, m.getName());
            ps.setString(2, m.getAddress());
            ps.setString(3, m.getPhone());
            ps.setString(4, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public boolean delete(String id) {
        String sql = "DELETE FROM members WHERE member_id=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) { e.printStackTrace(); return false; }
    }

    public Optional<Member> findById(String id) {
        String sql = "SELECT * FROM members WHERE member_id = ?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return Optional.of(new Member(
                            rs.getString("member_id"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("phone")
                    ));
                }
            }
        } catch (SQLException e) { e.printStackTrace(); }
        return Optional.empty();
    }
}
