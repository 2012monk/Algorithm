package BOJ.N21611마법사상어블리자드;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] seq;
    static int[] marvels;
    static int[] res = new int[4];
    static int N, M;


    static void build() {
        int[][] dt = {{0, -1}, {1, 0}, {0, 1}, {-1, 0}};
        int x = N / 2, y = N / 2, n = 2;
        int len = 1, d = 0;
        boolean flag = false;

        while (!(x == 0 && y == 0)) {
            for (int i = 0; i < len; i++) {
                x += dt[d][0];
                y += dt[d][1];
                marvels[n] = seq[x][y];
                seq[x][y] = n++;
                if (x == 0 && y == 0) break;
            }
            d = (d + 1) % 4;
            if (flag) len++;
            flag = !flag;
        }
    }

    static void destroy(int d, int s) {
        int[][] dt = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        int x = N / 2, y = N / 2,dx ,dy;
        for (int i = s; i > 0; i--) {
            dx = x + dt[d][0] * i;
            dy = y + dt[d][1] * i;
            if (dx < 0 || dx >= N || dy < 0 || dy >= N)
                continue;
            marvels[seq[dx][dy]] = 0;
        }
        fill();
    }

    static void pop() {
        int color = marvels[2], len = 1;
        boolean flag = false;

        for (int i = 3; i <= N * N + 1; i++) {
            int now = marvels[i];
            if (now == color) {
                len++;
                continue;
            }
            if (len > 3) {
                res[color] += len;
                flag = true;
                for (int j = i - len; j < i; j++) marvels[j] = 0;
            }
            if (now == 0)
                break;
            len = 1;
            color = now;
        }
        if (flag){
            fill();
            pop();
        }
    }

    static void fill() {
        for (int i = 2; i < N * N; i++) {
            if (marvels[i] > 0) continue;

            int j = i + 1;
            while (j <= N * N && marvels[j] == 0) j++;

            if (j <= N * N) {
                marvels[i] = marvels[j];
                marvels[j] = 0;
            }
        }
    }

    static int[] div() {
        int start = 2, size = N * N, color = marvels[2], len = 1;
        int[] r = new int[size + 1];

        for (int i = 3; i <= size; i++) {
            int now = marvels[i];
            if (now == color) {
                len++;
                continue;
            }
            r[start] = len;
            if (start + 1 <= size)
                r[start + 1] = color;
            else
                break;
            if (start + 2 <= size)
                start += 2;
            else
                break;
            if (now == 0)
                break;
            color = now;
            len = 1;
        }
        return r;
    }

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());

        seq = new int[N][N];
        marvels = new int[N*N+1];

        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0 ; j < N ; j ++ ) {
                seq[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        build();

        int d, s;
        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());
            d = Integer.parseInt(stz.nextToken()) - 1;
            s = Integer.parseInt(stz.nextToken());
            destroy(d, s);
            pop();
            marvels = div();
        }
        System.out.println(res[1] + res[2] * 2 + res[3] * 3);
    }
}
