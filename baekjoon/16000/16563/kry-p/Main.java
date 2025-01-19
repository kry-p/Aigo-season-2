import java.util.*;
import java.io.*;

public class Main {
    private final static int MAXIMUM = 5000000;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        int[] numbers = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int[] largestPrimeFactors = new int[MAXIMUM + 1];
        calculateLargestPrimesFactor(largestPrimeFactors);
        for (int i = 0; i < n; i++) 
            builder.append(find(largestPrimeFactors, numbers[i]) + "\n");
        System.out.print(builder.toString());
    }

    // 배열에 자기 자신의 소인수 중 최댓값을 기록 (에라소트테네스의 체 생성)
    private static void calculateLargestPrimesFactor(int[] primes) {
        for (int i = 2; i <= MAXIMUM; i++) 
            primes[i] = i;
        for (int i = 2; i * i <= MAXIMUM; i++) 
            for (int j = i * i; j <= MAXIMUM; j += i) 
                if (primes[j] == j) primes[j] = i;
    }

    private static String find(int[] primeFactors, int target) {
        StringBuilder currentPrimes = new StringBuilder();
        // 해당 숫자가 가질 수 있는 최대 소인수로 나누어 1이 될 때까지 반복
        while (target > 1) {
            currentPrimes.append(primeFactors[target] + " ");
            target /= primeFactors[target];
        }
        return currentPrimes.toString();
    }
}
