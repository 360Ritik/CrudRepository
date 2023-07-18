package com.example.CrudOperation.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class Company {

    String companyName;
    Date yearOfEst;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
