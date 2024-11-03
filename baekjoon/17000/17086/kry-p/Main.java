import java.io.*;
import java.util.*;

public class Main {
    private final static int[] DX = { 0, 1, 1, 1, 0, -1, -1, -1, 0 };
    private final static int[] DY = { 1, 1, 0, -1, -1, -1, 0, 1, 1 };
    private static int max = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];
        int[][] map = new int[n][m];
        
        for (int i = 0; i < n; i++) 
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < m; j++) 
                max = Math.max(bfs(map, i, j), max);
        System.out.print(max);
    }

    private static int bfs(int[][] map, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int[][] distance = new int[map.length][map[0].length];
        distance[x][y] = 0;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            if (map[current.x][current.y] == 1) return distance[current.x][current.y];
            for (int i = 0; i < 8; i++) {
                int nextX = current.x + DX[i], nextY = current.y + DY[i];
                if (nextX < 0 || nextX >= map.length || nextY < 0 || nextY >= map[0].length) continue;
                if (nextX == x && nextY == y) continue;
                if (distance[nextX][nextY] != 0) continue;
                distance[nextX][nextY] = distance[current.x][current.y] + 1;
                queue.add(new Point(nextX, nextY));
            }
        }
        return Integer.MAX_VALUE;
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}