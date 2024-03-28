import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Course {
    //Directed graph
    //Attributes

    /*Attributes taken straight from JSON database*/

    //The alphanumeric code of a course (i.e. CSC 110
    @JsonProperty("CourseCode")
    private String course_code;

    //The plain language name of a course (i.e. Fundamentals of Programming I)
    @JsonProperty("CourseName")
    private String course_name;

    //Description of what the course is all about
    @JsonProperty("CourseDescription")
    private String course_description;

    //Array of how many credits the course is worth
    @JsonProperty("Units")
    private String units;

    //Additional notes to consider about the course
    @JsonProperty("Notes")
    private String notes;
    //Department that offers/oversees the course
    @JsonProperty("Department")
    private String department;
    private Requirement pre_req_head;
    @JsonSetter("Prereqs")
    private void create_pre_reqs(Map the_input){
        String type = null;
        String name = null;
        String quantity = null;
        Object sub_reqs = null;

        //for( Object key : the_input.keySet()){
            //System.out.println(key);
        type = (String) the_input.get("type");
        name = (String)the_input.get("name");
        quantity = (String)the_input.get("quantity");
        sub_reqs = the_input.get("sub maps");
        this.pre_req_head = new Requirement(type, name, quantity, sub_reqs);
        //}

        //System.out.println("\n\n");

        // System.out.println(the_input);
    }


    private String map;
    //private HashMap<String, Object> prereqs;

    //Weekly hours a course is scheduled for
    //@JsonProperty("Hours")
    private HashMap<String,String> hours;
    private void find_shortest_path(){
        //Start at head sub req and meet its requirements
        Requirement current = this.pre_req_head;



    }
    //

    private String reqs_string;
    //private HashMap<String, Requirement> prereqs;
    private HashMap<String, Requirement> coreqs;


    /*Other attributes that are part of being a class*/

    private boolean taken;


    private double final_grade;



    //Constructor
    public Course(){
        this.taken = true;
        //System.out.println("The prereq is: "+this.map );
        //this.prereqs = new HashMap<>();
        //can = "HELLO";
        //System.out.println(can);

    }

    public boolean canTakeCourse(HashSet takenCourses){
        //If there actually is some sort of requirement that isn't empty
        if (this.pre_req_head.getName() != null) {

            double quantity = Double.parseDouble(this.pre_req_head.getQuantity().split("-")[0]);
            double level = quantity;
            return (this.pre_req_head.isSatisfied(takenCourses));

        }else{

            return true;
        }

        //When we have 'all' we want to look at the length of the sub reqs list
        //return false;
    }



    /*public Course(String[] prereqs, boolean taken, double final_grade){
        this.prereqs=prereqs;
        this.taken= taken;
        this.final_grade = final_grade;

    }
*/




    //Getters



    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    /* public String[] getPrereqs() {
        return prereqs;
    }
    */
    /* public Course[] getPrereq_courses() {
        Program.loadIntoMap(name, this);



        return prereq_courses;
    }
*/
    public String get_course_name(){
        return course_name;
    }

    public String get_course_code(){
        return course_code;}

    public String getUnits(){
        return this.units;
    }

    public void setPrereqs(HashMap<String, Object> prereqs) {
        //this.prereqs = prereqs;
    }

    public double getFinal_grade() {
        return final_grade;
    }


    //Setters

    public void setFinal_grade(double final_grade) {
        this.final_grade = final_grade;
    }

    @Override
    public String toString() {
        return course_code;
    }
}
