package com.example;
import java.util.ArrayList;
import java.util.Scanner;

class Book {
    private String bookID;
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private String category;
    private int quantity;

    public Book(String bookID, String title, String author, String publisher, int yearPublished, String category, int quantity) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.category = category;
        this.quantity = quantity;
    }
    public String getBookID() { return bookID; }
    public void setBookID(String bookID) { this.bookID = bookID; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }

    public String getPublisher() { return publisher; }
    public void setPublisher(String publisher) { this.publisher = publisher; }

    public int getYearPublished() { return yearPublished; }
    public void setYearPublished(int yearPublished) { this.yearPublished = yearPublished; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public void displayBookInfo() {
        System.out.println("Book ID     : " + bookID);
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Publisher   : " + publisher);
        System.out.println("Year        : " + yearPublished);
        System.out.println("Category    : " + category);
        System.out.println("Quantity    : " + quantity);
        System.out.println("----------------------------");
    }
}

public class BookCRUD {
    private static ArrayList<Book> bookList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n===== BOOK MANAGEMENT =====");
            System.out.println("1. Add Book");
            System.out.println("2. View Book by ID");
            System.out.println("3. Update Book by ID");
            System.out.println("4. Delete Book by ID");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1 -> addBook();
                case 2 -> viewBook();
                case 3 -> updateBook();
                case 4 -> deleteBook();
                case 0 -> System.out.println("Exiting...");
                default -> System.out.println("Invalid choice!");
            }

        } while (choice != 0);
    }

    private static void addBook() {
        System.out.println("=== Add New Book ===");
        System.out.print("Book ID: ");
        String id = scanner.nextLine();
        System.out.print("Title: ");
        String title = scanner.nextLine();
        System.out.print("Author: ");
        String author = scanner.nextLine();
        System.out.print("Publisher: ");
        String publisher = scanner.nextLine();
        System.out.print("Year Published: ");
        int year = Integer.parseInt(scanner.nextLine());
        System.out.print("Category: ");
        String category = scanner.nextLine();
        System.out.print("Quantity: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        Book newBook = new Book(id, title, author, publisher, year, category, quantity);
        bookList.add(newBook);
        System.out.println(" Book added successfully!");
    }

    private static void viewBook() {
        System.out.print("Enter Book ID to view: ");
        String id = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getBookID().equalsIgnoreCase(id)) {
                book.displayBookInfo();
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void updateBook() {
        System.out.print("Enter Book ID to update: ");
        String id = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getBookID().equalsIgnoreCase(id)) {
                System.out.println("Leave empty if no change.");

                System.out.print("New Title (" + book.getTitle() + "): ");
                String title = scanner.nextLine();
                if (!title.isEmpty()) book.setTitle(title);

                System.out.print("New Author (" + book.getAuthor() + "): ");
                String author = scanner.nextLine();
                if (!author.isEmpty()) book.setAuthor(author);

                System.out.print("New Publisher (" + book.getPublisher() + "): ");
                String publisher = scanner.nextLine();
                if (!publisher.isEmpty()) book.setPublisher(publisher);

                System.out.print("New Year (" + book.getYearPublished() + "): ");
                String year = scanner.nextLine();
                if (!year.isEmpty()) book.setYearPublished(Integer.parseInt(year));

                System.out.print("New Category (" + book.getCategory() + "): ");
                String category = scanner.nextLine();
                if (!category.isEmpty()) book.setCategory(category);

                System.out.print("New Quantity (" + book.getQuantity() + "): ");
                String quantity = scanner.nextLine();
                if (!quantity.isEmpty()) book.setQuantity(Integer.parseInt(quantity));

                System.out.println("Book updated successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private static void deleteBook() {
        System.out.print("Enter Book ID to delete: ");
        String id = scanner.nextLine();
        for (Book book : bookList) {
            if (book.getBookID().equalsIgnoreCase(id)) {
                bookList.remove(book);
                System.out.println(" Book deleted successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }
}
