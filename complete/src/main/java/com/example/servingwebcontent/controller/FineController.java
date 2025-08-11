package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Fine;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/fines")
public class FineController {

    @GetMapping
    public List<Fine> getAllFines() { return Fine.getAllFines(); }

    @GetMapping("/{id}")
    public ResponseEntity<Fine> getFineById(@PathVariable String id) {
        Optional<Fine> fine = Fine.getFineByID(id);
        return fine.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> addFine(@RequestBody Fine fine) {
        Fine.addFine(fine);
        return ResponseEntity.ok("Fine added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateFine(@PathVariable String id, @RequestBody Fine updated) {
        boolean updatedStatus = Fine.updateFine(id, updated);
        return updatedStatus ? ResponseEntity.ok("Fine updated") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteFine(@PathVariable String id) {
        boolean deleted = Fine.deleteFine(id);
        return deleted ? ResponseEntity.ok("Fine deleted") : ResponseEntity.notFound().build();
    }
}
