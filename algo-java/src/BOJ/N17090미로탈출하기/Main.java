package BOJ.N17090미로탈출하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] d = new int[][]{
        {-1, 0}, {0, 1}, {1, 0}, {0, -1}
    };
    static int n, m;
    static int[][] grid, v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        grid = new int[n][m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                char c = s.charAt(j);
                int idx = 0;
                if (c == 'R') {
                    idx = 1;
                }
                if (c == 'D') {
                    idx = 2;
                }
                if (c == 'L') {
                    idx = 3;
                }
                grid[i][j] = idx;
            }
        }
        System.out.println(solve());
    }

    private static int solve() {
        int res = 0;
        v = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                res += count(i, j, 0);
            }
        }
        return res;
    }

    private static int count(int i, int j, int count) {
        if (i < 0 || i >= n || j < 0 || j >= m) {
            return count;
        }
        if (v[i][j] > 0) {
            return count;
        }
        if (v[i][j] == -1) {
            return 0;
        }
        int idx = grid[i][j];
        v[i][j] = -1;
        return v[i][j] = count(i + d[idx][0], j + d[idx][1], count + 1);
    }
}
