package Algo241027;

import java.util.*;
import java.util.List;
import java.lang.*;
import java.io.*;
import java.awt.*;

public class boj1038 {
	
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int arr[];
	public static List<Long> list;
	static int N;
	static int cnt, min;
//	static int dp[];
	static int len;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));

	    // N을 입력받는다.
	    N = Integer.parseInt(br.readLine());
	    
		list = new ArrayList<Long>();

	    cnt = 0;
	    min = 10;
	    
	    // 예제3번
	    if (N > 1022) {
			System.out.println(-1);
			System.exit(0);
		}
	    
//		len = (int) (Math.log10(N)+1); 
	    
		for (int i = 1; i <= 10; i++) {
			arr = new int[i];		// 자리수에 들어갈 값
			dfs(0, arr);
		}
//	    dfs(1 , 1); 	// 현재 값 , 순서
//	    dfs(0 , 0); 	// 현재 자리값 , 현재자리수
//		Collections.sort(list);
	    
	    long answer = list.get(N);
	    sb.append(answer);
	    System.out.println(sb);
	    
//		dp = new int[N+1];
		
//		System.out.println("len : " + len );
		
//		if(len)
		
		// 1,000,000 이하..
	    // 제일 큰 수 987,654
	    // 1, 2, 3, 4, 5, 6, 7, 8, 9
	    // 10, 20, 30, 40, 50, 60, 70, 80, 90
	    // 21, 32, 31, 43, 42, 41, 54, 53, 52, 51, 65, 64, 63, 62, 61....
		/*
	    for(int i = 0; i <= 10; i++) {
	    	dp[i] = 1;
	    }
	    
	    for(int i = 11; i < N; i++) {
	    	dp[i] = dp[i-1]+dp[(i/10)];
	    }
	    
	    System.out.println(dp);
		 */
		
	    /*
	     * 1자리 
	     * 1, 2, 3, 4, 5, 6, 7, 8, 9
	     * 1 1 1 1 1 1 1 1 1
	     * 9개
	     * 
	     * 2자리
	     * 0 x
	     * 10
	     * 20 21
	     * 30 31 32
	     * 40 41 42 43
	     * 50 51 52 53 54
	     * 60 61 62 63 64 65 
	     * .....
	     * 0+1+2+3+4+5+6+7+8+9 = 45
	     * 
	     * 3자리
	     * 0 x
	     * 1 x
	     * 210
	     * 310 320 321
	     * 410 420 421 430 431 432
	     * 510 520 521 530 531 532 540 541 542 543
	     * 610 620 621 630 631 632 640 641 642 643 650 651 652 653 654
	     * .....
	     * 0+0+1+3+6+10+15+21+28+36 = 120
	     * 
	     * 4자리
	     * 0 x
	     * 1 x
	     * 2 x
	     * 3 3210
	     * 4 4210 4310 4320 4321
	     * 5 5210 5310 5320 5321 5410 5420 5421 5430 5431 5432
	     * 6 6210 6310 6320 6321 6410 6420 6421 6430 6431 6432 6510 6520 6521 6530 6531 6532 6540 6541 6542 6543
	     * ..... 
	     * 0+0+0+1+4+10+20+35+56+84 = 210
	     * 
	     * 5자리
	     * 0 1 2 3 x
	     * 0+0+0+0+1+5+15+35+70+126 = 252
	     * 
	     * 6자리
	     * 0 1 2 3 4 x
	     * 0+0+0+0+0+1+6+21+56+126 = 210
	     * 
	     * 7자리
	     * 0 ~ 5 x
	     * 0+0+0+0+0+1+7+28+84 = 120
	     * 
	     * 8자리
	     * 0 ~ 6 x
	     * 0+0+0+0+0+0+1+8+36 = 45
	     * 
	     * 9자리
	     * 0 ~ 7 x
	     * 0+0+0+0+0+0+0+1+9 = 10
	     * 
	     * 10자리
	     * 0 ~ 8 x
	     * 1
	     * 
	     * 9 45 120 210 252 210 120 45 10 1
	     * 1022개 - 9876543210
	     */
		  
	}
	
	// 재귀
	public static void dfs(int  num, int[] result) { //100 3
		// 숫자 리스트 담기
		if (num == result.length) {
			long number = 0;
			for (int i = result.length - 1; i >= 0; i--) {
				number += (Math.pow(10, result.length - 1 - i) * result[i]);
			}
			list.add(number);
			return;
		}
		
		for (int i = 0; i <= 9; i++) { 
			// 예시로 9자리 감소하는 수를 구하는데 맨 앞의 숫자가 8 미만이면 이미 틀려먹음...
			// 이전자리수 보다 작아야함
			if (result.length - num - 1 <= i 
					&& (num == 0 || (num > 0 && result[num - 1] > i))) {
				result[num] = i;
				dfs(num + 1, result);
			}
		}
	}
	
//	public static void dfs(int start, int now) {
////		if(now == 10) return;
////		
////		if (now == 0) {
////			min = 10;
////		}
//		
//		for (int i = 0; i < 10; ++i) {
//			if(start > i) {
//				
//			}
//		}
//	}
}
