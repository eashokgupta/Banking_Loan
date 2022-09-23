package com.example.bankingloan.service;


import com.example.bankingloan.dto.LoanDto;
import com.example.bankingloan.dto.LoanTypesDto;


public interface LoanService {
    LoanDto save(LoanDto loanDto);


    LoanDto  getDetails(String loanTypes);

}
