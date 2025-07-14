package observerpattern_7;

public class WebApp implements Observer {
    private String user;

    public WebApp(String user) {
        this.user = user;
    }

    public void update(String stockName, double newPrice) {
        System.out.println("[WebApp - " + user + "] " + stockName + " is now ₹" + newPrice);
    }
}
