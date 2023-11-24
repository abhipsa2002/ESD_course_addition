package com.example.esdproj.Repositories;

import com.example.esdproj.Entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface employeeRepo extends JpaRepository<employee, Integer> {
    employee findByEmail(String email);
}
