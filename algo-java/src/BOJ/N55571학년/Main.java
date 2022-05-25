package BOJ.N55571학년;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] a;
    static long[][] d;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        d = new long[n][21];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stz.nextToken());
        }
        d[0][a[0]] = 1;

        for (int i = 1; i < n - 1; i++) {
            for (int j = 0; j <= 20; j++) {
                long v = d[i - 1][j];
                if (v == 0) continue;
                if (j + a[i] <= 20) d[i][j + a[i]] += v;
                if (j - a[i] >= 0) d[i][j - a[i]] += v;
            }
        }
        System.out.println(d[n - 2][a[n - 1]]);
    }
}
