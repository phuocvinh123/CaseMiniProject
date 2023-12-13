package com.cg.model.dto.reponse;

import com.cg.model.Category;
import com.cg.model.Color;
import com.cg.model.Company;
import com.cg.model.Product;
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
public class ProductRepDTO {
    private String title;
    private BigDecimal price;
    private Color color;
    private Category category;
    private Company company;
    private String img;

    public Product toProduct(){
        return new Product()
                .setTitle(title)
                .setNewPrice(price)
                .setPrevPrice(BigDecimal.ZERO)
                .setReviews(0)
                .setStar(0)
                .setImg(img)
                .setColor(color)
                .setCompany(company)
                .setCategory(category);
    }
}
