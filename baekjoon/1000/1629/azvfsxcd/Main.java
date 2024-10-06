package Algo04.BOJ_240929;

import java.util.*;
import java.lang.*;
import java.io.*;

// 곱셈
public class boj1629 {
	
	static StringBuilder sb = new StringBuilder();
	static StringTokenizer st;
	
	static long a, b, c;
	static long result;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		a = Long.parseLong(st.nextToken());
		b = Long.parseLong(st.nextToken());
		c = Long.parseLong(st.nextToken());
		result = a;
		// 당연히 안됨
//		System.out.println((long) Math.pow(a, b) % c);

		result = Solution(a, b);	// 횟수?
		
		System.out.println(result);
	}
	
	// 이건 또 시간 초과...
	//2^101 = 2^51 * 2^50 = 2^50 * 2^50 * 2^1 
	//2^100 = 2^50 * 2^50
	static long Solution(long A, long B) {
		if(B == 1) return A % c;
		
		long sol = Solution(A, B/2);
		
		/*
			 이유를 모르겠다... 도중에 %c 를 하나 끼지 않으면 틀렸습니다가 뜸
			 홀수일때
			 return ((sol * sol) * A)% c; 
			 이럼 틀렸음
		 */
		long test =  (sol * sol) % c;
		if(B % 2 == 1) { 
			// 홀수
			return (test * A)% c;
		} else {
			// 짝수
			return test;
		}
		
	}
	
	// 이건 또 시간 초과...
	//2^101 = 2^51 * 2^50 = 2^50 * 2^50 * 2^1 
	//2^100 = 2^50 * 2^50
	/*
	static long Solution(long A, long B) {
		if(B == 1) return A % c;
		
		if(B % 2 == 1) { 
			// 홀수
			return Solution(A, B/2) * Solution(A, B/2) * A % c;
		} else {
			// 짝수
			return Solution(A, B/2) * Solution(A, B/2) % c;
		}
		
	}
	*/
	
	
	// 당연하지만 이것도 안된다... 메모리 초과 (b가 매우 크면 StackOverflowError가 나옴)
	// 2 2147483647 2147483647 이런거...
	// b를 나눠야함
	/*
	static void Solution(int cnt) {
		if(cnt == b-1) return;
		
		result *= a;
		result %= c;
		
		Solution(cnt+1);
	}
 */

}
