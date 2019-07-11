package com.cafe24.gg.Vo;

import java.sql.Blob;

import javax.persistence.Column;
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
@Table(name="[nonemember]")
public class NoneMember{

    @Id
    private String email;

    private Blob phone;

    private Blob name;

    private Blob password;



    
}