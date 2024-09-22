import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int cases = Integer.parseInt(reader.readLine());
        for (int i = 0; i < cases; i++) {
            long current = Long.parseLong(reader.readLine());
            if (isPrime(current)) builder.append(current + "\n");
            else {
                while (true) {
                    current += 1;
                    if (isPrime(current)) {
                        builder.append(current + "\n");
                        break;
                    }
                }
            }
           
        }
        System.out.print(builder.toString());
    }   
    public static boolean isPrime(long number) {
        if (number == 0 || number == 1) return false;
        for(int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        return true;
    }
}