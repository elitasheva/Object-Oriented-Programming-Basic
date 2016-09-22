package problem12;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class MainEntryPoint {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            HashMap<String, Rectangle> rectangles = new LinkedHashMap<>();
            String[] dataInput = reader.readLine().trim().split("[\\s]+");
            int inputRect = Integer.parseInt(dataInput[0]);
            int inputIntersect = Integer.parseInt(dataInput[1]);

            for (int i = 0; i < inputRect; i++) {
                String[] params = reader.readLine().trim().split("[\\s]+");
                String id = params[0].trim();
                double width = Double.parseDouble(params[1]);
                double height = Double.parseDouble(params[2]);
                double x = Double.parseDouble(params[3]);
                double y = Double.parseDouble(params[4]);
                Rectangle current = new Rectangle(id, width, height, x, y);
                rectangles.put(id, current);
            }

            for (int i = 0; i < inputIntersect; i++) {
                String[] params = reader.readLine().trim().split("[\\s]+");
                String firstId = params[0].trim();
                String secondId = params[1].trim();

                Rectangle firstRect = rectangles.get(firstId);
                Rectangle secondRect = rectangles.get(secondId);
                System.out.println(firstRect.intersect(secondRect));

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Rectangle {

    private String id;
    private double width;
    private double height;

    private double x;
    private double y;

    private double x2;
    private double y2;

    public Rectangle(String id, double width, double height, double x, double y) {
        this.id = id;
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.x2 = x + this.width;
        this.y2 = y + this.height;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public double getX2() {
        return x2;
    }

    public double getY2() {
        return y2;
    }

    public boolean intersect(Rectangle other) {

        return this.getX() <= other.getX2() &&
                other.getX() <= this.getX2() &&
                this.getY() <= other.getY2() &&
                other.getY() <= this.getY2();

    }
}