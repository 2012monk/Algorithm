package BOJ.N1197최소스패닝트리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int m = Integer.parseInt(stz.nextToken());
        UF uf = new UF(n);
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken()) - 1;
            int b = Integer.parseInt(stz.nextToken()) - 1;
            long c = Long.parseLong(stz.nextToken());
            edges.add(new Edge(c, a, b));
        }
        edges.sort(Comparator.comparingLong(e -> e.cost));
        long ans = 0;
        for (Edge edge : edges) {
            if (uf.isConnected(edge.u, edge.v)) continue;
            uf.union(edge.u, edge.v);
            ans += edge.cost;
        }
        System.out.println(ans);
    }

    static class UF {
        int[] u;

        UF(int n) {
            u = new int[n];
            for (int i = 0; i < n; i++) u[i] = i;
        }
        int find(int x) {
            if (u[x] != x) u[x] = find(u[x]);
            return u[x];
        }
        void union(int a, int b) {
            int ux = find(a);
            int uy = find(b);
            if (ux < uy) u[uy] = ux;
            else u[ux] = uy;
        }

        boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
    }

    static class Edge {
        int u,v;
        long cost;

        public Edge(long cost, int u, int v) {
            this.cost = cost;
            this.u = u;
            this.v = v;
        }
    }
}
