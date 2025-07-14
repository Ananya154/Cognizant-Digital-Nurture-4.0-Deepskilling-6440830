package adapterpattern_4;

public class PaymentTest {
    public static void main(String[] args) {
     
        RazorpayGateway razorpay = new RazorpayGateway();
        PaymentProcessor razorpayProcessor = new RazorpayAdapter(razorpay);
        razorpayProcessor.processPayment(500.0);

        PaypalGateway paypal = new PaypalGateway();
        PaymentProcessor paypalProcessor = new PaypalAdapter(paypal);
        paypalProcessor.processPayment(750.0);
    }
}
