package com.example.servingwebcontent.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LibraryController {

    // Trang chủ
    @GetMapping("/")
    public String homePage() {
        return "index"; // index.html
    }

    // Quản lý sách
    // Đổi path để không trùng API /books
    @GetMapping("/books/page")
    public String booksPage() {
        return "books"; // books.html
    }

    // Quản lý thành viên
    @GetMapping("/members/page")
    public String membersPage() {
        return "members"; // members.html
    }

    // Quản lý mượn trả
    @GetMapping("/loans/page")
    public String loansPage() {
        return "loans"; // loans.html
    }

    // Quản lý tiền phạt
    @GetMapping("/fines/page")
    public String finesPage() {
        return "fines"; // fines.html
    }

    // Quản lý nhân viên
    @GetMapping("/staff/page")
    public String staffPage() {
        return "staff"; // staff.html
    }
}
