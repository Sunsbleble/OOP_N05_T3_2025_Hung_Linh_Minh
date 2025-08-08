import com.example.servingwebcontent.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

package com.example.servingwebcontent.controller;



@RestController
@RequestMapping("/books")
public class BookController {

    // Get all books
    @GetMapping
    public List<Book> getAllBooks() {
        return Book.getAllBooks();
    }

    // Get book by ID
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable String id) {
        Optional<Book> bookOpt = Book.getBookByID(id);
        return bookOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Add new book
    @PostMapping
    public ResponseEntity<String> addBook(@RequestBody Book book) {
        Book.addBook(book);
        return ResponseEntity.ok("Book added successfully");
    }

    // Update book
    @PutMapping("/{id}")
    public ResponseEntity<String> updateBook(@PathVariable String id, @RequestBody Book updatedBook) {
        boolean updated = Book.updateBook(id, updatedBook);
        if (updated) {
            return ResponseEntity.ok("Book updated successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Delete book
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable String id) {
        boolean deleted = Book.deleteBook(id);
        if (deleted) {
            return ResponseEntity.ok("Book deleted successfully");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}