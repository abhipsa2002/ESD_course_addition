package com.example.esdproj.service;

import com.example.esdproj.Entity.employee;
import com.example.esdproj.Repositories.employeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService {
    @Autowired
    private employeeRepo employeeRepo;
    public boolean verifyEmployee(String email, String enteredPassword) {
        // Retrieve the employee by email
        employee employee = employeeRepo.findByEmail(email);

        // Check if the employee exists and has the "admin" department
        if (employee != null && "admin".equals(employee.getDepartment())) {
            // Check if the passwords match
            return employee.isPasswordMatch(enteredPassword);
        }

        // Either the employee doesn't exist or has a different department
        return false;
    }
    public boolean addEmployee(employee emp) {
        try {
            employeeRepo.save(emp);
            // If the save operation is successful, return true
            return true;
        } catch (Exception e) {
            // If an exception occurs (e.g., DataAccessException), return false
            return false;
        }
    }

    public List<employee> getEmployees()
    {
        return employeeRepo.findByDepartmentIn(List.of("cs", "ec"));
    }
}
