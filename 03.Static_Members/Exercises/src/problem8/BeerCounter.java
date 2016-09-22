package problem8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class BeerCounter {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            while (true) {
                String input = reader.readLine();
                if ("End".equals(input)){
                    break;
                }

                String[] params = input.split("\\s+");
                int boughtBeers = Integer.parseInt(params[0]);
                int drinkedBeers = Integer.parseInt(params[1]);
                Beer.addBeers(boughtBeers);
                Beer.drinkBeer(drinkedBeers);
            }

            System.out.println(Beer.getBeersInStock() + " " + Beer.getBeersDrinked());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Beer {
    private static int beersInStock;
    private static int beersLeft;
    private static int beersDrinked;

    static {
        beersInStock = 0;
        beersLeft = 0;
        beersDrinked = 0;
    }

    public static void addBeers(int beer) {
        beersInStock += beer;
    }

    public static void drinkBeer(int beer) {
        beersInStock -= beer;
        beersDrinked += beer;
        beersLeft = beersInStock - beersDrinked;
    }

    public static int getBeersInStock() {
        return beersInStock;
    }

    public static int getBeersLeft() {
        return beersLeft;
    }

    public static int getBeersDrinked() {
        return beersDrinked;
    }
}