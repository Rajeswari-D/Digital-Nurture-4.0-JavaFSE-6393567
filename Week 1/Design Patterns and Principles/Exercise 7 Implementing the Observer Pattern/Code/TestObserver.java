public class TestObserver {
    public static void main(String[] args) {
        StockMarket bse = new StockMarket();

        Observer mobileClient = new MobileApp("Ananya");
        Observer webClient = new WebApp("Ananya");

        bse.register(mobileClient);
        bse.register(webClient);

        bse.setPrice("TCS", 3650.25);
        bse.setPrice("INFY", 1530.75);

        bse.deregister(mobileClient);
        bse.setPrice("WIPRO", 401.20);
    }
}