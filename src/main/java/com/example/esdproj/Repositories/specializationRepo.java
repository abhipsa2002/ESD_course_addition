package com.example.esdproj.Repositories;

import com.example.esdproj.Entity.specialization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface specializationRepo extends JpaRepository<specialization, Integer> {
    List<specialization> findAll();
    specialization findByName(String name);

}
