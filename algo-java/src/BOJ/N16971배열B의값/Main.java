package BOJ.N16971배열B의값;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[] r, c;
    static int n, m;
    static long ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        r = new long[n];
        c = new long[m];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                long v = Integer.parseInt(stz.nextToken());
                if (i != 0 && i != n - 1 && j != 0 && j != m - 1) {
                    ans += v * 4;
                    r[i] += v * 4;
                    c[j] += v * 4;
                    continue;
                }
                ans += v * 2;
                r[i] += v * 2;
                c[j] += v * 2;
                if ((i == 0 && j == 0) || (i == 0 && j == m - 1) ||
                    (i == n - 1 && j == 0) || (i == n - 1 && j == m - 1)) {
                    ans -= v;
                    r[i] -= v;
                    c[j] -= v;
                }
            }
        }
        f();
        System.out.println(ans);
    }

    static void f() {
        long tmp = Integer.MIN_VALUE;
        for (int i = 1; i < n - 1; i++) {
            tmp  = Math.max(tmp, ans - r[i] / 2 + r[0]);
            tmp  = Math.max(tmp, ans - r[i] / 2 + r[n - 1]);
        }
        for (int i = 1; i < m - 1; i++) {
            tmp = Math.max(tmp, ans - c[i] / 2 + c[0]);
            tmp = Math.max(tmp, ans - c[i] / 2 + c[m - 1]);
        }
        ans = Math.max(ans, tmp);
    }

}
