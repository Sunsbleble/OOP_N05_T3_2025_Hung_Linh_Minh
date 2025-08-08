package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Loan;
import com.example.servingwebcontent.model.Book;
import com.example.servingwebcontent.model.Member;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.*;



@RestController
@RequestMapping("/loans")
public class LoanController {

    private final Map<String, Loan> loanMap = new HashMap<>();

    @GetMapping
    public List<Loan> getAllLoans() {
        return new ArrayList<>(loanMap.values());
    }

    @GetMapping("/{loanID}")
    public Loan getLoan(@PathVariable String loanID) {
        return loanMap.get(loanID);
    }

    @PostMapping
    public Loan createLoan(@RequestBody Loan loan) {
        loanMap.put(loan.getLoanID(), loan);
        return loan;
    }

    @PutMapping("/{loanID}")
    public Loan updateLoan(@PathVariable String loanID, @RequestBody Loan updatedLoan) {
        loanMap.put(loanID, updatedLoan);
        return updatedLoan;
    }

    @DeleteMapping("/{loanID}")
    public void deleteLoan(@PathVariable String loanID) {
        loanMap.remove(loanID);
    }

    // CRUD for borrowedBooks in a Loan
    @PostMapping("/{loanID}/books")
    public Loan addBorrowedBook(@PathVariable String loanID, @RequestBody Book book) {
        Loan loan = loanMap.get(loanID);
        if (loan != null) {
            loan.addBorrowedBook(book);
        }
        return loan;
    }

    @DeleteMapping("/{loanID}/books/{index}")
    public Loan removeBorrowedBook(@PathVariable String loanID, @PathVariable int index) {
        Loan loan = loanMap.get(loanID);
        if (loan != null) {
            loan.removeBorrowedBook(index);
        }
        return loan;
    }

    @PutMapping("/{loanID}/books/{index}")
    public Loan updateBorrowedBook(@PathVariable String loanID, @PathVariable int index, @RequestBody Book book) {
        Loan loan = loanMap.get(loanID);
        if (loan != null) {
            loan.updateBorrowedBook(index, book);
        }
        return loan;
    }

    @GetMapping("/{loanID}/books")
    public List<Book> getBorrowedBooks(@PathVariable String loanID) {
        Loan loan = loanMap.get(loanID);
        if (loan != null) {
            return loan.getBorrowedBooks();
        }
        return Collections.emptyList();
    }
}