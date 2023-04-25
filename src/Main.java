public class Main {
    public static void main(String[] args) {
        Course cs100 = new Course();
        cs100.setTaken(true);
        Course cs200 = new Course(new Course[]{cs100}, false, 85);

        Program compscifirsttwo = new Program(
                new Course[]{

                        new Course("CSC110", null),
                        new Course("CSC 115", new Course[]{new Coures("CSC")}

                }



        );

    }
}
