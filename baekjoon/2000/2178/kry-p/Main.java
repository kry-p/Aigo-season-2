import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().split(" ");
        int n = Integer.parseInt(size[0]), m = Integer.parseInt(size[1]);
        int[][] map = new int[n][m];
        int[][] distance = new int[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        bfs(map, distance, 0, 0);
        System.out.print(distance[n - 1][m - 1]); // 최단거리 배열에 저장된 도착지까지의 거리 출력
    }
    private static void bfs(int[][] map, int[][] distance, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        int row = map.length, col = map[0].length;
        distance[0][0] = 1;
        queue.add(new Point(0, 0));
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];
                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) continue;
                if ((distance[current.x][current.y] + 1) >= distance[nextX][nextY]) continue;
                if (map[nextX][nextY] == 0) continue;
                // 최단 거리 정보를 갱신
                distance[nextX][nextY] = Math.min(distance[current.x][current.y] + 1, distance[nextX][nextY]);
                queue.add(new Point(nextX, nextY));
            }
        }
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}