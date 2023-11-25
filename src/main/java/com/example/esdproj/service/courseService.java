package com.example.esdproj.service;

import com.example.esdproj.DTO.courseform;
import com.example.esdproj.Entity.course;
import com.example.esdproj.Entity.employee;
import com.example.esdproj.Entity.schedule;
import com.example.esdproj.Entity.specialization;
import com.example.esdproj.Repositories.courseRepo;
import com.example.esdproj.Repositories.employeeRepo;
import com.example.esdproj.Repositories.scheduleRepo;
import com.example.esdproj.Repositories.specializationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class courseService {
    @Autowired
    private courseRepo courseRepo;

    @Autowired
    private  employeeRepo employeeRepo;

    @Autowired
    private scheduleRepo scheduleRepo;

    @Autowired
    private specializationRepo specializationRepo;

    @Transactional
    public boolean saveCourse(courseform courseform) {
        // Create entities and populate data
        try {
            course course = new course();
            course.setCourseCode(courseform.getCode());
            course.setName(courseform.getName());
            course.setTerm(courseform.getTerm());
            course.setYear(courseform.getYear());
            course.setCapacity(courseform.getCapacity());
            course.setCredits(courseform.getCredits());


            //pre-req id at the course table
            course pre = new course();
            Optional<course> prereqCourseOptional = Optional.ofNullable(courseRepo.findByName(courseform.getPrereq()));

            if (prereqCourseOptional.isPresent()) {
                course prereqCourse = prereqCourseOptional.get();
                Integer prereqCourseId = prereqCourse.getCourseId();
                course.setPrereq(prereqCourseId);
            }

            //mapping employee to the course table
            Integer employeeId = courseform.getFacID();
            Optional<employee> optionalEmployee = employeeRepo.findById(employeeId);

            if (optionalEmployee.isPresent()) {
                // Employee found
                employee emp = optionalEmployee.get();
                course.setFaculty(emp);
            }

            String spcl = courseform.getSpecialization();
            Optional<specialization> optionalSpecialization = Optional.ofNullable(specializationRepo.findByName(spcl));
            if (optionalSpecialization.isPresent()) {
                specialization sp = optionalSpecialization.get();
                course.setSpecialization(sp);

            }
            courseRepo.save(course);
            for (int i = 0; i < courseform.getSchedule_day().size(); i++) {
                schedule schedule = new schedule();
                schedule.setTime(courseform.getSchedule_time().get(i));
                schedule.setRoom(courseform.getSchedule_room().get(i));
                schedule.setDay(courseform.getSchedule_day().get(i));
                schedule.setBuilding(courseform.getSchedule_building().get(i));
                schedule.setCourse(course);
                scheduleRepo.save(schedule);
            }
            return true;
        } catch (Exception e) {
            // If an exception occurs (e.g., DataAccessException), return false
            return false;
        }

    }

    public List<String> getAllCourseNames() {
        List<course> courses = courseRepo.findAll();
        return courses.stream()
                .map(course::getName)
                .collect(Collectors.toList());
    }
}
