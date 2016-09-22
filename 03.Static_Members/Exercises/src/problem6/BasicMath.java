package problem6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BasicMath {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            while (true){
                String input = reader.readLine();
                if ("End".equals(input)){
                    break;
                }

                String[] params = input.split("\\s+");
                String operation = params[0];
                double first = Double.parseDouble(params[1]);
                double second = Double.parseDouble(params[2]);
                double result = 0;
                switch (operation){
                    case "Sum":
                        result = MathUtil.add(first,second);
                        break;
                    case "Multiply":
                        result = MathUtil.multiply(first,second);
                        break;
                    case "Percentage":
                        result = MathUtil.percentage(first,second);
                        break;
                    case "Subtract":
                        result = MathUtil.subtract(first,second);
                        break;
                    case "Divide":
                        result = MathUtil.divide(first,second);
                        break;
                }

                System.out.printf("%.2f%n",result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class MathUtil {

    public static double add(double first, double second) {
        return first + second;
    }

    public static double multiply(double first, double second) {
        return first * second;
    }

    public static double subtract(double first, double second) {
        return first - second;
    }

    public static double divide(double first, double second) {

        return first / second;
    }

    public static double percentage(double first, double second){
        return first * (second / 100);
    }

}
