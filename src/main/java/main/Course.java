package main;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.time.Period;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Course {
    //Directed graph
    //Attributes
    @JsonProperty("id")
    private String name;



    private boolean taken;
    @JsonProperty("prereqs")
    private String[] prereqs;
    private Course[] prereq_courses;
    private String can;

    private double final_grade;


    //Constructor
    public Course(){
        this.taken = true;
        can = "HELLO";
        //System.out.println(can);

    }

    public Course(String[] prereqs, boolean taken, double final_grade){
        this.prereqs=prereqs;
        this.taken= taken;
        this.final_grade = final_grade;

    }


    public Course(String name, String[] prereqs){
        this.name = name;
        this.prereqs=prereqs;

    }
    //Methods

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public String[] getPrereqs() {
        return prereqs;
    }

    public Course[] getPrereq_courses() {
        Program.loadIntoMap(name, this);



        return prereq_courses;
    }

    public void setPrereqs(String[] prereqs) {
        this.prereqs = prereqs;
    }

    public double getFinal_grade() {
        return final_grade;
    }

    public void setFinal_grade(double final_grade) {
        this.final_grade = final_grade;
    }

    @Override
    public String toString() {
        return name;
    }
}
