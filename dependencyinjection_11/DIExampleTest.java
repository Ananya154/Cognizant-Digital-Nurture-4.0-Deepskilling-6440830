package dependencyinjection_11;

public class DIExampleTest {
    public static void main(String[] args) {

        CustomerRepository repository = new CustomerRepositoryImpl();

        CustomerService service = new CustomerService(repository);

        service.showCustomerDetails("C101");
    }
}
