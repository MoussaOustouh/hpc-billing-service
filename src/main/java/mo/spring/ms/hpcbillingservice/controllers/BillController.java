package mo.spring.ms.hpcbillingservice.controllers;

import mo.spring.ms.hpcbillingservice.entities.Bill;
import mo.spring.ms.hpcbillingservice.repositories.BillRepository;
import mo.spring.ms.hpcbillingservice.repositories.ProductItemRepository;
import mo.spring.ms.hpcbillingservice.services.feign.CustomerServiceClient;
import mo.spring.ms.hpcbillingservice.services.feign.InventoryServiceClient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BillController {
    @Autowired private BillRepository billRepository;
    @Autowired private ProductItemRepository productItemRepository;
    @Autowired private CustomerServiceClient customerServiceClient;
    @Autowired private InventoryServiceClient inventoryServiceClient;

    @GetMapping("/bills/full/{id}")
    Bill getBill(@PathVariable("id") Long id){
        Bill bill = billRepository.findById(id).orElse(null);
        if(bill != null){
            bill.setCustomer(customerServiceClient.findCustomerById(bill.getCustomerID()));
            bill.setProductItems(productItemRepository.findByBillId(id));
            bill.getProductItems().forEach(pi ->
                pi.setProduct(inventoryServiceClient.findProductById(pi.getProductID()))
            );
        }

        return bill;
    }
}
