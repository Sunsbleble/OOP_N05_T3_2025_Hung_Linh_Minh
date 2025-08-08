package com.example.servingwebcontent.model;

public class Fine {
    private String fineID;
    private String member;
    private double amount;
    private String reason;

    public Fine(String fineID, String member, double amount, String reason) {
        this.fineID = fineID;
        this.member = member;
        this.amount = amount;
        this.reason = reason;
    }

    // Create (Constructor above)

    // Read (Getters)
    public String getFineID() {
        return fineID;
    }

    public String getMember() {
        return member;
    }

    public double getAmount() {
        return amount;
    }

    public String getReason() {
        return reason;
    }

    // Update (Setters)
    public void setMember(String member) {
        this.member = member;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    // Delete: In Java, deletion is handled by removing the object from its collection or setting it to null.
    // You may implement deletion logic in a repository/service class.
}