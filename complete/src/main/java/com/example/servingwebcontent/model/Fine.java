package com.example.servingwebcontent.model;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


public class Fine {
    private String fineID;
    private String member;
    private double amount;
    private String reason;

    // In-memory storage for CRUD operations
    private static final Map<String, Fine> fines = new HashMap<>();

    public Fine(String member, double amount, String reason) {
        this.fineID = UUID.randomUUID().toString();
        this.member = member;
        this.amount = amount;
        this.reason = reason;
    }

    // Create
    public static Fine createFine(String member, double amount, String reason) {
        Fine fine = new Fine(member, amount, reason);
        fines.put(fine.getFineID(), fine);
        return fine;
    }

    // Read
    public static Fine getFine(String fineID) {
        return fines.get(fineID);
    }

    // Update
    public static boolean updateFine(String fineID, String member, double amount, String reason) {
        Fine fine = fines.get(fineID);
        if (fine != null) {
            fine.setMember(member);
            fine.setAmount(amount);
            fine.setReason(reason);
            return true;
        }
        return false;
    }

    // Delete
    public static boolean deleteFine(String fineID) {
        return fines.remove(fineID) != null;
    }

    // Getters and Setters
    public String getFineID() {
        return fineID;
    }

    public String getMember() {
        return member;
    }

    public void setMember(String member) {
        this.member = member;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}