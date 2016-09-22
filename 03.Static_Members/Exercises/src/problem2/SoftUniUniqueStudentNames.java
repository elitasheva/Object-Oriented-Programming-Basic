package problem2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class SoftUniUniqueStudentNames {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            List<Student> students = new ArrayList<>();
            HashSet<String> names = new HashSet<>();
            while (true) {

                String input = reader.readLine();
                if ("End".equals(input)){
                    break;
                }

                if (names.add(input)) {
                    names.add(input);
                    Student student = new Student(input);
                    students.add(student);
                }


            }

            System.out.println(Student.count);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Student {

    public static int count;
    private String name;

    public Student(String name) {
        this.name = name;
        count++;
    }
}
