import java.util.*;
import java.io.*;

public class Main {
    private static int n, mp, mf, ms, mv;
    private static int min = Integer.MAX_VALUE;
    private static ArrayList<String> combination = new ArrayList<>();
    private static int[][] ingredients;
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        n = Integer.parseInt(reader.readLine());
        int[] m = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        mp = m[0];
        mf = m[1];
        ms = m[2];
        mv = m[3];
        ingredients = new int[n + 1][5];
        for (int i = 1; i <= n; i++) ingredients[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int currentDepth = 0;

        for (int i = 0; i < (int) Math.pow(2, n); i++) {
            String current = padLeftZeros(i, n + 1);
            boolean[] isVisited = new boolean[n + 1];
            for (int j = 0; j <= n; j++) 
                if (current.charAt(j) == '1') isVisited[j] = true;
            calculate(isVisited);
        }
        Collections.sort(combination, new Comparator<String>() {
            public int compare(String s1, String s2) {
                int[] s1Array = Arrays.stream(s1.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] s2Array = Arrays.stream(s2.split(" ")).mapToInt(Integer::parseInt).toArray();
                if (s1Array.length > s2Array.length) {
                    for (int i = 0; i < s2Array.length; i++)
                        if (s1Array[i] != s2Array[i]) return s1Array[i] - s2Array[i];
                }
                else if (s2Array.length > s1Array.length) {
                    for (int i = 0; i < s1Array.length; i++)
                        if (s1Array[i] != s2Array[i]) return s1Array[i] - s2Array[i];
                }
                else {
                    for (int i = 0; i < s1Array.length; i++) {
                        if (s1Array[i] != s2Array[i]) return s1Array[i] - s2Array[i];
                    }
                }
                return 0;
            }
        });
        if (min == Integer.MAX_VALUE || combination.size() == 0) builder.append(-1 + "\n");
        else {
            builder.append(min + "\n");
            builder.append(combination.get(0) + "\n");
        }
        System.out.print(builder.toString());
        reader.close();
    }

    private static String padLeftZeros(int number, int totalLength) {
        String formatted = Integer.toBinaryString(number);
        int length = formatted.length();
        if (length < totalLength) {
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < totalLength - length; i++) 
                builder.append("0");
            builder.append(formatted);
            formatted = builder.toString();
        }
        return formatted;
    }

    private static void calculate(boolean[] isVisited) {
        StringBuilder builder = new StringBuilder();
        int[] currentIngerdients = new int[4];
        int currentCost = 0;
        for (int i = 1; i < isVisited.length; i++) {
            if (isVisited[i]) {
                for (int j = 0; j < 4; j++) {
                    currentIngerdients[j] += ingredients[i][j];
                } 
                builder.append(i + " ");
                currentCost += ingredients[i][4];
            }       
        }
        if (mp > currentIngerdients[0] || mf > currentIngerdients[1] ||
            ms > currentIngerdients[2] || mv > currentIngerdients[3]) return;

        if (currentCost > min) return;
        if (currentCost < min) { 
            min = currentCost;
            combination.clear();
        }
        String currentCombination = builder.toString();
        if (currentCombination.length() > 0) combination.add(currentCombination.substring(0, currentCombination.length() - 1));
    }
}
