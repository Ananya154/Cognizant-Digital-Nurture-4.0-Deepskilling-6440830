package observerpattern_7;

public class MobileApp implements Observer {
    private String user;

    public MobileApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double newPrice) {
        System.out.println("[MobileApp - " + user + "] " + stockName + " is now ₹" + newPrice);
    }
}
