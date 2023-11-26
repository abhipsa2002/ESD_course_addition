package com.example.esdproj.Controller;

import com.example.esdproj.DTO.loginform;
import com.example.esdproj.Entity.employee;
import com.example.esdproj.service.employeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/api/v1")
public class employeeController{

    @Autowired
    employeeService employeeService;

    @PostMapping("/add_employee")
    public ResponseEntity<String> addEmployee(@RequestBody employee employee) {
        employeeService.addEmployee(employee);
        if (employeeService.addEmployee(employee)) {
            return ResponseEntity.ok("Added successfully");
        } else {
            return ResponseEntity.status(401).body("Failed to add");
        }
    }


    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody loginform emp) {
        String email = emp.getEmail();
        String enteredPassword = emp.getPassword();

        if (employeeService.verifyEmployee(email, enteredPassword)) {
            return ResponseEntity.ok("Login successful");
        } else {
            return ResponseEntity.status(401).body("Login failed");
        }
    }

    @GetMapping("/get_employee")
    public ResponseEntity<List<employee>> getemp() {
        List<employee> emp = employeeService.getEmployees();

        if (emp.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(emp, HttpStatus.OK);
        }
    }

}
