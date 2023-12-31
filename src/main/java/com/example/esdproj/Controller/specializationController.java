package com.example.esdproj.Controller;


import com.example.esdproj.Entity.specialization;
import com.example.esdproj.service.specializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/api/v1")
public class specializationController {
    //specializationService specializationService = new specializationService();
    @Autowired
    specializationService specializationService;

    @GetMapping("/get_special")
    public ResponseEntity<List<specialization>> getSpecializations() {
        List<specialization> specializations = specializationService.getAllSpecializations();

        if (specializations.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(specializations);
    }




}
