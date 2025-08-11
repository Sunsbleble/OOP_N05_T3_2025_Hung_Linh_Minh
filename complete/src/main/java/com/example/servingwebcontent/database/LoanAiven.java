package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.servingwebcontent.model.Loan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoanAiven {

    @Autowired
    private myDBConnection mydb;

    // Lấy tất cả loan
    public List<Loan> getAllLoan() {
        List<Loan> danhSachLoan = new ArrayList<>();
        try (Connection conn = mydb.getOnlyConn()) {

            createTableIfNotExists(conn);

            String sql = "SELECT * FROM loan ORDER BY tenLoan";
            try (PreparedStatement pstmt = conn.prepareStatement(sql);
                 ResultSet rs = pstmt.executeQuery()) {

                while (rs.next()) {
                    String maLoan = rs.getString("maLoan");
                    String tenLoan = rs.getString("tenLoan");
                    double soTien = rs.getDouble("soTien");
                    double laiSuat = rs.getDouble("laiSuat");

                    danhSachLoan.add(new Loan(maLoan, tenLoan, soTien, laiSuat));
                }
            }

        } catch (Exception e) {
            System.out.println("Lỗi lấy danh sách loan: " + e.getMessage());
            e.printStackTrace();
        }
        return danhSachLoan;
    }

    // Tạo bảng nếu chưa có
    private void createTableIfNotExists(Connection conn) {
        String sql = "CREATE TABLE IF NOT EXISTS loan (" +
                "maLoan VARCHAR(50) PRIMARY KEY," +
                "tenLoan VARCHAR(255) NOT NULL," +
                "soTien DOUBLE PRECISION," +
                "laiSuat DOUBLE PRECISION" +
                ")";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (Exception e) {
            System.out.println("Lỗi tạo bảng loan: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Lấy loan theo mã
    public Loan getLoanById(String maLoan) {
        Loan loan = null;
        String sql = "SELECT * FROM loan WHERE maLoan = ?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maLoan);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    loan = new Loan(
                            rs.getString("maLoan"),
                            rs.getString("tenLoan"),
                            rs.getDouble("soTien"),
                            rs.getDouble("laiSuat")
                    );
                }
            }

        } catch (Exception e) {
            System.out.println("Lỗi lấy loan theo mã: " + e.getMessage());
            e.printStackTrace();
        }
        return loan;
    }

    // Thêm loan mới
    public boolean createLoan(Loan loan) {
        String sql = "INSERT INTO loan (maLoan, tenLoan, soTien, laiSuat) VALUES (?, ?, ?, ?)";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, loan.getMaLoan());
            pstmt.setString(2, loan.getTenLoan());
            pstmt.setDouble(3, loan.getSoTien());
            pstmt.setDouble(4, loan.getLaiSuat());

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi tạo loan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Cập nhật loan
    public boolean updateLoan(String maLoan, Loan loan) {
        String sql = "UPDATE loan SET tenLoan = ?, soTien = ?, laiSuat = ? WHERE maLoan = ?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, loan.getTenLoan());
            pstmt.setDouble(2, loan.getSoTien());
            pstmt.setDouble(3, loan.getLaiSuat());
            pstmt.setString(4, maLoan);

            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi cập nhật loan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    // Xóa loan
    public boolean deleteLoan(String maLoan) {
        String sql = "DELETE FROM loan WHERE maLoan = ?";
        try (Connection conn = mydb.getOnlyConn();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maLoan);
            return pstmt.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Lỗi xóa loan: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}
