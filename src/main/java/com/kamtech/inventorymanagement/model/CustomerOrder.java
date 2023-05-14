package com.kamtech.inventorymanagement.model;

import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="customer_order")
public class CustomerOrder extends AbstractEntity{
    @Column(name = "order_number")
    private String orderNumber;
    @Column(name = "order_date")
    private Instant orderDate;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    @OneToMany(mappedBy = "customerOrder")
    private List<CustomerOrderLine> customerOrderLines;

    @Column(name = "id_enterprise")
    private Integer idEnterprise;

}
