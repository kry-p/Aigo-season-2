import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int result = 0;
        int testCase = Integer.parseInt(br.readLine());

        for(int i = 0; i < testCase; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            int circle = Integer.parseInt(br.readLine());

            for (int j = 0; j < circle; j++) {

                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int radius = Integer.parseInt(st.nextToken());

                if((Math.pow(x1-x, 2) + Math.pow(y1-y, 2) < Math.pow(radius, 2)) &&
                        (Math.pow(x2-x, 2) + Math.pow(y2-y, 2) < Math.pow(radius, 2))) {
                    continue;
                }
                if(Math.pow(x1-x, 2) + Math.pow(y1-y, 2) < Math.pow(radius, 2)) {
                    result += 1;
                } else if(Math.pow(x2-x, 2) + Math.pow(y2-y, 2) < Math.pow(radius, 2)) {
                    result += 1;
                }
            }
            System.out.println(result);
            result = 0;
        }
    }
}