import java.io.*;
import java.util.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static int currentAreaSheepCount, currentAreaWolfCount;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int[] rc = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int r = rc[0], c = rc[1];
        String[][] map = new String[r][c];
        int resultWolf = 0, resultSheep = 0;

        for (int i = 0; i < r; i++) map[i] = reader.readLine().split("");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // 벽이 아닌 경우 탐색을 시작
                if (!map[i][j].equals("#")) {
                    currentAreaSheepCount = 0;
                    currentAreaWolfCount = 0;
                    bfs(map, i, j);
                    // 벽으로 막히지 않은 영역의 탐색을 끝냈을 때 양의 마릿수가 더 많으면 양의 마릿수만 카운트
                    // 아닌 경우 늑대의 마릿수만 카운트
                    if (currentAreaSheepCount > currentAreaWolfCount) resultSheep += currentAreaSheepCount;
                    else resultWolf += currentAreaWolfCount;
                }
            }
        }
        builder.append(resultSheep + " " + resultWolf);
        System.out.print(builder.toString());
        reader.close();
    }

    private static void addCount(String current) {
        if (current.equals("o")) currentAreaSheepCount += 1;
        if (current.equals("v")) currentAreaWolfCount += 1;
    }

    private static void bfs(String[][] map, int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        int row = map.length, column = map[0].length;
        queue.add(new Point(x, y));
        addCount(map[x][y]);
        map[x][y] = " ";
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i];
                int nextY = current.y + DY[i];
                if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= column) continue;
                if (map[nextX][nextY].equals("#")) continue;
                if (map[nextX][nextY].equals(" ")) continue;
                addCount(map[nextX][nextY]);
                map[nextX][nextY] = " "; // 탐색한 위치를 빈 문자열로 변경하여 재탐색 방지
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
