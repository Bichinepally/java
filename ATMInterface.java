import java.util.Scanner;
// BankAccount class
class BankAccount {
    private double balance;

    // Constructor to initialize account balance
    public BankAccount(double initialBalance) {
        this.balance = initialBalance;
    }void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance!");
        } else {
            System.out.println("Invalid withdrawal amount!");
        }
    }

    // Method to check balance
    public double getBalance() {
        return balance;
    }
}

// ATM class
class ATM {
    private BankAccount userAccount;
    private Scanner scanner;

    // Constructor
    public ATM(BankAccount account) {
        this.userAccount = account;
        this.scanner = new Scanner(System.in);
    }

    // Method to display ATM menu
    public void start() {
        while (true) {
            System.out.println("\n===== ATM Menu =====");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your Balance: $" + userAccount.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    userAccount.deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawAmount = scanner.nextDouble();
                    userAccount.withdraw(withdrawAmount);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option! Please choose again.");
            }
        }
    }
}

// Main class
public class ATMInterface {
    public static void main(String[] args) {
        // Creating a bank account with an initial balance of $500
        BankAccount userAccount = new BankAccount(500.0);
        
        // Creating ATM interface
        ATM atm = new ATM(userAccount);
        atm.start(); // Start the ATM
    }
}
