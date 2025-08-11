package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Loan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/loans")
public class LoanController {

    @GetMapping
    public List<Loan> getAllLoans() { return Loan.getAllLoans(); }

    @GetMapping("/{id}")
    public ResponseEntity<Loan> getLoanById(@PathVariable String id) {
        Optional<Loan> loan = Loan.getLoanByID(id);
        return loan.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> addLoan(@RequestBody Loan loan) {
        Loan.addLoan(loan);
        return ResponseEntity.ok("Loan added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateLoan(@PathVariable String id, @RequestBody Loan updated) {
        boolean updatedStatus = Loan.updateLoan(id, updated);
        return updatedStatus ? ResponseEntity.ok("Loan updated") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteLoan(@PathVariable String id) {
        boolean deleted = Loan.deleteLoan(id);
        return deleted ? ResponseEntity.ok("Loan deleted") : ResponseEntity.notFound().build();
    }
}
