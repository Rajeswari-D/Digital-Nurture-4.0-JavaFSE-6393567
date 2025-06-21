import java.util.HashMap;
import java.util.Map;

public class CustomerRepositoryImpl implements CustomerRepository {
    private final Map<String, Customer> database = new HashMap<>();

    public CustomerRepositoryImpl() {
        // Simulated in-memory data
        database.put("C101", new Customer("C101", "Ananya"));
        database.put("C102", new Customer("C102", "Keerthana"));
    }

    @Override
    public Customer findCustomerById(String id) {
        return database.getOrDefault(id, new Customer(id, "Unknown"));
    }
}
