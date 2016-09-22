package problem3;

import problem3.models.Human;
import problem3.models.Student;
import problem3.models.Worker;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            List<Human> humans = new ArrayList<>();

           try {
               while (true){

                   String input = reader.readLine();
//                   if ("End".equals(input)){
//                       break;
//                   }

                   if (input == null || input.trim().length() == 0){
                       break;
                   }

                   String[] params = input.split("\\s+");
                   String firstName = params[0];
                   String lastName = params[1];
                   if (params.length == 3){

                       String facultyNumber = params[2];
                       Student student = new Student(firstName,lastName,facultyNumber);
                       humans.add(student);
                   }
                   if (params.length == 4){

                       Double salary = Double.valueOf(params[2]);
                       Double hours = Double.valueOf(params[3]);
                       Worker worker = new Worker(firstName,lastName,salary,hours);
                       humans.add(worker);
                   }
               }

               for (Human human : humans) {
                   System.out.println(human);
                   System.out.println();
               }

           }catch (IllegalArgumentException ex){
               System.out.println(ex.getMessage());
           }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
