package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/members")
public class MemberController {

    @GetMapping
    public List<Member> getAllMembers() { return Member.getAllMembers(); }

    @GetMapping("/{id}")
    public ResponseEntity<Member> getMemberById(@PathVariable String id) {
        Optional<Member> member = Member.getMemberByID(id);
        return member.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> addMember(@RequestBody Member member) {
        Member.addMember(member);
        return ResponseEntity.ok("Member added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateMember(@PathVariable String id, @RequestBody Member updated) {
        boolean updatedStatus = Member.updateMember(id, updated);
        return updatedStatus ? ResponseEntity.ok("Member updated") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMember(@PathVariable String id) {
        boolean deleted = Member.deleteMember(id);
        return deleted ? ResponseEntity.ok("Member deleted") : ResponseEntity.notFound().build();
    }
}
