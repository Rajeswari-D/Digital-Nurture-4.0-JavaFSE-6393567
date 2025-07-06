public class CustomerService {
    private final CustomerRepository repo;

    // Constructor-based Dependency Injection
    public CustomerService(CustomerRepository repo) {
        this.repo = repo;
    }

    public void printCustomer(String id) {
        Customer customer = repo.findCustomerById(id);
        System.out.println("Found: " + customer);
    }
}