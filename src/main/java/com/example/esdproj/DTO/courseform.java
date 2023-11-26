package com.example.esdproj.DTO;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class courseform {
    private String name;//
    private Integer specialization;
    private List<String> schedule_day;//
    private List<String>  schedule_time;//
    private List<String>  schedule_room;//
    private List<String>  schedule_building;//
    private Integer prereq;//
    private Integer capacity;//
    private Integer credits;//
    private Integer facID;   //at the end
    private String code;//
    private Integer term;//
    private Integer year;//

}
