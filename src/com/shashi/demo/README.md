# Demo Applications

This directory contains educational Java demo applications organized into separate packages with modular class structure.

## 📁 Package Structure

```
src/com/shashi/demo/
├── bank/
│   ├── BankSystem.java      # Main banking application
│   ├── Account.java         # Account data model
│   └── README.md           # Bank system documentation
├── library/
│   ├── LibraryManagementSystem.java  # Main library application
│   ├── Book.java           # Book data model
│   ├── Member.java         # Member data model
│   ├── Transaction.java    # Transaction data model
│   └── README.md           # Library system documentation
├── BankSystem.java         # Legacy single-file version
├── LibraryManagementSystem.java  # Legacy single-file version
└── README.md              # This file
```

## 🏦 Bank Management System

### New Modular Structure: [`bank/`](bank/)
- **`BankSystem.java`** - Main application with user interface
- **`Account.java`** - Account data model class

### Features:
- **Account Creation** - Create new bank accounts with unique account numbers
- **Deposit Money** - Add funds to existing accounts
- **Withdraw Money** - Remove funds with balance validation
- **Balance Inquiry** - Check current account balance
- **Account Listing** - View all accounts in the system

### How to Run:
```bash
# Compile the modular version
javac src/com/shashi/demo/bank/*.java

# Run the modular version
java -cp src com.shashi.demo.bank.BankSystem
```

**📖 [Detailed Bank System Documentation](bank/README.md)**

---

## 📚 Library Management System

### New Modular Structure: [`library/`](library/)
- **`LibraryManagementSystem.java`** - Main application with user interface
- **`Book.java`** - Book data model class
- **`Member.java`** - Member data model class
- **`Transaction.java`** - Transaction data model class

### Features:
- **Book Management** - Add new books to the library catalog
- **Member Management** - Register new library members
- **Book Issuing** - Issue books to members with transaction tracking
- **Book Returns** - Return books and update availability
- **Search Functionality** - Search books by title or author
- **Transaction History** - View all book issue/return transactions
- **Inventory Display** - View all books and members

### How to Run:
```bash
# Compile the modular version
javac src/com/shashi/demo/library/*.java

# Run the modular version
java -cp src com.shashi.demo.library.LibraryManagementSystem
```

**📖 [Detailed Library System Documentation](library/README.md)**

---

## 🎯 Learning Objectives

These demo applications demonstrate:
- **Object-Oriented Programming** - Classes, objects, encapsulation
- **Package Organization** - Proper Java package structure
- **Modular Design** - Separation of concerns and single responsibility
- **Data Structures** - ArrayList, object collections
- **User Input Handling** - Scanner class usage
- **Control Structures** - Loops, conditionals, switch statements
- **Exception Handling** - Input validation and error handling
- **Business Logic** - Real-world application scenarios

## 📝 Code Structure Benefits

### Modular Design:
- **Separation of Concerns** - Each class has a specific responsibility
- **Maintainability** - Easier to modify and extend individual components
- **Reusability** - Classes can be reused in other applications
- **Testing** - Individual classes can be unit tested
- **Documentation** - Each package has its own README

### Clean Architecture:
- **Data Models** - Separate classes for business entities
- **Business Logic** - Main classes handle application flow
- **User Interface** - Console-based interaction in main classes
- **Validation** - Input validation and error handling throughout

## 🚀 Getting Started

1. **Prerequisites:** Java JDK 8 or higher
2. **Choose Version:** Use modular versions in `bank/` and `library/` packages
3. **Compilation:** Use `javac` with package paths
4. **Execution:** Use `java` with full class names including packages
5. **Interaction:** Follow the on-screen menu prompts

## 📚 Legacy Versions

The root directory also contains single-file versions (`BankSystem.java` and `LibraryManagementSystem.java`) for comparison, but the modular versions in separate packages are recommended for learning proper Java project structure.
