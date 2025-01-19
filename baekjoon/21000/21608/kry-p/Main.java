import java.io.*;
import java.util.*;

public class Main {
    private final static int[] CHECK_DX = { 1, 0, -1, 0 };
    private final static int[] CHECK_DY = { 0, -1, 0, 1 };
    private static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        Student[][] map = new Student[n + 2][n + 2];
        int result = 0;
        for (int i = 0; i < n * n; i++) {
            int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] like = { input[1], input[2], input[3], input[4] };
            Student currentStudent = new Student(input[0], like);
            findNextPosition(map, currentStudent);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                int currentLikeCount = getLikeCount(map[i][j], map, i, j);
                if (currentLikeCount == 4) result += 1000;
                if (currentLikeCount == 3) result += 100;
                if (currentLikeCount == 2) result += 10;
                if (currentLikeCount == 1) result += 1;
            }
        }
        System.out.print(result);
        reader.close();
    }

    private static void findNextPosition(Student[][] map, Student current) {
        ArrayList<Point> availablePositions = new ArrayList<>();    
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (map[i][j] != null) continue; // 자리가 비어있지 않으면 넘김
                int currentLikeCount = getLikeCount(current, map, i, j);
                int emptySides = getEmptySides(map, i, j);
                availablePositions.add(new Point(i, j, emptySides, currentLikeCount));
            }
        }
        Collections.sort(availablePositions, new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                if (o1.likeCount != o2.likeCount) return o2.likeCount - o1.likeCount;
                if (o1.emptyCount != o2.emptyCount) return o2.emptyCount - o1.emptyCount;
                if (o1.x != o2.x) return o1.x - o2.x;
                return o1.y - o2.y;
            }
        });
        Point destination = availablePositions.get(0);
        map[destination.x][destination.y] = current;
    }

    private static int getLikeCount(Student current, Student[][] map, int x, int y) {
        int[] like = current.like;
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + CHECK_DX[i];
            int nextY = y + CHECK_DY[i];
            if (nextX < 1 || nextX > n) continue;
            if (nextY < 1 || nextY > n) continue;
            if (map[nextX][nextY] == null) continue;
            for (int studentNumber : like) 
                if (map[nextX][nextY].studentNumber == studentNumber)
                    count += 1;
        }
        return count;
    }

    private static int getEmptySides(Student[][] map, int x, int y) {
        int count = 0;
        for (int i = 0; i < 4; i++) {
            int nextX = x + CHECK_DX[i];
            int nextY = y + CHECK_DY[i];
            if (nextX < 1 || nextX > n) continue;
            if (nextY < 1 || nextY > n) continue;
            if (map[nextX][nextY] != null) continue;
            count += 1;
        }
        return count;
    }
}

class Student {
    public int[] like;
    public int studentNumber;
    public Student(int studentNumber, int[] like) {
        this.studentNumber = studentNumber;
        this.like = like;
    }

}

class Point { 
    public int x, y, emptyCount, likeCount;
    public Point(int x, int y, int emptyCount, int likeCount) {
        this.x = x;
        this.y = y;
        this.emptyCount = emptyCount;
        this.likeCount = likeCount;
    }
}