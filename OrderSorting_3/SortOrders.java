package OrderSorting_3;

import java.util.*;

public class SortOrders {
    public static void main(String[] args) {

        Order[] orders = {
            new Order("O101", "Alice", 2500.50),
            new Order("O102", "Bob", 1500.00),
            new Order("O103", "Charlie", 3200.75),
            new Order("O104", "David", 1800.20),
            new Order("O105", "Eve", 2999.99)
        };

        System.out.println(" Bubble Sort by Total Price:");
        Order[] bubbleSorted = orders.clone();
        bubbleSort(bubbleSorted);
        for (Order o : bubbleSorted) {
            System.out.println(o);
        }

        System.out.println("\n Quick Sort by Total Price:");
        Order[] quickSorted = orders.clone();
        quickSort(quickSorted, 0, quickSorted.length - 1);
        for (Order o : quickSorted) {
            System.out.println(o);
        }
    }

    public static void bubbleSort(Order[] orders) {
        int n = orders.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (orders[j].totalPrice > orders[j + 1].totalPrice) {
                
                    Order temp = orders[j];
                    orders[j] = orders[j + 1];
                    orders[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(Order[] orders, int low, int high) {
        if (low < high) {
            int pi = partition(orders, low, high);
            quickSort(orders, low, pi - 1);
            quickSort(orders, pi + 1, high);
        }
    }

    public static int partition(Order[] orders, int low, int high) {
        double pivot = orders[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (orders[j].totalPrice <= pivot) {
                i++;
                Order temp = orders[i];
                orders[i] = orders[j];
                orders[j] = temp;
            }
        }
        Order temp = orders[i + 1];
        orders[i + 1] = orders[high];
        orders[high] = temp;
        return i + 1;
    }
}
