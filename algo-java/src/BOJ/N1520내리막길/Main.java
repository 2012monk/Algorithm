package BOJ.N1520내리막길;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] map = new int[501][501], cache = new int[501][501];
    static int[][] dt = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n, m;


    public static void main(String[] args) throws IOException {
        init();
        System.out.println(dfs(0, 0));
    }

    static int dfs(int x, int y) {
        if (x == n - 1 && y == m - 1) {
            return 1;
        }

        if (cache[x][y] != -1) {
            return cache[x][y];
        }
        cache[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int dx = x + dt[i][0];
            int dy = y + dt[i][1];

            if (dx >= 0 && dx < n && dy >= 0 && dy < m && map[x][y] > map[dx][dy]) {
                cache[x][y] += dfs(dx, dy);
            }
        }
        return cache[x][y];
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(stz.nextToken());
                cache[i][j] = -1;
            }
        }
    }
}
