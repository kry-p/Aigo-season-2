import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static char[] lineArray;

    public static void recursion(int start, int num) {
        // num이 0일 때 재귀함수 멈춤
        if(num == 0)
            return;

        // 가운데 문자열을 공백으로 바꾼다
        int N = (int)Math.pow(3, num-1);
        for(int i = N+start; i < N*2+start; i++) {
            lineArray[i] = ' ';
        }

        // 재귀
        recursion(start, num-1);
        recursion(start+N*2, num-1);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = "";

        while((str = br.readLine()) != null) {
            int num = Integer.parseInt(str);
            StringBuilder sb = new StringBuilder();

            // 3의 num승의 길이로 된 선을 문자열에 채운다
            lineArray = new char[(int)Math.pow(3, num)];
            Arrays.fill(lineArray, '-');

            // 재귀함수
            recursion(0, num);

            // 출력
            for(int i = 0; i < lineArray.length; i++) {
                sb.append(lineArray[i]);
            }
            System.out.println(sb);
        }
    }
}