package session_11_SortingAlgorithm.class_problems;


    import java.util.Arrays;

class Book {
    String isbn;
    String title;

    public Book(String isbn, String title) {
        this.isbn = isbn;
        this.title = title;
    }
}

public class BookCatalogSearch {

    /**
     * Finds a book title by ISBN using Binary Search.
     * 
     * Complexity Analysis:
     * - Time Complexity: O(log N) where N is the number of books in the catalog.
     * - Space Complexity: O(1) auxiliary space.
     * 
     * Justification: Since queries vastly outnumber updates and the catalog is already sorted, 
     * binary search is ideal. It provides logarithmic lookup time without the memory overhead 
     * of building and maintaining an external hash map.
     */
    public static String findBook(Book[] catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog[mid].isbn.compareTo(targetIsbn);

            if (cmp == 0) {
                return catalog[mid].title;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Book[] catalog = {
            new Book("0001112223", "Introduction to Algebra"),
            new Book("0002223334", "Beginning Python"),
            new Book("0003334445", "Classic Mythology"),
            new Book("0004445556", "Data and Society"),
            new Book("0005556667", "European History")
        };

        System.out.println(findBook(catalog, "0003334445")); // Classic Mythology
        System.out.println(findBook(catalog, "0009998887")); // Not Found
    }
}

