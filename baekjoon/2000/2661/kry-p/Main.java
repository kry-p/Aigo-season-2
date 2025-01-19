import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine()); 
        dfs(new int[n], 0, n);  
    }

    private static void dfs(int[] array, int currentLength, int targetLength) {
        if (currentLength == targetLength) {
            if (!isGoodArray(array, targetLength)) return;
            StringBuilder builder = new StringBuilder();
            for (int i : array) builder.append(i);
            System.out.print(builder.toString());
            System.exit(0);
        }
        for (int i = 1; i <= 3; i++) {
            array[currentLength] = i;
            if (isGoodArray(array, currentLength + 1)) dfs(array, currentLength + 1, targetLength);
        }
    }

    private static boolean isGoodArray(int[] array, int targetLength) {
        int maximumSize = targetLength / 2;
        for (int i = 1; i <= maximumSize; i++) {
            int maximumCurrentStartIndex = targetLength - i * 2 + 1;
            for (int j = 0; j < maximumCurrentStartIndex; j++) {
                boolean flag = true;
                for (int k = j; k < j + i; k++) {
                    if (array[k] != array[k + i]) {
                        flag = false;
                        break;
                    }
                }
                if (flag) return false;
            }
        }
        return true;
    }
}