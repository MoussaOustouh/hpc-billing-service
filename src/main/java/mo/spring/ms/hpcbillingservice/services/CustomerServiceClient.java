package mo.spring.ms.hpcbillingservice.services;

import mo.spring.ms.hpcbillingservice.classes.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-services")
public interface CustomerServiceClient {
    @GetMapping("?customers/{id}?projection=fullCustomer")
    Customer findCustomerById(@PathVariable("id") Long id);
}
