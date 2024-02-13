import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class graphTest {
    JSON_DB db;

    //Create a fresh database each time
    @BeforeEach
    private void generate_DB(){
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
    @Test
    void check_can_take_course(){
        HashMap<String, String> course_taken_map = new HashMap<>();

        Transcript my_transcript = new Transcript(course_taken_map);

//        Course csc360 = db.getCourse("CSC360");
        Course atwp101 = db.getCourse("ATWP101");
        boolean expected = true;
        assertEquals(expected,atwp101.canTakeCourse(my_transcript.getCoursesTaken()));

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
