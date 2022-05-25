package BOJ.N11049행렬곱셈순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[][] a, d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        a = new int[n][2];
        d = new int[n][n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(stz.nextToken());
            a[i][1] = Integer.parseInt(stz.nextToken());
        }
        System.out.println(solve(0, n - 1));
    }

    static int solve(int lo, int hi) {
        if (lo == hi) return 0;
        if (hi - lo == 1) return d[lo][hi] = a[lo][0] * a[lo][1] * a[hi][1];
        if (d[lo][hi] != 0) return d[lo][hi];
        int ans = Integer.MAX_VALUE;
        for (int i = lo; i < hi; i++) {
            ans = Math.min(ans, solve(lo, i) + solve(i + 1, hi) + a[lo][0] * a[i][1] * a[hi][1]);
        }
        return d[lo][hi] = ans;
    }
}
