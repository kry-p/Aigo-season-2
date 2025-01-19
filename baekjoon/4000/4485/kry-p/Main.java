import java.io.*;
import java.util.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static ArrayList<ArrayList<Node>> graph;
    private static int[] lowestCosts;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int attempt = 0;
        while (true) {
            attempt += 1;
            int size = Integer.parseInt(reader.readLine());
            if (size == 0)
                break;

            int vertex = size * size;
            graph = new ArrayList<>();
            lowestCosts = new int[vertex + 1];

            for (int i = 0; i <= vertex; i++)
                graph.add(new ArrayList<>());

            int[][] map = new int[size][size];
            for (int i = 0; i < size; i++)
                map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();

            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + DX[k];
                        int nextY = j + DY[k];

                        if (nextX < 0 || nextY < 0 || nextX >= size || nextY >= size)
                            continue;
                        graph.get(i * size + j + 1).add(new Node(nextX * size + nextY + 1, map[nextX][nextY]));
                    }
                }
            }

            for (int i = 0; i < lowestCosts.length; i++) 
                lowestCosts[i] = Integer.MAX_VALUE;

            dijkstra(1);

            builder.append("Problem " + attempt + ": " + (lowestCosts[vertex] + map[0][0]) + "\n");
        }
        System.out.print(builder.toString());
    }

    private static void dijkstra(int startPos) {
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startPos, 0));
        lowestCosts[startPos] = 0;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int currentCost = current.cost;
            int currentNode = current.vertex;

            if (lowestCosts[currentNode] < currentCost)
                continue;

            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                int cost = lowestCosts[currentNode] + graph.get(currentNode).get(i).cost;
                if (cost < lowestCosts[graph.get(currentNode).get(i).vertex]) {
                    lowestCosts[graph.get(currentNode).get(i).vertex] = cost;
                    queue.add(new Node(graph.get(currentNode).get(i).vertex, cost));
                }
            }
        }
    }
}

class Node implements Comparable<Node> {
    public int vertex, cost;

    public Node(int vertex, int cost) {
        this.vertex = vertex;
        this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
        return this.cost - o.cost;
    }
}