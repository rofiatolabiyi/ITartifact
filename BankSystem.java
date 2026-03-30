import java.util.ArrayList;
import java.util.Scanner;

public class BankSystem {
    private ArrayList<BankAccount> accounts;
    private Scanner scanner;

    public BankSystem() {
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    // MAIN MENU METHOD
    public void showMainMenu() {
        int choice;

        // do while statement
        do {
            // display the main menu
            System.out.println("\nWelcome to the Bank System");
            System.out.println("1. Create Account or Multiple Accounts");
            System.out.println("2. Access Account");
            System.out.println("3. Exit");
            System.out.print("Please select an option: ");

            // read in user input
            choice = scanner.nextInt();
            scanner.nextLine(); // buffer

            // switch statement handles choice
            switch (choice) {
                case 1:
                    createMultipleAccounts();
                    break;
                case 2:
                    login();
                    break;
                case 3:
                    System.out.println("Exiting system.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 3);
    }

    // CREATE MULTIPLE ACCOUNT METHOD
    private void createMultipleAccounts() {
        System.out.println("How many accounts would you like to create?");
        int count = scanner.nextInt();
        scanner.nextLine(); // buffer

        // if number isnt valid
        if (count <= 0) {
            System.out.println("Invalid number of accounts.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Creating account " + (i + 1) + ":");
            createAccount();
        }
    }

    // CREATE ACCOUNT METHOD
    private void createAccount() {
        scanner.nextLine(); // clear buffer

        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();

        int accNo;
        while (true) {
            System.out.print("Enter account number: ");
            accNo = scanner.nextInt();

            //if acc number already exists try again
            if (findAccount(accNo) != null) {
                System.out.println("Account number already exists. Try again.");}

            else{break;}

            System.out.print("Set 4-digit PIN: ");
            int pin = scanner.nextInt();

            System.out.print("Enter initial balance: ");
            double balance = scanner.nextDouble();

            BankAccount newAccount = new BankAccount(name, accNo, pin, balance);
            accounts.add(newAccount);

            System.out.println("Account created successfully.");
        }
    }

    // LOGIN METHOD
    private void login() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts exist. Create one first.");
            return;
        }
        //read in acc number and pin
        System.out.print("Enter account number: ");
        int accNo = scanner.nextInt();

        System.out.print("Enter PIN: ");
        int pin = scanner.nextInt();
        //object created
        BankAccount account = findAccount(accNo);

        if (account != null && account.checkPin(pin)) {
            System.out.println("Login successful. Welcome " + account.getAccountHolder());
            showAccountMenu(account);
        } else {
            System.out.println("Invalid account number or PIN.");
        }
    }

     // FIND ACCOUNT
    private BankAccount findAccount(int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }

    // ACCOUNT MENU METHOD
    private void showAccountMenu(BankAccount account) {
        int choice;

        do {
            System.out.println("\n=== ACCOUNT MENU ===");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("4. View Account Info");
            System.out.println("5. Transfer Money");
            System.out.println("6. Logout");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            //switch statement handles choices
            switch (choice) {
                case 1:
                    handleDeposit(account);
                    break;

                case 2:
                    handleWithdraw(account);
                    break;

                case 3:
                    System.out.println("Current Balance: €" + account.getBalance());
                    break;

                case 4:
                    account.displayAccountInfo();
                    break;

                case 5:
                    transferMoney(account);
                    break;

                case 6:
                    System.out.println("Logged out successfully.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);
    }

    // HANDLE DEPOSIT
    private void handleDeposit(BankAccount account) {
        double amount;

        do {
            System.out.print("Enter deposit amount: ");
            amount = scanner.nextDouble();

            if (amount <= 0) {
                System.out.println("Invalid number entered. Try again.");
            }
        } while (amount <= 0);
        account.deposit(amount);

    }
}
