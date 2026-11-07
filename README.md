# ATM Interface – Java

## Project Overview

The ATM Interface is a console-based Java application developed using Object-Oriented Programming (OOP) concepts. It simulates basic ATM operations such as user authentication, cash withdrawal, deposit, fund transfer, and transaction history.

The project uses Java classes and ArrayList to manage account details and maintain transaction records during the application session.

## Features

- **User Authentication:** Login using account number and PIN.
- **Login Attempts:** Allows a maximum of three incorrect login attempts.
- **Transaction History:** Displays previous transactions with date and time.
- **Cash Withdrawal:** Withdraw money with balance validation.
- **Cash Deposit:** Deposit money into an account.
- **Fund Transfer:** Transfer money between different accounts.
- **Input Validation:** Handles invalid amounts, insufficient funds, and invalid account numbers.
- **Transaction Records:** Maintains transaction history for both sender and receiver.

## Technologies Used

- Java
- Object-Oriented Programming (OOP)
- ArrayList
- Java Date and Time API
- Eclipse IDE

## Project Structure

```text
ATM-Interface/
└── src/
    └── com/
        └── atm/
            ├── Account.java
            ├── ATM.java
            ├── Bank.java
            ├── Main.java
            └── Transaction.java
```

## Class Responsibilities

| Class | Description |
|---|---|
| `Account` | Manages account details, balance, deposits, withdrawals, and transaction history. |
| `ATM` | Handles login, menu options, and ATM operations. |
| `Bank` | Stores account objects and handles account lookup and authentication. |
| `Transaction` | Stores and displays transaction details. |
| `Main` | Starts the ATM application. |

## Sample Login Credentials

| Account Number | PIN | Name | Initial Balance |
|---|---|---|---|
| 1001 | 1234 | Naidu | ₹6,000 |
| 1002 | 5678 | Ravi | ₹1,500 |
| 1003 | 9012 | Vamsi | ₹4,500 |

*These are sample credentials for testing purposes only.*

## How to Run the Project

1. Clone or download this repository.
2. Open Eclipse IDE.
3. Import the project into your workspace.
4. Open `Main.java` inside the `com.atm` package.
5. Run `Main.java` as a Java Application.
6. Enter an account number and PIN to access the ATM menu.

## Application Menu

```text
======= ATM MENU ========

1. Transaction History
2. Withdraw
3. Deposit
4. Transfer
5. Quit

Enter your choice:
```

## Concepts Learned

- Classes and Objects
- Encapsulation
- Constructors
- ArrayList
- Methods and Return Types
- Loops and Conditional Statements
- Object Interaction
- Java LocalDateTime API
- Basic Input Validation

## Data Storage

This project uses in-memory storage with Java objects and ArrayList. Account balances and transaction histories are maintained during the application session and reset when the application is restarted. No database is used.

## Author

**Pedavenkayyanaidu Poluparthi**

Java Developer | Aspiring Backend Developer