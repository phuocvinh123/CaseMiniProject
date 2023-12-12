package com.cg.model;

import com.cg.model.dto.reponse.FilterDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Filter {
    private String search;
    private Long category;
    private Long company;
    private Long color;
    private Integer maxPrice;
    private Integer minPrice;

    public FilterDTO toFilterDTO(){
        return new FilterDTO()
                .setSearch(search)
                .setCategory(category)
                .setColor(color)
                .setCompany(company)
                .setMinPrice(new BigDecimal(minPrice))
                .setMaxPrice(new BigDecimal(maxPrice));
    }
}
