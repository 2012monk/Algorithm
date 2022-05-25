package BOJ.N1890점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] g;
    static long[][] d;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        g = new int[n][n];
        d = new long[n][n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                g[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        System.out.println(solve());
    }

    static long solve() {
        d[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int dt = g[i][j];
                if (d[i][j] == 0 || dt == 0) continue;
                if (withinBound(i + dt, j)) {
                    d[i + dt][j] += d[i][j];
                }
                if (withinBound(i,j + dt)) {
                    d[i][j + dt] += d[i][j];
                }
            }
        }
        return d[n - 1][n - 1];
    }

    static boolean withinBound(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < n;
    }
}
