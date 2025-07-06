public class TestDI {
    public static void main(String[] args) {
        // Manual Dependency Injection
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);

        service.printCustomer("C101");
        service.printCustomer("C999");  // Not found
    }
}