package problem1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class MainEntryPoint {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            double length = Double.parseDouble(reader.readLine());
            double width = Double.parseDouble(reader.readLine());
            double height = Double.parseDouble(reader.readLine());

            Class boxClass = Box.class;
            Field[] fields = boxClass.getDeclaredFields();
            System.out.println(Arrays.asList(fields)
                    .stream()
                    .filter(f -> Modifier.isPrivate(f.getModifiers())).count());


            try {
                Box box = new Box(length, width, height);

                double surfaceArea = box.calculateSurfaceArea();
                System.out.printf("Surface Area - %.2f%n", surfaceArea);

                double lateralSurfaceArea = box.calculateLateralSurfaceArea();
                System.out.printf("Lateral Surface Area - %.2f%n",lateralSurfaceArea);

                double volume = box.calculateVolume();
                System.out.printf("Volume - %.2f%n", volume);

            }catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
