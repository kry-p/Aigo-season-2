import java.util.*;
import java.io.*;

public class Main {
    private static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] lc = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int l = lc[0], c = lc[1];
        boolean[] isVisited = new boolean[c];
        String[] strarr = reader.readLine().split(" ");
        Arrays.sort(strarr);
        dfs(0, 0, l, strarr, isVisited);
        System.out.print(builder.toString());
    }

    private static void dfs(int start, int depth, int targetDepth, String[] strarr, boolean[] isVisited) {
        if (depth == targetDepth) {
            StringBuilder test = new StringBuilder();
            int vowels = 0;
            int consonants = 0;
            for (int i = 0; i < strarr.length; i++) {
                if (isVisited[i]) {
                    String current = strarr[i];
                    test.append(current);
                    if (current.equals("a") || current.equals("e") || 
                        current.equals("i") || current.equals("o") || 
                        current.equals("u"))
                        vowels += 1;
                    else
                        consonants += 1;
                }
            }
            if (vowels > 0 && consonants > 1) builder.append(test.toString() + "\n");
            return;
        }
        for (int i = start; i < strarr.length; i++) {
            isVisited[i] = true;
            dfs(i + 1, depth + 1, targetDepth, strarr, isVisited);
            isVisited[i] = false;
        }
    }
}