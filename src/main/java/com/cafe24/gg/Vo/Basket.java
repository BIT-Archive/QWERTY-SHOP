package com.cafe24.gg.Vo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Basket{

    @Id
    private String product_id;

    private String id;

    private String email;

    private String detail_id;

    private int amount;
    

}