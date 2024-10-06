package Algo241006;

import java.util.*;
import java.lang.*;
import java.awt.*;
import java.io.*;

// 섬의 개수
public class boj4963 {
	static StringBuilder sb;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int w, h;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1, 1, 1, -1, -1 };
	static int[] dy = { 1, 0, -1, 0, 1, -1, -1, 1 };
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		while (true) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				System.exit(0);
			}

			map = new int[51][51];
			visited = new boolean[51][51];
			cnt = 0;

			for (int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}

			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1 && visited[i][j] == false) {
						bfs(i, j);
					}
				}
			}
			sb.append(cnt);
			System.out.println(sb);
		}
	}

	// bfs
	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(x, y));
		visited[x][y] = true;

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			visited[p.x][p.y] = true;
			
			// 8방향
			for (int d = 0; d < 8; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx >= 0 && ny >= 0 && nx < h && ny < w && map[nx][ny] == 1 && visited[nx][ny] == false) {
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		cnt++;
	}
}
