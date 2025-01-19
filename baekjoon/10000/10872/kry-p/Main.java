import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        System.out.println(getFactorial(n));
    }

    private static int getFactorial(int number) {
        if (number < 2) return 1;
        return getFactorial(number - 1) * number;
    }
}