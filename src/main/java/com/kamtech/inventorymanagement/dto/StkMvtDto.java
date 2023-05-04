package com.kamtech.inventorymanagement.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kamtech.inventorymanagement.model.MvtType;
import com.kamtech.inventorymanagement.model.StkMvt;
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

    public static StkMvtDto fromEntity(StkMvt stkMvt){

        if(stkMvt == null){
            return null;
        }

        return StkMvtDto.builder()
                .id(stkMvt.getId())
                .mvtDate(stkMvt.getMvtDate())
                .quantity(stkMvt.getQuantity())
                .mvtType(stkMvt.getMvtType())
                .item(ItemDto.builder().id(stkMvt.getItem().getId()).build())
                .item(ItemDto.fromEntity(stkMvt.getItem()))
                .build();
    }

    public static StkMvt toEntity(StkMvtDto stkMvtDto){

        if(stkMvtDto == null){
            return null;
        }

        StkMvt stkMvt = new StkMvt();
        stkMvt.setId(stkMvtDto.getId());
        stkMvt.setMvtDate(stkMvtDto.getMvtDate());
        stkMvt.setQuantity(stkMvtDto.getQuantity());
        stkMvt.setMvtType(stkMvtDto.getMvtType());
        stkMvt.setItem(ItemDto.toEntity(stkMvtDto.getItem()));

        return stkMvt;
    }
}
