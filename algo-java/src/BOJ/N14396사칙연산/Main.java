package BOJ.N14396사칙연산;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static long n,t;
    static Set<Long> v = new HashSet<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        t = Integer.parseInt(stz.nextToken());
        System.out.println(f());
    }

    static String f()  {
        if (n == t) return "0";
        Queue<N> q = new ArrayDeque<>();
        q.add(new N(n, ""));
        v.add(n);
        while (!q.isEmpty()) {
            N x = q.poll();
            if (x.x == t) {
                return x.path;
            }
            if (!v.contains(x.x*x.x)) {
                v.add(x.x*x.x);
                q.add(new N(x.x*x.x, x.path + "*"));
            }
            if (!v.contains(x.x * 2)) {
                v.add(x.x*2);
                q.add(new N(x.x*2, x.path + "+"));
            }
            if (!v.contains(0L)) {
                v.add(0L);
                q.add(new N(0, x.path + "-"));
            }
            if (!v.contains(1L) && x.x != 0) {
                v.add(1L);
                q.add(new N(1, x.path + "/"));
            }
        }
        return "-1";
    }

    static class N {
        long x;
        String path;

        public N(long x, String path) {
            this.x = x;
            this.path = path;
        }
    }
}
