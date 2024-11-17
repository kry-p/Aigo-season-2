package Algo241013;

import java.util.*;
import java.lang.*;
import java.awt.*;
import java.io.*;

// 서울 지하철 2호선
public class boj16947 {
	
	static StringBuilder sb;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	//모든 정점의 순환선에 대한 거리를 출력
	static int n;
//	static boolean[] cycle;		// 사이클 노드 저장
	static ArrayList<Integer>[]	list;		// 간선
	static boolean[] visited;
	static int[] pre;			// 이전 방문했던 노드들(사이클 찾을 때 사용)
//	static boolean hasCycle;
//	static int[] dist;
    static Queue<Integer> q = new ArrayDeque<>();

	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		br = new BufferedReader(new InputStreamReader(System.in));
		sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		list = new ArrayList[n + 1];
		pre = new int[n+1];
		
		// 사이클에 속하지 않는 노드를 -1로 채우고
		// 속하면 0으로 채울 예정
		Arrays.fill(pre, -1);
		 
		 for(int i = 1 ; i <= n; i++) {
			 list[i] = new ArrayList<>();
		 }

		for(int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
		}
		
		// 사이클 체크 
        for(int i = 1 ; i <= n ; i ++) {
            visited = new boolean[n+1];
            dfs(i, 1, i);
        }
        
        // 사이클에 포함되지 않을 경우 가까운 노드는 1을 기준
        bfs();

        for(int i = 1 ; i <= n ; i ++) {
        	sb.append(pre[i]).append(" ");
        }

        System.out.print(sb);
		
	}

	
	private static void dfs(int cur, int cnt, int start) {
        // 방문
		visited[cur] = true;

        for(int next: list[cur]) {
            // 다음노드를 방문하지 않았다면
            if(!visited[next]) {
            	dfs(next, cnt+1, start);
            }
            // 다음노드를 방문했다면 
            else if(next == start && cnt > 2) {
                // 사이클 표시
                pre[next] = 0;
                q.add(next);
                return;
            }
        }
    }

	// 사이클이 아닐때 거리 체크
    private static void bfs() {
    	
        while(!q.isEmpty()) {
            int cur = q.poll();

            for(int next: list[cur]) {
                // 사이클이 아닌 노드라면
                if(pre[next] == -1) {
                    pre[next] = pre[cur] + 1;
                    q.add(next);
                }
            }
        }
    }
}