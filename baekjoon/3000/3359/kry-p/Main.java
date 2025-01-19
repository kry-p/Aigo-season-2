import java.io.*;
import java.util.*;

public class Main {
    private static int arraySize;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[][] r = new int[n + 1][2];
        int[] dpS = new int[n + 1];
        int[] dpL = new int[n + 1];
        for (int i = 1; i <= n; i++) r[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        
        dpS[1] = r[1][0]; // 짧은축 시작
        dpL[1] = r[1][1]; // 긴축 시작

        for (int i = 2; i <= n; i++) {
            // 이전 사각형과의 높이 차를 계산하여 큰 쪽으로 갱신
            dpS[i] = Math.max(dpS[i - 1] + Math.abs(r[i - 1][1] - r[i][1]), dpL[i - 1] + Math.abs(r[i - 1][0] - r[i][1])) + r[i][0]; // 짧은 쪽 사용 시
            dpL[i] = Math.max(dpS[i - 1] + Math.abs(r[i - 1][1] - r[i][0]), dpL[i - 1] + Math.abs(r[i - 1][0] - r[i][0])) + r[i][1]; // 긴 쪽 사용 시
        }

        System.out.print(Math.max(dpL[n], dpS[n]));
    }
}