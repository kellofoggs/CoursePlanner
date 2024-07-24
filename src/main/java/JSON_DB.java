import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class JSON_DB {

    private static boolean instance_exists;
    private HashMap<String, Course > classes_map;
    private Course[] courses_array;
    private static JSON_DB json_db;
    private int db_size;
    private static ObjectMapper mapper;

    /**
     * @return: The only allowed instance of the class
     * @param json_file: a file handle to a json database
     * Singleton getter that ensures that only one database may created at a time.
     * Enforces consistency across different classes
     *
     * */
    public static JSON_DB get_instance(File json_file){
        if (json_db == null){
           json_db = new JSON_DB(json_file);


        }
        return json_db;

    }

    public static ObjectMapper get_mapper(){
        return mapper;
    }




    //Singleton Constructor
    private JSON_DB(File json_file){


        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false);
        classes_map = new HashMap<>();
        db_size = 0;
        try{
            Scanner fileReader = new Scanner(json_file);


            courses_array = mapper.readValue( json_file, Course[].class);
            for (Course current: courses_array){
                classes_map.put(current.get_course_code(), current);
            }
            db_size = classes_map.size();
            int i = 1;
        }catch (IOException e){
            System.out.println(e.toString());
        }


    }

    //Methods

    //Getters

    public static boolean isInstance_exists() {
        return instance_exists;
    }

    public HashMap<String, Course> getClasses_map() {
        return classes_map;
    }

    public Course[] getCourses_array() {
        return courses_array;
    }

    public static JSON_DB getJson_db() {
        return json_db;
    }

    public int getDb_size() {
        return db_size;
    }

    public Course getCourse(String course_code){
        return classes_map.get(course_code);

    }
    //Setters




}
