package EcommercePlatform_2;

import java.util.*;

public class SearchApp {

    public static void main(String[] args) {
        
        Product[] products = {
            new Product("P101", "Laptop", "Electronics"),
            new Product("P102", "T-shirt", "Clothing"),
            new Product("P103", "Book", "Books"),
            new Product("P104", "Headphones", "Electronics"),
            new Product("P105", "Shoes", "Footwear")
        };

        Product[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts, Comparator.comparing(Product::getProductName));

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product name to search: ");
        String target = scanner.nextLine();
        
        Product resultLinear = linearSearch(products, target);
        System.out.println("\nLinear Search Result:");
        if (resultLinear != null) {
            System.out.println(resultLinear);
        } else {
            System.out.println("Product not found.");
        }

        Product resultBinary = binarySearch(sortedProducts, target);
        System.out.println("\nBinary Search Result:");
        if (resultBinary != null) {
            System.out.println(resultBinary);
        } else {
            System.out.println("Product not found.");
        }

        scanner.close();
    }

    public static Product linearSearch(Product[] products, String target) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(target)) {
                return p;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String target) {
        int low = 0;
        int high = products.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int cmp = products[mid].getProductName().compareToIgnoreCase(target);

            if (cmp == 0) {
                return products[mid];
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
