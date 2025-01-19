import java.util.*;

public class Main {
  private final static int DIVISOR = 1000000000;
  public static void main(String args[]) {
    Scanner scanner = new Scanner(System.in);
    int input = scanner.nextInt();
    scanner.close();

    int[] dpPositive = new int[1000000 + 1];
    int[] dpNegative = new int[1000000 + 1];
    dpPositive[0] = 0;
    dpPositive[1] = 1;
    dpNegative[0] = 0;
    dpNegative[1] = 1;

    for (int i = 2; i <= 1000000; i++) {
      dpPositive[i] = (dpPositive[i - 1] + dpPositive[i - 2]) % DIVISOR;
      dpNegative[i] = (dpNegative[i - 2] - dpNegative[i - 1]) % DIVISOR;
    }
    
    if (input == 0) {
      System.out.print("0\n0");
    } else {
      if (input > 0) {
        System.out.print(1 + "\n" + dpPositive[input]);
      } else {
        int result = dpNegative[Math.abs(input)];
        boolean isZero = result == 0;
        boolean isPositive = result > 0;
        System.out.print((isZero ? 0 : (isPositive ? 1 : -1)) + "\n" + Math.abs(result));
      }
    }
  }
}