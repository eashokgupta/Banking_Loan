package com.example.bankingloan.Controller;


import com.example.bankingloan.dto.LoanDto;

import com.example.bankingloan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loan")
public class LoanController {
    @Autowired
    private LoanService loanService;
@PostMapping("/save")
    public ResponseEntity<LoanDto> save(@RequestBody LoanDto loanDto){
        LoanDto loanDto1=loanService.save(loanDto);
        return new ResponseEntity<>(loanDto1, HttpStatus.CREATED);

    }
    @GetMapping("/loantype/{loanTypes}")
    public ResponseEntity<LoanDto> get(@PathVariable String loanTypes){
    LoanDto loanDto=loanService.getDetails(loanTypes);
return new ResponseEntity<>(loanDto,HttpStatus.OK);
    }
}
