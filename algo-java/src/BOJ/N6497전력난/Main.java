package BOJ.N6497전력난;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static List<Edge> edges = new ArrayList<>();
    static U u;
    static int n,m,ans;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    public static void main(String[] args) throws Exception {
        StringBuilder sb = new StringBuilder();
        while (true) {
            edges.clear();
            stz = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stz.nextToken());
            m = Integer.parseInt(stz.nextToken());
            ans = 0;
            if (n == 0) break;
            u = new U(n);
            for (int i = 0; i < m; i++) {
                stz = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(stz.nextToken());
                int y = Integer.parseInt(stz.nextToken());
                int z = Integer.parseInt(stz.nextToken());
                edges.add(new Edge(x,y,z));
                ans += z;
            }
            edges.sort(Comparator.comparingInt(e -> e.cost));
            for (Edge e : edges) {
                if (u.isUnion(e)) continue;
                u.union(e.u, e.v);
                ans -= e.cost;
            }
            sb.append(ans).append('\n');
        }
        System.out.println(sb);
    }


    static class Edge {
        int u,v,cost;

        public Edge(int u, int v, int cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }
    static class U{
        int[] u;
        int[] rank;

        public U(int n) {
            u = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) u[i] = i;
        }

        int find(int x) {
            if (u[x] != x) u[x] = find(u[x]);
            return u[x];
        }
        void union(int a, int b) {
            a = find(a);
            b = find(b);
            if (a == b) return;
            if (rank[a] < rank[b]) {
                int tmp = a;
                a = b;
                b = tmp;
            }
            if (rank[a] == rank[b]) rank[a]++;
            u[b] = a;
        }
        boolean isUnion(Edge e) {
            return isUnion(e.u, e.v);
        }
        boolean isUnion(int a, int b) {
            return find(a) == find(b);
        }
    }
}
