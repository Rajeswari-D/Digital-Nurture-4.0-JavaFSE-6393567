import java.util.Arrays;
import java.util.Comparator;

public class SearchEngine {

    // Linear Search by Product Name
    public static Product linearSearch(Product[] products, String keyword) {
        for (Product p : products) {
            if (p.getProductName().equalsIgnoreCase(keyword)) {
                return p;
            }
        }
        return null;
    }

    // Binary Search (must be sorted by Product Name)
    public static Product binarySearch(Product[] products, String keyword) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].getProductName().compareToIgnoreCase(keyword);

            if (cmp == 0) return products[mid];
            if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }

        return null;
    }

    // Sort by name before using binary search
    public static void sortByName(Product[] products) {
        Arrays.sort(products, Comparator.comparing(Product::getProductName, String.CASE_INSENSITIVE_ORDER));
    }
}