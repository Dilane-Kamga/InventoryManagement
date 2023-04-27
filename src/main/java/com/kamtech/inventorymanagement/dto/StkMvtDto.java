package com.kamtech.inventorymanagement.dto;


import com.kamtech.inventorymanagement.model.MvtType;
import lombok.Builder;
import lombok.Data;


import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class StkMvtDto {

    private Integer id;
    private Instant mvtDate;

    private BigDecimal quantity;

    private MvtType mvtType;

    private ItemDto item;
}
