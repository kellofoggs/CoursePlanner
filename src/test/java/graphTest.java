import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class graphTest {
    JSON_DB db;
    @BeforeEach
    private void generate_DB(){
        System.out.print("\nYO\n");
        File my_file = new File("results.json");
        db = JSON_DB.get_instance(my_file);
    }


    @Test
    @DisplayName("Correct number of course items generated")
    void test_array_size(){
        assertEquals(3547, db.getDb_size());



    }



    @Test
    void test(){
        assertTrue(true);
    }




}
