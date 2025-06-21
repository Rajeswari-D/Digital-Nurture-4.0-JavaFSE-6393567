public class Main {
    public static void main(String[] args) {
        Logger l1 = Logger.getInstance();
        l1.log("This is the 1st log.");

        Logger l2 = Logger.getInstance();
        l2.log("This is the 2nd log.");

        if (l1 == l2) {
            System.out.println("Both l1 and l2 are the same instance.");
        } else {
            System.out.println("Different instances are not singleton!");
        }
    }
}
