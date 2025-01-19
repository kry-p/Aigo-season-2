package Algo04.BOJ_240929;

import java.util.*;
import java.lang.*;
import java.io.*;

// 칸토어 집합
public class boj25501 {
	static StringBuilder sb;// = new StringBuilder();

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		int k;
		String test;
		
		while((test = (br.readLine())) != null) {
			
			// 이거 여기서 초기화 시키는거 까먹어서 오래걸렸다...
			sb = new StringBuilder();
			
			int k = Integer.parseInt(test);
			int len = (int) Math.pow(3, k);
			//System.out.println("len : " + len);
			for(int i = 0; i < len; i++) {
				sb.append("-");
			}

			// 시작 지점과 길이 값 - 시작지점 없으니까 나눠도 재귀를 만들수가없네
			Solution(0, len); 

			System.out.println(sb);
		}
				
	}

	// 이거 좀 많이 헷갈리네...
	public static void Solution(int start, int size) {
//		System.out.println("start : " + start);
//		System.out.println("size : " + size);
		
		// 길이가 1 되면 종료
		if(size == 1) {
			return;
		}
		
		
		// 3등분용 길이
		int small = size/3;
		
		// 빈값으로 다시 변경 "-" >> ""
		// 문자열 교체 setCharAt()
		for(int i = start + small; i < start+small+small; i++) {
			sb.setCharAt(i, ' ');
		}
		
		Solution(start, small);
//		Solution(); // 어차피 중앙은 빈값
		Solution(small+small+start, small);
	
		
	}
	
}
