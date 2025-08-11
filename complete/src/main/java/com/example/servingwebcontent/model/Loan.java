package com.example.servingwebcontent.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Loan {
    private String loanID;
    private String bookID;   // Sách mượn
    private String memberID; // Người mượn
    private String borrowDate;
    private String returnDate;

    public Loan(String loanID, String bookID, String memberID, String borrowDate, String returnDate) {
        this.loanID = loanID;
        this.bookID = bookID;
        this.memberID = memberID;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
    }

    public String getLoanID() { return loanID; }
    public void setLoanID(String loanID) { this.loanID = loanID; }

    public String getBookID() { return bookID; }
    public void setBookID(String bookID) { this.bookID = bookID; }

    public String getMemberID() { return memberID; }
    public void setMemberID(String memberID) { this.memberID = memberID; }

    public String getBorrowDate() { return borrowDate; }
    public void setBorrowDate(String borrowDate) { this.borrowDate = borrowDate; }

    public String getReturnDate() { return returnDate; }
    public void setReturnDate(String returnDate) { this.returnDate = returnDate; }

    private static final List<Loan> loans = new ArrayList<>();

    public static void addLoan(Loan loan) { loans.add(loan); }
    public static List<Loan> getAllLoans() { return new ArrayList<>(loans); }
    public static Optional<Loan> getLoanByID(String id) {
        return loans.stream().filter(l -> l.getLoanID().equals(id)).findFirst();
    }
    public static boolean updateLoan(String id, Loan updated) {
        Optional<Loan> opt = getLoanByID(id);
        if (opt.isPresent()) {
            Loan l = opt.get();
            l.setBookID(updated.getBookID());
            l.setMemberID(updated.getMemberID());
            l.setBorrowDate(updated.getBorrowDate());
            l.setReturnDate(updated.getReturnDate());
            return true;
        }
        return false;
    }
    public static boolean deleteLoan(String id) {
        return loans.removeIf(l -> l.getLoanID().equals(id));
    }
}
