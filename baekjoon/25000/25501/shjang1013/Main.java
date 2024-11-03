import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int count;
    public static int isPalindrome(String str, int l, int r) {
        count += 1;
        if(l >= r) return 1;
        else if(str.charAt(l) != str.charAt(r)) return 0;
        else return isPalindrome(str, l+1, r-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 테스트케이스
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            count = 0;
            String str = br.readLine();
            System.out.println(isPalindrome(str, 0, str.length()-1) + " " + count);
        }
    }
}