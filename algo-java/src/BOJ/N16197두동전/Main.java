package BOJ.N16197두동전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid;
    static int[] coins = new int[4];
    static int n, m, ans = Integer.MAX_VALUE;
    static int[][] d = {
        {-1, 0}, {1, 0}, {0, 1}, {0, -1}
    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());

        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        grid = new int[n][m];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                grid[i][j] = s.charAt(j) == '#' ? 1 : 0;
                if (s.charAt(j) == 'o') {
                    coins[idx++] = i;
                    coins[idx++] = j;
                }
            }
        }
        solve(coins[0], coins[1], coins[2], coins[3], 0);
        if (ans == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(ans);
        }
    }

    static void solve(int x1, int y1, int x2, int y2, int count) {
        if (isInside(x1, y1) != isInside(x2, y2)) {
            ans = Math.min(ans, count);
            return;
        }
        if (!isInside(x1, y1) || !isInside(x2, y2) || count >= 10) {
            return;
        }
        for (int i = 0; i < 4; i++) {
            int dx1 = x1 + d[i][0], dy1 = y1 + d[i][1];
            int dx2 = x2 + d[i][0], dy2 = y2 + d[i][1];
            if (isInside(dx1, dy1) && isInside(dx2, dy2)) {
                if (grid[dx1][dy1] == 1) {
                    dx1 = x1;
                    dy1 = y1;
                }
                if (grid[dx2][dy2] == 1) {
                    dx2 = x2;
                    dy2 = y2;
                }
            }
            solve(dx1, dy1, dx2, dy2, count + 1);
        }
    }

    private static boolean isInside(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }
}
