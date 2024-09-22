import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i - 1]; // 이전 값 + 1이라고 가정
            for (int j = 1; j * j <= i; j++) 
                dp[i] = Math.min(dp[i], dp[i - (j * j)]); // 제곱수만큼 뺀 값의 배열 값을 참조하여 최솟값을 찾음
            dp[i] += 1; // 최솟값만 찾았으므로 구한 값에 + 1
        }
        System.out.println(dp[n]);
    }   
}
