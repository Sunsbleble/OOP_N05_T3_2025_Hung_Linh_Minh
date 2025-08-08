package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/members")
public class MemberController {

    @GetMapping
    public String listMembers(Model model) {
        List<Member> members = Member.getAllMembers();
        model.addAttribute("members", members);
        return "members";
    }

    @GetMapping("/{id}")
    public String getMember(@PathVariable("id") String memberID, Model model) {
        Optional<Member> member = Member.getMemberByID(memberID);
        member.ifPresent(m -> model.addAttribute("member", m));
        return "member-detail";
    }

    @PostMapping
    public String addMember(@RequestParam String memberID,
                            @RequestParam String name,
                            @RequestParam String address,
                            @RequestParam String phone) {
        Member.addMember(new Member(memberID, name, address, phone));
        return "redirect:/members";
    }

    @PostMapping("/update")
    public String updateMember(@RequestParam String memberID,
                               @RequestParam String name,
                               @RequestParam String address,
                               @RequestParam String phone) {
        Member.updateMember(memberID, name, address, phone);
        return "redirect:/members";
    }

    @PostMapping("/delete")
    public String deleteMember(@RequestParam String memberID) {
        Member.deleteMember(memberID);
        return "redirect:/members";
    }
}