package BOJ.N16958텔레포트;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid = new int[1000][2];
    static int[][] dist;
    static boolean[] isSpecial = new boolean[1000];
    static int n, t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        t = Integer.parseInt(stz.nextToken());

        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            isSpecial[i] = stz.nextToken().equals("1");
            grid[i][0] = Integer.parseInt(stz.nextToken());
            grid[i][1] = Integer.parseInt(stz.nextToken());
        }

        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dist[i][j] = Math.abs(grid[i][0] - grid[j][0]);
                dist[i][j] += Math.abs(grid[i][1] - grid[j][1]);
                if (isSpecial[i] && isSpecial[j]) {
                    dist[i][j] = Math.min(dist[i][j], t);
                }
            }
        }
//        floydWarshall();
        int m = Integer.parseInt(br.readLine());
        while (m-- > 0) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken()) - 1;
            int b = Integer.parseInt(stz.nextToken()) - 1;
//            System.out.println(dist[a][b]);
            System.out.println(shortestDist(a, b));
        }
    }

    static void floydWarshall() {
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }
    }

    static int shortestDist(int a, int b) {
        int w = dist[a][b];

        int closeA = closestSpecial(a);
        int closeB = closestSpecial(b);

        if (closeA < 0 || closeB < 0) {
            return w;
        }
        return Math.min(w, dist[a][closeA] + t + dist[closeB][b]);
    }

    private static int closestSpecial(int x) {
        int r = -1, idx = -1;

        for (int i = 0; i < n; i++) {
            if (!isSpecial[i]) continue;
            if (r == -1 || r > dist[x][i]) {
                r = dist[x][i];
                idx = i;
            }
        }
        return idx;
    }
}
