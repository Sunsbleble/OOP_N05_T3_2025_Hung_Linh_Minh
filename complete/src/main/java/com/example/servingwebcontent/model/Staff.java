package com.example.servingwebcontent.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Staff {
    private String staffID;
    private String name;
    private String position;
    private String email;

    public Staff(String staffID, String name, String position, String email) {
        this.staffID = staffID;
        this.name = name;
        this.position = position;
        this.email = email;
    }

    public String getStaffID() { return staffID; }
    public void setStaffID(String staffID) { this.staffID = staffID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    private static final List<Staff> staffs = new ArrayList<>();

    public static void addStaff(Staff staff) { staffs.add(staff); }
    public static List<Staff> getAllStaffs() { return new ArrayList<>(staffs); }

    public static Optional<Staff> getStaffByID(String id) {
        return staffs.stream().filter(s -> s.getStaffID().equals(id)).findFirst();
    }

    public static boolean updateStaff(String id, Staff updated) {
        Optional<Staff> opt = getStaffByID(id);
        if (opt.isPresent()) {
            Staff s = opt.get();
            s.setName(updated.getName());
            s.setPosition(updated.getPosition());
            s.setEmail(updated.getEmail());
            return true;
        }
        return false;
    }

    public static boolean deleteStaff(String id) {
        return staffs.removeIf(s -> s.getStaffID().equals(id));
    }
}
