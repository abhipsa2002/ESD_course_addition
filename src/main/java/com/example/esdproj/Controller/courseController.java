package com.example.esdproj.Controller;

import com.example.esdproj.DTO.courseform;
import com.example.esdproj.service.courseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class courseController {
     @Autowired
     courseService courseService;

    @GetMapping("/get_pre")
    public List<String> getCourses() {
        List<String> courses;
        return courses = courseService.getAllCourseNames();

    }

    @PostMapping("/add_course")
    public ResponseEntity<String> addCourse(@RequestBody  courseform dto)
    {
        courseService.saveCourse(dto);
        return ResponseEntity.ok("Added Successfully");
    }






}
