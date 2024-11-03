import java.io.*;
import java.util.*;

public class Main {
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] t = new int[n + 1];
        int[] p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            t[i] = input[0];
            p[i] = input[1];
        }
       
        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            int sum = 0;
            int currentDay = 1;
            boolean flag = true;
            String current = padLeftZeros(i, n + 1);
            while (currentDay <= n) {
                if (current.charAt(currentDay) == '0') {
                    currentDay += 1;
                } else {
                    sum += p[currentDay];
                    currentDay += t[currentDay];
                    if (currentDay > n + 1) flag = false; 
                }
            } 
            if (flag) max = Math.max(max, sum);
        }
        System.out.print(max);
    }

    private static String padLeftZeros(int number, int totalLength) {
        String formatted = Integer.toBinaryString(number);
        int length = formatted.length();
        if (length < totalLength) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < totalLength - length; i++) 
                builder.append("0");
            builder.append(formatted);
            formatted = builder.toString();
        }
        return formatted;
    }
}
