package session_8_Inheritanceoopsconcept.class_problems;


    import java.util.Scanner;

abstract class Payment {
    double amount;

    Payment(double amount) {
        this.amount = amount;
    }

    abstract double calculateAmount();
}

class Card extends Payment {
    Card(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount + (amount * 0.02);
    }
}

class Wallet extends Payment {
    Wallet(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount + (amount * 0.01);
    }
}

class BankTransfer extends Payment {
    BankTransfer(double amount) {
        super(amount);
    }

    @Override
    double calculateAmount() {
        return amount;
    }


public class Feecalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of transactions: ");
        int n = sc.nextInt();

        double total = 0;

        for (int i = 1; i <= n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment p;

            if (type.equals("CARD")) {
                p = new Card(amount);
            } else if (type.equals("WALLET")) {
                p = new Wallet(amount);
            } else {
                p = new BankTransfer(amount);
            }

            double adjustedAmount = p.calculateAmount();

            System.out.printf("%s: %.2f%n", type, adjustedAmount);

            total += adjustedAmount;
        }

        System.out.printf("Total: %.2f%n", total);

        sc.close();
    }
}
}
