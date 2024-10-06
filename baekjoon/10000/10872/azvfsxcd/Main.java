package Algo04.BOJ_240929;

import java.util.*;
import java.lang.*;
import java.io.*;

public class boj10872 {
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		sb.append(fec(N));
		
		System.out.println(sb);
	}

	// 팩토리얼 >> 1부터 n까지의 모든 자연수의 곱
	private static int fec (int n) {
		if(n==1 || n==0) {
			return 1;
		}
		
		return fec(n-1) * n;
	}
}
