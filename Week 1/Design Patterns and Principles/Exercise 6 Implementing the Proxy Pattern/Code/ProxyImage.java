public class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage;

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    @Override
    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename); // lazy load
        } else {
            System.out.println("Retrieving " + filename + " from cache...");
        }
        realImage.display();
    }
}