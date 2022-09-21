package com.example.bankingloan.repository;


import com.example.bankingloan.entity.LoanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoanRepository extends JpaRepository<LoanEntity,Long> {
    static LoanEntity findbyLoanType(String loanTypes) {
        return new LoanEntity();
    }
}
