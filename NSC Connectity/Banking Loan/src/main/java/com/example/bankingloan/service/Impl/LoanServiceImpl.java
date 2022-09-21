package com.example.bankingloan.service.Impl;


import com.example.bankingloan.dto.LoanDto;
import com.example.bankingloan.dto.LoanTypesDto;
import com.example.bankingloan.entity.LoanEntity;
import com.example.bankingloan.entity.LoanTypes;
import com.example.bankingloan.repository.LoanRepo;
import com.example.bankingloan.repository.LoanRepository;
import com.example.bankingloan.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class LoanServiceImpl implements LoanService {
    @Autowired
    private LoanRepo loanRepo;
    @Autowired
    private LoanRepository loanRepository;


    @Override
    public LoanDto save(LoanDto loanDto) {
        LoanEntity loanEntity=new LoanEntity();
        loanEntity.setId(loanDto.getId());
        List<LoanTypes> loanTypesList=new ArrayList<>();
        for (LoanTypesDto loanTypesDto:loanDto.getLoanTypesList())
        {
            LoanTypes loanTypes=new LoanTypes();
            loanTypes.setId(loanTypesDto.getId());
            loanTypes.setLoanTypes(loanTypesDto.getLoanType());
           // loanRepo.save(loanTypes);
           loanTypesList.add(loanTypes);
        }
        loanEntity.setLoanTypesList(loanTypesList);
       LoanEntity  loanEntity1= loanRepository.save(loanEntity);
       List<LoanTypesDto>loanTypesDtos=new ArrayList<>();
 LoanTypesDto loanDto1=new LoanTypesDto();
       loanEntity1.getLoanTypesList().stream().forEach(x->{
           loanDto1.setLoanType(x.getLoanTypes());

       });
       loanTypesDtos.add(loanDto1);
       loanDto.setId(loanEntity.getId());
       loanDto.setLoanTypesList(loanTypesDtos);
        return loanDto;
    }

    @Override
    public LoanDto getDetails(String id) {
        LoanEntity loanEntity=LoanRepository.findbyLoanType(id);
        LoanDto loanDto=new LoanDto();
        loanDto.setId(loanEntity.getId());
        loanDto.setLoanTypesList(loanDto.getLoanTypesList());
        return loanDto;
    }
}
