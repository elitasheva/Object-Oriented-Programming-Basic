package problem14;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DrawingTool {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            String typeOfFigure = reader.readLine();
            if (typeOfFigure.equals("Square")) {

                int side = Integer.parseInt(reader.readLine());
                Figure figure = new Square(side);
                CorDraw draw = new CorDraw(figure);
                draw.drawFigure();

            }

            if (typeOfFigure.equals("Rectangle")) {

                int sideA = Integer.parseInt(reader.readLine());
                int sideB = Integer.parseInt(reader.readLine());
                Figure figure = new Rectangle(sideA,sideB);
                CorDraw draw = new CorDraw(figure);
                draw.drawFigure();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class CorDraw {

    private Figure figure;

    public CorDraw(Figure figure) {
        this.figure = figure;
    }

    public void drawFigure() {
        this.figure.draw();
    }
}

abstract class Figure {

    protected int side;

    protected Figure(int side) {
        this.side = side;
    }

    public abstract void draw();
}

class Square extends Figure {

    public Square(int side) {
        super(side);
    }

    @Override
    public void draw() {

        int dashes = this.side + 2;
        for (int i = 0; i < this.side; i++) {

            if (i == 0 || i == this.side - 1) {

                for (int j = 0; j < dashes; j++) {

                    if (j == 0 || j == dashes - 1) {
                        System.out.print("|");

                    }else {
                        System.out.print("-");
                    }
                }
            } else {

                for (int j = 0; j < dashes; j++) {

                    if (j == 0 || j == dashes - 1) {
                        System.out.print("|");

                    } else {
                        System.out.print(" ");
                    }
                }

            }
            System.out.println();
        }

    }
}

class Rectangle extends Figure {

    private int secondSide;

    public Rectangle(int side, int secondSide) {
        super(side);
        this.secondSide = secondSide;
    }

    @Override
    public void draw() {
        int dashes = this.side + 2;
        for (int i = 0; i < this.secondSide; i++) {

            if (i == 0 || i == this.secondSide - 1) {

                for (int j = 0; j < dashes; j++) {

                    if (j == 0 || j == dashes - 1) {
                        System.out.print("|");

                    } else{
                        System.out.print("-");
                    }
                }
            } else {

                for (int j = 0; j < dashes; j++) {

                    if (j == 0 || j == dashes - 1) {
                        System.out.print("|");

                    } else {
                        System.out.print(" ");
                    }
                }

            }
            System.out.println();
        }

    }
}
