package decoratorpattern_5;

public class NotificationTest {
    public static void main(String[] args) {
      
        Notifier notifier = new EmailNotifier();

        notifier = new SMSNotifierDecorator(notifier);
        notifier = new SlackNotifierDecorator(notifier);

        notifier.send("Your order has been shipped!");
    }
}
