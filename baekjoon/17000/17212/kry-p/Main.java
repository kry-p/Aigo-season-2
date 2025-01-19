import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[100000 + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        dp[4] = 2;
        dp[5] = 1;
        dp[6] = 2;
        for (int i = 7; i <= 100000; i++) 
            dp[i] = Math.min(dp[i - 7] + 1, Math.min(dp[i - 5] + 1, Math.min(dp[i - 2] + 1, dp[i - 1] + 1)));
        System.out.print(dp[n]);
    }
}