package BOJ.N17142연구소3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, ans = Integer.MAX_VALUE, pos, total;
    static int[][] grid, possible, d = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    static boolean[] v;
    static boolean[][] visit;
    static int[] c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        grid = new int[n][n];
        possible = new int[n * n][2];
        c = new int[m];
        v = new boolean[m];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                grid[i][j] = Integer.parseInt(stz.nextToken());
                if (grid[i][j] == 1) continue;
                if (grid[i][j] == 0) total++;
                if (grid[i][j] == 2) {
                    possible[pos][0] = i;
                    possible[pos++][1] = j;
                }
            }
        }
        if (total == 0) {
            System.out.println(0);
            return;
        }
        solve(0, 0);
        if (ans == Integer.MAX_VALUE) {
            ans = -1;
        }
        System.out.println(ans);
    }

    static void solve(int x, int num) {
        if (x == m) {
            bfs();
            return;
        }
        if (num >= pos) {
            return;
        }
        c[x] = num;
        solve(x + 1, num + 1);
        solve(x, num + 1);
    }

    private static void bfs() {
        Queue<P> q = new LinkedList<>();
        int count = 0;
        visit = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            q.add(new P(possible[c[i]][0], possible[c[i]][1], 0));
            visit[possible[c[i]][0]][possible[c[i]][1]] = true;
        }
        while (!q.isEmpty()) {
            P p = q.poll();
            for (int[] dd : d) {
                int dx = dd[0] + p.x;
                int dy = dd[1] + p.y;
                if (dx < 0 || dx >= n || dy < 0 || dy >= n) {
                    continue;
                }
                if (grid[dx][dy] == 1 || visit[dx][dy]) {
                    continue;
                }
                if (grid[dx][dy] == 0) count++;
                if (count == total) {
                    ans = Math.min(ans, p.d + 1);
                    return;
                }
                visit[dx][dy] = true;
                q.add(new P(dx, dy, p.d + 1));
            }
        }
    }

    static class P {
        int x, y, d;
        public P(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
}
