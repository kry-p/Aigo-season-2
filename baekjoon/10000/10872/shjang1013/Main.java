import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int result = 1;

    public static int Factorial(int N) {
        if(N <= 1) return result;
        return N * Factorial(N-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 정수 N
        int N = Integer.parseInt(br.readLine());
        System.out.println(Factorial(N));
    }
}