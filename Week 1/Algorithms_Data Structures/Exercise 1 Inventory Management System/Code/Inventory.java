import java.util.HashMap;

public class Inventory {
    private HashMap<String, Product> products = new HashMap<>();

    // Add or Update a product
    public void addOrUpdateProduct(Product product) {
        products.put(product.getProductId(), product);
        System.out.println("Product saved: " + product);
    }

    // Delete product
    public void deleteProduct(String productId) {
        if (products.remove(productId) != null) {
            System.out.println("Product " + productId + " removed.");
        } else {
            System.out.println("Product not found: " + productId);
        }
    }

    // Display product
    public void showProduct(String productId) {
        Product p = products.get(productId);
        if (p != null) {
            System.out.println(p);
        } else {
            System.out.println("Product not found.");
        }
    }

    // Show all
    public void showAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in inventory.");
        } else {
            for (Product p : products.values()) {
                System.out.println(p);
            }
        }
    }
}