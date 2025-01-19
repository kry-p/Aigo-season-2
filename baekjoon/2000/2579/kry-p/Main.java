import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] map = new int[300 + 1];
        int[] dp = new int[300 + 1];
        for (int i = 1; i <= n; i++) map[i] = Integer.parseInt(reader.readLine());
        dp[1] = map[1];
        dp[2] = map[1] + map[2];
        for (int i = 3; i <= n; i++) dp[i] = Math.max(dp[i - 2], dp[i - 3] + map[i - 1]) + map[i];
        System.out.print(dp[n]);
    }
}