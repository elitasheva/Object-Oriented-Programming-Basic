package problem3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LastDigitName {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))){

            int number = Integer.parseInt(reader.readLine());
            Number num = new Number(number);
            System.out.println(num.getLastDigit());

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Number{

    private int number;

    public Number(int number) {
        this.number = number;
    }

    public String getLastDigit(){

        int num = this.number % 10;
        switch (num){
            case 0: return "zero";
            case 1: return "one";
            case 2: return "two";
            case 3: return "three";
            case 4: return "four";
            case 5: return "five";
            case 6: return "six";
            case 7: return "seven";
            case 8: return "eight";
            case 9: return "nine";
            default: return "unknown digit";
        }
    }
}
