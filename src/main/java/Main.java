import java.io.File;
import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File my_file = new File("results.json");
        JSON_DB db = JSON_DB.get_instance(my_file);

    }
}
