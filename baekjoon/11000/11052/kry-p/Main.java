import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] array = new int[n + 1];
        int[] dp = new int[n + 1];
        int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 1; i <= n; i++) array[i] = input[i - 1];
        dp[1] = array[1];
        for (int i = 2; i <= n; i++) {
            int currentMax = 0;
            for (int j = 1; j <= i - 1; j++) 
                currentMax = Math.max(currentMax, dp[j] + dp[i - j]);
            dp[i] = Math.max(array[i], currentMax);
        }
        // 1개 살 때 => P1 -> DP[1]
        // 2개 살 때 => max(P2, P1 + P1) -> DP[2]
        // 3개 살 때 => max(P3, P2 + P1, P1 + P1 + P1) -> DP[3]
        // 4개 살 때 => max(P4, P3 + P1, P2 + P1 + P1, P2 + P2, P1 + P1 + P1 + P1)

        System.out.print(dp[n]);
    }
}