import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;

import com.nextcommerce.customerdata.domain.Customer;
import com.nextcommerce.customerdata.service.CustomerService;
import com.nextcommerce.customerdata.service.CustomerServiceImpl;

public class CustomerServiceImplTest  {

    

    // test method to verify that getCustomers() returns the expected list of customers
    @Test
    public void testGetCustomers() {
        CustomerService service = new CustomerServiceImpl();
        List<Customer> customers = service.getCustomers();
        assertEquals(1, customers.size());
        assertEquals("John", customers.get(0).getFirstName());
        assertEquals("Doe", customers.get(0).getLastName());
        assertEquals("johndoe@example.com", customers.get(0).getEmail());
       
    }
}