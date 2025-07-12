package com.example
import java.util.ArrayList;
import java.util.Scanner;

class Member {
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

    public String getMemberID() { return memberID; }
    public void setMemberID(String memberID) { this.memberID = memberID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public void displayInfo() {
        System.out.println("Member ID : " + memberID);
        System.out.println("Name      : " + name);
        System.out.println("Address   : " + address);
        System.out.println("Phone     : " + phone);
        System.out.println("-------------------------");
    }
}

public class MemberCRUD {
    private static ArrayList<Member> memberList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n=== MEMBER MANAGEMENT ===");
            System.out.println("1. Add Member");
            System.out.println("2. View Member");
            System.out.println("3. Update Member");
            System.out.println("4. Delete Member");
            System.out.println("5. View All Members");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addMember();
                case 2 -> viewMember();
                case 3 -> updateMember();
                case 4 -> deleteMember();
                case 5 -> viewAllMembers();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }
        } while (choice != 0);
    }

    private static void addMember() {
        System.out.println("=== Add Member ===");
        System.out.print("Member ID: ");
        String id = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();

        Member member = new Member(id, name, address, phone);
        memberList.add(member);
        System.out.println("✅ Member added successfully!");
    }

    private static void viewMember() {
        System.out.print("Enter Member ID to view: ");
        String id = scanner.nextLine();
        for (Member m : memberList) {
            if (m.getMemberID().equalsIgnoreCase(id)) {
                m.displayInfo();
                return;
            }
        }
        System.out.println("❌ Member not found.");
    }

    private static void updateMember() {
        System.out.print("Enter Member ID to update: ");
        String id = scanner.nextLine();
        for (Member m : memberList) {
            if (m.getMemberID().equalsIgnoreCase(id)) {
                System.out.print("New Name (" + m.getName() + "): ");
                String name = scanner.nextLine();
                if (!name.isEmpty()) m.setName(name);

                System.out.print("New Address (" + m.getAddress() + "): ");
                String address = scanner.nextLine();
                if (!address.isEmpty()) m.setAddress(address);

                System.out.print("New Phone (" + m.getPhone() + "): ");
                String phone = scanner.nextLine();
                if (!phone.isEmpty()) m.setPhone(phone);

                System.out.println("✅ Member updated successfully!");
                return;
            }
        }
        System.out.println("❌ Member not found.");
    }

    private static void deleteMember() {
        System.out.print("Enter Member ID to delete: ");
        String id = scanner.nextLine();
        for (Member m : memberList) {
            if (m.getMemberID().equalsIgnoreCase(id)) {
                memberList.remove(m);
                System.out.println("🗑️ Member deleted successfully!");
                return;
            }
        }
        System.out.println("❌ Member not found.");
    }

    private static void viewAllMembers() {
        if (memberList.isEmpty()) {
            System.out.println("📭 No members in the system.");
            return;
        }
        for (Member m : memberList) {
            m.displayInfo();
        }
    }
}