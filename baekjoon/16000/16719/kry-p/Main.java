import java.io.*;
import java.util.*;

public class Main {
    private static StringBuilder builder = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String current = reader.readLine();
        char[] charArray = current.toCharArray();
        zoac(charArray, new boolean[charArray.length], 0, charArray.length - 1);
        System.out.print(builder.toString());
    }
    
    private static void zoac(char[] charArray, boolean[] isVisited, int start, int end) {
        if (start > end) return; // 구하려는 길이가 1 미만이면 종료
        int currentIndex = start;

        for (int i = start; i <= end; i++) 
            // 구간 내 사전 순으로 가장 앞인 문자를 찾음
            if (charArray[currentIndex] > charArray[i]) currentIndex = i;
        isVisited[currentIndex] = true;

        // 방문했으면 문자열에 더함
        for (int i = 0; i < charArray.length; i++) 
            if (isVisited[i]) builder.append(charArray[i]);
        
        builder.append("\n");
        zoac(charArray, isVisited, currentIndex + 1, end); 
        zoac(charArray, isVisited, start, currentIndex - 1);
    }
}
