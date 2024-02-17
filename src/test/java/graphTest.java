import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class graphTest {
    JSON_DB db;

    //Create a fresh database each time
    @BeforeEach
    void generate_DB(){
        File my_file = new File("C:\\Users\\Kelly\\Documents\\PersonalProjects\\CoursePlanner\\src\\main\\resources\\results.json");
        db = JSON_DB.get_instance(my_file);
    }


    @Test
    @DisplayName("Correct number of course items generated")
    void test_array_size(){
        assertEquals(3547, db.getDb_size());
    }

    @Test
    @DisplayName("Does get the a coures object from querying database")
    void get_course(){
        String expected_course_code = "ECE460";
        String expected_course_name = "Control Theory and Systems II";
        Course target = db.getCourse(expected_course_code);

        boolean is_course_name_and_desc =
                target.get_course_name().equals(expected_course_name) && target.get_course_code().equals(expected_course_code);
        assertTrue(is_course_name_and_desc);





    }
    //Tests if the 'can take course' method works by creating a transcript and object with courses taken and seeing if all
    //requirements are met
    // First column is the name, then whether or not student should be able to take course, the name of the course, then the courses taken
    @ParameterizedTest
    @CsvSource({

            "'No requirements needed (ATWP) but has some courses', 'true', 'ATWP101', 'CSC361, CSC360, CSC226'",
            "'No requirements needed (ATWP101) empty transcript' , 'true', 'ATWP101', ''",
            "'1 of first level requirements needed (LING325) --Unneeded requirement in transcript', 'true', 'LING325', 'LING181, LING100A, CSC226' ",
            "'Second level of sub requirements needed (CSC360) reqs met', 'true', 'CSC360', 'CSC225, SENG265, CSC230' ",
            "'Second level of sub requirements needed (CSC360) one branch of reqs not met', 'false', 'CSC360', 'CSC225, CSC230'"


    })
    @DisplayName("The can take course method works properly")
    void check_can_take_course(String test_case_name, boolean expected, String target_course_name, String courses_taken_string){
        String[] courses_taken_array = courses_taken_string.split(", ");

        HashSet<String> course_taken_set = new HashSet<>();
        for (String taken_course_name: courses_taken_array){
            course_taken_set.add(taken_course_name);
        }

        //Transcript my_transcript = new Transcript(course_taken_map);

        Course atwp101 = db.getCourse(target_course_name);
        //boolean expected = true;
        assertEquals(expected,atwp101.canTakeCourse(course_taken_set));

    }


    @Test
    @DisplayName("Does get the names of prereqs")
    void get_pre_reqs(){



    }




    @Test
    void test(){
        assertTrue(true);
    }




}
