import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.*;

public class Course {
    //Directed graph
    //Attributes

    /*Attributes taken straight from JSON database*/

    //The alphanumeric code of a course (i.e. CSC 110
    @JsonProperty("courseCode")
    private String course_code;

    //The plain language name of a course (i.e. Fundamentals of Programming I)
    @JsonProperty("courseName")
    private String course_name;

    //Description of what the course is all about
    @JsonProperty("courseDescription")
    private String course_description;

    //Array of how many credits the course is worth
    @JsonProperty("units")
    private String units;

    //Additional notes to consider about the course
    @JsonProperty("notes")
    private String notes;
    //Department that offers/oversees the course
    @JsonProperty("department")
    private String department;
    private Requirement prereqs;
    @JsonSetter("prereqs")
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
        sub_reqs = the_input.get("sub_maps");
        this.prereqs = new Requirement(type, name, quantity, sub_reqs);
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
        Requirement current = this.prereqs;



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
        if (this.prereqs.getName() != null) {

            double quantity = Double.parseDouble(this.prereqs.getQuantity().split("-")[0]);
            double level = quantity;
            return (this.prereqs.isSatisfied(takenCourses));

        }else{

            return true;
        }

        //When we have 'all' we want to look at the length of the sub reqs list
        //return false;
    }

    public Requirement expandedTreeWrapper( ){


        Requirement current = this.prereqs.clone();

        HashSet<Requirement> visited = new HashSet<>();

//
//        long time_before = System.nanoTime();
        this.getExpandedTree(current, visited);
//        long time_after = System.nanoTime();
//
//        long time_passed = time_after-time_before;
////        System.out.println("Before: "+time_before);
////        System.out.println("After: "+time_after);
//        System.out.println("Elapsed time in seconds: " + time_passed/1000000000);
        System.out.println(current);
        return current;

//        return prereqs;
    }

    /**
     * Recursive method that goes down sub req tree to build new sub reqs if the current requirement is a course
     * @param requirement The current requirement being looked at in the dfs progression. Can be a course, unit, 'complete' or other type
     * @param visitedSet Set that contains visited nodes for dfs
     * @return Eventually the last requirement is returned
     * */
    private Requirement getExpandedTree(Requirement requirement, HashSet<Requirement> visitedSet){


        //When we get course requirement replace that requirement's submaps with requirements of that course
        if (requirement != null ) {
            visitedSet.add(requirement);
            List<Requirement> sub_maps = requirement.getSub_reqs();
            if (requirement.getType().equals("course")) {
                String name = requirement.getName();
                Course course = JSON_DB.getJson_db().getCourse(name);
                if (course != null) {
                    sub_maps.add(course.getPrereqs());
                    requirement.setSub_reqs(sub_maps);
                }


            }


            for (Requirement child : requirement.getSub_reqs()) {
                // If the visited set does not contain the requirement, look at the requirement
                if (!visitedSet.contains(child)) {
                    getExpandedTree(child, visitedSet);
                }
            }
        }

        return requirement;

    }

    public Requirement getPrereqs() {
        return prereqs;
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
//        this.prereqs = prereqs;
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
