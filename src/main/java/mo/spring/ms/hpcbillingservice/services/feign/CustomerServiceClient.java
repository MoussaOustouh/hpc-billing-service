package mo.spring.ms.hpcbillingservice.services.feign;

import mo.spring.ms.hpcbillingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "CUSTOMER-SERVICES")
public interface CustomerServiceClient {
    @GetMapping("?customers/{id}?projection=fullCustomer")
    Customer findCustomerById(@PathVariable("id") Long id);
}
