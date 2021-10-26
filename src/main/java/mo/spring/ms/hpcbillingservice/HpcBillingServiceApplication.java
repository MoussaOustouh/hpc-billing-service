package mo.spring.ms.hpcbillingservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
public class HpcBillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(HpcBillingServiceApplication.class, args);
    }

}
