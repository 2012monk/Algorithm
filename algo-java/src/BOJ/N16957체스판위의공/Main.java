package BOJ.N16957체스판위의공;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid, result, v, d = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, -1}, {1, 1}, {-1, 1}, {-1, -1}
    };
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        grid = new int[n][m];
        result = new int[n][m];
        v = new int[n][m];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(stz.nextToken());
            }
            Arrays.fill(v[i], -1);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                travel(i, j);
            }
        }
        for (int[] ints : result) {
            for (int i : ints) {
                sb.append(i).append(' ');
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    static int travel(int x, int y) {
        int nx = x, ny = y, r = Integer.MAX_VALUE;
        if (v[x][y] != -1) {
            return v[x][y];
        }
        for (int[] dd : d) {
            int dx = dd[0] + x;
            int dy = dd[1] + y;
            if (dx < 0 || dx >= n || dy < 0 || dy >= m) {
                continue;
            }
            if (grid[dx][dy] > grid[x][y]) {
                continue;
            }
            if (r > grid[dx][dy]) {
                r = grid[dx][dy];
                nx = dx;
                ny = dy;
            }
        }

        if (r == Integer.MAX_VALUE) {
            result[x][y]++;
            return v[x][y] = x * m + y;
        }
        v[x][y] = travel(nx, ny);
        nx = v[x][y] / m;
        ny = v[x][y] % m;
        result[nx][ny]++;
        return v[x][y];
    }
}
