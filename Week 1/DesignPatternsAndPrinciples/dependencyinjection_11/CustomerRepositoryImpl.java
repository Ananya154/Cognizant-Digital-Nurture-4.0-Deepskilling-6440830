package dependencyinjection_11;

public class CustomerRepositoryImpl implements CustomerRepository {

    public String findCustomerById(String customerId) {

        return "Customer ID: " + customerId + ", Name: Ananya, City: Mumbai";
    }
}
