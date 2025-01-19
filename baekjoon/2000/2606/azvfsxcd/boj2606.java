package Algo03.BOJ_240922;

import java.util.*;
import java.lang.*;
import java.io.*;

// ���̷���
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

		map = new int[n+1][n+1];				// ���� ���� ���� (1�̸� ����)
		visited = new boolean[n+1];				// �湮 ����
		
		for(int i=0; i<k; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			// ������ ����Ǹ� �ٸ��ʵ� �����
			map[a][b] = map[b][a] = 1;
		}
		
		// 1�� ��ǻ�͸� ���� ��..
		bfs(1);
		
		System.out.println(count);
	}
	
	//bfs
	public static void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a);	// ť�� �ְ�
		visited[a] = true;
		
		while(!q.isEmpty()) {
			int idx = q.poll();		// ť���� ����
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
