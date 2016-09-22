package problem10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FamilyTree {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String searchedPerson = reader.readLine();
            List<String> inputs = new ArrayList<>();
            LinkedHashMap<String, Person> personByDate = new LinkedHashMap<>();
            LinkedHashMap<String, Person> personByFullName = new LinkedHashMap<>();
            Pattern pattern = Pattern.compile("^([\\w]+)\\s([\\w]+)\\s([\\d\\/]+)$");

            while (true) {

                String input = reader.readLine();
                if ("End".equals(input)) {
                    break;
                }
                Matcher match = pattern.matcher(input);
                if (match.find()) {
                    String firstName = match.group(1);
                    String lastName = match.group(2);
                    String date = match.group(3);
                    Person currentPerson = new Person(firstName, lastName, date);
                    personByDate.put(date, currentPerson);
                    String fullName = firstName + " " + lastName;
                    personByFullName.put(fullName, currentPerson);

                } else {
                    inputs.add(input);
                }
            }

            Pattern pattern1 = Pattern.compile("^([\\w]+)\\s([\\w]+)\\s-\\s([\\w]+)\\s([\\w]+)$");
            Pattern pattern2 = Pattern.compile("^([\\w]+)\\s([\\w]+)\\s-\\s([\\d\\/]+)$");
            Pattern pattern3 = Pattern.compile("^([\\d\\/]+)\\s-\\s([\\w]+)\\s([\\w]+)$");
            Pattern pattern4 = Pattern.compile("^([\\d\\/]+)\\s-\\s([\\d\\/]+)$");

            for (String input : inputs) {

                Matcher match = pattern1.matcher(input);
                Person parent = null;
                Person child = null;
                if (match.find()) {

                    String firstFullName = match.group(1) + " " + match.group(2);
                    String secondFullName = match.group(3) + " " + match.group(4);
                    parent = personByFullName.getOrDefault(firstFullName,null);
                    child = personByFullName.getOrDefault(secondFullName,null);
                }

                match = pattern2.matcher(input);
                if (match.find()) {

                    String fullName = match.group(1) + " " + match.group(2);
                    String date = match.group(3);
                    parent = personByFullName.getOrDefault(fullName,null);
                    child = personByDate.getOrDefault(date,null);
                }

                match = pattern3.matcher(input);
                if (match.find()) {

                    String date = match.group(1);
                    String fullName = match.group(2) + " " + match.group(3);
                    parent = personByDate.getOrDefault(date,null);
                    child = personByFullName.getOrDefault(fullName,null);
                }

                match = pattern4.matcher(input);
                if (match.find()) {
                    String dateParent = match.group(1);
                    String dateChild = match.group(2);
                    parent = personByDate.getOrDefault(dateParent,null);
                    child = personByDate.getOrDefault(dateChild,null);

                }

                if (parent != null){
                    parent.getChildren().add(child);
                }
                if (child != null){
                    child.getParents().add(parent);
                }
            }

            Person last = null;

            if (Character.isDigit(searchedPerson.charAt(0))) {

                last = personByDate.get(searchedPerson);
            } else {
                last = personByFullName.get(searchedPerson);
            }

            System.out.println(last.toString());
            System.out.println("Parents:");
            for (Person person : last.getParents()) {
                System.out.println(person.toString());
            }
            System.out.println("Children:");
            for (Person person : last.getChildren()) {
                System.out.println(person.toString());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

class Person {
    private String firstName;
    private String lastName;
    private String date;
    private List<Person> parents;
    private List<Person> children;

    public Person(String firstName, String lastName, String date) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.date = date;
        this.parents = new ArrayList<>();
        this.children = new ArrayList<>();
    }

    public List<Person> getParents() {
        return parents;
    }

    public List<Person> getChildren() {
        return children;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s", this.firstName, this.lastName, this.date);
    }
}
