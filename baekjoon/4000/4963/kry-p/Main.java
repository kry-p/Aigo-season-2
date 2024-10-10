import java.io.*;
import java.util.*;

public class Main {
    // 8방향 탐색을 위해 사전 정의된 값
    private final static int[] DX = { 1, -1, 0, 0, 1, 1, -1, -1 };
    private final static int[] DY = { 0, 0, 1, -1, 1, -1, 1, -1 };
    private static int[][] map;
    private static int count, width, height;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        while (true) {
            String[] input = reader.readLine().split(" ");
            width = Integer.parseInt(input[0]);
            height = Integer.parseInt(input[1]);
            count = 0;

            if (width == 0 && height == 0)
                break;

            map = new int[height][width];

            for (int i = 0; i < height; i++) {
                map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            }

            // 탐색이 가능한 경우 개수를 증가시키고 탐색 진행
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (map[i][j] == 1) {
                        dfs(i, j);
                        count += 1;
                    }
                }
            }
            builder.append(count + "\n");
        }
        System.out.println(builder.toString());
    }

    private static void dfs(int x, int y) {
        map[x][y] = 0; // 이미 지나간 곳을 0으로 바꿔 주어 추가 탐색을 방지
        for (int i = 0; i < 8; i++) {
            int nextX = x + DX[i];
            int nextY = y + DY[i];
            if (nextX < 0 || nextY < 0 || nextX >= height || nextY >= width || map[nextX][nextY] == 0)
                continue;
            dfs(nextX, nextY);
        }
    }
}