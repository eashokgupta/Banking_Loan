package com.example.bankingloan.dto;


import lombok.Data;

import java.util.List;
@Data
public class LoanDto {
    private Long id;
    private List<LoanTypesDto> loanTypesList;
}
