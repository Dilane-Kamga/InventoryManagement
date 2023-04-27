package com.kamtech.inventorymanagement.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.Enterprise;
import lombok.Builder;
import lombok.Data;


import javax.persistence.Embedded;
import java.util.List;

@Data
@Builder
public class EnterpriseDto {

    private Integer id;

    private String name;

    private String description;

    private String taxId;

    @JsonIgnore
    private AddressDto address;

    private String phone;

    private String email;

    private String website;

    private String picture;

    @JsonIgnore
    private List<UserDto> users;

    public EnterpriseDto fromEntity(Enterprise enterprise) {

        if(enterprise == null) {
            return null;
        }

        return EnterpriseDto.builder()
                .id(enterprise.getId())
                .name(enterprise.getName())
                .description(enterprise.getDescription())
                .taxId(enterprise.getTaxId())
                .phone(enterprise.getPhone())
                .email(enterprise.getEmail())
                .website(enterprise.getWebsite())
                .picture(enterprise.getPicture())
                .build();
    }

    public Enterprise toEntity(EnterpriseDto enterpriseDto) {

        if(enterpriseDto == null) {
            return null;
        }

        Enterprise enterprise = new Enterprise();
        enterprise.setId(enterpriseDto.getId());
        enterprise.setName(enterpriseDto.getName());
        enterprise.setDescription(enterpriseDto.getDescription());
        enterprise.setTaxId(enterpriseDto.getTaxId());
        enterprise.setPhone(enterpriseDto.getPhone());
        enterprise.setEmail(enterpriseDto.getEmail());
        enterprise.setWebsite(enterpriseDto.getWebsite());
        enterprise.setPicture(enterpriseDto.getPicture());

        return enterprise;
    }
}
