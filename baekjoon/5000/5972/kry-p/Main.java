import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<ArrayList<Node>> graph;
    private static int[] lowestCosts;
	public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int vertex = Integer.parseInt(input[0]);
        int edge = Integer.parseInt(input[1]);
        graph = new ArrayList<>();
        lowestCosts = new int[vertex + 1];

        for (int i = 0; i <= vertex; i++) 
            graph.add(new ArrayList<>());
        
        for (int i = 0; i < edge; i++) {
            int[] vector = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            graph.get(vector[0]).add(new Node(vector[1], vector[2])); 
            graph.get(vector[1]).add(new Node(vector[0], vector[2]));
        }

        for (int i = 0; i < lowestCosts.length; i++) 
            lowestCosts[i] = Integer.MAX_VALUE;

        dijkstra();
        System.out.println(lowestCosts[vertex]);
    }

    private static void dijkstra() {
        int startPos = 1;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(startPos, 0));
        lowestCosts[startPos] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            int currentCost = current.cost;
            int currentNode = current.vertex;

            if (lowestCosts[currentNode] < currentCost) {
                continue;
            }

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