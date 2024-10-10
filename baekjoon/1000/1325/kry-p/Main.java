import java.util.*;
import java.io.*;

public class Main {

    private static int max = 0;
    private static boolean[] isVisited;
    static List<Integer>[] list;
    private static int[] result;
    private static List<Integer>[] connection;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        StringBuilder builder = new StringBuilder();
        // nm[0] = n, nm[1] = m
        int[] nm = new int[2];
        int maxHack = 0;
        nm[0] = Integer.parseInt(tokenizer.nextToken());
        nm[1] = Integer.parseInt(tokenizer.nextToken());

        int[] relation = new int[2];
        isVisited = new boolean[nm[0] + 1];
        connection = new ArrayList[nm[0] + 1];
        result = new int[nm[0] + 1];

        // 링크 상태 정보를 저장할 ArrayList 배열 초기화
        for (int i = 1; i <= nm[0]; i++) {
            connection[i] = new ArrayList<Integer>();
        }
        // 각 입력에 대해 링크 상태를 ArrayList에 저장
        for (int i = 0; i < nm[1]; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            relation[0] = Integer.parseInt(tokenizer.nextToken());
            relation[1] = Integer.parseInt(tokenizer.nextToken());
            connection[relation[0]].add(relation[1]);
        }
        // 각 시작 노드별로 방문 가능한 노드의 개수를 구함
        for (int i = 1; i <= nm[0]; i++) {
            isVisited = new boolean[nm[0] + 1];
            isVisited[i] = true;
            search(i);
        }
        // 최댓값 찾기
        for (int i = 0; i < result.length; i++) maxHack = Math.max(maxHack, result[i]);
        for (int i = 1; i <= nm[0]; i++) 
            if (maxHack == result[i]) builder.append(i + " ");
        System.out.print(builder.toString());
    }

    /**
     * 순회를 수행합니다.
     * 해당 node에서 탐색 가능한 노드가 있고 isVisited[node]가 false인 경우 추가 탐색을 진행
     * @param node
     */
    private static void search(int node) {
        for (int i : connection[node]) {
            if (!isVisited[i]) {
                result[i] += 1;
                isVisited[i] = true;
                search(i);
            }
        }
    }
}