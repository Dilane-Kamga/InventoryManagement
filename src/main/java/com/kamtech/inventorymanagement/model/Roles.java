package com.kamtech.inventorymanagement.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="roles")
public class Roles extends AbstractEntity{

    @Column(name = "role_name")
    private String roleName;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
