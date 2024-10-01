import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
      
        while (true) {
            String s = reader.readLine();
            if (s == null) break;
            int current = Integer.parseInt(s);
            int size = (int) Math.pow(3, current);
            boolean[] cantor = new boolean[size];
            runCantor(cantor, 0, size);
            for (boolean isTrue : cantor) {
                if (isTrue) builder.append(" ");
                else builder.append("-");
            }
            builder.append("\n");
        }
        System.out.print(builder.toString());
    }

    private static void runCantor(boolean[] cantor, int start, int end) {
        int pivot = (end - start + 1) / 3;
        int removalStartIndex = start + pivot, removalEndIndex = end - pivot;
        if (start >= end - 1) return;   
        for (int i = removalStartIndex; i < removalEndIndex; i++) cantor[i] = true;
        runCantor(cantor, start, removalStartIndex);
        runCantor(cantor, removalEndIndex, end);
    }
}