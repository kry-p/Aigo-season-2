package Algo03.BOJ_240922;

import java.util.*;
import java.lang.*;
import java.io.*;

public class boj1010 {
	
	static StringBuilder sb = new StringBuilder();
    static int[][] dp = new int[31][31];

    public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        for(int i=0; i<n; i++){
            String[] arr = br.readLine().split(" ");
            int N = Integer.parseInt(arr[0]);
            int M = Integer.parseInt(arr[1]);
            
            sb.append(String.valueOf(result(M,N)));
            sb.append("\n");
            
        }
        System.out.println(sb);
    }
    
    public static int result(int n, int r) {
        // 이미 계산된 값
        if (dp[n][r] > 0) {
            return dp[n][r];
        }
        // 원소의 갯수가 조합의 갯수와 동일하거나 0일 경우
        else if (n == r || r == 0) {
            return dp[n][r] = 1;
        } else {
            return dp[n][r] = result(n - 1, r - 1) + result(n - 1, r);
        }
    }

}
