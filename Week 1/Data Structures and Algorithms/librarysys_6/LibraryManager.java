package librarysys_6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class LibraryManager {
    public static void main(String[] args) {
        
        Book[] books = {
            new Book(101, "The Alchemist", "Paulo Coelho"),
            new Book(102, "To Kill a Mockingbird", "Harper Lee"),
            new Book(103, "1984", "George Orwell"),
            new Book(104, "Pride and Prejudice", "Jane Austen"),
            new Book(105, "Harry Potter", "J.K. Rowling")
        };

        Book[] sortedBooks = books.clone();
        Arrays.sort(sortedBooks, Comparator.comparing(b -> b.title.toLowerCase()));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter book title to search: ");
        String targetTitle = scanner.nextLine();

        Book result1 = linearSearch(books, targetTitle);
        System.out.println("\n Linear Search Result:");
        if (result1 != null) {
            System.out.println(result1);
        } else {
            System.out.println("Book not found.");
        }
        Book result2 = binarySearch(sortedBooks, targetTitle);
        System.out.println("\nBinary Search Result:");
        if (result2 != null) {
            System.out.println(result2);
        } else {
            System.out.println("Book not found.");
        }

        scanner.close();
    }

    public static Book linearSearch(Book[] books, String title) {
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(title)) {
                return b;
            }
        }
        return null;
    }

    public static Book binarySearch(Book[] books, String title) {
        int low = 0, high = books.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(title);

            if (cmp == 0) {
                return books[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return null;
    }
}
