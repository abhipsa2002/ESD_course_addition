package com.example.esdproj.service;

import com.example.esdproj.Entity.specialization;
import com.example.esdproj.Repositories.specializationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class specializationService {


    @Autowired
    private specializationRepo specializationRepo;

    public List<String> getAllSpeclNames() {
        List<specialization> spl = specializationRepo.findAll();
        return spl.stream()
                .map(specialization::getName)
                .collect(Collectors.toList());
    }

    public List<specialization> getAllSpecializations() {
        return specializationRepo.findAll();

    }
}
