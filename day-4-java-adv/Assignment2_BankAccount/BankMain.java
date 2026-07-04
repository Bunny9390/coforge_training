// Main class for Assignment 2
public class BankMain {
    public static void main(String[] args) {
        BankAccount account = new BankAccount(1001, 5000);

        account.deposit(1500);
        account.withdraw(3000);
        account.checkBalance();
    }
}
