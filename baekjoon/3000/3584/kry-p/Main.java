import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder builder;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        while (t > 0) {
            t -= 1;

            int edges = Integer.parseInt(reader.readLine());
            int[] parentNodes = new int[edges + 1];

            for (int i = 0; i < edges - 1; i++) {
                int[] input = readoutIntegerArray(reader);
                parentNodes[input[1]] = input[0];
            }
            int[] lcaTarget = readoutIntegerArray(reader);
            boolean[] isVisited = new boolean[edges + 1];
            getLCA(parentNodes, isVisited, lcaTarget[0], lcaTarget[1]);
        }
        System.out.print(builder.toString());
    }

    private static void getLCA(int[] parentNodes, boolean[] isVisited, int v1, int v2) {
        // 첫 번째 정점으로부터 부모를 타고 올라가면서 탐색 가능한 정점에 방문 여부를 표시
        while (v1 > 0) {
            isVisited[v1] = true;
            v1 = parentNodes[v1];
        }
        while (v2 > 0) {
            // 첫 번째 정점이 부모로 갈 때 방문했던 접점이라면 공통 조상이라고 볼 수 있음
            if (isVisited[v2]) {
                builder.append(v2 + "\n");
                break;
            }
            v2 = parentNodes[v2];
        }
    }

    private static int[] readoutIntegerArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}