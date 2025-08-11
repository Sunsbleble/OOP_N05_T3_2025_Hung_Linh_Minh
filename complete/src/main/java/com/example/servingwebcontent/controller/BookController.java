package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.BookAivenRepository;
import com.example.servingwebcontent.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookController {

    private final BookAivenRepository repo;

    public BookController(BookAivenRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", repo.findAll());
        return "books"; // template books.html
    }

    @PostMapping("/add")
    public String addBook(@RequestParam String bookID,
                          @RequestParam String title,
                          @RequestParam(required = false) String author,
                          @RequestParam(required = false) String publisher,
                          @RequestParam(required = false, defaultValue = "0") int yearPublished,
                          @RequestParam(required = false) String category,
                          @RequestParam(required = false, defaultValue = "1") int quantity,
                          Model model) {
        Book b = new Book(bookID, title, author, publisher, yearPublished, category, quantity);
        repo.save(b);
        return "redirect:/books";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@PathVariable("id") String id,
                             @RequestParam String title,
                             @RequestParam(required = false) String author,
                             @RequestParam(required = false) String publisher,
                             @RequestParam(required = false, defaultValue = "0") int yearPublished,
                             @RequestParam(required = false) String category,
                             @RequestParam(required = false, defaultValue = "1") int quantity) {
        Book b = new Book(id, title, author, publisher, yearPublished, category, quantity);
        repo.update(id, b);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable String id) {
        repo.delete(id);
        return "redirect:/books";
    }
}
