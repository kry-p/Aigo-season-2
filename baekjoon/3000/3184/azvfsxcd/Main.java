package Algo241013;

import java.util.*;
import java.lang.*;
import java.awt.*;
import java.io.*;

// 양
public class boj3184 {
	static StringBuilder sb;
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;

	static int n, m;
	static char[][] map;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1};
	static int[] dy = { 1, 0, -1, 0};
	static int sheep, wolf;
	static int s, w;

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();

		if (n == 0 && m == 0) {
			System.exit(0);
		}

		map = new char[251][251];
		visited = new boolean[251][251];
		sheep = 0;
		wolf = 0;

		for (int i = 0; i < n; i++) {
//				st = new StringTokenizer(br.readLine());
			String str = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (map[i][j] != '#' && visited[i][j] == false) {
					w = 0;
					s = 0;
					bfs(i, j);
				}
			}
		}
		sb.append(sheep + " " + wolf);
		System.out.println(sb);
	}

	// bfs
	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<>();

		queue.add(new Point(x, y));
		visited[x][y] = true;
		fight(map[x][y]);

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			visited[p.x][p.y] = true;
			// 4방향
			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny] != '#' && visited[nx][ny] == false) {
					queue.add(new Point(nx, ny));
					visited[nx][ny] = true;
					
					fight(map[nx][ny]);
//					if(map[nx][ny] == 'o') {
//						s++;
//					} else if (map[nx][ny] == 'v') {
//						w++;
//					} 
//					else {
//						System.out.println("이게뭔데   " + map[nx][ny]);
//					}
					
				}
			}
		}
		
		if(s>w) {
			sheep += s;
		} else {
			wolf += w;
		}
		
	}

	public static void fight(char c) {
		if(c == 'o') {
			s++;
		} else if (c == 'v') {
			w++;
		} 
	}
}

