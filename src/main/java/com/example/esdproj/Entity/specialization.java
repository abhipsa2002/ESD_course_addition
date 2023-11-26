package com.example.esdproj.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity(name="Specializations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class specialization {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="specialization_id")
    private Integer specializationId;
    @Column(name="code",unique = true, nullable = false)
    private String code;
    @Column(name="name",nullable = false,unique = true)
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "specialization")
    private List<course> courses;
}
