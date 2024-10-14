import java.util.*;
import java.io.*;

public class Main {
    private static ArrayList<Integer>[] connection;
    private static int[] minimumDistance;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nm[0], m = nm[1];
        connection = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) connection[i] = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            int[] current = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            // 연결 정보를 저장
            connection[current[0]].add(current[1]);
            connection[current[1]].add(current[0]);
        }
        int q = Integer.parseInt(reader.readLine());
        while (q > 0) {
            int[] current = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int a = current[0], i = current[1], j = current[2];
            // a가 1일 경우 연결 정보를 추가
            if (a == 1) {
                connection[i].add(j);
                connection[j].add(i); 
            }
            // a가 2일 경우 존재하는 연결 정보를 제거
            if (a == 2) {
                connection[i].remove(connection[i].indexOf(j));
                connection[j].remove(connection[j].indexOf(i));
            }
            // 최단거리 배열을 생성
            minimumDistance = new int[n + 1];
            boolean[] isVisited = new boolean[n + 1];
            Arrays.fill(minimumDistance, Integer.MAX_VALUE);
            bfs(1, isVisited);
            // 저장된 최단거리를 출력
            for (int k = 1; k < minimumDistance.length; k++) {
                int currentDistance = minimumDistance[k];
                if (currentDistance == Integer.MAX_VALUE) builder.append(-1 + " ");
                else builder.append(minimumDistance[k] + " ");
            }
            builder.append("\n");
            q -= 1;
        }
        System.out.print(builder.toString());
        reader.close();
    }

    private static void bfs(int start, boolean[] isVisited) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[start] = true;
        minimumDistance[start] = 0;
        queue.add(start);
        while (!queue.isEmpty()) {
            int current = queue.poll();
            for (int i = 0; i < connection[current].size(); i++) {
                int next = connection[current].get(i);
                if (isVisited[next]) continue;
                isVisited[next] = true;
                minimumDistance[next] = minimumDistance[current] + 1;
                queue.add(next);
            }
        }
    }
}