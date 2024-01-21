import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

public class Course extends Requirement{
    //Directed graph
    //Attributes

    /*Attributes taken straight from JSON database*/
    //The alpha numeric code of a course (i.e. CSC 110
    @JsonProperty("CourseCode")
    private String course_code;

    //The plain language name of a course (i.e. Fundamentals of Programming I)
    @JsonProperty("CourseName")
    private String course_name;

    //Description of what the course is all about
    @JsonProperty("CourseDescription")
    private String course_description;

    //Array of how many creits the course is worth
    @JsonProperty("Units")
    private String units;

    //Additional notes to consider about the course
    @JsonProperty("Notes")
    private String notes;
    //Department that offers/oversees the course
    @JsonProperty("Department")
    private String department;

    //Weekly hours a course is scheduled for
    private String hours;

    //
    private HashMap<String, Requirement> prereqs;
    private HashMap<String, Requirement> coreqs;


    /*Other attributes that are part of being a class*/

    private boolean taken;


    private double final_grade;



    //Constructor
    public Course(){
        this.taken = true;
        //can = "HELLO";
        //System.out.println(can);

    }



    /*public Course(String[] prereqs, boolean taken, double final_grade){
        this.prereqs=prereqs;
        this.taken= taken;
        this.final_grade = final_grade;

    }
*/


    //Methods


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
    public String getCourseName(){
        return course_name;
    }

    public void setPrereqs(HashMap<String, Requirement> prereqs) {
        this.prereqs = prereqs;
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
