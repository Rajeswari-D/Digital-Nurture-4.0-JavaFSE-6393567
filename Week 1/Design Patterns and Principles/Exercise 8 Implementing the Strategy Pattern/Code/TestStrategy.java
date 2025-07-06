public class TestStrategy {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Use Credit Card payment
        context.setStrategy(new CreditCardPayment("Ananya", "1234-5678-9876"));
        context.pay(1500.0);

        // Use PayPal payment
        context.setStrategy(new PayPalPayment("ananya@email.com"));
        context.pay(2400.5);
    }
}