package observerpattern_7;

public class ObserverTest {
    public static void main(String[] args) {

        StockMarket tcs = new StockMarket("TCS", 3500.00);

        Observer mobileUser1 = new MobileApp("Ananya");
        Observer webUser1 = new WebApp("Ravi");

        tcs.registerObserver(mobileUser1);
        tcs.registerObserver(webUser1);

        tcs.setPrice(3550.50);
        System.out.println();

        tcs.removeObserver(webUser1);

        tcs.setPrice(3600.00);
    }
}
