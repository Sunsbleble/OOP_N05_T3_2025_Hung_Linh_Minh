package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.LoanAivenRepository;
import com.example.servingwebcontent.database.BookAivenRepository;
import com.example.servingwebcontent.database.MemberAivenRepository;
import com.example.servingwebcontent.model.Loan;
import com.example.servingwebcontent.model.Book;
import com.example.servingwebcontent.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/loans")
public class LoanController {

    private final LoanAivenRepository repo;
    private final BookAivenRepository bookRepo;
    private final MemberAivenRepository memberRepo;

    public LoanController(LoanAivenRepository repo, BookAivenRepository bookRepo, MemberAivenRepository memberRepo) {
        this.repo = repo;
        this.bookRepo = bookRepo;
        this.memberRepo = memberRepo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("loans", repo.findAll());
        return "loans";
    }

    @PostMapping("/add")
    public String add(@RequestParam String loanID,
                      @RequestParam String bookID,
                      @RequestParam String memberID,
                      @RequestParam String borrowDate,
                      @RequestParam(required = false) String returnDate) {
        Book book = bookRepo.findById(bookID).orElse(null);
        Member member = memberRepo.findById(memberID).orElse(null);
        Loan loan = new Loan(loanID, book, member,
                LocalDate.parse(borrowDate),
                (returnDate == null || returnDate.isEmpty()) ? null : LocalDate.parse(returnDate));
        repo.save(loan);
        return "redirect:/loans";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable String id,
                         @RequestParam String bookID,
                         @RequestParam String memberID,
                         @RequestParam String borrowDate,
                         @RequestParam(required = false) String returnDate) {
        Book book = bookRepo.findById(bookID).orElse(null);
        Member member = memberRepo.findById(memberID).orElse(null);
        Loan loan = new Loan(id, book, member,
                LocalDate.parse(borrowDate),
                (returnDate == null || returnDate.isEmpty()) ? null : LocalDate.parse(returnDate));
        repo.update(id, loan);
        return "redirect:/loans";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        repo.delete(id);
        return "redirect:/loans";
    }
}
