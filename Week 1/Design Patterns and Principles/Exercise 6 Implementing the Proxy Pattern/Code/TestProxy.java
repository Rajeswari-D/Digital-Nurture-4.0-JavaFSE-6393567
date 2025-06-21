// TestProxy.java
public class TestProxy {
    public static void main(String[] args) {
        // Use full path to your actual image
        Image img = new ProxyImage("C:/Users/rajes/Downloads/download.png");

        img.display(); // First time - loads from disk
        System.out.println();

        img.display(); // Second time - should use cached version
    }
}
