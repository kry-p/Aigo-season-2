import java.io.*;
import java.util.*;

public class Main {
    private final static int DIRECTIONS = 6;
    // 6방향 탐색 (4방향 + Z축)
    private static int[] DX = { 1, 0, -1, 0, 0, 0 };
    private static int[] DY = { 0, -1, 0, 1, 0, 0 };
    private static int[] DZ = { 0, 0, 0, 0, 1, -1 };

    private static int[][][] minimumDistance;
    private static String[][][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while (true) {
            int[] lrc = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            if (lrc[0] == 0 && lrc[1] == 0 && lrc[2] == 0) break;
            int l = lrc[0], r = lrc[1], c = lrc[2];
            map = new String[l][r][c];
            minimumDistance = new int[l][r][c];
            int startX = 0, startY = 0, startZ = 0; // 시작 위치
            int endX = 0, endY = 0, endZ = 0; // 도착 위치
            for (int i = 0; i < l; i++) {
                for (int j = 0; j <= r; j++) {
                    String[] currentLine = reader.readLine().split("");
                    if (j == r) continue;
                    Arrays.fill(minimumDistance[i][j], Integer.MAX_VALUE);
                    for (int k = 0; k < c; k++) {
                        map[i][j][k] = currentLine[k];
                        if (map[i][j][k].equals("S")) {
                            startX = i;
                            startY = j;
                            startZ = k;
                        } 
                        if (map[i][j][k].equals("E")) {
                            endX = i;
                            endY = j;
                            endZ = k;
                        } 
                    }
                }
            }
            // 탐색하여 최단거리 배열을 작성
            bfs(startX, startY, startZ, l, r, c);
            // 최단거리 값이 갱신되지 않았으면 도달할 수 없음
            if (minimumDistance[endX][endY][endZ] == Integer.MAX_VALUE) builder.append("Trapped!\n");
            else builder.append("Escaped in " + minimumDistance[endX][endY][endZ] + " minute(s).\n");
        }
        System.out.print(builder.toString());
    }

    private static void bfs(int x, int y, int z, int l, int r, int c) {
        Queue<Point> queue = new LinkedList<>();
        minimumDistance[x][y][z] = 0;
        queue.add(new Point(x, y, z));
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < DIRECTIONS; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];
                int nextZ = current.z + DZ[i];
                if (nextX < 0 || nextX >= l || nextY < 0 || nextY >= r || nextZ < 0 || nextZ >= c) continue;
                if (minimumDistance[nextX][nextY][nextZ] != Integer.MAX_VALUE) continue;
                if (minimumDistance[nextX][nextY][nextZ] < minimumDistance[current.x][current.y][current.z] + 1) continue;
                if (map[nextX][nextY][nextZ].equals("#")) continue;
                minimumDistance[nextX][nextY][nextZ] = Math.min(minimumDistance[current.x][current.y][current.z] + 1, minimumDistance[nextX][nextY][nextZ]);
                queue.add(new Point(nextX, nextY, nextZ));
            }
        }
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