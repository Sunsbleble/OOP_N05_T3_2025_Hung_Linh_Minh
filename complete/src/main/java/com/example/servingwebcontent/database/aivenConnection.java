package com.example.servingwebcontent.database;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class aivenConnection {

    public void connectAiven() {
        Connection conn = null;
        Statement sta = null;
        ResultSet reset = null;
        try {
            MyDBConnection mydb = new MyDBConnection();
            conn = mydb.getOnlyConn();
            sta = conn.createStatement();
            reset = sta.executeQuery("select * from sach");
            System.out.println("Hiển thị dữ liệu sách từ database: ");
            while (reset.next()) {
                String masach = reset.getString("BookID");
                String tensach = reset.getString("title");
                String tacgia = reset.getString("author");
                System.out.println("Mã sách: " + masach + " | Tên sách: " + tensach + " | Tác giả: " + tacgia);
            }
        } catch (Exception e) {
            System.out.println("Lỗi kết nối database: " + e);
            e.printStackTrace();
        } finally {
            try {
                if (reset != null) reset.close();
                if (sta != null) sta.close();
                if (conn != null) conn.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
