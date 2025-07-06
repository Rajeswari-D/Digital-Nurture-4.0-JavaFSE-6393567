public class TestPayment {
    public static void main(String[] args) {
        // Using Razorpay through adapter
        PaymentProcessor razorpay = new RazorpayAdapter(new RazorpayGateway());
        razorpay.processPayment(1500);

        // Using Stripe through adapter
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        stripe.processPayment(30);  // In USD
    }
}