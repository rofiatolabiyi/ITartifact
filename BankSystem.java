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

    // CREATE ACCOUNT METHOD
    private void createMultipleAccounts() {
        System.out.println("How many accounts would you like to create?");
        int count = scanner.nextInt();
        scanner.nextLine(); // buffer

        // if number isnt valid
        if(count<=0){
            System.out.println("Invalid number of accounts.");
            return;
        }

        for (int i = 0; i < count; i++) {
            System.out.println("Creating account " + (i + 1) + ":");
           createAccount();
        }
    }

}