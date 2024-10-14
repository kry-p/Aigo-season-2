import java.util.*;
import java.io.*;

public class Main {
    private final static int[] DX = { 1, 0, -1, 0 };
    private final static int[] DY = { 0, -1, 0, 1 };
    private static int[][] map;
    private static int size;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int[] nq = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nq[0];
        size = (int) Math.pow(2, n);
        map = new int[size][size];
        for (int i = 0; i < size; i++) 
            map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] firestormSequence = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        // 주어진 규칙에 따라 파이어스톰을 수행
        for (int sequence : firestormSequence) firestorm(sequence);
        // 모두 수행한 뒤 얼음의 개수와 최대 크기인 덩어리가 차지하는 칸의 수를 출력
        builder.append(getCountOfIce() + "\n" + getMaximumClusterSize());
        System.out.print(builder.toString());
        reader.close();
    }

    // 전체 얼음의 수
    private static int getCountOfIce() {
        int sum = 0;
        for (int i = 0; i < map.length; i++) 
            for (int j = 0; j < map[0].length; j++)
                sum += map[i][j];
        return sum;
    }

    // 얼음 덩어리의 최대 크기
    private static int getMaximumClusterSize() {
        int result = 0;
        boolean[][] isVisited = new boolean[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (map[i][j] > 0 && !isVisited[i][j]) {
                    ArrayList<Point> currentCluster = getPointsOfCluster(i, j, isVisited);
                    result = Math.max(currentCluster.size(), result);
                }
            }
        }
        return result;
    }

    // 파이어스톰 실행
    private static void firestorm(int l) {
        tornado(l);
        fireball();
    }

    // 토네이도를 수행
    // 격자 기준을 생성, 각 격자별로 90도 회전 수행
    private static void tornado(int l) {
        int currentSize = (int) Math.pow(2, l);
        if (currentSize == size) shift(0, 0, size);
        else {
            int currentX = 0, currentY = 0;
            boolean flag = false;
            while (currentY < size) {
                while (currentX < size) {
                    // if (flag) shift(currentX + currentSize, currentY, currentSize);
                    // else shift(currentX, currentY, currentSize);
                    shift(currentX, currentY, currentSize);
                    currentX += currentSize;
                }
                currentX = 0;
                currentY += currentSize;
                flag = !flag;
            }
        }
    }

    // 입력받은 좌표를 기준으로 size * size 배열을 90도 회전
    private static void shift(int startX, int startY, int size) {
        if (size > 1) {
            int[][] arrayCopy = new int[size][size];
            // 회전하고자 하는 서브 배열 복사
            for (int i = 0; i < size; i++) 
                for (int j = 0; j < size; j++) 
                    arrayCopy[i][j] = map[startX + i][startY + j];
            // 실제 배열을 회전
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    map[startX + j][startY + size - 1 - i] = arrayCopy[i][j];
                }
            }
        }
    }

    // 현재 시작점을 기준으로 덩어리의 좌표 배열 반환
    private static ArrayList<Point> getPointsOfCluster(int startX, int startY, boolean[][] isVisited) {
        ArrayList<Point> points = new ArrayList<>();
        Queue<Point> queue = new LinkedList<>();
        Point currentPosition = new Point(startX, startY);
        queue.add(currentPosition);
        points.add(currentPosition);
        isVisited[startX][startY] = true;
        while (!queue.isEmpty()) {
            Point current = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nextX = current.x + DX[i], nextY = current.y + DY[i];
                if (nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) continue;
                if (isVisited[nextX][nextY]) continue;
                if (map[nextX][nextY] <= 0) continue;
                isVisited[nextX][nextY] = true;
                Point next = new Point(nextX, nextY);
                points.add(next);
                queue.add(next);
            }
        }   
        return points;
    }

    /**
     * 파이어볼 수행
     * 전체를 순회하여 각 위치별로 3개 이상의 얼음과 인접해있는지를 판정
     * 인접하지 않은 경우 melt 배열에 삽입 후 한꺼번에 1씩 감소
     */
    private static void fireball() {
        ArrayList<Point> melt = new ArrayList<>();

        for (int i = 0; i < size; i++) 
            for (int j = 0; j < size; j++) {
                if (map[i][j] > 0) {
                    int iceSize = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + DX[k], nextY = j + DY[k];
                        if (nextX < 0 || nextX >= size || nextY < 0 || nextY >= size) continue;
                        if (map[nextX][nextY] > 0) iceSize += 1;
                    }
                    if (iceSize < 3) melt.add(new Point(i, j));
                }
            }
        for (int i = 0; i < melt.size(); i++) {
            Point current = melt.get(i);
            if (map[current.x][current.y] > 0) map[current.x][current.y] = map[current.x][current.y] - 1;
        }
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}