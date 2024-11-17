package Algo241020;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.awt.*;


public class boj20056 {
	
	static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] o = {0, 2, 4, 6};
    static int[] x = {1, 3, 5, 7};
    static ArrayList<FireBall> list;
    static ArrayList<FireBall>[][] fireBalls;
    static int n, m, k, tmp = 0;
	    
	static StringBuilder sb = new StringBuilder();
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		br = new BufferedReader(new InputStreamReader(System.in));

        // 입력
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        fireBalls = new ArrayList[n][n];
        list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                fireBalls[i][j] = new ArrayList<>();
            }
        }

       // 초기 파이어볼 지정
       for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list.add(new FireBall(r, c, m, s, d));
            tmp += m;
        }
       
       	for(int i = 0; i < k; i++) {
       		move();		// 이동
            divide();	// 2개 이상일경우 나누기
       	}
       	
       	sb.append(tmp + "\n");
       	
       	System.out.println(sb);
	}
	
	static void move() {
		// 좌표 이동 후 다시 리스트에 담기
        for(FireBall cur : list) {
            //좌표 모듈러 연산(나머지)
            int nr = ((cur.s) % n * dx[cur.d] + n + cur.r) % n;
            int nc = ((cur.s) % n * dy[cur.d] + n + cur.c) % n;
            cur.r = nr;
            cur.c = nc;
            fireBalls[nr][nc].add(cur);
        }
    }

    static void divide() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 2개 이상의 파이어볼이 있을 경우
                if(fireBalls[i][j].size() == 1) {
                    fireBalls[i][j].clear();
                }
                if(fireBalls[i][j].size() < 2) {
                    continue;
                }

                // 파이어볼 하나로 합치기
                int mSum = 0;
                int sSum = 0;
                int even = 0;
                int odd = 0;

                for(FireBall cur : fireBalls[i][j]) {
                    sSum += cur.s;
                    mSum += cur.m;
                    // 방향
                    if(cur.d % 2 == 0) {
                        even++;
                    } else {
                        odd++;
                    }

                    //파이어볼을 합쳐야 하니 리스트에서 하나씩 삭제해준다.
                    list.remove(cur);
                }
                
                tmp -= mSum;
                int newM = mSum / 5;
                int newS = sSum / fireBalls[i][j].size();
                fireBalls[i][j].clear();

                //파이어볼을 나눈 후 질량이 0이라면, 파이어볼 소멸
                if(newM < 1) {
                    continue;
                }

                //파이어볼 4개로 나누기
                for (int r = 0; r < 4; r++) {
                    int newD = (odd == 0 || even == 0 ? o[r] : x[r]); // 홀짝
                    list.add(new FireBall(i, j, newM ,newS, newD));
                    tmp += newM;
                }
            }
        }
    }

	
}

class FireBall {
    int r;
    int c;
    int m;	// 질량
    int s;	// 속력
    int d;	// 방향

    public FireBall(int r, int c, int m, int s, int d) {
        this.r = r;
        this.c = c;
        this.m = m;
        this.s = s;
        this.d = d;
    }
}
