package problem4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumberInReversedOrder {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            String input = reader.readLine();
            DecimalNumber num = new DecimalNumber(input);
            System.out.println(num.reverse());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class DecimalNumber{

    private String number;

    public DecimalNumber(String number) {
        this.number = number;
    }

    public String reverse(){
        return new StringBuilder(this.number).reverse().toString();
    }
}
