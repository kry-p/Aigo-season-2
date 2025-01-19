import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] visited;
    public static int count;
    public static ArrayList<Integer>[] computers;

    // BFS 함수
    public static void BFS(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);

        // 현재 컴퓨터를 방문 처리
        visited[start] = true;

        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            // 큐에서 하나의 컴퓨터 원소를 뽑아 방문
            int computer = queue.poll();

            // 해당 원소와 연결된, 아직 방문하지 않은 컴퓨터를 큐에 삽입
            for(int c : computers[computer]) {
                // 방문 여부 확인
                if(!visited[c]) {
                    queue.offer(c);
                    visited[c] = true;
                    count += 1;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 컴퓨터의 수
        int num = Integer.parseInt(br.readLine());

        // 초기화
        computers = new ArrayList[num+1];
        visited = new boolean[num+1];
        for(int i = 0; i < num+1; i++) {
            computers[i] = new ArrayList<>();
        }

        // 서로 연결되어 있는 정보
        int connection = Integer.parseInt(br.readLine());

        for(int j = 0; j < connection; j++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            computers[n].add(m);
            computers[m].add(n);
        }

        BFS(1);
        System.out.println(count);

        br.close();
    }
}