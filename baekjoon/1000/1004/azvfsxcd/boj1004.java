package Algo03.BOJ_240922;

import java.util.*;
import java.lang.*;
import java.io.*;

// 어린왕자
public class boj1004 {
	
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			// 출발점, 도착점
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// 행성 개수
			int num = Integer.parseInt(br.readLine());
			
			int ans = 0;
			
			int x,y,r;
			
			for(int i = 0 ; i < num ; i++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				
				// Math.pow = 제곱
				int a = (int) (Math.pow((x - x1), 2) + Math.pow((y - y1), 2));
				int b = (int) (Math.pow((x - x2), 2) + Math.pow((y - y2), 2));
				int r2 = (int) Math.pow(r, 2);
				
				/*
				 출발점 혹은 도착점이 하나만 원안에 들어갔을경우 선 1개를 건넘
				 점과 행성 중심거리 측정 해서 크기 비교 ( 작으면 안에 있는 것 )
				 ***** 출발점과 도착점이 둘다 원안에 있을 경우는 선 안넘어도 지나갈 수 있음
				*/
				if( a < r2 && b < r2) {
					continue;
				} else if( a < r2 ) {
					ans += 1;
				} else if( b < r2 ) {
					ans += 1;
				}
				
			}
			sb.append(ans).append("/n");
			System.out.println(ans);
		}
	}

}
