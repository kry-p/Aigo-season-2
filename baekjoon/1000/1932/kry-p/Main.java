import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n + 1][n + 1];
        int[][] dp = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= i; j++) map[i][j] = input[j - 1];
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (j == 1) dp[i][j] = dp[i - 1][j] + map[i][j];
                else if (j == i) dp[i][j] = dp[i - 1][j - 1] + map[i][j];
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1]) + map[i][j];
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) max = Math.max(max, dp[n][i]);
        System.out.print(max);
        reader.close();
    }
}