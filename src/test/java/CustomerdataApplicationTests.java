

import com.nextcommerce.customerdata.api.controllers.CustomerController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Configuration;

@SpringBootTest
class CustomerdataApplicationTests {
    @Autowired
    CustomerController customerController;

    @Test
    void contextLoads() {
        //assert that the customerController object is not null
        assert (customerController != null);
    }

    @Configuration
    static class Config {
    }


}
