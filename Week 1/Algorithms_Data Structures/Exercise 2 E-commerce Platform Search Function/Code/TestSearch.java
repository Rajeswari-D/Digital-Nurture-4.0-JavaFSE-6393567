public class TestSearch {
    public static void main(String[] args) {
        Product[] products = {
            new Product("P01", "Keyboard", "Electronics"),
            new Product("P02", "Shoes", "Footwear"),
            new Product("P03", "Mouse", "Electronics"),
            new Product("P04", "T-shirt", "Clothing"),
            new Product("P05", "Laptop", "Electronics")
        };

        String keyword = "Laptop";

        // --- Linear Search ---
        System.out.println("🔍 Linear Search:");
        Product foundLinear = SearchEngine.linearSearch(products, keyword);
        if (foundLinear != null)
            System.out.println("Found: " + foundLinear);
        else
            System.out.println("Not Found");

        // --- Binary Search (after sorting) ---
        System.out.println("\n🔍 Binary Search:");
        SearchEngine.sortByName(products);
        Product foundBinary = SearchEngine.binarySearch(products, keyword);
        if (foundBinary != null)
            System.out.println("Found: " + foundBinary);
        else
            System.out.println("Not Found");
    }
}