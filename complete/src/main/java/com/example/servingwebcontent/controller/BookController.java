package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.BookAiven;
import com.example.servingwebcontent.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookAiven bookAiven;

    /** -------------------- PHẦN VIEW (Thymeleaf) -------------------- **/
    @GetMapping
    public String listBooks(Model model) {
        List<Book> books = bookAiven.getAllBooks();
        model.addAttribute("books", books);
        return "books"; // file templates/books.html
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form"; // file templates/book-form.html
    }

    @PostMapping("/add")
    public String addBook(@ModelAttribute Book book) {
        bookAiven.addBook(book);
        return "redirect:/books";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") String id, Model model) {
        Book book = bookAiven.getBookById(id);
        if (book == null) {
            return "redirect:/books";
        }
        model.addAttribute("book", book);
        return "book-form";
    }

    @PostMapping("/edit/{id}")
    public String editBook(@PathVariable("id") String id, @ModelAttribute Book book) {
        bookAiven.updateBook(id, book);
        return "redirect:/books";
    }

    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") String id) {
        bookAiven.deleteBook(id);
        return "redirect:/books";
    }

    /** -------------------- PHẦN API JSON -------------------- **/
    @GetMapping("/api")
    @ResponseBody
    public List<Book> getAllBooksApi() {
        return bookAiven.getAllBooks();
    }

    @GetMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<Book> getBookApi(@PathVariable("id") String id) {
        Book book = bookAiven.getBookById(id);
        return (book != null) ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @PostMapping("/api")
    @ResponseBody
    public ResponseEntity<String> addBookApi(@RequestBody Book book) {
        boolean added = bookAiven.addBook(book);
        return added ? ResponseEntity.ok("Added successfully") : ResponseEntity.badRequest().body("Add failed");
    }

    @PutMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<String> updateBookApi(@PathVariable("id") String id, @RequestBody Book book) {
        boolean updated = bookAiven.updateBook(id, book);
        return updated ? ResponseEntity.ok("Updated successfully") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/api/{id}")
    @ResponseBody
    public ResponseEntity<String> deleteBookApi(@PathVariable("id") String id) {
        boolean deleted = bookAiven.deleteBook(id);
        return deleted ? ResponseEntity.ok("Deleted successfully") : ResponseEntity.notFound().build();
    }
}
