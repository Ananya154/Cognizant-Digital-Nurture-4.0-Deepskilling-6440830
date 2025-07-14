package singletonexample_1;

public class LoggerTest {
    public static void main(String[] args) {
        System.out.println("Creating first logger instance:");
        Logger logger1 = Logger.getInstance();
        logger1.log("This is the first log message.");

        System.out.println("\nCreating second logger instance:");
        Logger logger2 = Logger.getInstance();
        logger2.log("This is the second log message.");
        if (logger1 == logger2) {
            System.out.println("\nBoth logger instances are the same (Singleton works).");
        } else {
            System.out.println("\nLogger instances are different (Singleton failed).");
        }
    }
}
