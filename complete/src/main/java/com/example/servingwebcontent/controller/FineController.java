import com.example.servingwebcontent.model.Fine;
import org.springframework.web.bind.annotation.*;
import java.util.Collection;

package com.example.servingwebcontent.controller;



@RestController
@RequestMapping("/fines")
public class FineController {

    // Create a new fine
    @PostMapping
    public Fine createFine(@RequestParam String member,
                           @RequestParam double amount,
                           @RequestParam String reason) {
        return Fine.createFine(member, amount, reason);
    }

    // Get a fine by ID
    @GetMapping("/{fineID}")
    public Fine getFine(@PathVariable String fineID) {
        return Fine.getFine(fineID);
    }

    // Update a fine
    @PutMapping("/{fineID}")
    public boolean updateFine(@PathVariable String fineID,
                              @RequestParam String member,
                              @RequestParam double amount,
                              @RequestParam String reason) {
        return Fine.updateFine(fineID, member, amount, reason);
    }

    // Delete a fine
    @DeleteMapping("/{fineID}")
    public boolean deleteFine(@PathVariable String fineID) {
        return Fine.deleteFine(fineID);
    }

    // Get all fines
    @GetMapping
    public Collection<Fine> getAllFines() {
        // Expose all fines for listing
        return Fine.fines.values();
    }
}
