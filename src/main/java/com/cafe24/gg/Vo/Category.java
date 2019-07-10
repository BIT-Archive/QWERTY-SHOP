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
public class Category{
    
    @Id
    private int category_no;

    private String name;
    

}