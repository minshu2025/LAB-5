import java.util.Scanner;

public class ATM {
    public static void main(String[] args) {
        Account account = Account.getInstance();
        Scanner scanner = new Scanner(System.in);
        int choice;
        double amount;

        do {
            System.out.println("\n--- ATM ---");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check Balance");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter amount to deposit: $");
                    amount = scanner.nextDouble();
                    account.deposit(amount);
                    break;
                case 2:
                    System.out.print("Enter amount to withdraw: $");
                    amount = scanner.nextDouble();
                    account.withdraw(amount);
                    break;
                case 3:
                    System.out.println("Current Balance: $" + account.getBalance());
                    break;
                case 0:
                    System.out.println("Thank you for using the ATM.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}
