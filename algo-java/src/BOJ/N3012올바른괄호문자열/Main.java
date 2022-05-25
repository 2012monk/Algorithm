package BOJ.N3012올바른괄호문자열;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n;
    static char[] a;
    static long[][] d = new long[201][201];
    static long MOD = 100000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = br.readLine().toCharArray();
        for (long[] ints : d) {
            Arrays.fill(ints, -1);
        }
        long r = f(0, n - 1);
        if (r >= MOD) {
            System.out.printf("%05d", r % MOD);
        } else {
            System.out.println(r);
        }
    }

    static long mod(long v) {
        if (v >= MOD) return MOD + v % MOD;
        return v;
    }

    static char[] open = "([{".toCharArray();
    static char[] close = ")]}".toCharArray();

    static long f(int lo, int hi) {
        if (lo > hi) return 1;
        if (d[lo][hi] != -1) return d[lo][hi];
        d[lo][hi] = 0;
        for (int mid = lo + 1; mid <= hi; mid+=2) {
            for (int i = 0; i < 3; i++) {
                if (a[lo] == open[i] || a[lo] == '?') {
                    if (a[mid] == close[i] || a[mid] == '?') {
                        d[lo][hi] = mod(d[lo][hi] + f(lo + 1, mid - 1) * f(mid + 1, hi));

                    }
                }
            }
        }
        return d[lo][hi];
    }
}
