package com.example.esdproj.Controller;

import com.example.esdproj.DTO.courseform;
import com.example.esdproj.Entity.course;
import com.example.esdproj.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8080/")
@RestController
@RequestMapping("/api/v1")
public class courseController {
     @Autowired
     courseService courseService;

    @GetMapping("/get_pre")
    public ResponseEntity<List<course>> getcourse() {
        List<course> courses = courseService.getCourses();

        if (courses.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(courses, HttpStatus.OK);
        }
    }

    @PostMapping("/add_course")
    public ResponseEntity<String> addCourse(@RequestBody courseform c) {

        if (courseService.saveCourse(c)) {
            return ResponseEntity.ok("Added successfully");
        } else {
            return ResponseEntity.status(401).body("Failed to add the course");
        }
    }






}
