package BOJ.N11780플로이드2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

    static int[][] dist;
    static int[][] path;
    static int n, INF = 100001;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        dist = new int[n + 1][n + 1];
        path = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            dist[u][v] = Math.min(dist[u][v], c);
        }
        floydWarshall();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) dist[i][j] = 0;
                sb.append(dist[i][j]).append(' ');
            }
            sb.append('\n');
        }
        LinkedList<Integer> p = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == 0) {
                    sb.append(0).append('\n');
                    continue;
                }
                p.clear();
                route(i, j, p);
                sb.append(p.size());
                for (Integer v : p) {
                    sb.append(' ').append(v);
                }
                sb.append('\n');
            }
        }
        System.out.println(sb);
    }

    static void route(int i, int j, LinkedList<Integer> p) {
        if (path[i][j] == 0) {
            p.addLast(i);
            p.addLast(j);
            return;
        }
        route(i, path[i][j], p);
        p.removeLast();
        route(path[i][j], j, p);
    }

    static void floydWarshall() {
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][j] > dist[i][k] + dist[k][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        path[i][j] = k;
                    }
                }
            }
        }
    }
}
