package BOJ.N1647도시분할계획;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static UF uf;
    static int n,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        List<Edge> edges = new ArrayList<>();
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        uf = new UF(n + 1);
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            edges.add(new Edge(w,u,v));
        }
        edges.sort(Comparator.comparingInt(e -> e.cost));
        int ret = 0;
        int count = 0;
        int max = 0;
        for (Edge e : edges) {
            if (!uf.isConnected(e.u, e.v)) {
                uf.union(e.u, e.v);
                max = Math.max(max, e.cost);
                ret += e.cost;
            }
        }
        System.out.println(ret - max);
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
        int cost,u,v;

        public Edge(int cost, int u, int v) {
            this.cost = cost;
            this.u = u;
            this.v = v;
        }
    }

}
