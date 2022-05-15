package BOJ.N17141연구소2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n, m, ans = Integer.MAX_VALUE, pos, total;
    static int[][] grid, result, possible, d = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    static boolean[] v;
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
                if (grid[i][j] != 1) total++;
                if (grid[i][j] == 2) {
                    possible[pos][0] = i;
                    possible[pos++][1] = j;
                }
            }
        }
        solve(0, 0);
        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }

    static void solve(int x, int num) {
        if (x == m) {
            updateResult();
            return;
        }
        if (num >= pos) {
            return;
        }
        c[x] = num;
        solve(x + 1, num + 1);
        solve(x, num + 1);
    }

    private static void updateResult() {
        Queue<P> q = new LinkedList<>();
        int cur = 0, count = 0;
        result = new int[n][n];
        for (int i = 0; i < m; i++) {
            q.add(new P(possible[c[i]][0], possible[c[i]][1]));
            result[possible[c[i]][0]][possible[c[i]][1]] = 1;
            count++;
        }
        while (!q.isEmpty()) {
            P p = q.poll();
            for (int[] dd : d) {
                int dx = dd[0] + p.x;
                int dy = dd[1] + p.y;
                if (dx < 0 || dx >= n || dy< 0 || dy>=n) {
                    continue;
                }
                if (grid[dx][dy] == 1 || result[dx][dy] != 0) {
                    continue;
                }
                cur = result[dx][dy] = result[p.x][p.y] + 1;
                count++;
                q.add(new P(dx,dy));
            }
        }
        if (count != total) {
            return;
        }
        if (cur > 0) cur--;
        ans = Math.min(ans, cur);
    }

    static class P {
        int x, y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
