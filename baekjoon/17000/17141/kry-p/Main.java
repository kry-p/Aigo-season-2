import java.io.*;
import java.util.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static int n, m;
    private static int result = Integer.MAX_VALUE;
    private static int[][] distance, currentCalc;
    private static ArrayList<Point> installablePoints;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        n = nm[0];
        m = nm[1];

        // 지도의 각 요소를 입력받음
        int[][] map = new int[n][n];
        distance = new int[n][n];
        currentCalc = new int[n][n];
        for (int i = 0; i < n; i++) map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        installablePoints = new ArrayList<>();
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) 
                if (map[i][j] == 2) {
                    installablePoints.add(new Point(i, j));
                    map[i][j] = 0;
                }
        int installablePointCount = installablePoints.size();
        boolean[] isVisited = new boolean[installablePointCount];
        select(map, 0, m, 0, isVisited);        
        if (result == Integer.MAX_VALUE) System.out.print(-1);
        else System.out.println(result);
        reader.close();
    }

    private static void select(int[][] map, int start, int count, int depth, boolean[] isVisited) {
        if (depth == count) {
            copyArray(map);
            for (int i = 0; i < isVisited.length; i++) 
                if (isVisited[i]) {
                    Point current = installablePoints.get(i);
                    currentCalc[current.x][current.y] = 2;
                }
            spreadVirus(currentCalc);
            return;
        }

        for (int i = start; i < installablePoints.size(); i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            select(map, start + 1, count, depth + 1, isVisited);
            isVisited[i] = false;
        }
    }

    private static int getMaximumDistance(int[][] map) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 1) continue;
                max = Math.max(distance[i][j], max);
            }
        return max;
    }

    private static void copyArray(int[][] original) {
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++) {
                currentCalc[i][j] = original[i][j];
                distance[i][j] = Integer.MAX_VALUE;
            } 
    }

    private static void spreadVirus(int[][] map) {
        Queue<Point> queue = new LinkedList<>();
        boolean[][] isVisited = new boolean[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if (map[i][j] == 2) {
                    queue.add(new Point(i, j));
                    isVisited[i][j] = true;
                    distance[i][j] = 0;
                }
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];
                if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) continue;
                if (isVisited[nextX][nextY]) continue;
                if (map[nextX][nextY] == 1) continue;
                distance[nextX][nextY] = Math.min(distance[nextX][nextY], distance[current.x][current.y] + 1);
                isVisited[nextX][nextY] = true;
                queue.add(new Point(nextX, nextY));
            }
        }
        result = Math.min(getMaximumDistance(map), result);
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

