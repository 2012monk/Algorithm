package BOJ.N11437LCA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int INF = 21;
    static int[][] parent;
    static int[] depth;
    static List<Integer>[] g;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        parent = new int[n  + 1][INF];
        depth = new int[n + 1];
        g = new List[n + 1];
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            stz = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            g[p].add(c);
            g[c].add(p);
        }
        init();
        StringBuilder sb = new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            sb.append(lca(a, b)).append('\n');
        }
        System.out.println(sb);
    }

    static void dfs(int x, int d) {
        depth[x] = d;
        for (Integer c : g[x]) {
            if (depth[c] != -1) continue;
            parent[c][0] = x;
            dfs(c, d + 1);
        }
    }

    static void init() {
        Arrays.fill(depth, -1);
        dfs(1, 0);
        for (int rank = 1; rank < INF; rank++) {
            for (int node = 1; node <= n; node++) {
                parent[node][rank] = parent[parent[node][rank - 1]][rank - 1];
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] > depth[b]) {
            int tmp = a;
            a = b;
            b = tmp;
        }
        for (int i = INF - 1; i >= 0; i--) {
            if (depth[b] - depth[a] >= (1 << i)) {
                b = parent[b][i];
            }
        }
        if (a == b) return a;
        for (int i = INF - 1; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                a = parent[a][i];
                b = parent[b][i];
            }
        }
        return parent[a][0];
    }
}
