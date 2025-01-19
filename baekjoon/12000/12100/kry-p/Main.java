import java.util.*;
import java.io.*;

public class Main {
    private final static int MAXIMUM_PHASE = 5;
    private static int n;
    private static int max;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(reader.readLine());
        int[][] map = new int[n][n];
        for (int i = 0; i < n; i++) map[i] = Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        run(map, 0);
        System.out.print(max);
    } 

    private static void printMap(int[][] map) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        } 
    }

    private static void run(int[][] map, int currentPhase) {
        if (currentPhase == MAXIMUM_PHASE) {
            max = Math.max(max, findLargestBlock(map));
            return;
        }
        run(moveLeft(map), currentPhase + 1);
        run(moveRight(map), currentPhase + 1);
        run(moveUp(map), currentPhase + 1);
        run(moveDown(map), currentPhase + 1);
    }

    private static int findLargestBlock(int[][] map) {
        int max = 0;
        for (int i = 0; i < n; i++) 
            for (int j = 0; j < n; j++)
                max = Math.max(max, map[i][j]);
        return max;
    }

    private static int[][] moveLeft(int[][] map) {
        int[][] result = new int[n][n];
        Deque<Block>[] lines = new ArrayDeque[n];
        for (int i = 0; i < n; i++) {
            lines[i] = new ArrayDeque<>();
            Deque<Block> currentLine = lines[i];
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) continue;
                if (currentLine.isEmpty()) currentLine.addLast(new Block(map[i][j], false));
                else {
                    Block previous = currentLine.pollLast();
                    if (!previous.isMerged && map[i][j] == previous.amount) 
                        currentLine.addLast(new Block(previous.amount * 2, true));
                    else {
                        currentLine.addLast(previous);
                        currentLine.addLast(new Block(map[i][j], false));
                    }
                }
            }
            int currentIndex = 0;
            while (!currentLine.isEmpty()) {
                Block polled = currentLine.pollFirst();
                result[i][currentIndex] = polled.amount;
                currentIndex += 1;
            }
        }
        return result;
    }
    private static int[][] moveRight(int[][] map) {
        int[][] result = new int[n][n];
        Deque<Block>[] lines = new ArrayDeque[n];
        for (int i = 0; i < n; i++) {
            lines[i] = new ArrayDeque<>();
            Deque<Block> currentLine = lines[i];
            for (int j = n - 1; j >= 0; j--) {
                if (map[i][j] == 0) continue;
                if (currentLine.isEmpty()) currentLine.addLast(new Block(map[i][j], false));
                else {
                    Block previous = currentLine.pollLast();
                    if (!previous.isMerged && map[i][j] == previous.amount) 
                        currentLine.addLast(new Block(previous.amount * 2, true));
                    else {
                        currentLine.addLast(previous);
                        currentLine.addLast(new Block(map[i][j], false));
                    }
                }
            }
            int currentIndex = n - 1;
            while (!currentLine.isEmpty()) {
                Block polled = currentLine.pollFirst();
                result[i][currentIndex] = polled.amount;
                currentIndex -= 1;
            }
        }
    
        return result;
    }
    private static int[][] moveUp(int[][] map) {
        int[][] result = new int[n][n];
        Deque<Block>[] lines = new ArrayDeque[n];
        for (int i = 0; i < n; i++) {
            lines[i] = new ArrayDeque<>();
            Deque<Block> currentLine = lines[i];
            for (int j = 0; j < n; j++) {
                if (map[j][i] == 0) continue;
                if (currentLine.isEmpty()) currentLine.addLast(new Block(map[j][i], false));
                else {
                    Block previous = currentLine.pollLast();
                    if (!previous.isMerged && map[j][i] == previous.amount) 
                        currentLine.addLast(new Block(previous.amount * 2, true));
                    else {
                        currentLine.addLast(previous);
                        currentLine.addLast(new Block(map[j][i], false));
                    }
                }
            }
            int currentIndex = 0;
            while (!currentLine.isEmpty()) {
                Block polled = currentLine.pollFirst();
                result[currentIndex][i] = polled.amount;
                currentIndex += 1;
            }
        }
        return result;
    }
    private static int[][] moveDown(int[][] map) {
        int[][] result = new int[n][n];
        Deque<Block>[] lines = new ArrayDeque[n];
        for (int i = 0; i < n; i++) {
            lines[i] = new ArrayDeque<>();
            Deque<Block> currentLine = lines[i];
            for (int j = n - 1; j >= 0; j--) {
                if (map[j][i] == 0) continue;
                if (currentLine.isEmpty()) currentLine.addLast(new Block(map[j][i], false));
                else {
                    Block previous = currentLine.pollLast();
                    if (!previous.isMerged && map[j][i] == previous.amount) 
                        currentLine.addLast(new Block(previous.amount * 2, true));
                    else {
                        currentLine.addLast(previous);
                        currentLine.addLast(new Block(map[j][i], false));
                    }
                }
            }
            int currentIndex = n - 1;
            while (!currentLine.isEmpty()) {
                Block polled = currentLine.pollFirst();
                result[currentIndex][i] = polled.amount;
                currentIndex -= 1;
            }
        }
        return result;
    }
}

class Block {
    public int amount;
    public boolean isMerged;
    public Block(int amount, boolean isMerged) {
        this.amount = amount;
        this.isMerged = isMerged;
    }
}