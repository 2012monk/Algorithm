package BOJ.N10564팔굽혀펴기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static int[] a;
    static int[][] d;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            stz = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stz.nextToken());
            m = Integer.parseInt(stz.nextToken());
            a = new int[m];
            d = new int[n + 1][101];
            for (int[] dd : d) {
                Arrays.fill(dd, -1);
            }
            stz = new StringTokenizer(br.readLine());
            for (int i = 0; i < m; i++) {
                a[i] = Integer.parseInt(stz.nextToken());
            }
            int result = f(n , 1);
            if (result < 0) result = -1;
            sb.append(result).append('\n');
        }
        System.out.println(sb);
    }

    static int f(int cnt, int t) {
        if (cnt == 0) return 0;
        if (d[cnt][t] != -1) return d[cnt][t];
        int r = Integer.MIN_VALUE;
        for (int i = 0; i < m; i++) {
            if (cnt - t * a[i] < 0) continue;
            r = Math.max(r, f(cnt - t * a[i], t + 1) + a[i]);
        }
        return d[cnt][t] = r;
    }
}
