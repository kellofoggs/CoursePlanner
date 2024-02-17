import java.util.HashMap;

public class Transcript {

    // Map that has taken courses along with grade of course
    private HashMap<String, String> coursesTaken;
    //Grade point average
    private double gpa;


    public Transcript(HashMap coursesTaken){
        this.coursesTaken = coursesTaken;



    }

    //Getters
    public HashMap<String, String> getCoursesTaken() {
        return coursesTaken;
    }

    public double getGpa() {
        return gpa;
    }
}
