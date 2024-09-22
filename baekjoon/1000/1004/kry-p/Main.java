import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            int result = 0;
            int[] pos = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int startX = pos[0];
            int startY = pos[1];
            int finishX = pos[2];
            int finishY = pos[3];
            int system = Integer.parseInt(reader.readLine());
            boolean[] startIncluded = new boolean[system];
            boolean[] finishIncluded = new boolean[system];
            Circle[] systems = new Circle[system]; 
            for (int j = 0; j < system; j++) {
                int[] input = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                systems[j] = new Circle(input[0], input[1], input[2]);
            }
            for (int j = 0; j < system; j++) {
                double distanceFromStart = Math.sqrt((Math.pow(systems[j].x - startX, 2) + Math.pow(systems[j].y - startY, 2)));
                double distanceFromFinish = Math.sqrt((Math.pow(systems[j].x - finishX, 2) + Math.pow(systems[j].y - finishY, 2)));
                if (distanceFromStart <= (double) systems[j].radius) 
                    startIncluded[j] = true;
                if (distanceFromFinish <= (double) systems[j].radius) 
                    finishIncluded[j] = true;
                if (startIncluded[j] ^ finishIncluded[j])
                    result += 1;
            }
            builder.append(result + "\n");
        }
        System.out.print(builder.toString());
    }
}

class Circle {
    public int x, y, radius;
    public Circle(int x, int y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
    }
}
