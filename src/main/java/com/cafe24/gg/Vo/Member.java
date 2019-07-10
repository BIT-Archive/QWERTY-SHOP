package com.cafe24.gg.Vo;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Member{

    @Id
    private String id;

    private String email;

    private String name;

    private Blob password;

    private Blob phone;

    private Blob address;
    
}