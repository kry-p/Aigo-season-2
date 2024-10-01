package Algo03.BOJ_240922;

import java.util.*;
import java.lang.*;
import java.io.*;

// Four Squares
public class boj17626 {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n = Integer.parseInt(br.readLine());

		int[] dp = new int[50001];
	    
	    dp[0]  = 0;
	    dp[1]  = 1;		// 1
	    dp[2]  = 2; 	// 1 1 		
	    dp[3]  = 3; 	// 1 1 1 	

	    dp[4]  = 1; 	// 2		
	    dp[5]  = 2; 	// 2 1		
	    dp[6]  = 3; 	// 2 1 1	
	    dp[7]  = 4; 	// 2 1 1 1	
	    dp[8]  = 2; 	// 2 2		

	    /*
	    dp[9]  = 1; 	// 3
	    dp[10] = 2;		// 3 1
	    dp[11] = 3;		// 3 1 1
	    dp[12] = 3;		// 2 2 2		// �̰Ŷ��� �ݷ� ����... ���� ���ſ� ���ϴ°� �ȵ�
	    				
	    dp[13] = 2;		// 3 2
	    dp[14] = 3;		// 3 2 1
	    dp[15] = 4;		// 3 2 1 1
	    
	    dp[16] = 1;		// 4
	    dp[17] = 2;		// 4 1
	    dp[18] = 3;		// 4 1 1
	    dp[19] = 4;		// 4 1 1 1
	    dp[20] = 2;		// 4 2
	    dp[21] = 3;		// 4 2 1
	    dp[22] = 4;		// 4 2 1 1
	    dp[23] = 5;		// 3 3 2 1, 4 2 1 1 1	// ���⵵ �ݷ�... �ٽ� Ǯ��
	    */

	    for(int i = 1 ; i < 50001; i++) {
	    	// �̰� �ȳ־ Math.min���� ��� �Ѿ��
	    	dp[i] = i;
	    	
	    	// ��� ����� ���� �� ����� ������ ( ������ �������� �� �������� ���� ex : 12, 23)
	    	for(int j = 1; j*j <= i; j++) {
//	    		for(int j = 1; j < 224; j++) {					// �迭 ���� ������
	    		dp[i] = Math.min(dp[i], dp[i-(j*j)]+1);			// + 1 ������� : +1, +4, +9, +16... ������ �ϳ��� 
	    	}
	    }
	    
	    // 1 1 2 3 5 8 13 21 34 55 89
	    
	    
	    
//	    for(int i = 2; i < 224; i++) {
//	    	int test = (int) Math.pow(i , 2);
//	    	for(int j = 4; j < 50001; j++) {
//	    		if(test > j) return;
//	    		if(dp[j] > dp[j-test] + dp[test]) {
//	    			dp[j] = dp[j-test] + dp[test];	    		
//	    		}
//	    	}
//	    }
	    
	    System.out.println(dp[n]);
		
	}
}
