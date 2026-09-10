package session_1_javastringconcept.assigment_problems;

public class Warehouseinventory {
    public class Main {
    static void analyzeInventory(int[] a, int[] b) {

        int totalA = 0;
        int totalB = 0;

        for (int i = 0; i < a.length; i++) {
            totalA = totalA + a[i];
            totalB = totalB + b[i];
        }

        if (totalA == totalB) {
            System.out.println("Balanced");
        } else {
            System.out.println("Not Balanced");
        }

        int max = a[0];
        String section = "A";
        int index = 0;

        for (int i = 0; i < a.length; i++) {

            if (a[i] > max) {
                max = a[i];
                section = "A";
                index = i;
            }

            if (b[i] > max) {
                max = b[i];
                section = "B";
                index = i;
            }
        }

        System.out.println("Section A Total: " + totalA);
        System.out.println("Section B Total: " + totalB);
        System.out.println("Highest Quantity: " + max);
        System.out.println("Section: " + section);
        System.out.println("Index: " + index);
    }

    public static void main(String[] args) {

        int[] a = {20, 15, 30};
        int[] b = {25, 10, 30};

        analyzeInventory(a, b);
    }
}
}
