package com.cafe24.gg.Vo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class ProductDetail{

    @Id
    private int detail_id;

    private String product_id;

    private String option_name;

    private String option_value;

    private String description;

    private int amount;

    private Long add_price;

    
    
}