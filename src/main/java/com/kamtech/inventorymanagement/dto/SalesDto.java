package com.kamtech.inventorymanagement.dto;

import lombok.Builder;
import lombok.Data;


import java.time.Instant;

@Data
@Builder
public class SalesDto {

    private Integer id;
    private String salesCode;

    private Instant salesDate;

    private String comment;
}
