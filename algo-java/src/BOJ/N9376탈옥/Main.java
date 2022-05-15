package BOJ.N9376탈옥;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid, d = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    static int[][][] dist;
    static int n, m, INF = 10000;
    static P s, e;
    static StringBuffer sb =  new StringBuffer();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            e = s = null;
            stz = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stz.nextToken());
            m = Integer.parseInt(stz.nextToken());
            grid = new int[n + 2][m + 2];
            dist = new int[3][n + 2][m + 2];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < n + 2; j++) {
                    Arrays.fill(dist[i][j], INF);
                }
            }
            for (int i = 1; i <= n; i++) {
                String str = br.readLine();
                for (int j = 1; j <= m; j++) {
                    char c = str.charAt(j - 1);
                    if (c == '*')  grid[i][j] = -1;
                    if (c == '#')  grid[i][j] = 1;
                    if (c == '$') {
                        if (s == null) {
                            s = new P(i, j, 0);
                        } else {
                            e = new P(i, j, 0);
                        }
                    }
                }
            }
            solve();
        }
        System.out.println(sb);
    }

    private static void solve() {
        int ans = Integer.MAX_VALUE;
        dist[0] = getCost(s);
        dist[1] = getCost(e);
        dist[2] = getCost(new P(0, 0, 0));
        for (int i = 0; i < n + 2; i++) {
            for (int j = 0; j < m + 2; j++) {
                if (grid[i][j] == -1)  continue;
                int d = dist[0][i][j] + dist[1][i][j] + dist[2][i][j];
                if (grid[i][j] == 1) d-=2;
                ans = Math.min(ans, d);
            }
        }
        sb.append(ans).append('\n');
    }


    static int[][] getCost(P s) {
        ArrayDeque<P> q = new ArrayDeque<>();
        int[][] di = new int[n + 2][m + 2];
        for (int i = 0; i < n + 2; i++) {
            Arrays.fill(di[i], INF);
        }
        q.add(s);
        di[s.x][s.y] = 0;
        while (!q.isEmpty()) {
            P p = q.removeFirst();
            for (int[] dd : d) {
                int dx = dd[0] + p.x;
                int dy = dd[1] + p.y;
                if (dx < 0 || dx > n + 1|| dy < 0 || dy > m + 1) {
                    continue;
                }
                if (grid[dx][dy] == -1 || di[dx][dy] != INF) continue;
                int cost = grid[dx][dy];
                P dp = new P(dx,dy,cost+di[p.x][p.y]);
                di[dx][dy] = dp.d;
                if (cost == 0) {
                    q.offerFirst(dp);
                } else {
                    q.offerLast(dp);
                }
            }
        }
        return di;
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
