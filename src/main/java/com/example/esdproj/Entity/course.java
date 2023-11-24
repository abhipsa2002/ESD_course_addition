package com.example.esdproj.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;


@Entity(name="Courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private Integer courseId;
    @Column(name = "course_code", nullable = false, unique = true)
    private String courseCode;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "description", nullable = true)
    private String description;
    @Column(name = "year", nullable = false)
    private Integer year;
    @Column(name = "term", nullable = false)
    private Integer term;
    @Column(name = "credits", nullable = false)
    private Integer credits;
    @Column(name = "capacity", nullable = false)
    private Integer capacity;
    @Column(name = "pre_req")
    private Integer prereq;

    @ManyToOne
    @JoinColumn(name="employee_id")
    private employee faculty;
    @ManyToOne
    @JoinColumn(name="specialization")
    private specialization specialization;




//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name="Course_Domain", joinColumns = {@JoinColumn(name="course_id")},
//            inverseJoinColumns = {@JoinColumn(name="domain_id")})
//    private List<domain> domains;

//    @ManyToMany(fetch = FetchType.EAGER)
//    @JoinTable(name="Course_Prerequisite",
//            joinColumns = {@JoinColumn(name="course_id", referencedColumnName = "course_id", unique = false)},
//            inverseJoinColumns = {@JoinColumn(name="prerequisite_id", referencedColumnName = "course_id", unique = false)})
//    private Set<course> preRequisite;

//    @ManyToMany(cascade = CascadeType.ALL , fetch = FetchType.EAGER)
//    @JoinTable(name="Course_Specialization", joinColumns = {@JoinColumn(name="course_id")},
//            inverseJoinColumns = {@JoinColumn(name = "specialization_id")})
//    private List<specialization> specializationList;

    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    private Set<schedule> schedules;


}
