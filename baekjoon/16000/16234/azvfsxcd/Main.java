package Algo241020;

import java.util.*;
import java.util.List;
import java.lang.*;
import java.io.*;
import java.awt.*;

// 인구이동
public class boj16234 {
	
	static int N;
	static int[][] A;
	static boolean[][] visited;
	static boolean[][] move; // 0 : 위, 1 : 오른쪽, 2 : 밑, 3 : 아래
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { -1, 0, 1, 0 };
	static int min, max;
	static int sum, count;
	static Queue<Point> queue = new LinkedList<Point>();
//	static boolean f;
    static boolean isChange;
	static ArrayList<Point> inGroup;

//    static List<Integer> avg;
	
    static class Point {
    	int x,y,v;
    	public Point(int x, int y) {
	        this.x = x;
	        this.y = y;
	    }
    	public Point(int x, int y, int v) {
    		this.x = x;
    		this.y = y;
    		this.v = v;
    	}
    }
    
//	static class Point {
//	    int x, y;
//	    
//	    public Point(int x, int y) {
//	        this.x = x;
//	        this.y = y;
//	    }
//	}
	
	
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		min = Integer.parseInt(st.nextToken());
		max = Integer.parseInt(st.nextToken());
		A = new int[N][N];
		
		// 평균값들을 담을 리스트
//        avg = new ArrayList<>();
        		
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				A[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int cnt = 0;
		// 더이상 안될때까지 돌려야함
		while(true) {
			isChange = false;
//		while (f == false){
			visited = new boolean[N][N];		// bfs 방문용
			
//			f = false;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (!visited[i][j]) {
//						move = new boolean[N][N];		// 0 : 위, 1 : 오른쪽, 2 : 밑, 3 : 아래
						bfs(i, j);
					}
				}
			}

//			if(f==true) {
//				cnt++;
//			}
			
//			t : for (int i = 0; i < N; i++) {
//				for (int j = 0; j < N; j++) {
//					f = check(i, j);
//					if(f==false) {
//						break t;
//					}
//				}
//			}
			// 국가간 이동(연합)이 없었다면 출력하고 종료
            if(!isChange) {
                System.out.println(cnt);
                return;
            }
            
            cnt++;
		} 
		
//		System.out.println(cnt);

	}


	private static void bfs(int x, int y) {
		inGroup = new ArrayList<>();	
		queue.add(new Point(x, y));
		inGroup.add(new Point(x, y, A[x][y]));
		visited[x][y] = true;
		sum = A[x][y];
		count = 1;
//		move[x][y] = true;
		

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			for (int d = 0; d < 4; d++) {
				int nx = p.x + dx[d];
				int ny = p.y + dy[d];

				if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]==true) {
					continue;
				}
				
				if (Math.abs(A[p.x][p.y] - A[nx][ny]) >= min && Math.abs(A[p.x][p.y] - A[nx][ny]) <= max) {
					sum += A[nx][ny];
					visited[nx][ny] = true;
					count += 1;
//					move[nx][ny] = true;
					queue.add(new Point(nx, ny));
					inGroup.add(new Point(nx, ny, A[nx][ny]));
					isChange = true;
//					f = true;
				}

			}
		}
		
		// 시간초과 O(N^4)
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < N; j++) {
//				if (move[i][j] == true) {
//					A[i][j] = sum / count;
//				}
//			}
//		}

		for(Point p : inGroup) { // 1, 5
			A[p.x][p.y] =  sum / inGroup.size();
		}
	}

	/*
	// 범위 체크
	private static boolean check(int x, int y) {	
		for (int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
				continue;
			}
			
			if(Math.abs(A[x][y]-A[nx][ny])>=min && Math.abs(A[x][y]-A[nx][ny])<=max) {
				return false;
			}
			
		}
		return true;
		
	}
	*/
}

