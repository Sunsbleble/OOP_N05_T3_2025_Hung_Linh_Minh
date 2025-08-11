package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Loan;
import com.example.servingwebcontent.model.Book;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loans") // tất cả API sẽ bắt đầu với /loans
public class LoanController {

    private List<Loan> loanList = new ArrayList<>();

    // CREATE - thêm loan mới
    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        loanList.add(loan);
        return loan;
    }

    // READ - lấy tất cả loan
    @GetMapping
    public List<Loan> getAllLoans() {
        return loanList;
    }

    // READ - lấy loan theo ID
    @GetMapping("/{loanId}")
    public Loan getLoanById(@PathVariable String loanId) {
        Optional<Loan> loan = loanList.stream()
                .filter(l -> l.getLoanID().equals(loanId))
                .findFirst();
        return loan.orElse(null);
    }

    // UPDATE - cập nhật loan
    @PutMapping("/{loanId}")
    public Loan updateLoan(@PathVariable String loanId, @RequestBody Loan updatedLoan) {
        for (int i = 0; i < loanList.size(); i++) {
            if (loanList.get(i).getLoanID().equals(loanId)) {
                loanList.set(i, updatedLoan);
                return updatedLoan;
            }
        }
        return null;
    }

    // DELETE - xóa loan
    @DeleteMapping("/{loanId}")
    public boolean deleteLoan(@PathVariable String loanId) {
        return loanList.removeIf(l -> l.getLoanID().equals(loanId));
    }

    // --- CRUD cho borrowedBooks bên trong Loan ---
    // Thêm sách vào loan
    @PostMapping("/{loanId}/books")
    public Loan addBookToLoan(@PathVariable String loanId, @RequestBody Book book) {
        for (Loan loan : loanList) {
            if (loan.getLoanID().equals(loanId)) {
                loan.addBorrowedBook(book);
                return loan;
            }
        }
        return null;
    }

    // Xóa sách khỏi loan
    @DeleteMapping("/{loanId}/books/{index}")
    public Loan removeBookFromLoan(@PathVariable String loanId, @PathVariable int index) {
        for (Loan loan : loanList) {
            if (loan.getLoanID().equals(loanId)) {
                loan.removeBorrowedBook(index);
                return loan;
            }
        }
        return null;
    }
}
