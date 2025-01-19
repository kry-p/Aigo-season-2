import java.io.*;
import java.util.*;

public class Main {
    private final static int MAX = 100000;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int c = Integer.parseInt(input[0]);
        int n = Integer.parseInt(input[1]);
        
        int[] cost = new int[n + 1];
        int[] customer = new int[n + 1];
        int[] dp = new int[MAX * 2]; // 범위초과 나길래 대충 여유롭게 잡았음

        int min = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            int[] current = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            cost[i] = current[0];
            customer[i] = current[1];
        }

        // dp[n] -> i원을 냈을 때 홍보할 수 있는 고객의 최댓값
        loop:
        for (int i = 1; i < MAX + 1; i++) {
            /**
             * i원을 냈을 때 고객의 최댓값은 현재 비용에서 각 도시를 홍보하는 비용을 제했을 때의 최댓값과 그 도시에서 모집되는 고객의 수
             * 모든 도시에 대해 시도했을 때의 최댓값을 갱신
             */
            for (int j = 1; j <= n; j++) 
                if (i - cost[j] >= 0)
                    dp[i] = Math.max(dp[i - cost[j]] + customer[j], dp[i]);
            if (dp[i] >= c) {
                min = i;
                break loop;
            }
        }
        System.out.print(min);
    }
}