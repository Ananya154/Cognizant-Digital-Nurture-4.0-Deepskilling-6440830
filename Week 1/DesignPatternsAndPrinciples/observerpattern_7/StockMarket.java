package observerpattern_7;

import java.util.ArrayList;
import java.util.List;

public class StockMarket implements Stock {

    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double price;

    public StockMarket(String stockName, double initialPrice) {
        this.stockName = stockName;
        this.price = initialPrice;
    }

    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, price);
        }
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
        System.out.println(stockName + " updated to ₹" + newPrice);
        notifyObservers(); 
    }
}
