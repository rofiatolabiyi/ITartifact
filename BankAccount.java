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
    this.balance = balance;}

    // helper constructor
    public BankAccount(String accountHolder, int accountNumber, int pin) {
    this(accountHolder, accountNumber, pin, 0.0);}

    //getters
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

}
