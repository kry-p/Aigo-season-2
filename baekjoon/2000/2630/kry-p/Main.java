import java.io.*;
import java.util.*;

public class Main {
    private static int blueCount = 0, whiteCount = 0;    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        cut(map, 0, 0, n);
        System.out.print(whiteCount + "\n" + blueCount);
    }
    private static void cut(int[][] map, int startX, int startY, int size) {
        boolean flag = true;
        int start = map[startX][startY];
        loop:
        for (int i = startX; i < startX + size; i++) 
            for (int j = startY; j < startY + size; j++) 
                if (map[i][j] != start) {
                    flag = false;
                    int half = size / 2;
                    cut(map, startX, startY, half);
                    cut(map, startX + half, startY, half);
                    cut(map, startX, startY + half, half);
                    cut(map, startX + half, startY + half, half);
                    break loop;       
                }
        if (flag) {
            if (start == 0) whiteCount += 1;
            else blueCount += 1;
        }
    }
}