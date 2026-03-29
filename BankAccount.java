public class BankAccount {
    private String accountHolder;
    private int accountNumber;
    private int pin;
    private double balance;

    // main constructor
    public BankAccount(String accountHolder, int accountNumber, int pin, double balance) {
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
        this.pin = pin;
        this.balance = balance;
    }

    // helper constructor
    public BankAccount(String accountHolder, int accountNumber, int pin) {
        this(accountHolder, accountNumber, pin, 0.0);
    }

    // getters
    public String getAccountHolder() {
        return accountHolder;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public boolean checkPin(int enteredPin) {
        return this.pin == enteredPin;
    }

    // DEPOSIT METHOD
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposit successful.");
            System.out.println("New balance: €" + balance);
        } else {
            System.out.println("Unable to deposit.");
        }
    }

    // WITHDRAW METHOD
    public void withdraw(double amount) {
        if (amount < 0) {
            System.out.println("Invalid number entered.");
        } else if (amount > balance) {
            System.out.println("Funds unavailable.");
        } else {
            balance -= amount;
            System.out.println("Withdrawal successful.");
            System.out.println("New balance: €" + balance);
        }
    }

    // DISPLAY ACCOUNT INFO
    public void displayAccountInfo() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
    }

}
