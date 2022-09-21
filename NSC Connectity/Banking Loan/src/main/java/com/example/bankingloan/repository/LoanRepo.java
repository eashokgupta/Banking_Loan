package com.example.bankingloan.repository;


import com.example.bankingloan.entity.LoanEntity;
import com.example.bankingloan.entity.LoanTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepo extends JpaRepository<LoanTypes,Long> {
    static LoanEntity findbyLoanType(String loanTypes) {
        return new LoanEntity();
    }
}