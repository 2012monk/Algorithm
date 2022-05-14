package BOJ.N16985Maaaaaaze;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static final int[][] d = {
        {0, 0, 1}, {0, 0, -1}, {0, 1, 0}, {0, -1, 0}, {1, 0, 0}, {-1, 0, 0}
    };
    static int[][][] grid = new int[5][5][5];
    static int ans = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        for (int l = 0; l < 5; l++) {
            for (int i = 0; i < 5; i++) {
                stz = new StringTokenizer(br.readLine());
                for (int j = 0; j < 5; j++) {
                    grid[l][i][j] = Integer.parseInt(stz.nextToken());
                }
            }
        }
        rotateCombination(0);
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
    }

    private static void rotateCombination(int x) {
        if (x == 5) {
            stackCombination(0, new int[5][5][5], new boolean[5]);
            return;
        }
        rotateCombination(x + 1);
        for (int i = 0; i < 3; i++) {
            rotate(x);
            rotateCombination(x + 1);
        }
    }

    private static void stackCombination(int x, int[][][] path, boolean[] v) {
        if (x == 5) {
            if (path[0][0][0] == 0 || path[4][4][4] == 0) {
                return;
            }
            ans = Math.min(ans, shortestPath(path));
            return;
        }
        for (int i = 0; i < 5; i++) {
            if (v[i]) {
                continue;
            }
            v[i] = true;
            path[x] = grid[i];
            stackCombination(x + 1, path, v);
            v[i] = false;
        }
    }

    private static int shortestPath(int[][][] grid) {
        Queue<P> q = new ArrayDeque<>();
        boolean[][][] visited = new boolean[5][5][5];
        q.add(new P(0, 0, 0, 0));
        visited[0][0][0] = true;
        while (!q.isEmpty()) {
            P p = q.poll();
            if (p.i == 4 && p.j == 4 && p.k == 4) {
                if (p.d == 12) {
                    System.out.println(12);
                    System.exit(0);
                }
                return p.d;
            }
            for (int[] px : d) {
                int i = px[0] + p.i;
                int j = px[1] + p.j;
                int k = px[2] + p.k;
                if (!withinBounds(i, j, k)) {
                    continue;
                }
                if (visited[i][j][k] || grid[i][j][k] == 0) {
                    continue;
                }
                visited[i][j][k] = true;
                q.add(new P(i, j, k, p.d + 1));
            }
        }
        return Integer.MAX_VALUE;
    }

    private static boolean withinBounds(int i, int j, int k) {
        return i >= 0 && i < 5 && j >= 0 && j < 5 && k >= 0 && k < 5;
    }

    private static void rotate(int grade) {
        int[][] layer = grid[grade];
        int[][] dst = new int[5][5];
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                dst[j][4 - i] = layer[i][j];
            }
        }
        grid[grade] = dst;
    }

    static class P {
        int i, j, k, d;
        public P(int i, int j, int k, int d) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.d = d;
        }
    }
}
