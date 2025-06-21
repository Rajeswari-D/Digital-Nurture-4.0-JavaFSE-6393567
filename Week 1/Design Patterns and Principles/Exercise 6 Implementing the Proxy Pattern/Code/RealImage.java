// RealImage.java
import javax.swing.*;

public class RealImage implements Image {
    private final String filePath;

    public RealImage(String filePath) {
        this.filePath = filePath;
        loadFromDisk();  // Simulate loading
    }

    private void loadFromDisk() {
        System.out.println("Loading image from: " + filePath);
        // You can add delay here to simulate remote loading if desired
    }

    @Override
    public void display() {
        System.out.println("Displaying image: " + filePath);

        // Display the image in a JFrame
        JFrame frame = new JFrame("Image Viewer");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(600, 400);

        ImageIcon icon = new ImageIcon(filePath);
        JLabel label = new JLabel(icon);
        frame.add(label);

        frame.setVisible(true);
    }
}
