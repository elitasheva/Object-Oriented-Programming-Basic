package problem7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShapesVolume {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while (true) {
                String input = reader.readLine();

                if ("End".equals(input)){
                    break;
                }

                String[] params = input.split("\\s+");
                String shapeType = params[0];
                double result = 0;
                switch (shapeType) {
                    case "Cube":
                        double cubeParam = Double.parseDouble(params[1]);
                        Cube cube = new Cube(cubeParam);
                        result = Calculation.calculateVolumeOfCube(cube);
                        break;
                    case "Cylinder":
                        double firstCylParam = Double.parseDouble(params[1]);
                        double secondCylParam = Double.parseDouble(params[2]);
                        Cylinder cylinder = new Cylinder(firstCylParam, secondCylParam);
                        result = Calculation.calculateVolumeOfCylinder(cylinder);
                        break;
                    case "TrianglePrism":
                        double firstPrismParam = Double.parseDouble(params[1]);
                        double secondPrismParam = Double.parseDouble(params[2]);
                        double thirdPrismParam = Double.parseDouble(params[3]);
                        Prism prism = new Prism(firstPrismParam, secondPrismParam, thirdPrismParam);
                        result = Calculation.calculateVolumeOfPrism(prism);
                        break;

                }

                System.out.printf("%.3f%n",result);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Prism {

    private double side;
    private double height;
    private double length;

    public Prism(double side, double height, double length) {
        this.side = side;
        this.height = height;
        this.length = length;
    }

    public double getSide() {
        return side;
    }

    public double getHeight() {
        return height;
    }

    public double getLength() {
        return length;
    }
}

class Cube {

    private double length;

    public Cube(double length) {
        this.length = length;
    }

    public double getLength() {
        return length;
    }
}

class Cylinder {

    private double radius;
    private double height;

    public Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }

    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }
}

class Calculation {

    public static double calculateVolumeOfPrism(Prism prism) {
        return (prism.getSide() * prism.getHeight() * prism.getLength()) / 2;
    }

    public static double calculateVolumeOfCube(Cube cube) {
        return cube.getLength() * cube.getLength() * cube.getLength();
    }

    public static double calculateVolumeOfCylinder(Cylinder cylinder) {
        return Math.PI * cylinder.getRadius() * cylinder.getRadius() * cylinder.getHeight();
    }

}
