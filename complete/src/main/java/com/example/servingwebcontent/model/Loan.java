import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

package com.example.servingwebcontent.model;


public class Loan {
    private String loanID;
    private Book book;
    private Member member;
    private LocalDate borrowDate;
    private LocalDate returnDate;
    private List<Book> borrowedBooks;

    public Loan(String loanID, Book book, Member member, LocalDate borrowDate, LocalDate returnDate) {
        this.loanID = loanID;
        this.book = book;
        this.member = member;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.borrowedBooks = new ArrayList<>();
    }

    // Getters and Setters
    public String getLoanID() {
        return loanID;
    }

    public void setLoanID(String loanID) {
        this.loanID = loanID;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // CRUD for borrowedBooks
    // Create (Add)
    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);
    }

    // Read
    public Book getBorrowedBook(int index) {
        if (index >= 0 && index < borrowedBooks.size()) {
            return borrowedBooks.get(index);
        }
        return null;
    }

    // Update
    public boolean updateBorrowedBook(int index, Book newBook) {
        if (index >= 0 && index < borrowedBooks.size()) {
            borrowedBooks.set(index, newBook);
            return true;
        }
        return false;
    }

    // Delete
    public boolean removeBorrowedBook(Book book) {
        return borrowedBooks.remove(book);
    }

    public boolean removeBorrowedBook(int index) {
        if (index >= 0 && index < borrowedBooks.size()) {
            borrowedBooks.remove(index);
            return true;
        }
        return false;
    }
}