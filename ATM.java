import java.util.HashMap;
import java.util.Scanner;

class Account {
    private final int accountNumber;
    private final int PIN;
    private double balance;

    public Account(int accountNumber, int pin, double initialBalance) {
        this.accountNumber = accountNumber;
        this.PIN = pin;
        this.balance = initialBalance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean verifyPIN(int enteredPIN) {
        return this.PIN == enteredPIN;
    }

    public void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited $" + amount);
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew $" + amount);
            checkBalance();
        } else if (amount > balance) {
            System.out.println("Insufficient funds.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    public boolean transfer(Account recipient, double amount) {
        if (amount > 0 && amount <= balance) {
            // Directly deduct the amount from the sender's balance
            balance -= amount;
            // Directly add the amount to the recipient's balance
            recipient.balance += amount;  // Accessing balance directly
            System.out.println("Successfully transferred $" + amount + " to account number " + recipient.getAccountNumber());
            System.out.println("Your remaining balance is: $" + balance);
            return true;
        } else if (amount > balance) {
            System.out.println("Insufficient funds for the transfer.");
            return false;
        } else {
            System.out.println("Invalid transfer amount.");
            return false;
        }
    }
}

public class ATM {
    // Method to display the main menu
    public void displayMainMenu() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Create Account");
        System.out.println("2. Log into Existing Account");
        System.out.println("3. Exit");
    }

    // Method to display the ATM operations menu
    public void displayATMMenu() {
        System.out.println("\nATM Operations Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit Money");
        System.out.println("3. Withdraw Money");
        System.out.println("4. Transfer Money");
        System.out.println("5. Exit");
    }

    // Method to create a new account
    public void createAccount(HashMap<Integer, Account> accounts) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a new account number: ");
        int newAccountNumber = scanner.nextInt();
        System.out.print("Enter a new PIN for your account: ");
        int newPIN = scanner.nextInt();
        System.out.print("Enter an initial deposit: ");
        double initialDeposit = scanner.nextDouble();

        // Create a new account and store it in the accounts list
        accounts.put(newAccountNumber, new Account(newAccountNumber, newPIN, initialDeposit));
        System.out.println("Account created successfully!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<Integer, Account> accounts = new HashMap<>();

        ATM atm = new ATM();
        boolean exitMain = false;

        while (!exitMain) {
            atm.displayMainMenu();
            System.out.print("Choose an option: ");
            int mainChoice = scanner.nextInt();

            switch (mainChoice) {
                case 1:
                    // Create a new account
                    atm.createAccount(accounts);
                    break;

                case 2:
                    // Check if there are any accounts before logging in
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts available. Please create an account first.");
                    } else {
                        // Log into an existing account
                        System.out.print("Enter your account number: ");
                        int enteredAccountNumber = scanner.nextInt();

                        // Check if the account exists
                        if (accounts.containsKey(enteredAccountNumber)) {
                            System.out.print("Enter your PIN: ");
                            int enteredPIN = scanner.nextInt();
                            Account currentAccount = accounts.get(enteredAccountNumber);

                            // Verify PIN
                            if (currentAccount.verifyPIN(enteredPIN)) {
                                boolean exitATM = false;

                                // Operations menu after login
                                while (!exitATM) {
                                    atm.displayATMMenu();
                                    System.out.print("Choose an option: ");
                                    int choice = scanner.nextInt();

                                    switch (choice) {
                                        case 1:
                                            currentAccount.checkBalance();
                                            break;
                                        case 2:
                                            System.out.print("Enter the amount to deposit: ");
                                            double depositAmount = scanner.nextDouble();
                                            currentAccount.deposit(depositAmount);
                                            break;
                                        case 3:
                                            System.out.print("Enter the amount to withdraw: ");
                                            double withdrawAmount = scanner.nextDouble();
                                            currentAccount.withdraw(withdrawAmount);
                                            break;
                                        case 4:
                                            System.out.print("Enter the account number to transfer to: ");
                                            int recipientAccountNumber = scanner.nextInt();
                                            if (accounts.containsKey(recipientAccountNumber)) {
                                                System.out.print("Enter the amount to transfer: ");
                                                double transferAmount = scanner.nextDouble();
                                                Account recipientAccount = accounts.get(recipientAccountNumber);
                                                currentAccount.transfer(recipientAccount, transferAmount);
                                            } else {
                                                System.out.println("Recipient account not found.");
                                            }
                                            break;
                                        case 5:
                                            exitATM = true;
                                            System.out.println("Logging out. Thank you for using the ATM.");
                                            break;
                                        default:
                                            System.out.println("Invalid option. Please try again.");
                                    }
                                }
                            } else {
                                System.out.println("Incorrect PIN.");
                            }
                        } else {
                            System.out.println("Account not found.");
                        }
                    }
                    break;

                case 3:
                    // Exit the system
                    exitMain = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
