package BOJ.N4386별자리만들기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Edge> edges = new ArrayList<>();
    static Point[] points;
    static UF uf;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        points = new Point[n];
        uf = new UF(n);
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(stz.nextToken());
            double y = Double.parseDouble(stz.nextToken());
            points[i] = new Point(i, x, y);
        }
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                edges.add(new Edge(points[i], points[j]));
            }
        }
        edges.sort(Comparator.comparingDouble(e -> e.cost));
        double cost = 0;
        for (Edge edge : edges) {
            if (!uf.isConnected(edge.u.idx, edge.v.idx)) {
                uf.union(edge.u.idx, edge.v.idx);
                cost += edge.cost;
            }
        }
        System.out.printf("%.3f", cost);
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
        Point u,v;
        double cost;

        public Edge(Point u, Point v) {
            this.u = u;
            this.v = v;
            this.cost = dist();
        }

        double dist() {
            double x = u.x - v.x;
            double y = u.y - v.y;
            return Math.sqrt(x * x + y * y);
        }
    }
    static class Point {
        double x, y;
        int idx;

        public Point(int idx, double x, double y) {
            this.idx = idx;
            this.x = x;
            this.y = y;
        }
    }
}
