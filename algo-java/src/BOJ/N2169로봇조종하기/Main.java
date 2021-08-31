package BOJ.N2169로봇조종하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int n, m, INF = -1000001;
    static int[][]
        board = new int[1001][1001],
        v = new int[1001][1001],
        dt = {{1, 0}, {0, -1}, {0, 1}};

    static int[][][] cache = new int[1001][1001][3];

    public static void main(String[] args) throws IOException {
        init();
        v[0][0] = 1;
        System.out.println(dfs(0, 0, 0));

    }

    public static int dfs(int x, int y, int dir) {
        if (x == n - 1&& y == m - 1) return board[x][y];
        if (cache[x][y][dir] != INF) return cache[x][y][dir];

        for (int i=0; i<3;i++) {
            int dx = x + dt[i][0];
            int dy = y + dt[i][1];

            if (dx < 0 || dx >= n || dy < 0 || dy >= m || v[dx][dy] != 0) continue;

            v[dx][dy] = 1;
            cache[x][y][dir] = Math.max(cache[x][y][dir], dfs(dx, dy, i) + board[x][y]);
            v[dx][dy] = 0;
        }
        return cache[x][y][dir];
    }

    public static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        for (int i=0;i<n;i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j=0;j<m;j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
                Arrays.fill(cache[i][j], INF);
            }
        }


    }

}
