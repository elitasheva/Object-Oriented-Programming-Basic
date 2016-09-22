package problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TemperatureConverters {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {

                String input = reader.readLine();
                if ("End".equals(input)) {
                    break;
                }

                String[] params = input.split("\\s+");
                int num = Integer.parseInt(params[0]);
                String units = params[1];

                if (units.equals("Celsius")) {

                    System.out.printf("%.2f Fahrenheit%n", convertCelsius(num));
                }

                if (units.equals("Fahrenheit")) {

                    System.out.printf("%.2f Celsius%n", convertFahrenheit(num));
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static double convertCelsius(int number) {

        return number * 1.8 + 32;

    }

    public static double convertFahrenheit(int number) {

        return (number - 32) / 1.8;
    }
}


