import java.util.*;

public class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private final Map<String, Double> stockPrices = new HashMap<>();

    public void setPrice(String stockName, double newPrice) {
        System.out.println("\n[StockMarket] Updating " + stockName + " to Rs " + newPrice);
        stockPrices.put(stockName, newPrice);
        notifyObservers(stockName);
    }

    @Override
    public void register(Observer o) {
        observers.add(o);
    }

    @Override
    public void deregister(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObservers() {
        // Not used here
    }

    public void notifyObservers(String stockName) {
        for (Observer o : observers) {
            o.update(stockName, stockPrices.get(stockName));
        }
    }
}
