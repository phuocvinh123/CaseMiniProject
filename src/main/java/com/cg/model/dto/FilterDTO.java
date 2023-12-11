package com.cg.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class FilterDTO {
    private String search;
    private Long category;
    private Long company;
    private Long color;
    private BigDecimal maxPrice;
    private BigDecimal minPrice;
}
