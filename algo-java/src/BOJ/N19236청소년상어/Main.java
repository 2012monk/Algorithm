package BOJ.N19236청소년상어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int[][][] grid = new int[4][4][2];
    static int[] nx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] ny = {0, -1, -1, -1, 0, 1, 1, 1};

    static void step(int[][][] g, int x, int y) {
        for (int i = 0; i < 7; i++) {
            int d = ( g[x][y][1] + i ) % 8;
            int dx = x + nx[d];
            int dy = y + ny[d];
            if (dx < 0 || dx >= 4 || dy < 0 || dy >= 4)
                continue;
            if (g[dx][dy][0] == -1)
                continue;
            int t = g[x][y][0];
            g[x][y][0] = g[dx][dy][0];
            g[x][y][1] = g[dx][dy][1];
            g[dx][dy][0] = t;
            g[dx][dy][1] = d;
            break;
        }
    }

    static void move(int[][][] g) {

        for (int i = 1; i < 17; i++) {
            for (int j = 0; j < 16; j++) {
                if (g[j / 4][j % 4][0] == i) {
                    step(g, j / 4, j % 4);
                    break;
                }
            }
        }
    }

    static int[][][] copy(int [][][] g) {
        int[][][] n = new int[4][4][2];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                n[i][j][0] = g[i][j][0];
                n[i][j][1] = g[i][j][1];
            }
        }
        return n;
    }

    static int search(int[][][] g, int cx, int cy) {
        int[][][] board;
        int ret = 0;
        int tmp = g[cx][cy][0];
        int d = g[cx][cy][1];
        g[cx][cy][0] = -1;
        move(g);
        g[cx][cy][0] = 0;
        for (int i = 1; i <= 3; i++) {
            int dx =  cx + nx[d] * i;
            int dy =  cy + ny[d] * i;
            if (dx < 0 || dx >= 4 || dy < 0 || dy >= 4)
                continue;
            if (g[dx][dy][0] == 0)
                continue;
            board = copy(g);
            ret = Math.max(search(board, dx, dy), ret);
        }
        return ret + tmp;
    }

    public static void main(String[] args) throws IOException {
        for (int i = 0; i < 4; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                grid[i][j][0] = Integer.parseInt(stz.nextToken());
                grid[i][j][1] = Integer.parseInt(stz.nextToken()) - 1;
            }
        }
        System.out.println(search(grid, 0, 0));
    }
}
