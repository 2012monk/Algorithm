package BOJ.N1922네트워크연결;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        List<Edge> edges = new ArrayList<>();
        UF uf = new UF(n);
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken()) - 1;
            int b = Integer.parseInt(stz.nextToken()) - 1;
            int c = Integer.parseInt(stz.nextToken());
            edges.add(new Edge(c, a, b));
        }
        edges.sort(Comparator.comparingInt(e -> e.cost));
        int ret = 0;
        for (Edge e : edges) {
            if (!uf.isConnected(e.u, e.v)) {
                uf.union(e.u, e.v);
                ret += e.cost;
            }
        }
        System.out.println(ret);
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
