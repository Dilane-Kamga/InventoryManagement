package com.kamtech.inventorymanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name="customer")
public class Customer extends AbstractEntity{
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "picture")
    private String picture;
    @Embedded
    private Address address;
    @OneToMany(mappedBy = "customer")
    private List<CustomerOrder> customerOrders;

    @Column(name = "id_enterprise")
    private Integer idEnterprise;

}
