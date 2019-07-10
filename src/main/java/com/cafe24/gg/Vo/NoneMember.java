package com.cafe24.gg.Vo;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@Entity
public class NoneMember{

    @Id
    private Blob email;

    private Blob phone;

    private Blob name;

    private Blob password;



    
}