package BOJ.N2151거울설치;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static int[][] grid, d = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    static int[][][] v;
    static int n, ans = Integer.MAX_VALUE;
    static P s, e;
    static Queue<P> q= new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        grid = new int[n][n];
        v = new int[n][n][4];
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < n; j++) {
                Arrays.fill(v[i][j], Integer.MAX_VALUE);
                if (str.charAt(j) == '*') {
                    grid[i][j] = 1;
                }
                if (str.charAt(j) == '!') {
                    grid[i][j] = 2;
                }
                if (str.charAt(j) == '#') {
                    if (s == null) {
                        s = new P(i, j, 0, 0);
                    } else {
                        e = new P(i, j, 0, 0);
                    }
                }
            }
        }
        for (int i = 0; i < d.length; i++) {
            int[] dd = d[i];
            int dx = s.x + dd[0];
            int dy = s.y + dd[1];
            if (dx < 0 || dx >= n || dy < 0 || dy >= n) { continue; }
            if (grid[dx][dy] == 1) { continue; }
            q.add(new P(s.x,s.y,i,0));
        }
        grid[s.x][s.y] = 1;
        bfs();
        System.out.println(ans);
    }

    public static void bfs() {
        while (!q.isEmpty()) {
            P p = q.poll();
            if (v[p.x][p.y][p.d] <= p.c) continue;
            v[p.x][p.y][p.d] = p.c;
            int dx = p.x + d[p.d][0];
            int dy = p.y + d[p.d][1];
            if (dx < 0 || dx >= n || dy < 0 || dy >= n)  continue;
            if (grid[dx][dy] == 1)  continue;
            if (dx == e.x && dy == e.y) {
                ans = Math.min(ans, p.c);
                continue;
            }
            q.add(new P(dx,dy,p.d,p.c));
            if (grid[dx][dy] == 0) continue;
            for (int i = 0; i < 3; i++) {
                int dir = ((p.d / 2) * 2 + 2 + i) % 4;
                q.add(new P(dx,dy,dir, p.c + 1));
            }
        }
    }

    static class P {

        int x, y, d, c;

        public P(int x, int y, int d, int c) {
            this.x = x;
            this.y = y;
            this.d = d;
            this.c = c;
        }
    }
}
