package BOJ.N2662기업투자;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[][] p, path, d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        p = new int[n + 1][m + 1];
        d = new int[n + 1][m + 1];
        path = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            stz = new StringTokenizer(br.readLine());
            stz.nextToken();
            for (int j = 0; j < m; j++) {
                p[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

        System.out.println(f(0, n));
        for (int i = 0, v = n; i < m; i++) {
            System.out.printf("%d ", path[v][i]);
            v -= path[v][i];
        }
    }

    static int f(int cur, int val) {
        if (cur >= m || val == 0) return 0;
        if (d[val][cur] != 0) return d[val][cur];
        for (int i = 0; i <= val; i++) {
            int r = f(cur + 1, val - i) + p[i][cur];
            if (r > d[val][cur]) {
                path[val][cur] = i;
                d[val][cur] = r;
            }
        }
        return d[val][cur];
    }
}
