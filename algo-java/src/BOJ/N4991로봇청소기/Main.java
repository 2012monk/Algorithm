package BOJ.N4991로봇청소기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static class P {
        int x, y, d;
        public P(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }
    static int[][] dist, dp, grid, d = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    static boolean[][] v;
    static int n, m, points;
    static P[] ps;
    static Queue<P> q = new LinkedList<>();
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuffer sb = new StringBuffer();
    static StringTokenizer stz;

    public static void main(String[] args) throws IOException {
        while (setUp()) {
            solve();
        }
        System.out.println(sb);
    }

    static boolean setUp() throws IOException {
        stz = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stz.nextToken());
        n = Integer.parseInt(stz.nextToken());
        if (n == 0) return false;
        grid = new int[n][m];
        ps = new P[n*m];
        points = 1;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                set(i, j, c);
            }
        }
        dist = new int[points][points];
        dp = new int[points][1<<points];
        return true;
    }

    private static void set(int i, int j, char c) {
        int idx = 0;
        grid[i][j] = -2;
        if (c == 'x') {
            grid[i][j] = -1;
            return;
        }
        if (c == '.') return;
        if (c == '*') {
            idx = points++;
        }
        ps[grid[i][j] = idx] = new P(i, j, 0);
    }

    static void solve() {
        for (int i = 0; i < points; i++) {
            Arrays.fill(dp[i], -1);
            if (!fillDist(i)) {
                sb.append(-1).append('\n');
                return;
            }
        }
        sb.append(tsp(0, 1)).append("\n");
    }

    static boolean fillDist(int k) {
        int cnt = 0;
        q.clear();
        v = new boolean[n][m];
        v[ps[k].x][ps[k].y] = true;
        q.add(ps[k]);
        while (!q.isEmpty()) {
            P p = q.poll();
            if (grid[p.x][p.y] >= 0) {
                dist[k][grid[p.x][p.y]] = p.d;
                cnt++;
            }
            for (int[] dd : d) {
                int dx = dd[0] + p.x;
                int dy = dd[1] + p.y;
                if (dx < 0 || dx >= n || dy < 0 || dy >= m)  continue;
                if (v[dx][dy] || grid[dx][dy] == -1) continue;
                v[dx][dy] = true;
                q.add(new P(dx,dy,p.d+1));
            }
        }
        return cnt == points;
    }

    static int tsp(int cur, int v) {
        if (dp[cur][v] != -1) return dp[cur][v];
        if (v == (1<<points)-1) return 0;
        dp[cur][v] = Integer.MAX_VALUE;
        for (int i = 0; i < points; i++) {
            if ((v&(1<<i)) > 0) continue;
            dp[cur][v] = Math.min(dp[cur][v], dist[cur][i] + tsp(i, v | (1<<i)));
        }
        return dp[cur][v];
    }
}
