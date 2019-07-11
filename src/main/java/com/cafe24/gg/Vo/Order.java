package com.cafe24.gg.Vo;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name="[order]")
public class Order{

    @Id
    private int no;
    
    private Blob email;

    private Blob id;

    private String product_id;

    private String detail_id;

    private String option_name;

    private String option_value;

    private Long price;

    private int amount;

    private Blob phone;

    private Blob address;

    private String reg_date;
    
}