package com.shashi.demo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Date;

/**
 * Library Management System Demo
 * Demonstrates basic library operations like adding books, issuing books, returning books, and viewing inventory
 */
public class LibraryManagementSystem {
    
    private static List<Book> books = new ArrayList<>();
    private static List<Member> members = new ArrayList<>();
    private static List<Transaction> transactions = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static int nextBookId = 1;
    private static int nextMemberId = 1001;
    private static int nextTransactionId = 1;
    
    public static void main(String[] args) {
        // Add some sample data
        initializeSampleData();
        
        System.out.println("=== Welcome to Library Management System ===");
        
        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline
            
            switch (choice) {
                case 1:
                    addBook();
                    break;
                case 2:
                    addMember();
                    break;
                case 3:
                    issueBook();
                    break;
                case 4:
                    returnBook();
                    break;
                case 5:
                    displayAllBooks();
                    break;
                case 6:
                    displayAllMembers();
                    break;
                case 7:
                    searchBook();
                    break;
                case 8:
                    displayTransactions();
                    break;
                case 9:
                    System.out.println("Thank you for using Library Management System!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
            System.out.println();
        }
    }
    
    private static void showMenu() {
        System.out.println("\n=== Library Management System Menu ===");
        System.out.println("1. Add Book");
        System.out.println("2. Add Member");
        System.out.println("3. Issue Book");
        System.out.println("4. Return Book");
        System.out.println("5. Display All Books");
        System.out.println("6. Display All Members");
        System.out.println("7. Search Book");
        System.out.println("8. Display Transactions");
        System.out.println("9. Exit");
        System.out.print("Enter your choice: ");
    }
    
    private static void initializeSampleData() {
        // Add sample books
        books.add(new Book(nextBookId++, "Java Programming", "James Gosling", "Programming", true));
        books.add(new Book(nextBookId++, "Data Structures", "Robert Sedgewick", "Computer Science", true));
        books.add(new Book(nextBookId++, "Web Development", "John Doe", "Programming", true));
        
        // Add sample members
        members.add(new Member(nextMemberId++, "Alice Johnson", "alice@email.com", "123-456-7890"));
        members.add(new Member(nextMemberId++, "Bob Smith", "bob@email.com", "098-765-4321"));
    }
    
    private static void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.nextLine();
        
        System.out.print("Enter author name: ");
        String author = scanner.nextLine();
        
        System.out.print("Enter category: ");
        String category = scanner.nextLine();
        
        Book book = new Book(nextBookId++, title, author, category, true);
        books.add(book);
        
        System.out.println("Book added successfully!");
        System.out.println("Book ID: " + book.getBookId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Category: " + book.getCategory());
    }
    
    private static void addMember() {
        System.out.print("Enter member name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        
        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();
        
        Member member = new Member(nextMemberId++, name, email, phone);
        members.add(member);
        
        System.out.println("Member added successfully!");
        System.out.println("Member ID: " + member.getMemberId());
        System.out.println("Name: " + member.getName());
        System.out.println("Email: " + member.getEmail());
    }
    
    private static void issueBook() {
        System.out.print("Enter book ID: ");
        int bookId = scanner.nextInt();
        
        System.out.print("Enter member ID: ");
        int memberId = scanner.nextInt();
        
        Book book = findBook(bookId);
        Member member = findMember(memberId);
        
        if (book == null) {
            System.out.println("Book not found!");
            return;
        }
        
        if (member == null) {
            System.out.println("Member not found!");
            return;
        }
        
        if (!book.isAvailable()) {
            System.out.println("Book is already issued!");
            return;
        }
        
        book.setAvailable(false);
        Transaction transaction = new Transaction(nextTransactionId++, bookId, memberId, new Date(), null, "ISSUED");
        transactions.add(transaction);
        
        System.out.println("Book issued successfully!");
        System.out.println("Transaction ID: " + transaction.getTransactionId());
        System.out.println("Book: " + book.getTitle());
        System.out.println("Member: " + member.getName());
        System.out.println("Issue Date: " + transaction.getIssueDate());
    }
    
    private static void returnBook() {
        System.out.print("Enter transaction ID: ");
        int transactionId = scanner.nextInt();
        
        Transaction transaction = findTransaction(transactionId);
        if (transaction == null) {
            System.out.println("Transaction not found!");
            return;
        }
        
        if (transaction.getStatus().equals("RETURNED")) {
            System.out.println("Book already returned!");
            return;
        }
        
        Book book = findBook(transaction.getBookId());
        Member member = findMember(transaction.getMemberId());
        
        book.setAvailable(true);
        transaction.setReturnDate(new Date());
        transaction.setStatus("RETURNED");
        
        System.out.println("Book returned successfully!");
        System.out.println("Book: " + book.getTitle());
        System.out.println("Member: " + member.getName());
        System.out.println("Return Date: " + transaction.getReturnDate());
    }
    
    private static void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books found!");
            return;
        }
        
        System.out.println("\n=== All Books ===");
        System.out.printf("%-5s %-25s %-20s %-15s %-10s%n", "ID", "Title", "Author", "Category", "Available");
        System.out.println("--------------------------------------------------------------------------------");
        
        for (Book book : books) {
            System.out.printf("%-5d %-25s %-20s %-15s %-10s%n", 
                book.getBookId(), 
                book.getTitle(), 
                book.getAuthor(), 
                book.getCategory(),
                book.isAvailable() ? "Yes" : "No");
        }
    }
    
    private static void displayAllMembers() {
        if (members.isEmpty()) {
            System.out.println("No members found!");
            return;
        }
        
        System.out.println("\n=== All Members ===");
        System.out.printf("%-6s %-20s %-25s %-15s%n", "ID", "Name", "Email", "Phone");
        System.out.println("--------------------------------------------------------------------");
        
        for (Member member : members) {
            System.out.printf("%-6d %-20s %-25s %-15s%n", 
                member.getMemberId(), 
                member.getName(), 
                member.getEmail(), 
                member.getPhone());
        }
    }
    
    private static void searchBook() {
        System.out.print("Enter search term (title or author): ");
        String searchTerm = scanner.nextLine().toLowerCase();
        
        System.out.println("\n=== Search Results ===");
        boolean found = false;
        
        for (Book book : books) {
            if (book.getTitle().toLowerCase().contains(searchTerm) || 
                book.getAuthor().toLowerCase().contains(searchTerm)) {
                System.out.println("ID: " + book.getBookId() + " | Title: " + book.getTitle() + 
                                 " | Author: " + book.getAuthor() + " | Available: " + 
                                 (book.isAvailable() ? "Yes" : "No"));
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No books found matching your search.");
        }
    }
    
    private static void displayTransactions() {
        if (transactions.isEmpty()) {
            System.out.println("No transactions found!");
            return;
        }
        
        System.out.println("\n=== All Transactions ===");
        System.out.printf("%-5s %-8s %-10s %-12s %-12s %-10s%n", "ID", "Book ID", "Member ID", "Issue Date", "Return Date", "Status");
        System.out.println("------------------------------------------------------------------------");
        
        for (Transaction transaction : transactions) {
            System.out.printf("%-5d %-8d %-10d %-12s %-12s %-10s%n", 
                transaction.getTransactionId(), 
                transaction.getBookId(), 
                transaction.getMemberId(), 
                transaction.getIssueDate().toString().substring(0, 10),
                transaction.getReturnDate() != null ? transaction.getReturnDate().toString().substring(0, 10) : "N/A",
                transaction.getStatus());
        }
    }
    
    private static Book findBook(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }
    
    private static Member findMember(int memberId) {
        for (Member member : members) {
            if (member.getMemberId() == memberId) {
                return member;
            }
        }
        return null;
    }
    
    private static Transaction findTransaction(int transactionId) {
        for (Transaction transaction : transactions) {
            if (transaction.getTransactionId() == transactionId) {
                return transaction;
            }
        }
        return null;
    }
}

/**
 * Book class representing a library book
 */
class Book {
    private int bookId;
    private String title;
    private String author;
    private String category;
    private boolean available;
    
    public Book(int bookId, String title, String author, String category, boolean available) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.category = category;
        this.available = available;
    }
    
    // Getters and setters
    public int getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getCategory() { return category; }
    public boolean isAvailable() { return available; }
    public void setAvailable(boolean available) { this.available = available; }
}

/**
 * Member class representing a library member
 */
class Member {
    private int memberId;
    private String name;
    private String email;
    private String phone;
    
    public Member(int memberId, String name, String email, String phone) {
        this.memberId = memberId;
        this.name = name;
        this.email = email;
        this.phone = phone;
    }
    
    // Getters
    public int getMemberId() { return memberId; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }
}

/**
 * Transaction class representing book transactions
 */
class Transaction {
    private int transactionId;
    private int bookId;
    private int memberId;
    private Date issueDate;
    private Date returnDate;
    private String status;
    
    public Transaction(int transactionId, int bookId, int memberId, Date issueDate, Date returnDate, String status) {
        this.transactionId = transactionId;
        this.bookId = bookId;
        this.memberId = memberId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.status = status;
    }
    
    // Getters and setters
    public int getTransactionId() { return transactionId; }
    public int getBookId() { return bookId; }
    public int getMemberId() { return memberId; }
    public Date getIssueDate() { return issueDate; }
    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
