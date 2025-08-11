package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.BookAiven;
import com.example.servingwebcontent.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookApiController {

    @Autowired
    private BookAiven bookAiven;

    @GetMapping
    public List<Book> getAllBooks() {
        return bookAiven.getAllBooks();
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable String id) {
        return bookAiven.getBookById(id);
    }

    @PostMapping
    public void addBook(@RequestBody Book book) {
        bookAiven.addBook(book);
    }

    @PutMapping("/{id}")
    public void updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
        bookAiven.updateBook(id, updatedBook);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        bookAiven.deleteBook(id);
    }
}
