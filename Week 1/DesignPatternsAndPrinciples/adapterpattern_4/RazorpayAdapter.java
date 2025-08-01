package adapterpattern_4;

public class RazorpayAdapter implements PaymentProcessor {

    private RazorpayGateway razorpay;

    public RazorpayAdapter(RazorpayGateway razorpay) {
        this.razorpay = razorpay;
    }

    public void processPayment(double amount) {
        razorpay.makePayment(amount);
    }
}
