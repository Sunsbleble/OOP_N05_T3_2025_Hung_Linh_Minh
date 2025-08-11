package com.example.servingwebcontent.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Fine {
    private String fineID;
    private String memberID;
    private double amount;
    private String reason;

    public Fine(String fineID, String memberID, double amount, String reason) {
        this.fineID = fineID;
        this.memberID = memberID;
        this.amount = amount;
        this.reason = reason;
    }

    public String getFineID() { return fineID; }
    public void setFineID(String fineID) { this.fineID = fineID; }

    public String getMemberID() { return memberID; }
    public void setMemberID(String memberID) { this.memberID = memberID; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    private static final List<Fine> fines = new ArrayList<>();

    public static void addFine(Fine fine) { fines.add(fine); }
    public static List<Fine> getAllFines() { return new ArrayList<>(fines); }
    public static Optional<Fine> getFineByID(String id) {
        return fines.stream().filter(f -> f.getFineID().equals(id)).findFirst();
    }
    public static boolean updateFine(String id, Fine updated) {
        Optional<Fine> opt = getFineByID(id);
        if (opt.isPresent()) {
            Fine f = opt.get();
            f.setMemberID(updated.getMemberID());
            f.setAmount(updated.getAmount());
            f.setReason(updated.getReason());
            return true;
        }
        return false;
    }
    public static boolean deleteFine(String id) {
        return fines.removeIf(f -> f.getFineID().equals(id));
    }
}
