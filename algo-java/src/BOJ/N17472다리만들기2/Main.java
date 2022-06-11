package BOJ.N17472다리만들기2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Edge> edges = new ArrayList<>();
    static List<Point> points = new ArrayList<>();
    static int[][] g, dir = {{0, 1}, {0, -1},{1, 0}, {-1, 0}};
    static int n,m;
    static UF uf;
    static int W = 0, L = 1, group = 2;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        uf = new UF(10);
        g = new int[n][m];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                g[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        build();
        edges.sort(Comparator.comparingInt(e -> e.w));
        int ret = 0;
        for (Edge edge : edges) {
            if (!uf.isConnected(edge.a, edge.b)) {
                uf.union(edge.a, edge.b);
                ret += edge.w;
            }
        }
        int p = uf.find(2);
        for (int i = 2; i < group; i++) {
            if (uf.isConnected(p, i)) continue;
            ret = -1;
            break;
        }
        System.out.println(ret);
    }

    static void build() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (g[i][j] == 1) {
                    g[i][j] = group;
                    dfs(i, j, group++);
                }
            }
        }
        createEdges();
    }

    static void createEdges() {
        for (Point p : points) {
            createEdge(p.x,p.y, dir[p.dir][0], dir[p.dir][1], p.group);
        }
    }

    static void dfs(int x, int y, int group) {
        for (int i = 0; i < dir.length; i++) {
            int[] d = dir[i];
            int dx = x + d[0];
            int dy = y + d[1];
            if (!withinBounds(dx, dy)) continue;
            if (g[dx][dy] == W) {
                points.add(new Point(dx,dy,group, i));
                continue;
            }
            if (g[dx][dy] != L) continue;
            g[dx][dy] = group;
            dfs(dx, dy, group);
        }
    }

    static void createEdge(int x, int y, int nx, int ny, int a) {
        int dist = 0;
        while (withinBounds(x, y) && g[x][y] == W) {
            x += nx;
            y += ny;
            dist++;
        }
        if (!withinBounds(x, y) || dist < 2) return;
        int b = g[x][y];
        Edge edge = new Edge(a, b, dist);
        edges.add(edge);
    }

    static boolean withinBounds(int x, int y) {
        return 0 <= x && x < n && 0 <= y && y < m;
    }

    static class Point {
        int x,y,group,dir;

        public Point(int x, int y, int group, int dir) {
            this.x = x;
            this.y = y;
            this.group = group;
            this.dir = dir;
        }
    }

    static class Edge {
        int a, b, w;

        public Edge(int a, int b, int w) {
            if (a < b) {
                this.a = b;
                this.b = a;
            } else {
                this.a = a;
                this.b = b;
            }
            this.w = w;
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
}