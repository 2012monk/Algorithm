package BOJ.N1626두번째로작은스패닝트리;

import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Edge> connected = new ArrayList<>();
    static List<Edge> unused = new ArrayList<>();
    static U u;
    static int v,e, total = 0,INF = Integer.MAX_VALUE;
    static Tree t;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        v = Integer.parseInt(stz.nextToken());
        e = Integer.parseInt(stz.nextToken());
        u = new U(v + 1);
        LinkedList<Edge> edges = new LinkedList<>();
        for (int i = 0; i < e; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            edges.add(new Edge(u,v,c));
        }
        System.out.println(solve(edges));
    }
    static long solve(LinkedList<Edge> edges) {
        mst(edges);
        if (connected.size() != v - 1 || e <= v - 1) {
            return - 1;
        }
        t = new Tree();
        t.build(connected);
        long ans = INF;
        for (Edge edge : unused) {
            int w = t.query(edge);
            if (w == -1 || edge.cost == w) continue;
            ans = min(ans, edge.cost - w);
        }
        if (ans == INF) {
            return -1;
        }
        return total + ans;
    }

    static class Tree {
        int MAX = 20;
        R[][] p;
        List<Edge>[] t;
        int[] d;

        public Tree() {
            this.p = new R[MAX + 1][v + 1];
            this.d = new int[v + 1];
            this.t = new List[v + 1];
            for (int i = 0; i < t.length; i++) {
                t[i] = new ArrayList<>();
            }
        }

        int query(Edge e) {
            int a = e.p, b = e.c;
            return query(a, b, e.cost);
        }

        int query(int a, int b, int w) {
            if (d[a] > d[b]) return query(b, a, w);
            int ret = -1;
            for (int i = MAX; i >= 0; i--) {
                if (d[a] <= d[p[i][b].p]) {
                    ret = max(ret, m(p[i][b].f, p[i][b].s, w));
                    b = p[i][b].p;
                }
            }
            if (a == b) return ret;
            for (int i = MAX; i >= 0; i--) {
                if (p[i][b].p != p[i][a].p) {
                    ret = max(ret, m(p[i][a].f, p[i][a].s, w));
                    ret = max(ret, m(p[i][b].f, p[i][b].s, w));
                    a = p[i][a].p;
                    b = p[i][b].p;
                }
            }
            ret = max(ret, m(p[0][b].f, p[0][b].s, w));
            ret = max(ret, m(p[0][a].f, p[0][a].s, w));
            return ret;
        }

        int m(int f, int s, int w) {
            if (f != w) return f;
            return s;
        }

        void build(List<Edge> edges) {
            for (Edge edge : edges) {
                t[edge.p].add(edge);
                t[edge.c].add(edge);
            }
            for (R[] b : p) {
                Arrays.fill(b, new R(0,-1, -1));
            }
            dfs(1, 1);
            buildP();
        }

        void dfs(int cur, int dt) {
            d[cur] = dt;
            for (Edge e : t[cur]) {
                int c = e.p;
                if (cur == c) c = e.c;
                if (d[c] != 0) continue;
                p[0][c] = new R(cur, e.cost, -1);
                dfs(c, dt + 1);
            }
        }

        void buildP() {
            int[] a;
            for (int d = 0; d <= MAX; d++) {
                for (int cur = 1; cur <= v; cur++) {
                    int pp = p[d][cur].p;
                    if (pp == 0 || p[d][pp].p == 0) continue;
                    R tmp = p[d][pp];
                    R bf = p[d][cur];
                    a = new int[]{tmp.f,tmp.s,bf.f,bf.s};
                    Arrays.sort(a);
                    p[d + 1][cur] = new R(p[d][pp].p, a[3], a[2]);
                }
            }
        }
    }

    static void mst(LinkedList<Edge> edges) {
        edges.sort(Comparator.comparingInt(e -> e.cost));
        while (!edges.isEmpty()) {
            Edge e = edges.removeFirst();
            if (u.isUnion(e)) {
                unused.add(e);
                continue;
            }
            total += e.cost;
            u.union(e);
            connected.add(e);
        }
    }

    static class Edge {
        int p, c,cost;

        public Edge(int u, int v, int cost) {
            this.p = u;
            this.c = v;
            this.cost = cost;
        }
    }

    static class U{
        int[] u;

        public U(int n) {
            u = new int[n];
            for (int i = 0; i < n; i++) u[i] = i;
        }

        int find(int x) {
            if (u[x] != x) u[x] = find(u[x]);
            return u[x];
        }
        void union(Edge e) {
            int a = find(e.p);
            int b = find(e.c);
            if (a > b) u[a] = b;
            else u[b] = a;
        }
        boolean isUnion(Edge e) {
            return find(e.p) == find(e.c);
        }
    }

    static class R {
        int p,f, s;
        public R(int p, int f, int s) {
            this.p = p;
            this.f = f;
            this.s = s;
        }
    }
}
