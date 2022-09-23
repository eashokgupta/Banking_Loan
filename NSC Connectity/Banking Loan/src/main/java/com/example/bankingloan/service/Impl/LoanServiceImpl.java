package com.example.bankingloan.service.Impl;


import com.example.bankingloan.dto.LoanDto;
import com.example.bankingloan.dto.LoanTypesDto;
import com.example.bankingloan.entity.LoanEntity;
import com.example.bankingloan.entity.LoanTypes;
import com.example.bankingloan.repository.LoanRepo;
import com.example.bankingloan.repository.LoanRepository;
import com.example.bankingloan.service.LoanService;
import org.springframework.beans.BeanUtils;
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
        LoanEntity loanEntity = new LoanEntity();
        loanEntity.setId(loanDto.getId());
        List<LoanTypes> loanTypesList = new ArrayList<>();
        for (LoanTypesDto loanTypesDto : loanDto.getLoanTypesList()) {
            LoanTypes loanTypes = new LoanTypes();
            loanTypes.setId(loanTypesDto.getId());
            loanTypes.setLoanTypes(loanTypesDto.getLoanTypes());
            // loanRepo.save(loanTypes);
            loanTypesList.add(loanTypes);
        }
        loanEntity.setLoanTypesList(loanTypesList);
        LoanEntity loanEntity1 = loanRepository.save(loanEntity);
        List<LoanTypesDto> loanTypesDtos = new ArrayList<>();
        LoanTypesDto loanDto1 = new LoanTypesDto();
        loanEntity1.getLoanTypesList().stream().forEach(x -> {
          BeanUtils.copyProperties(x,loanDto1);


        });
        loanTypesDtos.add(loanDto1);
        loanDto.setId(loanEntity.getId());
        loanDto.setLoanTypesList(loanTypesDtos);
        return loanDto;
    }

    @Override
    public LoanDto getDetails(String loanTypes) {
      /*  LoanTypes loanTypes1=loanRepo.findbyLoanTypes(loanTypes);
       List <LoanEntity> loanEntity= loanRepository.findAll();
        LoanDto loanDto=new LoanDto();
       loanEntity.stream().map(LoanEntity::getLoanTypesList).map(L).forEach(x->{
                   loanDto.setId(x.getId());
                   loanDto.setLoanTypesList();
       });


        loanDto.setId(loanEntity.getId());*/
        //loanDto.setLoanTypesList(loanDto.getLoanTypesList());
        //  List<LoanTypes> loantype=loanRepo.findAll();
        List<LoanTypesDto> loanTypesDtos = new ArrayList<>();
        List<LoanEntity> loanEntities = loanRepository.findAll();
        LoanTypesDto loanTypesDto = new LoanTypesDto();
        LoanDto loanDto = new LoanDto();
        loanEntities.stream().forEach(x -> {
            x.getLoanTypesList().stream().filter(y -> y.getLoanTypes().equals(loanTypes)).forEach(l -> {
                BeanUtils.copyProperties(l, loanTypesDto);
                BeanUtils.copyProperties(x, loanDto);
             //   loanTypesDto.setLoanType(l.getLoanTypes());
               // loanDto.setId(x.getId());

                loanTypesDtos.add(loanTypesDto);

            });
        });

        loanDto.setLoanTypesList(loanTypesDtos);

        return loanDto;

    }
}
