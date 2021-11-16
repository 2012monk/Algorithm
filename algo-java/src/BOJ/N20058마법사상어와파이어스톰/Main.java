package BOJ.N20058마법사상어와파이어스톰;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] board, tmp;
    static int[] seq;
    static int[] nx = {0, 0, 1, -1};
    static int[] ny = {1, -1, 0, 0};
    static int N, Q, total;

    static void rotate(int x, int y, int size) {
        if (x >= N || y >= N)
            return;
        if (tmp[x][y] != -1)
            return;
        copy(x, y, 0, 0, size, board, tmp);

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i + x][j + y] = tmp[size - 1 - j][i];
            }
        }
        clear();
//        rotate(x + size, y, size);
//        rotate(x, y + size, size);
    }

    static void melt(int x, int y) {
        int cnt = 0, dx, dy;
        tmp[x][y] = board[x][y];

        for (int k = 0; k < 4; k++) {
            dx = nx[k] + x;
            dy = ny[k] + y;
            if (dx < 0 || dx >= N || dy < 0 || dy >= N)
                continue;
            if (board[dx][dy] == 0)
                continue;
            cnt++;
        }

        if (cnt < 3 && board[x][y] > 0) {
            tmp[x][y]--;
        }
    }

    static int search(int x, int y) {
        int size = 1, dx, dy;
        total += board[x][y];
        board[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            dx = nx[i] + x;
            dy = ny[i] + y;
            if (dx < 0 || dx >= N || dy < 0 || dy >= N)
                continue;
            if (board[dx][dy] == 0)
                continue;
            size += search(dx, dy);
        }
        return size;
    }

    static void magic() {
        for (int size : seq) {
            size = 1 << size;
            for (int i = 0; i < N; i+=size) {
                for (int j = 0; j < N; j+=size) {
                    rotate(i, j, size);
                }
            }
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    melt(i, j);
                }
            }
            copy(0, 0, 0, 0, N, tmp, board);
            clear();
        }
    }

    static void print() {
        System.out.println();
        for (int[] bb : board) {
            for (int b : bb) {
                System.out.printf("%d ", b);
            }
            System.out.println();
        }
    }

    static void clear() {
        for (int i = 0; i < N; i++) {
            Arrays.fill(tmp[i], -1);
        }
    }

    static void copy(int sx, int sy, int dtx, int dty, int size, int[][] src, int[][] dst) {
        for (int i = 0; i < size; i++) {
            System.arraycopy(src[i + sx], sy, dst[dtx + i], dty, size);
        }
    }

    public static void main(String[] args) throws IOException {
        int mx = 0;
        stz = new StringTokenizer(br.readLine());
        N = 1 << Integer.parseInt(stz.nextToken());
        Q = Integer.parseInt(stz.nextToken());

        board = new int[N][N];
        tmp = new int[N][N];
        seq = new int[Q];
        for (int i = 0; i < N; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < Q; i++) {
            seq[i] = Integer.parseInt(stz.nextToken());
        }

        clear();
        magic();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (board[i][j] == 0)
                    continue;
                mx = Math.max(mx, search(i, j));
            }
        }
        System.out.println(total);
        System.out.println(mx);
    }
}
