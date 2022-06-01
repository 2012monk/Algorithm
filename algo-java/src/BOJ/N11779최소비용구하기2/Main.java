package BOJ.N11779최소비용구하기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static List<Edge>[] g;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken()) - 1;
            int v = Integer.parseInt(stz.nextToken()) - 1;
            int c = Integer.parseInt(stz.nextToken());
            g[u].add(new Edge(v, c));
        }
        stz = new StringTokenizer(br.readLine());
        int u = Integer.parseInt(stz.nextToken()) - 1;
        int v = Integer.parseInt(stz.nextToken()) - 1;
        path(u,v);
    }

    static void path(int a, int b) {
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(e -> -e.cost));
        q.add(new Edge(a, 0));
        int[] dist = new int[n];
        int[] path = new int[n];
        dist[a] = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        while (!q.isEmpty()) {
            Edge cur = q.poll();
            if (dist[cur.u] < cur.cost) continue;
            for (Edge edge : g[cur.u]) {
                int w = cur.cost + edge.cost;
                if (dist[edge.u] > w) {
                    path[edge.u] = cur.u;
                    dist[edge.u] = w;
                    q.add(new Edge(edge.u, w));
                }
            }
        }
        List<Integer> r = new ArrayList<>();
        r.add(b + 1);
        int x = path[b];
        while (x != a) {
            r.add(x + 1);
            x = path[x];
        }
        r.add(a + 1);
        System.out.println(dist[b]);
        System.out.println(r.size());
        for (int i = r.size() - 1; i >= 0; i--) {
            System.out.printf("%d ", r.get(i));
        }
    }

    static class Edge {
        int u, cost;
        public Edge(int u, int cost) {
            this.u = u;
            this.cost = cost;
        }
    }
}
