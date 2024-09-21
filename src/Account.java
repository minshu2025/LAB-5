class Account {
    private static final Account instance = new Account();
    private double balance;

    // Private constructor for Singleton
    private Account() {
        this.balance = 0.0; // Initialize balance to 0
    }

    // Method to get the single instance of the Account
    public static Account getInstance() {
        return instance;
    }

    // Method to deposit money
    public synchronized void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public synchronized void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
            System.out.println("New Balance: $" + balance);
        } else if (amount > balance) {
            System.out.println("Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to get the current balance
    public synchronized double getBalance() {
        return balance;
    }
}

