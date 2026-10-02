package session_6_classesandobjects.class_problems;

public class MessWallet {

   private double balance;

    // Constructor
    public MessWallet(double balance) {
        if (balance < 0) {
            System.out.println("Warning: Negative opening balance. Starting with 0.");
            this.balance = 0;
        } else {
            this.balance = balance;
        }
    }

    // Top-up method
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid top-up amount.");
        } else {
            balance = balance + amount;
            System.out.println("Top-up successful.");
        }
    }

    // Deduct method
    public void deduct(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient balance. Deduction not allowed.");
        } else {
            balance = balance - amount;
            System.out.println("Deduction successful.");
        }
    }

    // Getter
    public double getBalance() {
        return balance;
    }



    public static void main(String[] args) {

        MessWallet wallet = new MessWallet(500);

        wallet.topUp(200);
        wallet.deduct(100);

        System.out.println("Current Balance: " + wallet.getBalance());
    }  
}
