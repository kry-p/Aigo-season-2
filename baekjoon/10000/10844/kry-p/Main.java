import java.util.Scanner;

public class Main {

    private static long memo[][];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        long result = 0;
        memo = new long[10][100];

        for (int i = 1; i <= 9; i++) {
            result += stair(i, input - 1);
        }

        System.out.println(result % 1000000000);
        scanner.close();
    }

    private static long stair(int current, int digits) {
        if (memo[current][digits] > 0) {
            return memo[current][digits];
        }
        if (digits == 0) {
            return memo[current][digits] = 1;
        } else {
            if (current > 0 && current < 9) {
                return memo[current][digits] = (stair(current - 1, digits - 1) + stair(current + 1, digits - 1))
                        % 1000000000;
            } else {
                if (current == 9) {
                    return memo[current][digits] = stair(8, digits - 1) % 1000000000;
                } else if (current == 0) {
                    return memo[current][digits] = stair(1, digits - 1) % 1000000000;
                } else {
                    return 0;
                }
            }
        }
    }
}
