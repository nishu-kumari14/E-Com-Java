# Bank Management System

A complete console-based banking application demonstrating object-oriented programming principles.

## 📁 Package Structure

```
src/com/shashi/demo/bank/
├── BankSystem.java      # Main application class with user interface
└── Account.java         # Account data model class
```

## 🏦 Classes

### `BankSystem.java`
- **Main class** containing the application logic and user interface
- **Features:** Account creation, deposits, withdrawals, balance inquiry, account listing
- **Entry point:** `main()` method starts the application

### `Account.java`
- **Data model** representing a bank account
- **Properties:** Account number, holder name, balance
- **Methods:** Deposit, withdraw, getters, and validation

## 🚀 How to Run

### Command Line:
```bash
# Navigate to project root
cd /path/to/E-Com-Java

# Compile all classes in the package
javac src/com/shashi/demo/bank/*.java

# Run the main application
java -cp src com.shashi.demo.bank.BankSystem
```

### Eclipse IDE:
1. Navigate to `src` → `com.shashi.demo.bank`
2. Right-click on `BankSystem.java`
3. Select `Run As` → `Java Application`

## 🎯 Features

- ✅ **Account Creation** - Unique account numbers starting from 1001
- ✅ **Money Deposit** - Add funds with validation
- ✅ **Money Withdrawal** - Remove funds with balance checking
- ✅ **Balance Inquiry** - Check current account balance
- ✅ **Account Listing** - View all accounts in formatted table
- ✅ **Input Validation** - Prevents negative amounts and invalid operations

## 📊 Sample Interaction

```
=== Welcome to Bank Management System ===

=== Bank Management System Menu ===
1. Create Account
2. Deposit Money
3. Withdraw Money
4. Check Balance
5. Display All Accounts
6. Exit
Enter your choice: 1

Enter account holder name: John Doe
Enter initial deposit amount: 1000
Account created successfully!
Account Number: 1001
Account Holder: John Doe
Initial Balance: $1000.0
```

## 🎓 Learning Objectives

- **Object-Oriented Programming** - Classes, objects, encapsulation
- **Data Validation** - Input validation and error handling
- **Console I/O** - Scanner usage and formatted output
- **Collections** - ArrayList for storing multiple accounts
- **Business Logic** - Real-world banking operations
