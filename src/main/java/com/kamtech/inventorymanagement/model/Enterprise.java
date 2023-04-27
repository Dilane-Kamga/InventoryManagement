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
@Table(name="enterprise")
public class Enterprise extends AbstractEntity{

    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "tax_id")
    private String taxId;
    @Embedded
    private Address address;
    @Column(name = "phone")
    private String phone;
    @Column(name = "email")
    private String email;
    @Column(name="website")
    private String website;
    @Column(name = "picture")
    private String picture;
    @OneToMany(mappedBy = "enterprise")
    private List<User> users;
}
