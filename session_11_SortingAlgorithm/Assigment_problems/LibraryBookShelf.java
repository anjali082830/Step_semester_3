package session_11_SortingAlgorithm.Assigment_problems;


    import java.util.Arrays;

public class LibraryBookShelf {

    /**
     * Sorts the books array using Insertion Sort logic and prints the shelf 
     * after each book is placed into its correct position.
     * 
     * @param books array of book numbers
     */
    public static void shelf(int[] books) {
        if (books == null || books.length <= 1) {
            return;
        }

        for (int i = 1; i < books.length; i++) {
            int key = books[i];
            int j = i - 1;

            // Move elements of the sorted segment that are greater than key 
            // to one position ahead of their current position
            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;

            // Print the shelf state after placing the current book
            System.out.println("After placing " + key + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        // Test Sample 1
        System.out.println("Sample 1 Output:");
        int[] books1 = {30, 10, 40, 20};
        shelf(books1);

        System.out.println("\nCustom Input Test Output:");
        // Custom Test Input
        int[] customBooks = {50, 20, 10, 60, 30};
        shelf(customBooks);
    }
}

