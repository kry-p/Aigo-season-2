import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<ArrayList<Node>> graph;
    private static int[] lowestCosts;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int testCase = Integer.parseInt(reader.readLine());

        for (int i = 0; i < testCase; i++) {
            String[] input = reader.readLine().split(" ");

            int vertex = Integer.parseInt(input[1]);
            int edge = Integer.parseInt(input[0]);
            int start = Integer.parseInt(input[2]);

            graph = new ArrayList<>();
            lowestCosts = new int[edge + 1];

            for (int j = 0; j <= edge; j++) 
                graph.add(new ArrayList<>());
            
            for (int j = 0; j < lowestCosts.length; j++)
                lowestCosts[j] = Integer.MAX_VALUE;
            
            for (int j = 0; j < vertex; j++) {
                int[] vector = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                graph.get(vector[1]).add(new Node(vector[0], vector[2]));
            }

            dijkstra(start);
            int max = lowestCosts[1] == Integer.MAX_VALUE ? Integer.MIN_VALUE : lowestCosts[1];
            int count = 0;

            for (int j = 1; j <= edge; j++) {
                if (lowestCosts[j] < Integer.MAX_VALUE) {
                    max = Math.max(max, lowestCosts[j]);
                    count += 1;
                }
            }
            builder.append(count + " " + max + "\n");
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