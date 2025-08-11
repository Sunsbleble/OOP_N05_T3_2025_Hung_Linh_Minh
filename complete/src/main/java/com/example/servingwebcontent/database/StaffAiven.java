package com.example.servingwebcontent.database;

import com.example.servingwebcontent.model.Staff;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Component
public class StaffAiven {

    @Autowired
    private MyDBConnection mydb;

    private void createTableIfNotExists(Connection conn) throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS staff (" +
                "staffID VARCHAR(50) PRIMARY KEY," +
                "name VARCHAR(100)," +
                "position VARCHAR(100)," +
                "email VARCHAR(100)" +
                ")";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        }
    }

    public List<Staff> getAllStaffs() {
        List<Staff> staffs = new ArrayList<>();
        try (Connection conn = mydb.getOnlyConn()) {
            createTableIfNotExists(conn);
            String sql = "SELECT * FROM staff";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    staffs.add(new Staff(
                            rs.getString("staffID"),
                            rs.getString("name"),
                            rs.getString("position"),
                            rs.getString("email")
                    ));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return staffs;
    }

    public boolean addStaff(Staff staff) {
        String sql = "INSERT INTO staff (staffID, name, position, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staff.getStaffID());
            pstmt.setString(2, staff.getName());
            pstmt.setString(3, staff.getPosition());
            pstmt.setString(4, staff.getEmail());
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateStaff(String staffID, Staff staff) {
        String sql = "UPDATE staff SET name=?, position=?, email=? WHERE staffID=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staff.getName());
            pstmt.setString(2, staff.getPosition());
            pstmt.setString(3, staff.getEmail());
            pstmt.setString(4, staffID);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteStaff(String staffID) {
        String sql = "DELETE FROM staff WHERE staffID=?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, staffID);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
