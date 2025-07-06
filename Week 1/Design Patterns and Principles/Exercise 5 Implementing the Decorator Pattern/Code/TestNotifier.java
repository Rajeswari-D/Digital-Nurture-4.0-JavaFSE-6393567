public class TestNotifier {
    public static void main(String[] args) {
        // Basic Email
        Notifier notifier = new EmailNotifier();

        // Add SMS and Slack support dynamically
        Notifier smsNotifier = new SMSNotifier(notifier);
        Notifier fullNotifier = new SlackNotifier(smsNotifier);

        // Send one message via Email + SMS + Slack
        fullNotifier.send("System maintenance at 10 PM tonight.");
    }
}