package com.example.bankingloan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class BankingLoanApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankingLoanApplication.class, args);
    }

}
