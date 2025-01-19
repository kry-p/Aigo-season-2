import java.io.*;
import java.util.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0, 0, 0 };
    private final static int[] DY = { 0, -1, 0, 1, 0, 0 };
    private final static int[] DZ = { 0, 0, 0, 0, 1, -1};
    private static int n, m, h;
    private static int maximumDistance = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mnh = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        m = mnh[0];
        n = mnh[1];
        h = mnh[2];

        int[][][] map = new int[h][n][m];
        ArrayList<Point> startPoints = new ArrayList<>();
        for (int i = 0; i < h; i++) 
            for (int j = 0; j < n; j++) {
                map[i][j] = readoutIntegerArray(reader);
                for (int k = 0; k < m; k++) 
                    if (map[i][j][k] == 1) startPoints.add(new Point(i, j, k));
            }
    
        spread(map, startPoints);
        
        if (maximumDistance == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.println(maximumDistance);
        reader.close();
    }

    private static int[] readoutIntegerArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    private static int getMaximumDistance(int[][][] map, int[][][] distance) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < h; i++) 
            for (int j = 0; j < n; j++) 
                for (int k = 0; k < m; k++) {
                    if (map[i][j][k] == -1) continue;
                    max = Math.max(distance[i][j][k], max);
                }
        return max;
    }

    private static void fillArray(int[][][] array, int value) {
        for (int i = 0; i < array.length; i++) 
            for (int j = 0; j < array[0].length; j++) 
                for (int k = 0; k < array[0][0].length; k++)
                    array[i][j][k] = value;
    }

    private static void spread(int[][][] map, ArrayList<Point> startPoints) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][][] isVisited = new boolean[h][n][m];
        int[][][] distance = new int[h][n][m];
        fillArray(distance, Integer.MAX_VALUE);
        for (Point p : startPoints) {
            queue.add(p);
            distance[p.x][p.y][p.z] = 0;
            isVisited[p.x][p.y][p.z] = true;
        }
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 6; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];
                int nextZ = current.z + DZ[i];
                if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= n || nextZ < 0 || nextZ >= m) continue;
                if (isVisited[nextX][nextY][nextZ]) continue;
                if (map[nextX][nextY][nextZ] == -1) continue;
                distance[nextX][nextY][nextZ] = Math.min(distance[nextX][nextY][nextZ], distance[current.x][current.y][current.z] + 1);
                isVisited[nextX][nextY][nextZ] = true;
                queue.add(new Point(nextX, nextY, nextZ));
            }
        }
        maximumDistance = Math.min(getMaximumDistance(map, distance), maximumDistance);
    }
}

class Point {
    public int x, y, z;
    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}
