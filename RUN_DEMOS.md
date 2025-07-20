# Running Demo Applications

## 🚀 Quick Start Commands

### Option 1: Command Line (Terminal/CMD)

```bash
# Navigate to project directory
cd /path/to/E-Com-Java

# Compile Bank System
javac src/com/shashi/demo/BankSystem.java

# Run Bank System
java -cp src com.shashi.demo.BankSystem

# Compile Library System
javac src/com/shashi/demo/LibraryManagementSystem.java

# Run Library System
java -cp src com.shashi.demo.LibraryManagementSystem
```

### Option 2: Eclipse IDE

1. **Import Project** (if not already imported)
2. **Navigate to:** `src` → `com.shashi.demo`
3. **Right-click** on `BankSystem.java` or `LibraryManagementSystem.java`
4. **Select:** `Run As` → `Java Application`
5. **Use Console** for interaction

### Option 3: IntelliJ IDEA

1. **Open Project**
2. **Navigate to:** `src/com/shashi/demo/`
3. **Right-click** on the Java file
4. **Select:** `Run 'BankSystem.main()'` or `Run 'LibraryManagementSystem.main()'`
5. **Use Run Console** for interaction

### Option 4: VS Code

1. **Open Project** in VS Code
2. **Install Java Extension Pack** (if not installed)
3. **Navigate to** the demo files
4. **Click** the `Run` button above the `main` method
5. **Use Terminal** for interaction

## 📋 Prerequisites

- **Java JDK 8+** installed
- **PATH** environment variable set correctly
- **Console/Terminal** access for interaction

## 🎯 What to Expect

### Bank Management System:
- Interactive menu with 6 options
- Create accounts with unique account numbers (starting from 1001)
- Perform banking operations
- View all accounts

### Library Management System:
- Interactive menu with 9 options
- Pre-loaded with sample books and members
- Complete library operations
- Transaction tracking

## 🔍 Sample Interaction

### Bank System Example:
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
```

### Library System Example:
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
Enter your choice: 5
```

## 🛠️ Troubleshooting

### Common Issues:

1. **"javac not found"**
   - Ensure JDK is installed and JAVA_HOME is set
   - Add Java bin directory to PATH

2. **"Class not found"**
   - Make sure you're running from the correct directory
   - Use the exact classpath: `-cp src`

3. **"Package does not exist"**
   - Ensure package structure is correct
   - Compile from project root directory

4. **Input not working**
   - Make sure you're using a proper console/terminal
   - Some IDEs may have console input limitations

## ✅ Quick Test

To quickly test if everything works:

```bash
# Test compilation
javac src/com/shashi/demo/BankSystem.java
echo $?  # Should return 0 if successful

# Test execution
java -cp src com.shashi.demo.BankSystem
# Should show the Bank Management System menu
```

These demo applications are perfect for learning Java fundamentals and understanding object-oriented programming concepts!
