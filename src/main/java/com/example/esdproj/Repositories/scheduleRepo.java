package com.example.esdproj.Repositories;

import com.example.esdproj.Entity.schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface scheduleRepo extends JpaRepository<schedule,Integer> {

}
