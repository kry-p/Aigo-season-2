package Algo04.BOJ_240929;

import java.util.*;
import java.lang.*;
import java.io.*;


// 색종이 만들기
public class boj2630 {

	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int N;
	static int[][] arr;
	static int white, blue;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N][N];
		white = 0; blue = 0;
		
		for(int i = 0 ; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 재귀
		Solution(0,0,N);		// 시작점 x,y, 길이
		
		System.out.println(white);
		System.out.println(blue);
		
	}
	
	// 재귀
	static void Solution(int startx, int starty, int len) {
		// 길이가 1일때 리턴
		if(len == 1) {
			wbck(arr[startx][starty]);
			return;
		}
		
		// 정사각형 체크
		if(ck(startx, starty, len)) return;
		
		int length = len/2;
		
		// 4등분
		Solution(startx, starty, length);
		Solution(startx+length, starty, length);
		Solution(startx, starty+length, length);
		Solution(startx+length, starty+length, length);
		
	}
	
	// 색칠 count
	static void wbck(int n) {
		if(n==0) white++;
		else blue++;
	}
	
	// 정사각형 체크
	static boolean ck(int startx, int starty, int len) {
		int n = arr[startx][starty];
		for(int i = startx; i  < startx + len; i++) {
			for(int j = starty; j < starty + len; j++) {
				if(n != arr[i][j]) return false;
			}
		}
		
		wbck(n);
		
		return true;
	
	}
	
}



