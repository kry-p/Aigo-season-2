package Algo03.BOJ_240922;

import java.util.*;
import java.lang.*;
import java.io.*;

// 바이러스
public class boj2606 {
//	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	static boolean[] visited;
	static int[][] map;
	static int n, k;
	static int count = 0;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		n = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());

		map = new int[n+1][n+1];				// 서로 연결 여부 (1이면 연결)
		visited = new boolean[n+1];				// 방문 여부
		
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// 한쪽이 연결되면 다른쪽도 연결됨
			map[a][b] = map[b][a] = 1;
		}
		
		// 1번 컴퓨터만 세면 됨..
		bfs(1);
		
		System.out.println(count);
	}
	
	//bfs
	public static void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a);	// 큐에 넣고
		visited[a] = true;
		
		while(!q.isEmpty()) {
			int idx = q.poll();		// 큐에서 빼고
			for(int i=1; i<=n; i++) {
				if(map[idx][i] == 1 && !visited[i]) {
					visited[i] = true;
					count++;
					q.add(i);
				}
			}
		}
	}
}
