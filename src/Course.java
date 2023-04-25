public class Course {
    //Directed graph
    //Attributes
    private String name;
    private boolean taken;
    private Course[] prereqs;
    private double final_grade;


    //Constructor
    public Course(){

    }

    public Course(Course[] prereqs, boolean taken, double final_grade){
        this.prereqs=prereqs;
        this.taken= taken;
        this.final_grade = final_grade;

    }


    public Course(String name, Course[] prereqs){
        this.name = name;
        this.prereqs=prereqs;

    }
    //Methods

    public boolean isTaken() {
        return taken;
    }

    public void setTaken(boolean taken) {
        this.taken = taken;
    }

    public Course[] getPrereqs() {
        return prereqs;
    }

    public void setPrereqs(Course[] prereqs) {
        this.prereqs = prereqs;
    }

    public double getFinal_grade() {
        return final_grade;
    }

    public void setFinal_grade(double final_grade) {
        this.final_grade = final_grade;
    }
}
