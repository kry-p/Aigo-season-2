import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        long[] input = Arrays.stream(reader.readLine().split(" ")).mapToLong(Long::parseLong).toArray();
        long x = input[0], y = input[1], w = input[2], s = input[3];
        long route1 = (x + y) * w; // 수평, 수직으로만 이동한다.
        // x 이동과 y 이동의 합이 짝수라면 대각선만으로 이동 가능하다.
        // 그렇지 않다면 긴 쪽 기준으로 이동하고 1번 수평 또는 수직으로 이동한다.
        long route2 = (x + y) % 2 == 0 ? Math.max(x, y) * s : (Math.max(x, y) - 1) * s + w;
        // 수평, 수직으로 이동 후 대각선으로 이동한다.
        long route3 = Math.min(x, y) * s + Math.abs(x - y) * w;
        System.out.print(Math.min(route1, Math.min(route2, route3)));
        reader.close();
    }
}