package Algo04.BOJ_240929;

import java.util.*;
import java.lang.*;
import java.io.*;

// 재귀의 귀재
public class boj4779 {
	static StringBuilder sb = new StringBuilder();
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());

		for(int i = 0 ; i < N; i++) {
			cnt = 0;
			sb.append(isPalindrome(br.readLine()) + " " + cnt + "\n");
		}
		
		System.out.println(sb);
	}

	// 이거 답을 왜 주는거지..?
	public static int recursion(String s, int l, int r){
		cnt++;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
	
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
}
