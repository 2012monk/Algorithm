package BOJ.N1956운동;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int INF = 200000000;
    static int n,e;
    static int[][] dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        e = Integer.parseInt(stz.nextToken());
        dist = new int[n + 1][n + 1];
        for (int[] d : dist) {
            Arrays.fill(d, INF);
        }
        for (int i = 0; i < e; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            dist[u][v] = w;
        }
        floyd();
        int ans = INF;
        for (int i = 0; i < n + 1; i++) {
            ans = Math.min(ans, dist[i][i]);
        }
        if (ans == INF) ans = -1;
        System.out.println(ans);
    }

    static void floyd() {
        for (int k = 1; k < n + 1; k++) {
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }
    }
}
