import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int answer = 0;
        for (int i = 1; i * i <= n; ++i) answer += 1;
        System.out.print(answer);
    }
}