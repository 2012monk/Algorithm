package BOJ.N1162도로포장;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static long INF = Long.MAX_VALUE;
    static int n,m,k;
    static List<Edge>[] g;
    static long[][] dp = new long[10001][21];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        g = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            g[i] = new ArrayList<>();
        }
        for (long[] d : dp) {
            Arrays.fill(d, INF);
        }
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            g[u].add(new Edge(v, w, 0));
            g[v].add(new Edge(u, w, 0));
        }
        System.out.println(dijkstra());
    }

    static long dijkstra() {
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingLong(e -> e.dist));
        q.add(new Edge(1, 0, 0));
        dp[1][0] = 0;
        while (!q.isEmpty()) {
            Edge cur = q.poll();
            if (dp[cur.node][cur.count] < cur.dist) continue;
            for (Edge edge : g[cur.node]) {
                long w = cur.dist + edge.dist;
                if (dp[edge.node][cur.count] > w) {
                    dp[edge.node][cur.count] = w;
                    q.add(new Edge(edge.node, w, cur.count));
                }
                if (cur.count < k && dp[edge.node][cur.count + 1] > cur.dist) {
                    dp[edge.node][cur.count + 1] = cur.dist;
                    q.add(new Edge(edge.node, cur.dist, cur.count + 1));
                }
            }
        }
        return Arrays.stream(dp[n]).sorted().findFirst().orElse(-1);
    }

    static class Edge {
        int node, count;
        long dist;

        public Edge(int node, long dist, int count) {
            this.node = node;
            this.dist = dist;
            this.count = count;
        }
    }
}
