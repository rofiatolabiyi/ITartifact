import java.util.ArrayList;
import java.util.Scanner;
public class BankSystem {
    private ArrayList<BankAccount> accounts;
    private Scanner scanner;

    public BankSystem() {
        accounts = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

}
