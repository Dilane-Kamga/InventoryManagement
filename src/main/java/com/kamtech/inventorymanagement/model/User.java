package com.kamtech.inventorymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="users")
public class User extends AbstractEntity{

        @Column(name = "first_name")
        private String firstName;
        @Column(name = "last_name")
        private String lastName;
        @Column(name = "birth_date")
        private Instant birthDate;
        @Column(name = "email")
        private String email;
        @Column(name = "password")
        private String password;
        @Embedded
        private Address address;
        @Column(name = "picture")
        private String picture;
        @ManyToOne
        @JoinColumn(name = "enterprise_id")
        private Enterprise enterprise;
        @OneToMany(mappedBy = "user")
        private List<Roles> roles;
}
