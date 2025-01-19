package Algo241006;

import java.util.*;
import java.lang.*;
import java.awt.*;
import java.io.*;

// 짝 정하기
public class boj2599 {
	static StringBuilder sb;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int[][] list;	// 0 : 남자, 1 : 여자
	static int[][] result;	
	static int N, M;
	static boolean ck;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		N = Integer.parseInt(br.readLine());
		ck = true;		
		list = new int[3][2];		// 학교[3]성별[2]
		
		for(int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			list[i][0] = Integer.parseInt(st.nextToken()); 
			list[i][1] = Integer.parseInt(st.nextToken()); 
		}
		
		// 이게 맞나... 모든 경우의 수 체크
		// ax ay
		// bx by
		// cx cy
//		for(int i = 0; i = list[0][0]; i++)
		int ax = list[0][0];	// a학교 남자
		int ay = list[0][1];	// a학교 여자
		int bx = list[1][0];	// b학교 남자
		int by = list[1][1];	// b학교 여자
		int cx = list[2][0];
		int cy = list[2][1];
		
//		if(ax != by+cy) ck = false; 
//		if(bx != ay+cy) ck = false; 
//		if(cx != ay+by) ck = false; 
//		
//		if(ay != bx+cx) ck = false; 
//		if(by != ax+cx) ck = false; 
//		if(cy != ax+bx) ck = false; 

		// ab a학교남자 b학교여자 
		// ac a학교남자 c학교여자
		// ba b학교남자 a학교여자....
		int ab = 0, ac = 0, ba = 0, bc = 0, ca = 0, cb = 0;
		
		// 만나는 값
//		result = new int[3][2];
		
		for(int i = 0 ; i <= ax ; i++) {
			// i = ax가 by랑 만나는 값
			// 저 값이 바뀜에 따라 모든 경우의 수가 바뀜
			ab = i;
			ac = ax - i;	// a학교 남자에서 ab값을 뺀거
			bc = cy - ac;	// c학교 여자에서 ac값을 뺀거 
			ba = bx - bc;	// b학교 남자에서 bc값을 뺀거 
			ca = ay - ba;	// a학교 여자에서 ba값을 뺀거 
			cb = cx - ca;	// c학교 남자에서 ca값을 뺀거 
			
			if(ab >= 0 && ac >= 0
					&& ba >= 0 && bc >= 0
					&& ca >= 0 && cb >= 0) {
				ck = false;
				break;
			}
		}
		
		if (!ck) {
			System.out.println("1");
			System.out.println(ab + " " + ac);
			System.out.println(ba + " " + bc);
			System.out.println(ca + " " + cb);
		} else {
			System.out.println("0");
		}
	
	}


}
