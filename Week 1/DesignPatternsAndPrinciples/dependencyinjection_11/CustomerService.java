package dependencyinjection_11;

public class CustomerService {
    private CustomerRepository repository;

    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void showCustomerDetails(String customerId) {
        String customer = repository.findCustomerById(customerId);
        System.out.println("Customer Details:");
        System.out.println(customer);
    }
}
