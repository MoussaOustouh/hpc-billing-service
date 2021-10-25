package mo.spring.ms.hpcbillingservice.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import mo.spring.ms.hpcbillingservice.models.Customer;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Collection;
import java.util.Date;

@Table(name = "bill")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Date billingDate;
    private long customerID;

    @OneToMany(mappedBy = "bill")
    private Collection<ProductItem> productItems;

    @Transient
    private Customer customer;

}