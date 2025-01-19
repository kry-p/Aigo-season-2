package Algo03.BOJ_240922;

import java.util.*;
import java.lang.*;
import java.io.*;

// �����
public class boj1004 {
	
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc = 1 ; tc <= T ; tc++) {
			
			st = new StringTokenizer(br.readLine(), " ");
			
			// �����, ������
			int x1 = Integer.parseInt(st.nextToken());
			int y1 = Integer.parseInt(st.nextToken());
			int x2 = Integer.parseInt(st.nextToken());
			int y2 = Integer.parseInt(st.nextToken());
			
			// �༺ ����
			int num = Integer.parseInt(br.readLine());
			
			int ans = 0;
			
			int x,y,r;
			
			for(int i = 0 ; i < num ; i++) {
				
				st = new StringTokenizer(br.readLine(), " ");
				
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				r = Integer.parseInt(st.nextToken());
				
				// Math.pow = ����
				int a = (int) (Math.pow((x - x1), 2) + Math.pow((y - y1), 2));
				int b = (int) (Math.pow((x - x2), 2) + Math.pow((y - y2), 2));
				int r2 = (int) Math.pow(r, 2);
				
				/*
				 ����� Ȥ�� �������� �ϳ��� ���ȿ� ������� �� 1���� �ǳ�
				 ���� �༺ �߽ɰŸ� ���� �ؼ� ũ�� �� ( ������ �ȿ� �ִ� �� )
				 ***** ������� �������� �Ѵ� ���ȿ� ���� ���� �� �ȳѾ ������ �� ����
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
