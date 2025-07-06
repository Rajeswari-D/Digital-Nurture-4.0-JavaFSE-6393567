public class TestSort {
    public static void main(String[] args) {
        Order[] orders = {
            new Order("O001", "Keerthana", 7500.50),
            new Order("O002", "Ravi", 1200.00),
            new Order("O003", "Sneha", 5300.00),
            new Order("O004", "Arjun", 9500.75),
            new Order("O005", "Divya", 3200.30)
        };

        // Test Bubble Sort
        System.out.println("🔷 Bubble Sort (High to Low Total):");
        Sorter.bubbleSort(orders);
        Sorter.display(orders);

        // Reinitialize for Quick Sort
        orders = new Order[] {
            new Order("O001", "Keerthana", 7500.50),
            new Order("O002", "Ravi", 1200.00),
            new Order("O003", "Sneha", 5300.00),
            new Order("O004", "Arjun", 9500.75),
            new Order("O005", "Divya", 3200.30)
        };

        System.out.println("\n🔶 Quick Sort (High to Low Total):");
        Sorter.quickSort(orders, 0, orders.length - 1);
        Sorter.display(orders);
    }
}