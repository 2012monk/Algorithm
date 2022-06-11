package BOJ.N3176도로네트워크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int MAX = 20;
    static List<Node>[] g;
    static int[] depth;
    static R[][] table;
    static int n,k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        g = new List[n + 1];
        depth = new int[n + 1];
        table = new R[MAX + 1][n + 1];
        for (int i = 0; i < g.length; i++) {
            g[i]=  new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            int d = Integer.parseInt(stz.nextToken());
            g[a].add(new Node(b,d));
            g[b].add(new Node(a,d));
        }
        build();
        k = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < k; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken());
            int b = Integer.parseInt(stz.nextToken());
            R r = query(a, b);
            sb.append(r.min).append(' ').append(r.max).append('\n');
        }
        System.out.println(sb);
    }

    static R query(int a, int b) {
        if (depth[a] > depth[b]) return query(b, a);
        R ret = new R(0, Integer.MAX_VALUE, 0);
        for (int i = MAX; i >= 0; i--) {
            if (depth[a] <= depth[table[i][b].p]) {
                ret.min = Math.min(ret.min, table[i][b].min);
                ret.max = Math.max(ret.max, table[i][b].max);
                b = table[i][b].p;
            }
        }
        if (a == b) return new R(0,ret.min, ret.max);
        for (int i = MAX; i >= 0; i--) {
            if (table[i][a].p!= table[i][b].p) {
                ret.min = Math.min(ret.min, table[i][b].min);
                ret.max = Math.max(ret.max, table[i][b].max);
                ret.min = Math.min(ret.min, table[i][a].min);
                ret.max = Math.max(ret.max, table[i][a].max);
                b = table[i][b].p;
                a = table[i][a].p;
            }
        }
        ret.min = Math.min(ret.min, table[0][b].min);
        ret.max = Math.max(ret.max, table[0][b].max);
        ret.min = Math.min(ret.min, table[0][a].min);
        ret.max = Math.max(ret.max, table[0][a].max);
        return ret;
    }

    static void dfs(int x, int d) {
        depth[x] = d;
        for (Node child : g[x]) {
            if (depth[child.n] != -1) continue;
            table[0][child.n] = new R(x, child.dist, child.dist);
            dfs(child.n, d + 1);
        }
    }

    static void build() {
        Arrays.fill(depth, -1);
        for (R[] rs : table) {
            Arrays.fill(rs, new R(0, Integer.MAX_VALUE, 0));
        }
        dfs(1, 0);
        for (int d = 1; d <= MAX; d++) {
            for (int cur = 1; cur <= n; cur++) {
                R tmp = table[d - 1][table[d - 1][cur].p];
                R before = table[d - 1][cur];
                int min = Math.min(tmp.min, before.min);
                int max = Math.max(tmp.max, before.max);
                table[d][cur] = new R(tmp.p, min, max);
            }
        }
    }

    static class Node {
        int n,dist;

        public Node(int n, int dist) {
            this.n = n;
            this.dist = dist;
        }
    }

    static class R {
        int p, min, max;
        public R(int p, int min, int max) {
            this.p = p;
            this.min = min;
            this.max = max;
        }
    }
}
