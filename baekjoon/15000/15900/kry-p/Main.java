import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<Integer>[] connection;
    private static int depth = 0;
    private static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        connection = new ArrayList[n + 1]; // 연결 상태를 저장
        for (int i = 0; i <= n; i++) connection[i] = new ArrayList<>();
        for (int i = 0; i < n - 1; i++) {
            int[] current = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            connection[current[0]].add(current[1]);
            connection[current[1]].add(current[0]);
        }
        isVisited = new boolean[n + 1];
        dfs(1, 0, 0);
        System.out.println(isOdd(depth) ? "Yes" : "No");
        reader.close();
    }

    private static boolean isOdd(int number) {
        return number % 2 == 1;
    }

    private static void dfs(int current, int previous, int currentDepth) {
        isVisited[current] = true;
        for (int i = 0; i < connection[current].size(); i++) {
            int next = connection[current].get(i);
            if (next == previous) continue;
            if (isVisited[next]) continue;
            dfs(next, current, currentDepth + 1);
        }
        // 연결된 노드가 하나만 있는 경우 리프 노드로 간주하고 깊이를 더함
        if (connection[current].size() == 1) depth += currentDepth;
    }
}