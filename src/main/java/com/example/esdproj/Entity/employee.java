package com.example.esdproj.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Employees")
public class employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer employeeId;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", nullable = false, unique = true)
    private String email;
    @Column(name = "title")
    private String title;

//    @Column(name = "photograph_path")
//    private String photographPath;
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name="dept_id")
//    private department department;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "department")
    private String department;

    @OneToMany(mappedBy = "faculty", cascade = CascadeType.ALL)
    private List<course> courses;

    public void setPassword(String password) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        this.password = passwordEncoder.encode(password);
    }
//
    // Method to check if the entered password matches the hashed password
    public boolean isPasswordMatch(String enteredPassword) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder.matches(enteredPassword, this.password);
    }

}