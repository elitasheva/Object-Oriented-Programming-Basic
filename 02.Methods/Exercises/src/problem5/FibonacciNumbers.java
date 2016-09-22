package problem5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FibonacciNumbers {

    public static void main(String[] args) {

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {

            int n = Integer.parseInt(reader.readLine());
            int m = Integer.parseInt(reader.readLine());
            Fibonacci fib = new Fibonacci(n, m);
            List<Long> nums = fib.getSequence();
            String result = nums.stream().map(Object::toString).collect(Collectors.joining(", "));
            System.out.println(result);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}

class Fibonacci {

    private int start;
    private int end;

    public Fibonacci(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public List<Long> getSequence() {

        List<Long> numbers = new ArrayList<>();
        numbers.add(0L);
        numbers.add(1L);
        numbers.add(1L);

        for (int i = 3; i < this.end; i++) {

            long first = numbers.get(i - 2);
            long second = numbers.get(i - 1);
            numbers.add(first + second);
        }

        List<Long> result = new ArrayList<>();
        for (int i = this.start; i < this.end; i++) {
            result.add(numbers.get(i));
        }

        return result;
    }

}
