import java.io.*;
import java.util.*;

public class Main {
    private static ArrayList<String> buttons = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int digits = Integer.toString(n).length();
        if (m == 0) {
            System.out.print(Math.min(Math.abs(n - 100), digits));
            System.exit(0);
        }
        int[] unavailableButtons = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        if (n == 100) {
            System.out.print(0);
            System.exit(0);
        }
        int min = Integer.MAX_VALUE;
        boolean[] isAvailable = new boolean[10];
        Arrays.fill(isAvailable, true);
        for (int i : unavailableButtons) isAvailable[i] = false;
        for (int i = 0; i <= 1000000; i++) {
            int start = 100;
            boolean isDirectAvailable = true;
            if (i == 100) {
                min = Math.min(min, Math.abs(n - i));
                continue;
            }
            String current = Integer.toString(i);
            for (int j = 0; j < current.length(); j++) {
                int currentDigit = Integer.parseInt(current.substring(j, j + 1));
                if (!isAvailable[currentDigit]) {
                    isDirectAvailable = false;
                    break;
                }
            }
            if (isDirectAvailable) min = Math.min(min, Math.abs(n - i) + Integer.toString(i).length());
        }
        if (min == Integer.MAX_VALUE) System.out.print(Math.abs(n - 100) + digits);
        else System.out.print(min);
    }
}
