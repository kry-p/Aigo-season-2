import java.util.*;
import java.io.*;

public class Main {
    private static int convexCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] abilities = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean[] isVisited = new boolean[8];
        int[] order = new int[8];
        dfs(0, 0, abilities, order, isVisited);
        System.out.print(convexCount);
        reader.close();
    }

    private static void dfs(int start, int depth, int[] abilities, int[] order, boolean[] isVisited) {
        if (depth == 8) {
            double[] result = new double[8];
            for (int i = 0; i < 8; i++) 
                result[i] = (double) abilities[order[i]];
            boolean isConvex = checkIfConvex(result);
            if (isConvex) convexCount += 1;
            return;
        }
        for (int i = 0; i < abilities.length; i++) {
            if (isVisited[i]) continue;
            isVisited[i] = true;
            order[i] = depth;
            dfs(i + 1, depth + 1, abilities, order, isVisited);
            isVisited[i] = false;
        }
    }

    private static boolean checkIfConvex(double[] abilities) {
        Point p1 = new Point(0, abilities[0]);
        Point p2 = new Point(Math.sqrt(abilities[1] * abilities[1] / 2), Math.sqrt(abilities[1] * abilities[1] / 2));
        Point p3 = new Point(abilities[2], 0);
        Point p4 = new Point(Math.sqrt(abilities[3] * abilities[3] / 2), -1 * Math.sqrt(abilities[3] * abilities[3] / 2));

        Point p5 = new Point(0, -1 * abilities[4]);
        Point p6 = new Point(-1 * Math.sqrt(abilities[5] * abilities[5] / 2), -1 * Math.sqrt(abilities[5] * abilities[5] / 2));
        Point p7 = new Point(-1 * abilities[6], 0);
        Point p8 = new Point(-1 * Math.sqrt(abilities[7] * abilities[7] / 2), Math.sqrt(abilities[7] * abilities[7] / 2));

        if (!ccw(p8, p1, p2) || !ccw(p1, p2, p3) || !ccw(p2, p3, p4) || !ccw(p3, p4, p5) ||
            !ccw(p4, p5, p6) || !ccw(p5, p6, p7) || !ccw(p6, p7, p8) || !ccw(p7, p8, p1)) return false; 

        return true;
    }

    /**
     * 선분의 방향 판정 (CCW)
     * 이 결과가 음수라면 시계 방향 (끼인각이 180도 미만)
     * @param p1
     * @param p2
     * @param p3
     * @return
     */
    private static boolean ccw(Point p1, Point p2, Point p3) {
        return ((p2.x - p1.x) * (p3.y - p1.y) - (p3.x - p1.x) * (p2.y - p1.y)) < 0;
    }
}

class Point {
    public double x, y;
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }
}