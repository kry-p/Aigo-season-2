import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] papers;
    public static int whitepaper;
    public static int bluepaper;

    public static void cutPapers(int start, int end, int N) {

        if(N < 1)
            return;

        if(checkPapers(start, end, N)) {
            if (papers[start][end] == 1) {
                bluepaper += 1;
            } else {
                whitepaper += 1;
            }
            return;
        }

        // 4등분으로 종이자르기
        cutPapers(start, end, N/2);
        cutPapers(start, end + N/2, N/2);
        cutPapers(start + N/2, end, N/2);
        cutPapers(start + N/2, end + N/2, N/2);
    }

    public static boolean checkPapers(int x, int y, int size) {
        int n = papers[x][y];
        for(int i = x; i < x+size; i++) {
            for(int j = y; j < y+size; j++) {
                if(n != papers[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        papers = new int[N][N];

        StringTokenizer st;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine(), " ");

            for(int j = 0; j < N; j++) {
                papers[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 종이 자르기
        cutPapers(0, 0, N);

        // 하얀색, 파란색 색종이 개수 출력
        System.out.println(whitepaper);
        System.out.println(bluepaper);
    }
}