package BOJ.N15480LCA와쿼리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] parent;
    static int[] d;
    static List<Integer>[] tree;
    static int n, MAX = 20;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        tree = new List[n + 1];
        parent = new int[n + 1][MAX + 1];
        d = new int[n + 1];
        for (int i = 0; i < tree.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }
        buildParent(1);
        StringBuilder sb =  new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(stz.nextToken());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            sb.append(query(r, a, b)).append('\n');
        }
        System.out.println(sb);
    }

    static int query(int r, int u, int v) {
        int ru = lca(r, u);
        int rv = lca(r, v);
        int uv = lca(u, v);
        int ret = uv;
        if (d[ret] < d[ru]) {
            ret = ru;
        }
        if (d[ret] < d[rv]) {
            ret = rv;
        }
        return ret;
    }

    static void buildTree(int node, int depth) {
        d[node] = depth;
        for (Integer child : tree[node]) {
            if (d[child] != -1) continue;
            parent[child][0] = node;
            buildTree(child, depth + 1);
        }
    }

    static void buildParent(int p) {
        Arrays.fill(d, -1);
        buildTree(p, 0);
        for (int depth = 1; depth <= MAX; depth++) {
            for (int node = 1; node <= n; node++) {
                parent[node][depth] = parent[parent[node][depth - 1]][depth - 1];
            }
        }
    }

    static int lca(int a, int b) {
        if (d[a] > d[b]) return lca(b, a);
        for (int i = MAX; i >= 0; i--) {
            if (d[a] <= d[parent[b][i]]) {
                b = parent[b][i];
            }
        }
        if (a == b) return a;
        for (int i = MAX; i >= 0; i--) {
            if (parent[a][i] != parent[b][i]) {
                b = parent[b][i];
                a = parent[a][i];
            }
        }
        return parent[a][0];
    }
}
