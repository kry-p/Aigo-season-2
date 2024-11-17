package Algo241027;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.*;

public class boj1051 {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static int n, m;
	static int[][] arr;
	static int max;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		sb = new StringBuilder();
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		max = (n>=m ? n : m);
		
		arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }
        
        int answer = 1;
        
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < m; j++) {
				// k 길이
				for(int k = 1; k <= max; k++) {
					
					if(i+k >= n || j+k >= m) continue;
					
					int a = arr[i][j];
					int b = arr[i+k][j];
					int c = arr[i][j+k];
					int d = arr[i+k][j+k];
					if(a == b && a == c && a == d) {
						answer = Math.max(answer, (k+1)*(k+1));
					}
				}
			}
		}
		
		sb.append(answer);
		System.out.println(sb);
		
	}
}
