import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };

    private static int[][] map;
    private static boolean[][] isVisited;
    private static int m, n, year;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        year = 0;
        m = Integer.parseInt(input[0]);
        n = Integer.parseInt(input[1]);
        map = new int[m][n];

        for (int i = 0; i < m; i++)
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int count;
        while (true) {
            meltIce();
            count = countPieces();
            year += 1;
            if (count != 1) break;
        }
        if (count == 0) System.out.println(0);
        else System.out.println(year);
    }

    private static int countPieces() {
        isVisited = new boolean[m][n];
        int count = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (map[i][j] > 0 && !isVisited[i][j]) {
                    count += 1;
                    dfs(i, j);
                }
        return count;
    }

    private static void dfs(int x, int y) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];
            if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n)
                continue;
            if (isVisited[nextX][nextY])
                continue;
            if (map[nextX][nextY] == 0)
                continue;
            dfs(nextX, nextY);
        }
    }

    private static void meltIce() {
        int[][] melt = new int[m][n];
        // 얼마나 녹는지 판정
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] > 0) {
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + DX[k];
                        int nextY = j + DY[k];
                        if (nextX < 0 || nextY < 0 || nextX >= m || nextY >= n)
                            continue;
                        if (map[nextX][nextY] == 0)
                            melt[i][j] += 1;
                    }
                }
            }
        }
        // 녹임
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] < melt[i][j])
                    map[i][j] = 0;
                else
                    map[i][j] -= melt[i][j];
            }
        }
    }
}