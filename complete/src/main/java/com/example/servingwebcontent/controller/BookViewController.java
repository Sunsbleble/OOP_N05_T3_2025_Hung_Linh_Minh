package com.example.servingwebcontent.controller;

import com.example.servingwebcontent.database.BookAiven;
import com.example.servingwebcontent.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/books")
public class BookViewController {

    @Autowired
    private BookAiven bookAiven;

    // Danh sách sách
    @GetMapping
    public String listBooks(Model model) {
        model.addAttribute("books", bookAiven.getAllBooks());
        return "books"; // books.html
    }

    // Form thêm mới
    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book("", "", "", "", 0, "", 0));
        return "form-book"; // form-book.html
    }

    // Form sửa
    @GetMapping("/edit/{bookID}")
    public String editBookForm(@PathVariable String bookID, Model model) {
        Book book = bookAiven.getBookById(bookID);
        if (book == null) return "redirect:/books";
        model.addAttribute("book", book);
        return "form-book"; // form-book.html
    }

    // Lưu sách (thêm hoặc sửa)
    @PostMapping("/save")
    public String saveBook(@ModelAttribute Book book) {
        if (bookAiven.getBookById(book.getBookID()) != null) {
            bookAiven.updateBook(book.getBookID(), book);
        } else {
            bookAiven.addBook(book);
        }
        return "redirect:/books";
    }

    // Xóa sách
    @GetMapping("/delete/{bookID}")
    public String deleteBook(@PathVariable String bookID) {
        bookAiven.deleteBook(bookID);
        return "redirect:/books";
    }
}
