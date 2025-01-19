import java.io.*;
import java.util.*;

public class Main {
    private static int[] parentNode;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        ArrayList<Integer>[] nodes = new ArrayList[n + 1];
        parentNode = new int[n + 1];
        for (int i = 1; i <= n; i++) nodes[i] = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            nodes[input[0]].add(input[1]);
            nodes[input[1]].add(input[0]);
        }
        dfs(nodes, 1, 0);
        for (int i = 2; i <= n; i++) builder.append(parentNode[i] + "\n");
        System.out.print(builder.toString());
    }

    private static void dfs(ArrayList<Integer>[] nodes, int current, int origin) {
        for (int n : nodes[current]) {
            if (n == origin) continue;
            parentNode[n] = current; // 기존에 탐색해 온 노드를 부모 노드 번호로 갱신
            dfs(nodes, n, current); // 다음 노드 탐색
        }
    }
}