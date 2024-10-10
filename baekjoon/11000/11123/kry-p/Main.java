/**
 * 2차 제출 변경사항: 주석을 추가하였습니다.
 */
import java.io.*;
import java.util.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        // 남은 테스트 케이스 개수가 0이 될 때까지 반복합니다.
        while (t > 0) {
            int groupCount = 0;
            int[] nm = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            boolean[][] array = new boolean[nm[0]][nm[1]]; // 해당 위치에 양의 존재 여부를 저장하는 배열입니다.
            boolean[][] isVisited = new boolean[nm[0]][nm[1]]; // 해당 위치를 방문했는지 확인하는 배열입니다.
            // 양의 존재 여부를 입력받아 기록합니다.
            for (int i = 0; i < nm[0]; i++) {
                String currentLine = reader.readLine();
                for (int j = 0; j < currentLine.length(); j++) 
                    array[i][j] = currentLine.charAt(j) == '#' ? true : false;
            }
            for (int i = 0; i < nm[0]; i++) 
                for (int j = 0; j < nm[1]; j++) 
                    // 방문하지 않았고 양이 존재하는 위치라면 해당 위치를 기점으로 탐색을 시작합니다.
                    if (!isVisited[i][j] && array[i][j]) {
                        groupCount += 1;
                        dfs(isVisited, array, i, j);
                    }
            // 그룹의 개수를 출력될 StringBuilder에 기록해 둡니다.
            writeLineInStringBuilder(Integer.toString(groupCount), builder);
            t -= 1;
        }
        // StringBuilder의 전체 내용을 표준 출력으로 내보냅니다.
        System.out.print(builder.toString());
        reader.close();
    }

    /**
     * 결괏값을 받아 StringBuilder에 기록하고 개행 문자(\n)를 추가합니다.
     * @param s
     * @param builder
     */
    private static void writeLineInStringBuilder(String s, StringBuilder builder) {
        builder.append(s + "\n");
    }

    /**
     * 깊이 우선 탐색을 수행합니다.
     * @param isVisited 방문 여부
     * @param array 양의 존재 여부 지도 배열
     * @param x 현재 탐색하려는 위치 x 좌표
     * @param y 현재 탐색하려는 위치 y 좌표
     */
    private static void dfs(boolean[][] isVisited, boolean[][] array, int x, int y) {
        isVisited[x][y] = true; // 현재 위치에 방문했음을 표시합니다.
        int row = array.length, col = array[0].length;
        /**
         * 4방향 탐색을 진행합니다.
         * 배열의 범위를 넘어가거나, 이미 방문했거나, 해당 위치에 양이 없으면 추가 탐색하지 않습니다.
         * 위 조건을 모두 통과하면 nextX, nextY를 좌표로 입력받아 이어서 탐색합니다.
         */
        for (int i = 0; i < 4; i++) {
            int nextX = x + DX[i], nextY = y + DY[i];
            if (nextX < 0 || nextX >= row || nextY < 0 || nextY >= col) continue;
            if (isVisited[nextX][nextY] || !array[nextX][nextY]) continue;
            dfs(isVisited, array, nextX, nextY);
        }
    }
}