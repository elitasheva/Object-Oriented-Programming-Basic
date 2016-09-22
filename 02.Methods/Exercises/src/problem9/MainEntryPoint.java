package problem9;


import com.sun.org.apache.bcel.internal.classfile.ClassFormatException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class MainEntryPoint {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String[] input = reader.readLine().split("\\s+");
            Map<Integer, List<String>> data = getData(input);

            for (Map.Entry<Integer, List<String>> integerListEntry : data.entrySet()) {

                System.out.printf("%d - %s%n", integerListEntry.getKey(), integerListEntry.getValue().stream().collect(Collectors.joining(", ")));
            }

            Class<?> pizzaClass = Pizza.class;
            java.lang.reflect.Method[] methods = pizzaClass.getDeclaredMethods();
            List<java.lang.reflect.Method> checkedMethods = Arrays.stream(methods)
                    .filter(m -> m.getReturnType().getName().contains("Map")).collect(Collectors.toList());

            if (checkedMethods.size() < 1) {
                throw new ClassFormatException();
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Map<Integer, List<String>> getData(String... inputStrings) {

        Map<Integer, List<String>> data = new HashMap<>();
        List<Pizza> pizzas = new ArrayList<>();
        Pattern pattern = Pattern.compile("(\\d+)([^\\s]+)");
        for (String current : inputStrings) {

            Matcher match = pattern.matcher(current);
            if (match.find()) {

                int group = Integer.parseInt(match.group(1));
                String name = match.group(2);
                if (!data.containsKey(group)) {
                    data.put(group, new ArrayList<>());
                }
                data.get(group).add(name);
                pizzas.add(new Pizza(name, group));

            }
        }

        return data;
    }

}

class Pizza {

    private String name;
    private int group;

    public Pizza(String name, int group) {
        this.name = name;
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }
}
