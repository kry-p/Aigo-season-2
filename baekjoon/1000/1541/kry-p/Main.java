import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] splitted = reader.readLine().split("-");
        int sum = Integer.MAX_VALUE;

        for (String s : splitted) {
            String[] currentTokens = s.split("\\+");
            int currentSum = 0;
            for (String token: currentTokens) 
                currentSum += Integer.parseInt(token);
            if (sum == Integer.MAX_VALUE) sum = currentSum;
            else sum -= currentSum;
        }
        System.out.print(sum);

        reader.close();
    }
}