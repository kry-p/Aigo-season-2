package Algo241013;

import java.util.*;
import java.lang.*;
import java.awt.*;
import java.io.*;

// 연산자 끼워넣기
public class boj14888 {
	
	static StringBuilder sb;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N;
	static int[] arr;
	static int[] oper;
	static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int A;
	static int[] B;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		sb = new StringBuilder();
		arr = new int[N];				// 숫자
		oper = new int[4];				// 계산식 개수 + - * / 
		
		for(int i = 0 ; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		B = new int[N-1];

		for(int i = 0 ; i < 4; i++) {
			oper[i] = Integer.parseInt(st.nextToken());	
		}
		
		// ************ 입력값 ****************
		
		test(0);
		
		// *********** 출력 *************
		sb.append(max).append("\n").append(min);
		System.out.println(sb);
	}
	
	private static void test(int n) {
		// 모든 경우의 수를 전부 갔을 때 
		if(n==N-1) {
			A = cal();
			max = Math.max(A, max);
			min = Math.min(A, min);
			return;
		}
		// + - * / 
		for(int i = 0 ; i < 4; i++) {
			if(oper[i]==0) continue;
			oper[i]--; 
			B[n]=i;			// + - * / 
			test(n+1);
			// 원복
			oper[i]++;
			B[n]=0;
		}
		
	}

	// 계산 값 출력 
	private static int cal() {
		
		int a = arr[0];
		
		for(int i=0; i<N-1; i++) {
			a = cal2(a,i,arr[i+1]);
		}
		
		return a;
	}

	private static int cal2(int f, int i, int b) {
		if(B[i]==0) {				// 더하기
			return f+b;
		} else if(B[i]==1) {		// 빼기
			return f-b;
		} else if(B[i]==2) {		// 곱하기
			return f*b;
		} else {					// 나누기
			return f/b;
		}
	}
	
}

