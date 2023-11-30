package com.example.esdproj.Repositories;

import com.example.esdproj.Entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface employeeRepo extends JpaRepository<employee, Integer> {
    employee findByEmail(String email);
    List<employee> findByDepartmentIn(List<String> departments);
    @Query("SELECT e.employeeId FROM Employees e")
    List<Integer> getAllEmployeeIds();
}
