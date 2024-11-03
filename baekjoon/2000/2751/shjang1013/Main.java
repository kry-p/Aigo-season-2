import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        // Scanner 대신 입력값 받기
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int testCase = Integer.parseInt(bufferedReader.readLine());  // readLine을 사용하기 위해선 IOException 필요
        ArrayList<Integer> arrayList = new ArrayList<>();

        for(int i = 0; i < testCase; i++) {
            arrayList.add(Integer.parseInt(bufferedReader.readLine()));
        }
        // 배열 정렬
        Collections.sort(arrayList);

        // 데이터 하나씩 println 할 경우 시간초과 발생 -> StringBuilder 담아서 출력하기
        for(int value : arrayList) {
            sb.append(value).append('\n');
        }
        System.out.println(sb);
    }
}