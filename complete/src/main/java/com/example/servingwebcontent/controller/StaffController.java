package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Staff;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/staffs")
public class StaffController {

    @GetMapping
    public List<Staff> getAllStaffs() {
        return Staff.getAllStaffs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Staff> getStaffById(@PathVariable String id) {
        Optional<Staff> staff = Staff.getStaffByID(id);
        return staff.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> addStaff(@RequestBody Staff staff) {
        Staff.addStaff(staff);
        return ResponseEntity.ok("Staff added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateStaff(@PathVariable String id, @RequestBody Staff updated) {
        boolean updatedStatus = Staff.updateStaff(id, updated);
        return updatedStatus ? ResponseEntity.ok("Staff updated") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteStaff(@PathVariable String id) {
        boolean deleted = Staff.deleteStaff(id);
        return deleted ? ResponseEntity.ok("Staff deleted") : ResponseEntity.notFound().build();
    }
}
