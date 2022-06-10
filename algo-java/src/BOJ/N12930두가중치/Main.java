package BOJ.N12930두가중치;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {

    private static final int MAX = 20 * 10;
    static int n,INF = (int) 1e8;
    static Node[][] g;
    static int[][] dp = new int[21][MAX + 1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        g = new Node[n + 1][n + 1];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '.') continue;
                g[i][j] = new Node();
                g[i][j].w1 = s.charAt(j) - '0';
            }
        }
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '.') continue;
                g[i][j].w2 = s.charAt(j) - '0';
            }
        }
        System.out.println(dijkstra());
    }

    static long dijkstra() {
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingLong(e -> -(e.cost())));
        q.add(new Edge(0, 0, 0));
        for (int i = 1; i < n; i++) {
            Arrays.fill(dp[i], INF);
        }
        while (!q.isEmpty()) {
            Edge u = q.poll();
            for (int v = 0; v < n; v++) {
                Node next = g[u.n][v];
                if (next == null) continue;
                int w1 = next.w1 + u.w1;
                int w2 = next.w2 + u.w2;
                Edge e = new Edge(v, w1, w2);
                if (w1 < MAX && dp[v][w1] > e.cost()) {
                    dp[v][w1] = e.cost();
                    q.add(e);
                } else if (w2 < MAX && dp[v][w2] > e.cost()) {
                    dp[v][w2] = e.cost();
                    q.add(e);
                }
            }
        }
        int ans = INF;
        for (int i = 0; i < dp[1].length; i++) {
            ans = Math.min(ans, dp[1][i]);
        }
        if (ans == INF) return -1;
        return ans;
    }

    static class Edge {
        int n;
        int w1, w2;

        public Edge(int n, int w1, int w2) {
            this.n = n;
            this.w1 = w1;
            this.w2 = w2;
        }

        int cost() {
            return w1 * w2;
        }
    }

    static class Node {
        int w1,w2;
    }
}
