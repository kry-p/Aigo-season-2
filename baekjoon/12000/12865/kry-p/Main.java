import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] nk = reader.readLine().split(" ");
        int n = Integer.parseInt(nk[0]);
        int k = Integer.parseInt(nk[1]);
        
        int[][] dp = new int[n + 1][k + 1];
        int[] w = new int[n + 1];
        int[] v = new int[n + 1];
    
        for (int i = 1; i <= n; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            w[i] = input[0];
            v[i] = input[1];
        }
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= k; j++) {
                // 담을 수 있다면 담았을 때와 담지 않았을 때의 최댓값을 저장
                // 해당 물건까지 탐색하지 않은 경우 해당 물건의 가치를 제했을 때 담을 수 있는 가치와 비교
				if (w[i] <= j) dp[i][j] = Math.max(v[i] + dp[i - 1][j - w[i]], dp[i - 1][j]);
                // 무게는 남아있으나 담을 수 없는 경우 이전 값을 그대로 사용
				else dp[i][j] = dp[i - 1][j];
			}
		}
		System.out.println(dp[n][k]);
    }
}