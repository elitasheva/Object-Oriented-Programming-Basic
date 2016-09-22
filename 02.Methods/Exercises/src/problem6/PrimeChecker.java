package problem6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeChecker {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int input = Integer.parseInt(reader.readLine());
            Number num = new Number(input);
            Number next = num.findNext();

            System.out.println(next.getNumber() + ", " + num.getPrime());

//            Field[] fields = Number.class.getDeclaredFields();
//
//            List<Field> filedsDeclared = Arrays.stream(fields)
//                    .filter(f -> f.getName().contains("prime") || f.getName().contains("number"))
//                    .collect(Collectors.toList());
//
//            List<Constructor<?>> constructors = Arrays.stream(Number.class.getDeclaredConstructors())
//                    .filter(c -> c.getParameterCount() > 1)
//                    .collect(Collectors.toList());
//
//            if (filedsDeclared.size() <= 1 || constructors.size() < 1 ) {
//                throw new ClassFormatException();
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Number {

    private Integer number;
    private Boolean prime;

    public Number(Integer number) {
        this.number = number;
        this.prime = isPrime(this.number);
    }

    public Integer getNumber() {
        return number;
    }

    public Boolean getPrime() {
        return prime;
    }

    private Boolean isPrime(Integer number) {
        if (number == 0 || number == 1) {
            return true;
        }

        for (int i = 2; i < number; i++) {

            if (number % i == 0 && i != number) {
                return false;
            }
        }

        return true;
    }

    public Number findNext() {

        Integer num = 0;

        for (int i = number + 1; i < 2 * (number + 1); i++) {

            if (isPrime(i)) {

                num = i;
                break;
            }
        }

        return new Number(num);
    }
}
