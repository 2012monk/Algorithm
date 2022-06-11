package BOJ.N1761정점들의거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {


    static int INF = 21;
    static int[][] parent;
    static int[][] dist;
    static int[] pd;
    static int[] depth;
    static List<Node>[] g;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        parent = new int[n  + 1][INF];
        depth = new int[n + 1];
        dist = new int[n + 1][INF];
        pd = new int[n + 1];
        g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int d = Integer.parseInt(stz.nextToken());
            g[a].add(new Node(b, d));
            g[b].add(new Node(a, d));
        }
        init();
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            sb.append(f(a,b)).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int d) {
        depth[x] = d;
        for (Node child : g[x]) {
            int c = child.node;
            if (depth[c] != -1) continue;
            pd[c] = pd[x] + child.dist;
            parent[c][0] = x;
            dist[c][0] = child.dist;
            dfs(c, d + 1);
        }
    }

    static void init() {
        Arrays.fill(depth, -1);
        dfs(1, 0);
        for (int d = 1; d < INF; d++) {
            for (int node = 1; node <= n; node++) {
                int tmp = parent[node][d - 1];
                parent[node][d] = parent[tmp][d - 1];
                dist[node][d] = dist[tmp][d - 1] + dist[node][d - 1];
            }
        }
    }

    static int f(int a, int b) {
        int c = lca(a, b);
        return pd[a] - pd[c] + pd[b] - pd[c];
    }
    static int lca(int a, int b) {
        if (depth[a] > depth[b]) return lca(b, a);
        for (int i = INF; i >= 0; i--) {
            if (depth[a] <= depth[parent[b][i]]) {
                b = parent[b][i];
            }
        }
        if (a == b) return a;
        for (int i = INF; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                b = parent[b][i];
                a = parent[a][i];
            }
        }
        return parent[a][0];
    }

    static int dist(int a, int b) {
        if (depth[a] > depth[b]) return dist(b, a);
        int ret = 0;
        for (int i = INF - 1; i >= 0; i--) {
            if (depth[b] - depth[a] >= (1 << i)) {
                ret += dist[b][i];
                b = parent[b][i];
            }
        }
        if (a == b) return ret;
        for (int i = INF - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                ret += dist[a][i] + dist[b][i];
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return ret + dist[a][0] + dist[b][0];
    }

    static class Node {
        int node, dist;

        public Node(int node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
