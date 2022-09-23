package com.example.bankingloan.service.Impl;

import com.example.bankingloan.dto.EducationDto;
import com.example.bankingloan.dto.LoanDto;
import com.example.bankingloan.dto.LoanTypesDto;
import com.example.bankingloan.entity.EducationEntity;
import com.example.bankingloan.entity.LoanEntity;
import com.example.bankingloan.entity.LoanTypes;
import com.example.bankingloan.repository.EducationRepository;
import com.example.bankingloan.repository.LoanRepo;
import com.example.bankingloan.repository.LoanRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class EducationServiceImpl {
    @Autowired
private EducationRepository repository;

    @Autowired
private LoanRepo loanRepo;

    @Autowired
private LoanRepository loanRepository;

    public EducationDto save(EducationDto educationDto){
        EducationEntity educationEntity = new EducationEntity();
        educationEntity.setMarks(educationDto.getMarks());
        educationEntity.setAge(educationDto.getAge());


        return educationDto;
    }
}
