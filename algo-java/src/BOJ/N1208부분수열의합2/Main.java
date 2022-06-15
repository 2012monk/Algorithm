package BOJ.N1208부분수열의합2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static int[] a;
    static Map<Integer, Integer> p = new HashMap<>();
    static int n,k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        a = new int[n];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stz.nextToken());
        }
        f(n / 2, 0);
        long ans = g(0, 0);
        if (k == 0) ans--;
        System.out.println(ans);
    }
    static void f(int i, int s) {
        if (i == n) {
            p.computeIfPresent(s, (k,v)->++v);
            p.putIfAbsent(s, 1);
            return;
        }
        f(i + 1, s + a[i]);
        f(i + 1, s);
    }
    static long g(int i, int s) {
        if (i == n / 2) {
            return p.getOrDefault(k - s, 0);
        }
        return g(i + 1, s + a[i]) + g(i + 1, s);
    }
}
