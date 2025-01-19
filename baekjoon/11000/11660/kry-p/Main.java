import java.io.*;
import java.util.*;

public class Main {
    private static int arraySize;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int[] size = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        arraySize = size[0];
        int attempt = size[1];
        int[][] map = new int[arraySize][arraySize];
        int[][] dp = new int[arraySize + 1][arraySize + 1];
        for (int i = 0; i < arraySize; i++) 
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int currentSum = 0;
        for (int i = 1; i <= arraySize; i++) 
            for (int j = 1; j <= arraySize; j++) 
                dp[i][j] = dp[i][j - 1] + dp[i - 1][j] - dp[i - 1][j - 1] + map[i - 1][j - 1];
            

        for (int i = 0; i < attempt; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x1 = input[0], y1 = input[1], x2 = input[2], y2 = input[3];
            builder.append(getSum(x1, y1, x2, y2, map, dp) + "\n");
        }
        System.out.print(builder.toString());
    }

    private static int getSum(int startX, int startY, int endX, int endY, int[][] map, int[][] dp) {
        if (startX == 0 && startY == 0) return dp[endX][endY];
        if (startX == 0) return dp[endX][endY] - dp[endX][startY - 1];
        if (startY == 0) return dp[endX][endY] - dp[startX - 1][endY];
        return dp[endX][endY] - dp[endX][startY - 1] - dp[startX - 1][endY] + dp[startX - 1][startY - 1];
    }
}