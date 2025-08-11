package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Fine;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/fines")
public class LoanController {

    @GetMapping
    public List<Fine> getAllFines() {
        return new ArrayList<>(Fine.fines.values());
    }

    @GetMapping("/{fineID}")
    public Fine getFine(@PathVariable String fineID) {
        return Fine.getFine(fineID);
    }

    @PostMapping
    public Fine createFine(@RequestBody Fine fine) {
        return Fine.createFine(fine.getMember(), fine.getAmount(), fine.getReason());
    }

    @PutMapping("/{fineID}")
    public boolean updateFine(@PathVariable String fineID, @RequestBody Fine fine) {
        return Fine.updateFine(fineID, fine.getMember(), fine.getAmount(), fine.getReason());
    }

    @DeleteMapping("/{fineID}")
    public boolean deleteFine(@PathVariable String fineID) {
        return Fine.deleteFine(fineID);
    }
}
