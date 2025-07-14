package financialforecast_7;

import java.util.Scanner;

public class Forecast {

    public static double calculateFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }

        return calculateFutureValue(currentValue, growthRate, years - 1) * (1 + growthRate);
    }
 
    public static double[] memo = new double[100]; 
    public static double optimizedFutureValue(double currentValue, double growthRate, int years) {
        if (years == 0) {
            return currentValue;
        }
        if (memo[years] != 0) {
            return memo[years];
        }
        memo[years] = optimizedFutureValue(currentValue, growthRate, years - 1) * (1 + growthRate);
        return memo[years];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Financial Forecasting Tool");

        System.out.print("Enter current value (₹): ");
        double currentValue = scanner.nextDouble();

        System.out.print("Enter annual growth rate (as decimal, e.g., 0.10 for 10%): ");
        double growthRate = scanner.nextDouble();

        System.out.print("Enter number of years to forecast: ");
        int years = scanner.nextInt();
 
        double futureValue = calculateFutureValue(currentValue, growthRate, years);
        System.out.printf("Predicted Future Value (Recursion): ₹%.2f%n", futureValue);
 
        double optimizedValue = optimizedFutureValue(currentValue, growthRate, years);
        System.out.printf("Predicted Future Value (Optimized): ₹%.2f%n", optimizedValue);

        scanner.close();
    }
}
