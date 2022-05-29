package BOJ.N121002048;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[] forward, backward;
    static int[][] d = {{0,1},{0, -1},{1,0},{-1,0}};
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        int[][] orig = new int[n][n];
        forward = new int[n];
        backward = new int[n];
        for (int i = 0; i < n; i++) {
            forward[i] = i;
            backward[i] = n - i - 1;
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                orig[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        System.out.println(f(orig, 0));
    }

    static int f(int[][] g, int cnt) {
        if (cnt == 5) return max(g);
        int r = max(g);
        for (int i = 0; i < 4; i++) {
            int[][] shifted = shift(copy(g), i);
            if (shifted == null) continue;
            r = Math.max(r, f(shifted, cnt + 1));
        }
        return r;
    }

    private static int max(int[][] g) {
        int r = 0;
        for (int[] a : g) {
            r = Math.max(r, Arrays.stream(a).max().orElse(0));
        }
        return r;
    }

    static int[][] shift(int[][] g, int dir) {
        int[] outer = forward;
        int[] inner = forward;
        if (dir == 1) inner = backward;
        if (dir == 3) outer = backward;
        return shift(outer,inner,g,dir);
    }

    static int[][] shift(int[] outer, int[] inner, int[][] g, int dir) {
        boolean f = false;
        for (int i : outer) {
            for (int j : inner) {
                f |= merge(i,j,dir,g);
            }
        }
        if (!f) return null;
        return g;
    }

    private static int[][] copy(int[][] g) {
        int[][] t = new int[n][n];
        for (int i = 0; i < n; i++) {
            System.arraycopy(g[i], 0, t[i], 0, n);
        }
        return t;
    }

    static boolean withinBound(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }

    static boolean merge(int i, int j, int dir, int[][] g) {
        int x = i + d[dir][0];
        int y = j + d[dir][1];
        while (withinBound(x,y) && g[x][y] == 0) {
            x += d[dir][0];
            y += d[dir][1];
        }
        if (!withinBound(x, y)) return false;
        if (g[i][j] == 0) {
            g[i][j] = g[x][y];
            g[x][y] = 0;
            merge(i, j, dir, g);
            return true;
        }
        if (g[i][j] == g[x][y]) {
            g[i][j] *= 2;
            g[x][y] = 0;
            return true;
        }
        return false;
    }
}
