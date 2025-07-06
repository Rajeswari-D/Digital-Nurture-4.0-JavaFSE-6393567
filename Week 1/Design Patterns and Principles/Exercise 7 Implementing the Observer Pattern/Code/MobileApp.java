public class MobileApp implements Observer {
    private final String user;

    public MobileApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println("[MobileApp] " + user + " notified: " + stockName + " is now Rs " + newPrice);
    }
}