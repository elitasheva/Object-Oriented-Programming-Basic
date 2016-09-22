package problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SoftUniStudents {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){
            List<Student> students = new ArrayList<>();
            while (true){

                String input = reader.readLine();

               if ("End".equals(input)){
                   break;
               }
                Student current = new Student(input);
                students.add(current);
            }

            System.out.println(Student.count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Student{

    public static int count;
    private String name;

    public Student(String name) {
        this.name = name;
        count++;
    }
}
