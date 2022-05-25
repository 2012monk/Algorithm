package BOJ.N2281데스노트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[] a, d;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        d = new int[n];
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        Arrays.fill(d, Integer.MAX_VALUE);
        d[n - 1] = 0;
        System.out.println(f(0));
    }

    static int f(int cur) {
        if (d[cur] != Integer.MAX_VALUE) return d[cur];
        int r = m - a[cur];
        for (int i = cur + 1; i < n; i++) {
            d[cur] = Math.min(d[cur], f(i) + r*r);
            r -= a[i] + 1;
            if (r < 0) break;
            if (i == n - 1) d[cur] = 0;
        }
        return d[cur];
    }
}
