import java.util.Scanner;

public class Main {
    public static int solution(int n, int m) {
        int result = 1;
        // 조합 계산할 숫자 구하기
        int num = Math.min(n, m-n);

        for(int i = 0; i < num; i++) {
            result *= (m-i);
            result /= (i+1);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for(int i = 0; i < testCase; i++) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            System.out.println(solution(n, m));
        }
    }
}