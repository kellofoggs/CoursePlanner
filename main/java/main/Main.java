package main;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        //Course cs100 = new Course();
        //cs100.setTaken(true);
        //Course cs200 = new Course(new String[]{cs100}, false, 85);

        Program program = new Program("CompSci.json");
        //System.out.println(program.getStringCourseHashMap().get("CS200"));
        //System.out.println(program.getStringCourseHashMap().get("CS120"));

        System.out.println(program.canTakeCourse(program.getStringCourseHashMap().get("CS200")));
        //program.pathToCourseOG(program.getStringCourseHashMap().get("CS210"));
        //.generateProgram("CompSci.json");
        /*Program compscifirsttwo = new Program(
                new Course[]{

                        new Course("CSC110", null),
                        new Course("CSC 115", new Course[]{new Coures("CSC")}

                }



        );*/

    }
}
