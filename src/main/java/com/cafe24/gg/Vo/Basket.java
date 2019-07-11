package com.cafe24.gg.Vo;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Basket{

    @Id
    private String product_id;

    private String id;

    private String email;

    private String detail_id;

    private int amount;
    

}