package com.example.bankingloan.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Setter
@Getter
@Table(name = "LOAN_TBL")
public class LoanTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String loanTypes;
  //  @ManyToOne( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    //private List<LoanTypes> loanTypesList;

}
