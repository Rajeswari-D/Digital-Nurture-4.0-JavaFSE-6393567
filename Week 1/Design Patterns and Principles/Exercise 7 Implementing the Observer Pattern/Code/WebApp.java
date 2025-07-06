public class WebApp implements Observer {
    private final String user;

    public WebApp(String user) {
        this.user = user;
    }

    @Override
    public void update(String stockName, double newPrice) {
        System.out.println("[WebApp] " + user + " notified: " + stockName + " is now Rs " + newPrice);
    }
}