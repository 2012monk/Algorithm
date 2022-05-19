package BOJ.N2234성곽;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m, mx, group, ans;
    static int[][] v, g, d = {
        {0, -1}, {-1, 0}, {0,1},{1, 0}
    };
    static int[] s;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stz.nextToken());
        n = Integer.parseInt(stz.nextToken());
        g = new int[n][m];
        v = new int[n][m];
        s = new int[n * m * 2];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                g[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        grouping();
        find();
        System.out.println(group);
        System.out.println(mx);
        System.out.println(ans);
    }

    static void grouping() {
        group = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (v[i][j] != 0)
                    continue;
                group++;
                s[group] = dfs(i, j, group);
                mx = Math.max(mx, s[group]);
            }
        }
    }

    static int dfs(int x, int y, int f) {
        if (v[x][y] != 0) return 0;
        v[x][y] = f;
        int ret = 1;
        for (int i = 0; i < d.length; i++) {
            if ((g[x][y] & (1 << i)) > 0) continue;
            int[] dd = d[i];
            int dx = x + dd[0];
            int dy = y + dd[1];
            if (v[dx][dy] != 0) continue;
            ret += dfs(dx, dy, f);
        }
        return ret;
    }

    static void find() {
        if (group == 1) {
            ans = mx;
            return;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    if ((g[i][j] & (1 << k)) != (1 << k)) continue;
                    int[] dd = d[k];
                    int dx = i + dd[0];
                    int dy = j + dd[1];
                    if (dx < 0 || dx >= n || dy < 0 || dy >= m) { continue; }
                    if (v[i][j] == v[dx][dy]) continue;
                    ans = Math.max(ans, s[v[i][j]] + s[v[dx][dy]]);
                }
            }
        }
    }
}
