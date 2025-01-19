import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int[] abc = readoutIntegerArray(reader);
        int[] xy = readoutIntegerArray(reader);
        int a = abc[0], b = abc[1], c = abc[2];
        int x1 = xy[0], x2 = xy[1], y1 = xy[2], y2 = xy[3];
       
        ArrayList<Point> points = new ArrayList<>();
        points.add(new Point(x1, y1));
        points.add(new Point(x1, y2));
        points.add(new Point(x2, y1));
        points.add(new Point(x2, y2));
        
        int isUp = 0, isDown = 0;

        for (Point p : points) {
            int res = a * p.x + b * p.y;
            if (res >= -c) isUp += 1;
            if (res <= -c) isDown += 1; 
        }

        System.out.print((isUp == 4 || isDown == 4) ? "Lucky" : "Poor");
    }

    private static int[] readoutIntegerArray(BufferedReader reader) throws IOException {
        return Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}

class Point {
    public int x, y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}