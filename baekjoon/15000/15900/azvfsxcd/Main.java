package Algo241013;

import java.util.*;
import java.lang.*;
import java.awt.*;
import java.io.*;

// 나무탈출
public class boj15900 {
	
	static StringBuilder sb;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static ArrayList<Integer> list[];
	static int cnt = 0;			// 총 이동 거리

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		
		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);
		}
		
		dfs(1, -1, 0); // 1이 루트 노드이기 때문에 부모가 없어 -1로 부여.

		// 루트 노드에서 리프 노드까지의 깊이 합이 짝수라면 성원이가 패배하고, 홀수면은 승리
		if (cnt % 2 == 0) {
			sb.append("No");
		} else {
			sb.append("Yes");
		}
		System.out.println(sb);
	}

	static void dfs(int start, int parent, int depth) {
		// 방문 확인용 배열을 따로 만들어도 되지만 부모 노드의 값을 입력받아
		// 불일치 여부를 통해 dfs 탐색을 진행할 수도 있다.

		for (int next : list[start]) { // 8 4 2
			if (next != parent) {				// 이동 할 곳이 있는 지 체크 
				dfs(next, start, depth + 1);
			}
		}

		if (list[start].size() == 1) {
			cnt += depth; // 리프 노드라면 깊이(거리)를 더해줌.
		}
	}
	
}

