package BOJ.N1854K번째최단경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int INF = Integer.MAX_VALUE;
    static int n, m, k;
    static List<Edge>[] g;
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
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            g[u].add(new Edge(v, w));
//            g[v].add(new Edge(u, w));
        }
        D[] dist = dijkstra();
        for (int i = 1; i <= n; i++) {
            System.out.println(dist[i].get());
        }
    }

    static D[] dijkstra() {
        PriorityQueue<Edge> q = new PriorityQueue<>(Comparator.comparingInt(e -> e.dist));
        D[] dist = new D[n + 1];
        for (int i = 0; i < n + 1; i++) {
            dist[i] = new D();
        }
        q.add(new Edge(1, 0));
        dist[1].update(0);
        while (!q.isEmpty()) {
            Edge cur = q.poll();
            if (dist[cur.n].top() < cur.dist) continue;
            for (Edge next : g[cur.n]) {
                int w = next.dist + cur.dist;
                if (dist[next.n].update(w)) {
                    q.add(new Edge(next.n, w));
                }
            }
        }
        return dist;
    }

    static class Edge {
        int n, dist;
        public Edge(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }

    static class D {

        PriorityQueue<Integer> dist = new PriorityQueue<>(Comparator.reverseOrder());

        public D() {
            for (int i = 0; i < k; i++) {
                dist.add(INF);
            }
        }
        public void print() {
            Iterator<Integer> i = dist.iterator();
            i.forEachRemaining(v -> System.out.printf("%d ", v));
            System.out.println();
        }
        public int get() {
            if (dist.peek() == INF) return -1;
            return dist.peek();
        }

        public int top() {
            return dist.peek();
        }

        boolean update(int d) {
            dist.add(d);
            return dist.poll() != d;
        }
    }
}
