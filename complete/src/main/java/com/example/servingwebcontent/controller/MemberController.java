package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.MemberAivenRepository;
import com.example.servingwebcontent.model.Member;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MemberController {

    private final MemberAivenRepository repo;

    public MemberController(MemberAivenRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("members", repo.findAll());
        return "members";
    }

    @PostMapping("/add")
    public String add(@RequestParam String memberID,
                      @RequestParam String name,
                      @RequestParam(required = false) String address,
                      @RequestParam(required = false) String phone) {
        repo.save(new Member(memberID, name, address, phone));
        return "redirect:/members";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable String id,
                         @RequestParam String name,
                         @RequestParam(required = false) String address,
                         @RequestParam(required = false) String phone) {
        repo.update(id, new Member(id, name, address, phone));
        return "redirect:/members";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable String id) {
        repo.delete(id);
        return "redirect:/members";
    }
}
