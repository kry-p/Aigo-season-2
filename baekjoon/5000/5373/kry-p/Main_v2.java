import java.util.*;
import java.io.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder builder = new StringBuilder();
        int t = Integer.parseInt(reader.readLine());
        while (t-- > 0) {
            Integer.parseInt(reader.readLine()); // 입력 버림 
            String[] commands = reader.readLine().split(" ");
            RubiksCube cube = new RubiksCube();
            for (String command : commands) cube.runCommand(command);
            builder.append(cube.getTopColors());
        }
        System.out.print(builder.toString());
    }
}

class RubiksCube {
    private final static char UP_DEFAULT = 'w', DOWN_DEFAULT = 'y', FRONT_DEFAULT = 'r', 
                            BACK_DEFAULT = 'o', LEFT_DEFAULT = 'g', RIGHT_DEFAULT = 'b';
    private char[][] up, down, front, back, left, right;
    public RubiksCube() { initializeCube(); }
    public void runCommand(String command) {
        char side = command.charAt(0);
        boolean isClockwise = command.charAt(1) == '+';
        int runCount = isClockwise ? 1 : 3;
        while (runCount-- > 0) {
            switch(side) {
                case 'U':
                    rotateUp();
                    break;
                case 'D':
                    rotateDown();
                    break;
                case 'F':
                    rotateFront();
                    break;
                case 'B':
                    rotateBack();
                    break;
                case 'L':
                    rotateLeft();
                    break;
                case 'R':
                    rotateRight();
                    break;
                default:
                    return;
            }
        }  
    }
    public String getTopColors() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++)
                builder.append(up[i][j]);
            builder.append("\n");
        }
        return builder.toString();
    }

    private void initializeCube() {
        this.up = new char[3][3];
        this.down = new char[3][3];
        this.front = new char[3][3];
        this.back = new char[3][3];
        this.left = new char[3][3];
        this.right = new char[3][3];
        for (int i = 0; i < 3; i++) {
            Arrays.fill(this.up[i], UP_DEFAULT);
            Arrays.fill(this.down[i], DOWN_DEFAULT);
            Arrays.fill(this.front[i], FRONT_DEFAULT);
            Arrays.fill(this.back[i], BACK_DEFAULT);
            Arrays.fill(this.left[i], LEFT_DEFAULT);
            Arrays.fill(this.right[i], RIGHT_DEFAULT);
        }
    }
    private char[][] rotateCurrentSide(char[][] side) {
        char[][] temp = new char[3][3];
        for (int i = 0; i < 3; i++) 
	        for (int j = 0; j < 3; j++) temp[j][3 - 1 - i] = side[i][j];
        return temp;
    }
    /**
     * 회전 시 수행해주어야 하는 동작은 아래와 같다.
     * - 가운데를 제외한 해당 면의 바깥 8개를 해당 방향으로 2칸씩 이동 (배열 시계방향 / 반시계방향 회전)
     * - 인접한 4면의 요소를 해당 방향으로 3칸씩 이동
     * - 반시계방향 회전 = 시계방향 회전 * 3 으로 간주
     */
    // 윗면
    private void rotateUp() {
        up = rotateCurrentSide(up);
        char[] temp = { front[0][0], front[0][1], front[0][2] };
        for (int i = 0; i < 3; i++) front[0][i] = right[2 - i][0];
        for (int i = 0; i < 3; i++) right[2 - i][0] = back[2][2 - i];
        for (int i = 0; i < 3; i++) back[2][i] = left[2 - i][2];
        for (int i = 0; i < 3; i++) left[i][2] = temp[i]; 
    }   
    // 아랫면
    private void rotateDown() {
        down = rotateCurrentSide(down);
        char[] temp = { front[2][0], front[2][1], front[2][2] };
        for (int i = 0; i < 3; i++) front[2][i] = left[i][0];
        for (int i = 0; i < 3; i++) left[i][0] = back[0][2 - i];
        for (int i = 0; i < 3; i++) back[0][i] = right[i][2];
        for (int i = 0; i < 3; i++) right[i][2] = temp[2 - i];
    }
    // 앞면
    private void rotateFront() {
        front = rotateCurrentSide(front);
        char[] temp = { up[2][0], up[2][1], up[2][2] };
        for (int i = 0; i < 3; i++) up[2][i] = left[2][i];
        for (int i = 0; i < 3; i++) left[2][i] = down[0][2 - i];
        for (int i = 0; i < 3; i++) down[0][i] = right[2][2 - i];
        for (int i = 0; i < 3; i++) right[2][i] = temp[i];
    }
    // 뒷면
    private void rotateBack() {
        back = rotateCurrentSide(back);
        char[] temp = { up[0][0], up[0][1], up[0][2] };
        for (int i = 0; i < 3; i++) up[0][i] = right[0][i];
        for (int i = 0; i < 3; i++) right[0][i] = down[2][2 - i];
        for (int i = 0; i < 3; i++) down[2][i] = left[0][2 - i];
        for (int i = 0; i < 3; i++) left[0][i] = temp[i]; 
    }
    // 왼쪽면
    private void rotateLeft() {
        left = rotateCurrentSide(left);
        char[] temp = { up[0][0], up[1][0], up[2][0] };
        for (int i = 0; i < 3; i++) up[i][0] = back[i][0];
        for (int i = 0; i < 3; i++) back[i][0] = down[i][0];
        for (int i = 0; i < 3; i++) down[i][0] = front[i][0];
        for (int i = 0; i < 3; i++) front[i][0] = temp[i]; 
    }
    // 오른쪽면
    private void rotateRight() {
        right = rotateCurrentSide(right);
        char[] temp = { up[0][2], up[1][2], up[2][2] };
        for (int i = 0; i < 3; i++) up[i][2] = front[i][2];
        for (int i = 0; i < 3; i++) front[i][2] = down[i][2];
        for (int i = 0; i < 3; i++) down[i][2] = back[i][2];
        for (int i = 0; i < 3; i++) back[i][2] = temp[i];
    }   
}