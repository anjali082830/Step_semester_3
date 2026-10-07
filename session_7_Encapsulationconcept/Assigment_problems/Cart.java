package session_7_Encapsulationconcept.Assigment_problems;

    import java.util.Scanner;

class Cart {

    private double[] prices;
    private int count;
    private final String cartId;

    public Cart(String cartId, int size) {
        this.cartId = cartId;
        prices = new double[size];
        count = 0;
    }

    public void addItem(double price) {

        if (count < prices.length) {
            prices[count] = price;
            count++;
        } else {
            System.out.println("Cart is full.");
        }
    }

    public double getTotal() {

        double total = 0;

        for (int i = 0; i < count; i++) {
            total = total + prices[i];
        }

        return total;
    }

    public int getItemCount() {
        return count;
    }

    public String getCartId() {
        return cartId;
    }


public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter cart ID: ");
        String id = sc.nextLine();

        System.out.print("Enter maximum number of items: ");
        int size = sc.nextInt();

        Cart cart = new Cart(id, size);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {

            System.out.print("Enter price of item " + i + ": ");
            double price = sc.nextDouble();

            cart.addItem(price);
        }

        System.out.println("\nCart ID: " + cart.getCartId());
        System.out.println("Number of items: " + cart.getItemCount());
        System.out.println("Total: " + cart.getTotal());

        sc.close();
    }
}
}
