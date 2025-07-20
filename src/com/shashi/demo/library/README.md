# Library Management System

A comprehensive console-based library management application demonstrating advanced object-oriented programming concepts.

## 📁 Package Structure

```
src/com/shashi/demo/library/
├── LibraryManagementSystem.java  # Main application class
├── Book.java                     # Book data model
├── Member.java                   # Member data model
└── Transaction.java              # Transaction data model
```

## 📚 Classes

### `LibraryManagementSystem.java`
- **Main class** containing application logic and user interface
- **Features:** Book/member management, issuing/returning books, search, transactions
- **Entry point:** `main()` method with sample data initialization

### `Book.java`
- **Data model** representing a library book
- **Properties:** Book ID, title, author, category, availability status
- **Methods:** Getters, setters, and availability management

### `Member.java`
- **Data model** representing a library member
- **Properties:** Member ID, name, email, phone
- **Methods:** Getters and member information access

### `Transaction.java`
- **Data model** representing book transactions
- **Properties:** Transaction ID, book ID, member ID, dates, status
- **Methods:** Getters, setters, and transaction state management

## 🚀 How to Run

### Command Line:
```bash
# Navigate to project root
cd /path/to/E-Com-Java

# Compile all classes in the package
javac src/com/shashi/demo/library/*.java

# Run the main application
java -cp src com.shashi.demo.library.LibraryManagementSystem
```

### Eclipse IDE:
1. Navigate to `src` → `com.shashi.demo.library`
2. Right-click on `LibraryManagementSystem.java`
3. Select `Run As` → `Java Application`

## 🎯 Features

- ✅ **Book Management** - Add new books with categories
- ✅ **Member Management** - Register members with contact details
- ✅ **Book Issuing** - Issue books to members with transaction tracking
- ✅ **Book Returns** - Return books and update availability
- ✅ **Search Functionality** - Search books by title or author
- ✅ **Transaction History** - Complete audit trail of all operations
- ✅ **Inventory Display** - View all books and members
- ✅ **Sample Data** - Pre-loaded with test data for immediate use

## 📊 Sample Data

### Pre-loaded Books:
- **Java Programming** by James Gosling (Programming)
- **Data Structures** by Robert Sedgewick (Computer Science)
- **Web Development** by John Doe (Programming)

### Pre-loaded Members:
- **Alice Johnson** - alice@email.com, 123-456-7890
- **Bob Smith** - bob@email.com, 098-765-4321

## 📈 Sample Interaction

```
=== Welcome to Library Management System ===

=== Library Management System Menu ===
1. Add Book
2. Add Member
3. Issue Book
4. Return Book
5. Display All Books
6. Display All Members
7. Search Book
8. Display Transactions
9. Exit
Enter your choice: 3

Enter book ID: 1
Enter member ID: 1001
Book issued successfully!
Transaction ID: 1
Book: Java Programming
Member: Alice Johnson
Issue Date: Sun Jul 21 10:30:15 UTC 2025
```

## 🎓 Learning Objectives

- **Advanced OOP** - Multiple classes with relationships
- **Data Management** - Complex data structures and relationships
- **Business Logic** - Real-world library operations
- **State Management** - Tracking object states and transitions
- **Date Handling** - Working with Date objects and formatting
- **Search Algorithms** - String matching and filtering
- **Transaction Processing** - Business transaction modeling
