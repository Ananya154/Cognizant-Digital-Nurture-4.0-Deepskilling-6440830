package inventorymanagement_1;

import java.util.*;

public class InventoryApp {
    private static Map<String, Product> inventory = new HashMap<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            System.out.println("\n--- Inventory Management System ---");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product");
            System.out.println("3. Delete Product");
            System.out.println("4. View All Products");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            
            choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    updateProduct();
                    break;
                case 3:
                    deleteProduct();
                    break;
                case 4:
                    viewAllProducts();
                    break;
                case 5:
                    System.out.println("Thank you! Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

    private static void addProduct() {
        System.out.print("Enter Product ID: ");
        String id = scanner.nextLine();

        if (inventory.containsKey(id)) {
            System.out.println("Product ID already exists!");
            return;
        }

        System.out.print("Enter Product Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Quantity: ");
        int qty = scanner.nextInt();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine(); 

        Product p = new Product(id, name, qty, price);
        inventory.put(id, p);
        System.out.println("Product added successfully!");
    }

    private static void updateProduct() {
        System.out.print("Enter Product ID to update: ");
        String id = scanner.nextLine();

        Product product = inventory.get(id);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }

        System.out.print("Enter new Product Name: ");
        product.setProductName(scanner.nextLine());

        System.out.print("Enter new Quantity: ");
        product.setQuantity(scanner.nextInt());

        System.out.print("Enter new Price: ");
        product.setPrice(scanner.nextDouble());
        scanner.nextLine(); 

        System.out.println("Product updated successfully.");
    }

    private static void deleteProduct() {
        System.out.print("Enter Product ID to delete: ");
        String id = scanner.nextLine();

        if (inventory.remove(id) != null) {
            System.out.println("Product deleted.");
        } else {
            System.out.println("Product not found.");
        }
    }

    private static void viewAllProducts() {
        if (inventory.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\n--- Inventory List ---");
        for (Product p : inventory.values()) {
            System.out.println(p);
        }
    }
}
