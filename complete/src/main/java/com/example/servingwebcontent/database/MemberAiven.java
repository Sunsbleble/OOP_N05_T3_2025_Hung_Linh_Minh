package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class MemberAiven {

    @Autowired
    private MyDBConnection mydb;

    private void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS member (" +
                "memberID VARCHAR(50) PRIMARY KEY," +
                "name VARCHAR(255)," +
                "address VARCHAR(255)," +
                "phone VARCHAR(50)" +
                ")";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        }
    }

    public List<Member> getAllMembers() {
        List<Member> members = new ArrayList<>();
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
            String sql = "SELECT * FROM member";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    members.add(new Member(
                            rs.getString("memberID"),
                            rs.getString("name"),
                            rs.getString("address"),
                            rs.getString("phone")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return members;
    }

    public Member getMemberById(String memberID) {
        try (Connection conn = mydb.getOnlyConn()) {
            String sql = "SELECT * FROM member WHERE memberID=?";
            try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
                pstmt.setString(1, memberID);
                try (ResultSet rs = pstmt.executeQuery()) {
                    if (rs.next()) {
                        return new Member(
                                rs.getString("memberID"),
                                rs.getString("name"),
                                rs.getString("address"),
                                rs.getString("phone")
                        );
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public boolean addMember(Member member) {
        String sql = "INSERT INTO member (memberID, name, address, phone) VALUES (?, ?, ?, ?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getMemberID());
            pstmt.setString(2, member.getName());
            pstmt.setString(3, member.getAddress());
            pstmt.setString(4, member.getPhone());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateMember(String memberID, Member member) {
        String sql = "UPDATE member SET name=?, address=?, phone=? WHERE memberID=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getName());
            pstmt.setString(2, member.getAddress());
            pstmt.setString(3, member.getPhone());
            pstmt.setString(4, memberID);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMember(String memberID) {
        String sql = "DELETE FROM member WHERE memberID=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, memberID);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
