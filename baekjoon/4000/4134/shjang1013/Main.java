import java.util.Scanner;

public class Main {
    public static long solution(long num) {
        // 0, 1는 while 로직을 타지 않음
        if(num == 0 || num == 1) {
            return 2;
        }

        while(true) {
            // 0과 1은 소수가 아니므로 시작은 2부터
            for(int i = 2; i <= num; i++) {
                if(num % i == 0) {
                    // num의 약수가 1과 자기자신일 경우 return
                    if (i == num)
                        return num;
                    break;
                }
                // 제곱근까지 확인하여 나누어떨어지지 않으면 return
                if(i == (int)Math.sqrt(num))
                    return num;
            }
            num += 1;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCase = scanner.nextInt();

        for(int i = 0; i < testCase; i++) {
            long num = scanner.nextLong();
            System.out.println(solution(num));
        }
    }
}