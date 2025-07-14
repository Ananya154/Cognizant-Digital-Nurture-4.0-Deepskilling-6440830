package adapterpattern_4;

public class PaypalGateway {
    public void sendPayment(double amount) {
        System.out.println("Processing ₹" + amount + " through PayPal.");
    }
}
