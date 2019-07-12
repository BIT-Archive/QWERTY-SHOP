package com.cafe24.gg.Vo;

import java.sql.Blob;

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
public class User{

    @Id
    private String id;

    private String email;

    private String name;

    private Blob password;

    private Blob phone;

    private Blob address;
    
}