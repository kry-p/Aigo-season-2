import java.io.*;
import java.util.*;

public class Main {
    private static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().split(" ");
        n = Integer.parseInt(size[0]);
        m = Integer.parseInt(size[1]);
        int sum = 0;    
        int[][] map = new int[n][m];

        for (int i = 0; i < n; i++)
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        sum += n * m * 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (j == 0) sum += map[i][j];
                else if (map[i][j] > map[i][j - 1]) sum += (map[i][j] - map[i][j - 1]);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                if (j == m - 1) sum += map[i][j];
                else if (map[i][j] > map[i][j + 1]) sum += (map[i][j] - map[i][j + 1]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0) sum += map[j][i];
                else if (map[j][i] > map[j - 1][i]) sum += (map[j][i] - map[j - 1][i]);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = n - 1; j >= 0; j--) {
                if (j == n - 1) sum += map[j][i];
                else if (map[j][i] > map[j + 1][i]) sum += (map[j][i] - map[j + 1][i]);
            }
        }

        System.out.println(sum);
    }
}