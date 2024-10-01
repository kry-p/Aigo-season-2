package Algo03.BOJ_240922;

import java.util.*;
import java.lang.*;
import java.io.*;

// 수 정렬하기2
public class boj2751 {

	static StringBuilder sb = new StringBuilder();
    
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] sort = new int[n];
		
        for(int i = 0 ; i < n ; i++) {
            
            int num = Integer.parseInt(br.readLine());

            sort[i] = num;
        }
        
        // 배열 정렬
        Arrays.sort(sort);
        
        for(int i = 0 ; i < n ; i++) {
        	
            sb.append(sort[i]);
           
            if(i != n-1) sb.append("\n");
        }
      
		System.out.println(sb);
	}
}