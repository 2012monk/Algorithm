package BOJ.N1774우주인과교감;

import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static P[] ps;
    static List<E> es = new ArrayList<>();
    static int n,m;
    static double ans;
    static U u;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        u = new U(n);
        ps = new P[n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(stz.nextToken());
            int y = Integer.parseInt(stz.nextToken());
            ps[i] = new P(x, y);
        }

        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stz.nextToken()) - 1;
            int b = Integer.parseInt(stz.nextToken()) - 1;
            u.union(a, b);
        }

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (u.isUnion(i , j)) continue;
                es.add(new E(i, j, cost(i, j)));
            }
        }
        es.sort(Comparator.comparingDouble(e -> e.cost));
        for (E e : es) {
            if (u.isUnion(e.u, e.v)) continue;
            u.union(e.u, e.v);
            ans += e.cost;
        }
        System.out.printf("%.2f", ans);
    }

    static double cost(int a, int b) {
        long x = ps[a].x - ps[b].x;
        long y = ps[a].y - ps[b].y;
        return sqrt(x*x+y*y);
    }

    static class U {
        int[] u;

        public U(int n) {
            u = new int[n];
            for (int i = 0; i < n; i++)  u[i]= i;
        }

        int find(int x) {
            if (u[x] != x) u[x] = find(u[x]);
            return u[x];
        }

        void union(int a, int b) {
            int fa = find(a);
            int fb = find(b);
            if (fa < fb) u[fb] = fa;
            else u[fa] = fb;
        }

        boolean isUnion(int a, int b) {
            return find(a) == find(b);
        }
    }

    static class E{
        int u,v;
        double cost;

        public E(int u, int v, double cost) {
            this.u = u;
            this.v = v;
            this.cost = cost;
        }
    }

    static class P {
        int x,y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
