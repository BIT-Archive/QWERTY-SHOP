package com.cafe24.gg.Vo;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class NoneMember{

    @Id
    private Blob email;

    private Blob phone;

    private Blob name;

    private Blob password;



    
}