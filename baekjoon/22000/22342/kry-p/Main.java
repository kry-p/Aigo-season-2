import java.io.*;
import java.util.*;

public class Main {
    private static int arraySize;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mn = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int m = mn[0], n = mn[1];
        int[][] d = new int[m + 1][n + 1];
        int[][] store = new int[m + 2][n + 2];
        int[][] print = new int[m + 2][n + 2];
        int max = 0;
        // 입력
        for (int i = 1; i <= m; i++) {
            int[] input = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();
            for (int j = 1; j <= n; j++) d[i][j] = input[j - 1];
        }

        // 저장 배열의 최댓값은 이전 열에서 선택 가능한 세 칸 중 최대
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                for (int k = -1; k <= 1; k++) store[j][i] = Math.max(store[j][i], print[j + k][i - 1]);
                print[j][i] = store[j][i] + d[j][i];
            }
        }

        // 배열을 순회하며 최댓값을 구함
        for (int i = 0; i <= m; i++) 
            for (int j = 0; j <= n; j++) max = Math.max(max, store[i][j]);
        System.out.print(max);
        reader.close();
    }
}