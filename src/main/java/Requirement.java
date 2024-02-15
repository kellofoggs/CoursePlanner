import java.util.*;

public class Requirement {

    /*Attributes*/
    private String type;
    private String name;
    private String quantity;
    private boolean satisfied;



    private List<Requirement> sub_reqs;
    private List<Requirement> sub;


    public Requirement(String type, String name, String quantity, Object passed_down_sub_reqs){
//        System.out.println(passed_down_sub_reqs);
//        System.out.println("quant: " + quantity);
//        if (name == null){
//            this.quantity = "0";
//            this.type = "Head";
//        }
//        if (name != null ) {
            this.type = type;
            this.name = name;
            this.quantity = quantity;
            this.sub_reqs = new ArrayList<>();
            this.generate_sub_reqs(passed_down_sub_reqs);
//        }




    }

    private void generate_sub_reqs(Object req_list) {
        if (req_list != null){
            for (Object subreq_obj : (List) req_list) {
                Map req_map = (Map) subreq_obj;
                String type = (String) req_map.get("type");//null;
                String name = (String) req_map.get("name");//null;
                String quantity = (String) req_map.get("quantity");// null;
                Object sub_req_array = req_map.get("sub maps");//null;

                Requirement sub_req = new Requirement(type, name, quantity, sub_req_array);

                this.sub_reqs.add(sub_req);

            }
         }
        //}
    }
//    public boolean sub_reqs_satisfied(HashMap takenCourses){


    public boolean sub_reqs_satisfied(HashSet takenCourses, JSON_DB db){
        //Consider edge case with variable


        // If we're at a 'complete' or 'units' type
        double level_quantity = Double.parseDouble(this.quantity);


        if (type.equals("requirement")) {
            //Evaluate sub level
            for (Requirement sub_req : sub_reqs) {
                System.out.println(sub_req.getName() + " " + sub_req.getType());
                //Go down to bottom
                if (sub_req.sub_reqs_satisfied(takenCourses, db)) {
                    level_quantity = level_quantity - 1;
                }

                System.out.println("\n");
//
//                // If the student has taken the course
//                if ( takenCourses.contains(sub_req.getName()) ){
//                    level_quantity--;
//                    System.out.println("Student has taken: " + sub_req.getName());
//                }
            }
        }
        // course type objects do not have sub reqs, stop going down here
        if (this.type.equals("course")){

            //Instead check if the course is in the taken set
           return (takenCourses.contains(this.getName()));
//            {
//               return true;
//           }else{
//               return false;
//           }

        }

        if (level_quantity <= 0){
            return true;
        }

        if (type.equals("units")){

        }



//        For future when calculating shortest path to taking course
//        if (!type.matches("course|other")){
//            for (Requirement req: sub_reqs){
//
//            }
//        }else{
//            return true;
//        }

        return false;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public String getQuantity() {
        return quantity;
    }

    public boolean isSatisfied(HashSet takenCourses) {
        JSON_DB db = JSON_DB.getJson_db();
        return sub_reqs_satisfied(takenCourses, db);
    }
}
