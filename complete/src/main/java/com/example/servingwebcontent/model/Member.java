package com.example.servingwebcontent.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


public class Member {
    private String memberID;
    private String name;
    private String address;
    private String phone;

    public Member(String memberID, String name, String address, String phone) {
        this.memberID = memberID;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getMemberID() {
        return memberID;
    }

    public void setMemberID(String memberID) {
        this.memberID = memberID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    // CRUD operations using in-memory list
    private static final List<Member> members = new ArrayList<>();

    // Create
    public static void addMember(Member member) {
        members.add(member);
    }

    // Read
    public static List<Member> getAllMembers() {
        return new ArrayList<>(members);
    }

    public static Optional<Member> getMemberByID(String memberID) {
        return members.stream()
                .filter(m -> m.getMemberID().equals(memberID))
                .findFirst();
    }

    // Update
    public static boolean updateMember(String memberID, String name, String address, String phone) {
        Optional<Member> opt = getMemberByID(memberID);
        if (opt.isPresent()) {
            Member m = opt.get();
            m.setName(name);
            m.setAddress(address);
            m.setPhone(phone);
            return true;
        }
        return false;
    }

    // Delete
    public static boolean deleteMember(String memberID) {
        return members.removeIf(m -> m.getMemberID().equals(memberID));
    }
}