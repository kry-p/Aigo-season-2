package Algo241006;

import java.util.*;
import java.lang.*;
import java.awt.*;
import java.io.*;

// 양 한마리.... 양 두마리...
public class boj11123 {
	static StringBuilder sb;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int w, h;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1};
	static int[] dy = { 1, 0, -1, 0};
	static int cnt;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		int n = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < n; tc++) {
//		while (true) {
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());

			if (w == 0 && h == 0) {
				System.exit(0);
			}

			map = new char[101][101];
			visited = new boolean[101][101];
			cnt = 0;

			for (int i = 0; i < w; i++) {
//				st = new StringTokenizer(br.readLine());
				String str = br.readLine();
				for (int j = 0; j < h; j++) {
					map[i][j] = str.charAt(j);
				}
			}

			for (int i = 0; i < w; i++) {
				for (int j = 0; j < h; j++) {
					if (map[i][j] == '#' && visited[i][j] == false) {
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
			
			// 4방향
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx >= 0 && ny >= 0 && nx < w && ny < h && map[nx][ny] == '#' && visited[nx][ny] == false) {
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
				}
			}
		}
		cnt++;
	}
}
