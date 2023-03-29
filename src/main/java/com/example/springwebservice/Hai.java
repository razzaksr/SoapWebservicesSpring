package com.example.springwebservice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Hai implements Serializable {
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    private String name;
    private int price;
}
