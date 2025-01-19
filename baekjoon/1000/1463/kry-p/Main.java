import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n + 1];
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            int currentMin = dp[i - 1] + 1;
            if (i % 2 == 0) currentMin = Math.min(currentMin, dp[i / 2] + 1);
            if (i % 3 == 0) currentMin = Math.min(currentMin, dp[i / 3] + 1); 
            dp[i] = currentMin;
        }
        System.out.print(dp[n]);
    }
}