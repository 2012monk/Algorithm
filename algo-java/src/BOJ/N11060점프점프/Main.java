package BOJ.N11060점프점프;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int INF = 10000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] dp = new int[n];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stz.nextToken());
            dp[i] = INF;
        }
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= a[i] && j + i < n; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        if (dp[n - 1] == INF) dp[n - 1] = -1;
        System.out.println(dp[n - 1]);
    }
}
