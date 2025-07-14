package OrderSorting_3;

public class Order {
    public String orderId;
    public String customerName;
    public double totalPrice;

    public Order(String orderId, String customerName, double totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.totalPrice = totalPrice;
    }

    public String toString() {
        return "Order ID: " + orderId + ", Name: " + customerName + ", Total: ₹" + totalPrice;
    }
}
