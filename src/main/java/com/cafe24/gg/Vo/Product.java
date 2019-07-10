package com.cafe24.gg.Vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class Product{

    @Id
    @GeneratedValue
    private Long product_id;

    private String title;

    private Boolean display;

    private Long category_no;

    private Long price;

}