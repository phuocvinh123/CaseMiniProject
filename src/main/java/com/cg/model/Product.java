package com.cg.model;

import com.cg.model.dto.reponse.ProductRepDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "products")
@Accessors(chain = true)
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String title;
    @Column(nullable = false)
    private BigDecimal newPrice;
    @Column(nullable = false)
    private BigDecimal prevPrice;
    private Integer reviews;
    private Integer star;
    @Column(nullable = false)
    private String img;
    @ManyToOne
    @JoinColumn(name = "company_id", referencedColumnName = "id",nullable = false)
    private Company company;
    @ManyToOne
    @JoinColumn(name = "color_id", referencedColumnName = "id",nullable = false)
    private Color color;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id",nullable = false)
    private Category category;

    public ProductRepDTO toProductRepDTO(){
        return new ProductRepDTO()
                .setTitle(title)
                .setPrice(newPrice)
                .setColor(color)
                .setCategory(category)
                .setCompany(company)
                .setImg(img);
    }
}
