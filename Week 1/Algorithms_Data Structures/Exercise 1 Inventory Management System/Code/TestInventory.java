public class TestInventory {
    public static void main(String[] args) {
        Inventory inventory = new Inventory();

        Product p1 = new Product("P101", "Mouse", 25, 499.99);
        Product p2 = new Product("P102", "Keyboard", 10, 899.50);
        Product p3 = new Product("P103", "Monitor", 5, 6500.00);

        inventory.addOrUpdateProduct(p1);
        inventory.addOrUpdateProduct(p2);
        inventory.addOrUpdateProduct(p3);

        System.out.println("\n>> All Products:");
        inventory.showAllProducts();

        System.out.println("\n>> Update Keyboard quantity:");
        p2.setQuantity(20);
        inventory.addOrUpdateProduct(p2);

        System.out.println("\n>> View Product P102:");
        inventory.showProduct("P102");

        System.out.println("\n>> Delete Product P101:");
        inventory.deleteProduct("P101");

        System.out.println("\n>> Final Inventory:");
        inventory.showAllProducts();
    }
}