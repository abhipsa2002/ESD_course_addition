package com.example.esdproj.Controller;


import com.example.esdproj.Entity.specialization;
import com.example.esdproj.service.specializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081/")
@RestController
@RequestMapping("/api/v1")
public class specializationController {
    //specializationService specializationService = new specializationService();
    @Autowired
    specializationService specializationService;

    @GetMapping("/get_special")
    public ResponseEntity<List<String>> getAllSpecialization() {
        List<String> specializations = specializationService.getAllSpeclNames();
        return ResponseEntity.ok(specializations);
    }



}
