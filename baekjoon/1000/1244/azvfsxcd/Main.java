package Algo241020;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1244 {
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
    static int[] arr;
    static int n;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		n = Integer.parseInt(br.readLine());
		
        arr = new int[n+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
        	arr[i] = Integer.parseInt(st.nextToken());
        }
        
        int k = Integer.parseInt(br.readLine());
        for(int i = 0; i < k; i++) {
        	st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            
            // 남자
            if(a==1) {
            	man(b);
            // 여자
            } else {
            	woman(b);
            }
        }
        
        for(int i = 1; i <= n; i++) {
        	if(i>=20 && (i) % 20 == 1) sb.append("\n");
        	sb.append(arr[i] + " ");
        }
        	
        System.out.println(sb);
	}
	
	public static void man(int sw) {
		int tmp = sw;
        while (tmp <= n) {
            arr[tmp] = (arr[tmp]==0?1:0);
            tmp += sw;
        }
	}
	
	public static void woman(int sw) {
		arr[sw] = (arr[sw]==0?1:0);
		int tmp = 1;
		while(true) {
			if(sw+tmp > n || sw-tmp <= 0) break;
			if(arr[sw+tmp] == arr[sw-tmp]) {
				tmp++;
			}
			else break;
		}
		for(int i=1; i < tmp; i++) {
			arr[sw+i] = (arr[sw+i]==0?1:0);
			arr[sw-i] = (arr[sw-i]==0?1:0);
		}
		
	}
}
