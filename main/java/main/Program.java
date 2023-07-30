//Kelly Ojukwu
package main;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

//A class that is a graph of the selected program
public class Program {


    private static HashMap<String, Course> stringCourseHashMap;

    public static void loadIntoMap(String name, Course course){
        stringCourseHashMap.put(name,course);

    }
    private Course[] requiredClasses;

    //Graph for a program that is generated from a formatted text file
    private Course start;
    private Course end;
    //Graph of courses
    //private Course[] requiredClasses;
    private double totalGPA;

    //Factory method to generate program object from a file
    /*
    public static Program generateProgram(String sourceURL) throws FileNotFoundException {

        File sourceFile = new File(sourceURL);
        ObjectMapper mapper = new ObjectMapper();
        Course[] requiredClasses;

        /*Scanner fileReader = new Scanner(sourceFile);
        while (fileReader.hasNextLine()){
            System.out.println(fileReader.nextLine());
        }

        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule()); // To use local date
        Program program= new Program(requiredClasses);

        try{
            requiredClasses = mapper.readValue(sourceFile, Course[].class);

            for (Course course: requiredClasses){
                System.out.println(course);



                for (String string : course.getPrereqs()) {
                    System.out.println(string);
                }
            }
        }catch (IOException e){
            System.out.println("CAUSE ");
            e.printStackTrace();
        }




        return program;

    }
*/
    private  void loadHashMap(String in, Course course){
        stringCourseHashMap.put(in, course);

    }

    public Program(String sourceURL){
        File sourceFile = new File(sourceURL);
        ObjectMapper mapper = new ObjectMapper();
        stringCourseHashMap = new HashMap<>();

        /*Scanner fileReader = new Scanner(sourceFile);
        while (fileReader.hasNextLine()){
            System.out.println(fileReader.nextLine());
        }
        */
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.registerModule(new JavaTimeModule()); // To use local date


        try{
            requiredClasses = mapper.readValue(sourceFile, Course[].class);

            for (Course course: requiredClasses){
                //System.out.println(course);

                //Load all courses into a hashmap by name
                stringCourseHashMap.put(course.toString(), course);


                for (String string : course.getPrereqs()) {
                    //System.out.println(string);
                }
            }
        }catch (IOException e){
            System.out.println("CAUSE ");
            e.printStackTrace();
        }

    }


    /*public Program(Course [] courses){
       requiredClasses = courses;

    }*/


    //Method that determines if a student can take a certain course
    public boolean canTakeCourse(Course course){

        for (String string : course.getPrereqs()){
            if (!stringCourseHashMap.get(string).isTaken() ){

                System.out.println("COURSE HAS BEEN TAKEN");
                return false;
            }
        }





        return true;
    }

    public void pathToCourseOG(Course target){
        Stack<Course> courseStack = new Stack<>();

        courseStack.push(target);
        HashSet <Course> visited = new HashSet<>();
        List< List<Course> > pathsList = new LinkedList< List<Course> >();
        pathsList.add(new LinkedList<>());
        int pathIndex = 0;

        while (!courseStack.isEmpty()){
            Course current = courseStack.pop();
            //System.out.println(current);
            if (!visited.contains(current)){
                visited.add(current);
                for (String prior : current.getPrereqs() ){
                    courseStack.push(stringCourseHashMap.get(prior));

                }






            }else{
                //System.out.println("VISITED:" + current);

            }
            if (pathsList.get(pathIndex).contains(current)){
                pathIndex++;
                pathsList.add(new LinkedList<>());

            }
            if (current != target){
            pathsList.get(pathIndex).add(current);

            }
        }

        for (List list: pathsList){
            System.out.print("Path: ");

            for (Object c : list){
                System.out.print(c+", ");
            }
        }


    }

    //Find path to course
    public LinkedList<LinkedList<Course>> pathToCourse(Course course){

        List<String> currentPrereqs = Arrays.asList(course.getPrereqs());



       // String[] currentPrereqs = course.getPrereqs();
        //Base case for recursive search for prereqs
        if (currentPrereqs.size() == 0 || currentPrereqs == null){
            return null;
        }

        return null;

    }



    public HashMap<String, Course> getStringCourseHashMap() {
        return stringCourseHashMap;
    }



}
