package BOJ.N1504특정한최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n,m, INF = 1_000_000_0;
    static int[][] g;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        g = new int[n + 1][n + 1];
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            g[v][u] = g[u][v] = w;
        }
        stz = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(stz.nextToken());
        int v2 = Integer.parseInt(stz.nextToken());
        System.out.println(solve(v1, v2));
    }

    static int solve(int v1, int v2) {
        int[] fromV1 = dijkstra(v1);
        int[] fromV2 = dijkstra(v2);
        long result = Math.min(fromV1[1] + fromV2[n], fromV2[1] + fromV1[n]) + fromV1[v2];
        if (result >= INF) return -1;
        return (int) result;
    }

    static int[] dijkstra(int start) {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(p -> -p[0]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, INF);
        q.add(new int[]{ 0, start });
        dist[start] = 0;
        while (!q.isEmpty()) {
            int node = q.peek()[1];
            int weight = q.poll()[0];
            if (dist[node] < weight) continue;
            for (int i = 1; i <= n; i++) {
                if (g[node][i] == 0) continue;
                int w = g[node][i] + weight;
                if (dist[i] > w) {
                    dist[i] = w;
                    q.add(new int[]{w, i});
                }
            }
        }
        return dist;
    }
}
