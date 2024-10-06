package Algo241006;

import java.util.*;
import java.lang.*;
import java.io.*;

// 효율적인 해킹
public class boj1325 {
//	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int N, M, max = Integer.MIN_VALUE;
	static List<Integer>[] list;
	static boolean[] visited = new boolean[10001];
	static int[] ans = new int[10001];

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		visited = new boolean[N + 1];
		ans = new int[N + 1];
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		String[] inputs = new String[2];

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			inputs[0] = st.nextToken();
			inputs[1] = st.nextToken();
			list[Integer.parseInt(inputs[0])].add(Integer.parseInt(inputs[1]));
		}

		for(int i = 1; i<=N; i++) {
			visited = new boolean[N+1]; 		// 계속 초기화
//			visited[i]=true;
			bfs(i);
		}

		for (int i = 1; i <= N; i++) {
			max = Math.max(max, ans[i]);
		}
		
//		System.out.println("max >> " + max);
		for (int i = 1; i <= N; i++) {
			if (max == ans[i]) {
				System.out.print(i);
				if (i != N) {
					System.out.print(" ");
				}
			}
		}
	}

	// bfs
	public static void bfs(int a) {
		Queue<Integer> q = new LinkedList<>();
		q.add(a); // 큐에 넣고
		visited[a] = true;

		while (!q.isEmpty()) {
			int idx = q.poll(); // 큐에서 빼고
//			if(visited[idx]) continue;
			
			for(int i : list[idx]) {
//			for (int i = 0; i < list[idx].size(); i++) {
				if (!visited[i]) {
					visited[i] = true;
					ans[i]++;
					q.add(i);
				}
			}
		}
	}
}
