package BOJ.N11438LCA2;

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
        buildParent();
        StringBuilder sb=  new StringBuilder();
        int m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            sb.append(lca(a, b)).append('\n');
        }
        System.out.println(sb);
    }

    static void buildTree(int node, int depth) {
        d[node] = depth;
        for (Integer child : tree[node]) {
            if (d[child] != -1) continue;
            parent[child][0] = node;
            buildTree(child, depth + 1);
        }
    }

    static void buildParent() {
        Arrays.fill(d, -1);
        buildTree(1, 0);
        for (int depth = 1; depth <= MAX; depth++) {
            for (int node = 1; node <= n; node++) {
                // 2 ^ depth 번째 조상은 2 ^ (depth -1) 번째 조상의 2 ^ (depth -1) 번째 조상과 같다
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
