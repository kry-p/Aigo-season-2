import java.io.*;
import java.util.*;

public class Main {
    private final static int[] DX = { 0, 0, -1, -1, -1, 0, 1, 1, 1 };
    private final static int[] DY = { 0, -1, -1, 0, 1, 1, 1, 0, -1 };
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nm = readoutIntegerArray(reader);
        n = nm[0];
        int m = nm[1];
        int[][] map = new int[n + 1][n + 1];
        boolean[][] clouds = new boolean[n + 1][n + 1];

        // 지도 정보 입력
        for (int i = 1; i <= n; i++) {
            int[] input = readoutIntegerArray(reader);
            for (int j = 1; j <= n; j++) map[i][j] = input[j - 1];
        }

        // 비바라기 시전
        clouds[n][1] = true;
        clouds[n][2] = true;
        clouds[n - 1][1] = true;
        clouds[n - 1][2] = true;

        // 정해진 이동 수행
        for (int i = 0; i < m; i++) {
            int[] move = readoutIntegerArray(reader);
            int d = move[0], s = move[1];
            clouds = moveClouds(clouds, d, s);
            ArrayList<Point> rainedPoints = rain(clouds, map);
            copyWaterBug(rainedPoints, map);
            clouds = createClouds(clouds, map);
        }
        System.out.print(getCountOfWater(map));
        reader.close();
    }

    private static boolean[][] createClouds(boolean[][] previousClouds, int[][] map) {
        boolean[][] next = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) 
            for (int j = 1; j <= n; j++) 
                if (map[i][j] >= 2 && !previousClouds[i][j]) {
                    next[i][j] = true;
                    map[i][j] -= 2;
                }      
        return next;
    }

    private static void copyWaterBug(ArrayList<Point> rainedPoints, int[][] map) {
        for (int i = 0; i < rainedPoints.size(); i++) {
            Point current = rainedPoints.get(i);
            // 대각선 방향만 증가 판정
            int waterCount = 0;
            for (int j = 2; j <= 8; j += 2) {
                int nextX = current.x + DX[j];
                int nextY = current.y + DY[j];
                if (nextX > n || nextX < 1) continue;
                if (nextY > n || nextY < 1) continue;
                if (map[nextX][nextY] < 1) continue;
                waterCount += 1;
            }
            map[current.x][current.y] += waterCount;
        }
    }

    private static ArrayList<Point> rain(boolean[][] clouds, int[][] map) {
        ArrayList<Point> rainedPoints = new ArrayList<>();
        for (int i = 1; i <= n; i++) 
            for (int j = 1; j <= n; j++) 
                if (clouds[i][j]) {
                    rainedPoints.add(new Point(i, j));
                    map[i][j] += 1;
                }
        return rainedPoints;
    }

    private static int getCountOfWater(int[][] map) {
        int sum = 0;
        for (int i = 1; i <= n; i++) 
            for (int j = 1; j <= n; j++)
                sum += map[i][j];
        return sum;
    }

    private static boolean[][] moveClouds(boolean[][] clouds, int direction, int speed) {
        boolean[][] next = new boolean[n + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (!clouds[i][j]) continue;
                int nextX = i + (DX[direction] * speed);
                int nextY = j + (DY[direction] * speed);
                while (nextX > n) nextX -= n;
                while (nextY > n) nextY -= n;
                while (nextX < 1) nextX += n;
                while (nextY < 1) nextY += n;
                next[nextX][nextY] = true;
            }
        }
        return next;
    }

    private static int[] readoutIntegerArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
