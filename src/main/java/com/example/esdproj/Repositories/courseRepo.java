package com.example.esdproj.Repositories;

import com.example.esdproj.Entity.course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface courseRepo extends JpaRepository<course,Integer> {

}
