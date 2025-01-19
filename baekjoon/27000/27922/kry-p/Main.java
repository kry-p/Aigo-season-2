import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] nk = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        int n = nk[0], k = nk[1];
        ArrayList<Integer> ab = new ArrayList<>();
        ArrayList<Integer> ac = new ArrayList<>();
        ArrayList<Integer> bc = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int[] currentLecture = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            Lecture current = new Lecture(currentLecture[0], currentLecture[1], currentLecture[2]);
            ab.add(current.a + current.b);
            ac.add(current.a + current.c);
            bc.add(current.b + current.c);
        }
        Collections.sort(ab, Collections.reverseOrder());
        Collections.sort(ac, Collections.reverseOrder());
        Collections.sort(bc, Collections.reverseOrder());
        int sumAB = 0, sumAC = 0, sumBC = 0;
        for (int i = 0; i < k; i++) {
            sumAB += ab.get(i);
            sumAC += ac.get(i);
            sumBC += bc.get(i);
        }
        System.out.print(Math.max(sumAB, Math.max(sumAC, sumBC)));
    }
}

class Lecture {
    public int a, b, c;
    public Lecture(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}