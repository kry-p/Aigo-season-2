import java.util.*;
import java.io.*;

public class Main {
    private static int leafNodeCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int[] nodes = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int nodeToRemove = Integer.parseInt(reader.readLine());
        int rootNode = 0;
        ArrayList<ArrayList<Integer>> tree = new ArrayList<>();
        for (int i = 0; i < n; i++) tree.add(new ArrayList<>());
        for (int i = 0; i < nodes.length; i++) {
            if (nodes[i] == -1) {
                rootNode = i;
                continue;
            }
            // 양방향 연결 추가
            tree.get(i).add(nodes[i]);
            tree.get(nodes[i]).add(i);
        }
        // 제거하려는 노드가 루트 노드라면 리프는 없음
        if (nodeToRemove == rootNode) {
            System.out.print(0);
            System.exit(0);
        }
        boolean[] isVisited = new boolean[n];
        dfs(tree, isVisited, nodeToRemove, rootNode);
        System.out.print(leafNodeCount);
    }

    private static void dfs(ArrayList<ArrayList<Integer>> tree, boolean[] isVisited, int deletedNode, int currentNode) {
        isVisited[currentNode] = true;
        int children = 0;

        for (int next : tree.get(currentNode)) {
            if (isVisited[next]) continue;
            if (next == deletedNode) continue;
            dfs(tree, isVisited, deletedNode, next);
            children += 1;
        }
        if (children == 0) leafNodeCount += 1;
    } 
}