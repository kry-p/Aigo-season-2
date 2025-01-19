import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] size = reader.readLine().split(" ");
        int max = 0, temp = 0;
        int[][] array = new int[Integer.parseInt(size[0])][Integer.parseInt(size[1])];
        for (int i = 0; i < array.length; i++) 
            array[i] = Arrays.stream(reader.readLine().split("")).mapToInt(Integer::parseInt).toArray();

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                int current = array[i][j];
                for (int k = 0; k < Math.min(array.length, array[0].length); k++) {
                    if (i + k < array.length && j + k < array[0].length) {
                        if (current == array[i][j + k] && current == array[i + k][j] && current == array[i + k][j + k]) {
                            temp = (k + 1) * (k + 1);
                            max = Math.max(max, temp);
                        }
                    }
                }
            }
        }
        System.out.println(max);
    }
}
