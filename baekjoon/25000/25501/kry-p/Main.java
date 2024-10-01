import java.io.*;
import java.util.*;

public class Main {
    private static int recursionCount = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        for (int i = 0; i < t; i++) {
            recursionCount = 0;
            String s = reader.readLine();
            builder.append(isPalindrome(s) + " " + recursionCount + "\n");
        }
        System.out.print(builder.toString());
    }

    public static int recursion(String s, int l, int r){
        recursionCount += 1;
        if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l + 1, r - 1);
    }
    public static int isPalindrome(String s) {
        return recursion(s, 0, s.length() - 1);
    }
}