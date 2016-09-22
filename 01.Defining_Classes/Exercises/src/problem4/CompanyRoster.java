package problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CompanyRoster {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            List<Employee> employees = new ArrayList<>();
            int count = Integer.parseInt(reader.readLine());
            for (int i = 0; i < count; i++) {

                String[] data = reader.readLine().split("\\s+");
                Employee employee = getCurrentEmployee(data);
                employees.add(employee);
            }

            Map<String, List<Employee>> groupedEmployees = employees.stream().collect(Collectors.groupingBy(e -> e.getDepartament()));

            double maxAverage = Double.MIN_VALUE;
            String maxDepartment = null;
            for (Map.Entry<String, List<Employee>> stringListEntry : groupedEmployees.entrySet()) {

                double currentAverage = stringListEntry.getValue()
                        .stream().map(e -> e.getSalary())
                        .mapToDouble(Double::valueOf).average()
                        .getAsDouble();

                if (currentAverage > maxAverage) {
                    maxAverage = currentAverage;
                    maxDepartment = stringListEntry.getKey();
                }
            }

            System.out.printf("Highest Average Salary: %s%n", maxDepartment);
            groupedEmployees.get(maxDepartment)
                    .stream()
                    .sorted((a, b) -> Double.compare(b.getSalary(), a.getSalary()))
                    .forEach(e -> System.out.println(e.toString()));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Employee getCurrentEmployee(String[] data) {

        int count = data.length;
        double salary = 0;
        int age = 0;
        switch (count) {
            case 4:
                salary = Double.parseDouble(data[1]);
                return new Employee(data[0], salary, data[2], data[3]);
            case 5:
                Employee employee = null;
                salary = Double.parseDouble(data[1]);
                try {
                    age = Integer.parseInt(data[4]);
                    employee = new Employee(data[0], salary, data[2], data[3], age);
                }catch (Exception ex){
                    employee = new Employee(data[0], salary, data[2], data[3], data[4]);
                }
                return employee;
            case 6:
                salary = Double.parseDouble(data[1]);
                age = Integer.parseInt(data[5]);
                return new Employee(data[0], salary, data[2], data[3], data[4], age);
            default:
                return null;
        }
    }
}

class Employee {

    private String name;

    public double getSalary() {
        return salary;
    }

    private double salary;
    private String position;
    private String departament;
    private String email;
    private int age;


    public Employee(String name, double salary, String position, String departament, String email, int age) {
        this.name = name;
        this.salary = salary;
        this.position = position;
        this.departament = departament;
        this.email = email;
        this.age = age;
    }

    public Employee(String name, double salary, String position, String departament, String email) {
        this(name, salary, position, departament, email, -1);

    }

    public Employee(String name, double salary, String position, String departament, int age) {
        this(name, salary, position, departament, "n/a", age);

    }

    public Employee(String name, double salary, String position, String departament) {
        this(name, salary, position, departament, "n/a", -1);
    }


    public String toString() {
        return String.format("%s %.2f %s %d", name, salary, email, age);
    }

    public String getDepartament() {
        return departament;
    }
}
