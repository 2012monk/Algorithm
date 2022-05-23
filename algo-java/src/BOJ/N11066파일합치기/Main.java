package BOJ.N11066파일합치기;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] d;
    static int[] a, prefix;
    static int n;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            a = new int[n];
            d = new int[n][n];
            prefix = new int[n + 1];
            stz = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(stz.nextToken());
                prefix[i] += a[i];
                prefix[i + 1] += prefix[i];
            }
            System.out.println(dp(0, n - 1) - prefix[n]);
        }
    }

    static int dp(int i, int j) {
        if (i == j) return a[i];
        if (d[i][j] != 0) return d[i][j];
        int sum = prefix[j];
        if (i > 0) {
            sum -= prefix[i - 1];
        }
        d[i][j] = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            d[i][j] = Math.min(d[i][j], dp(i, k) + dp(k + 1, j) + sum);
        }
        return d[i][j];
    }
}
