package com.kamtech.inventorymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="suppliers")
public class Supplier extends AbstractEntity{

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
    @OneToMany(mappedBy = "supplier")
    private List<SupplierOrder> supplierOrders;

    @Column(name = "id_enterprise")
    private Integer idEnterprise;
}
