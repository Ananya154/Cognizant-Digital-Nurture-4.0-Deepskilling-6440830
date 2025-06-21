package strategypattern_8;

public class StrategyTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.processPayment(2500.00);

        System.out.println();

        context.setPaymentStrategy(new PayPalPayment("ananya@example.com"));
        context.processPayment(1500.00);
    }
}
