import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int p = Integer.parseInt(reader.readLine());
        while (p > 0) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int m = input[1];
            int answer = 0;
            int fibonacciCurrent = 1, fibonacciNext = 1;
            do {
                int current = fibonacciCurrent;
                fibonacciCurrent = fibonacciNext;
                fibonacciNext = (current + fibonacciNext) % m;
                answer += 1;
            } while (fibonacciCurrent != 1 || fibonacciNext != 1);

            builder.append(input[0] + " " + answer + "\n");
            p -= 1;
        }
        System.out.println(builder.toString());
    }
}