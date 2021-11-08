package BOJ.N19237어른상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Shark {
        int s, x, y, c;
        int[][] p = new int[4][4];

        public Shark(int x, int y, int c) {
            this.x = x;
            this.y = y;
            this.c = c;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int[][] grid = new int[20][20];
    static int[][] status = new int[20][20];
    static Shark[] sharks;
    static int M, N, K;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean next(Shark s, int t, int comp) {
        for (int d : s.p[s.c]) {
            int nx = s.x + dx[d];
            int ny = s.y + dy[d];
            if (nx < 0 || nx >= N || ny < 0 || ny >= N)
                continue;
            if (comp == 0 && grid[nx][ny] != 0 && status[nx][ny] > t)
                continue;
            if (comp != 0 && grid[nx][ny] != comp)
                continue;
            s.x = nx;
            s.y = ny;
            s.c = d;
            return true;

        }
        return false;
    }

    static void mark(int t) {
        Shark s;
        for (int i = 1; i <= M; i++) {
            s = sharks[i];
            if (s == null)
                continue;
            if (grid[s.x][s.y] > 0 &&
                    grid[s.x][s.y] < i && status[s.x][s.y] == t + K) {
                sharks[i] = null;
                continue;
            }
//            System.out.printf("%d %d %d\n", grid[s.x][s.y], status[s.x][s.y], i);
            grid[s.x][s.y] = i;
            status[s.x][s.y] = t + K;
        }
    }

    static void debug() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N * 2; j++) {
                if (j == N) {
                    System.out.print(" ");
                }
                if (j < N) {
                    System.out.printf("%d ", grid[i][j]);
                } else {
                    System.out.printf("%d ", status[i][j - N]);
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    static boolean isAlone() {
        for (int i = 2; i <= M; i++) {
            if (sharks[i] != null)
                return false;
        }
    return true;
    }

    static int solve() {

//        debug();
        for (int t = 0; t < 1001; t++) {
            mark(t);
            if (isAlone())
                return t;
            for (int i = 1; i <= M; i++) {
                if (sharks[i] == null)
                    continue;
                if (!next(sharks[i], t, 0)) {
                    next(sharks[i], t, i);
                }
            }
//            debug();
        }

        return -1;
    }

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        sharks = new Shark[M + 1];
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int t = Integer.parseInt(stz.nextToken());
                if (t == 0)
                    continue;
                sharks[t] = new Shark(i, j, 0);
            }
        }
        stz = new StringTokenizer(br.readLine());
        for (int i = 1; i <= M; i++) {
            sharks[i].c = Integer.parseInt(stz.nextToken()) - 1;
        }
        for (int i = 1; i <= M; i++) {
            for (int j = 0; j < 4; j++) {
                stz = new StringTokenizer(br.readLine());
                for (int k = 0; k < 4; k++) {
                    sharks[i].p[j][k] = Integer.parseInt(stz.nextToken()) - 1;
                }
            }
        }
        System.out.println(solve());
    }
}
