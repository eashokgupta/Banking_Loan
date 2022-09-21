package com.example.bankingloan.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
@Data
@Setter
@Getter

public class LoanTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String loanTypes;


}
