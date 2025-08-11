package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @GetMapping
    public List<Book> getAllBooks() {
        return Book.getAllBooks();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Optional<Book> bookOpt = Book.getBookByID(id);
        return bookOpt.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        Book.addBook(book);
        return ResponseEntity.ok("Book added successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
        boolean updated = Book.updateBook(id, updatedBook);
        return updated ? ResponseEntity.ok("Book updated successfully") : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        boolean deleted = Book.deleteBook(id);
        return deleted ? ResponseEntity.ok("Book deleted successfully") : ResponseEntity.notFound().build();
    }
}
