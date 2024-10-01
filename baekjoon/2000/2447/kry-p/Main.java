import java.io.*;

public class Main {
    private static StringBuilder builder;
    public static void main(String[] args) throws Throwable {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        builder = new StringBuilder();
        int n = Integer.parseInt(reader.readLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) 
                draw(i, j, n);
            builder.append("\n");
        }
        System.out.println(builder.toString());
    }

    public static void draw(int i, int j, int size) {
        if ((i / size) % 3 == 1 && (j / size) % 3 == 1) builder.append(" ");
        else {
            if (size / 3 == 0) builder.append("*");
            else draw(i, j, size / 3);
        }
    }
}