package BOJ.N2887행성터널;

import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.ToIntFunction;

public class Main {

    static int n;
    static List<Edge> edges = new ArrayList<>();
    static List<Point> points = new ArrayList<>();
    static Point[] p;
    static UF uf;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        p = new Point[n];
        uf = new UF(n);
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());
            int z = Integer.parseInt(stz.nextToken());
            p[i] = new Point(i, x, y, z);
            points.add(p[i]);
        }
        e(p -> p.x);
        e(p -> p.y);
        e(p -> p.z);
        edges.sort(Comparator.comparingInt(e -> e.cost));
        long ans = 0;
        for (Edge edge : edges) {
            if (!uf.isConnected(edge.u, edge.v)) {
                uf.union(edge.u, edge.v);
                ans += edge.cost;
            }
        }
        System.out.println(ans);
    }

    static void e(ToIntFunction<Point> f) {
        points.sort(Comparator.comparingInt(f));
        for (int i = 0; i < n - 1; i++) {
            int u = points.get(i).i;
            int v = points.get(i + 1).i;
            edges.add(new Edge(u, v, abs(f.applyAsInt(p[u]) - f.applyAsInt(p[v]))));
        }
    }

    static class Point {
        int i,x,y,z;

        public Point(int i, int x, int y, int z) {
            this.i = i;
            this.x = x;
            this.y = y;
            this.z = z;
        }
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
        int cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
}
