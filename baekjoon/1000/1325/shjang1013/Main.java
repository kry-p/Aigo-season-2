import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static boolean[] visited;
    public static ArrayList<Integer>[] computers;
    public static int count;

    // BFS
    public static void BFS(int i) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(i);
        // 현재 노드를 방문 처리
        visited[i] = true;
        // 큐가 빌 때까지 반복
        while(!queue.isEmpty()) {
            // 큐에서 하나의 원소를 뽑아 출력
            int x = queue.poll();
            // 해당 원소와 연결된, 아직 방문하지 않은 원소들을 큐에 삽입
            for(int j : computers[x]) {
                if(!visited[j]) {
                    count++;
                    queue.offer(j);
                    visited[j] = true;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int[] hacking;

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        computers = new ArrayList[N+1];
        hacking = new int[N+1];

        for(int i = 0; i <= N; i++) {
            computers[i] = new ArrayList<>();
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            // 연결된 노드 정보
            computers[b].add(a);
        }

        int num = 0;
        // 한 번의 해킹으로 최대의 컴퓨터를 해킹할 수 있는 컴퓨터 번호를 출력하기
        for(int i = 1; i <= N; i++) {
            count = 0;
            visited = new boolean[N+1];
            BFS(i);
            hacking[i] = count;
        }

        for(int i = 1; i <= N; i++) {
            num = Math.max(hacking[i], num);
        }

        for(int i = 1; i <= N; i++) {
            if(hacking[i] == num) {
                System.out.print(i + " ");
            }
        }
    }
}