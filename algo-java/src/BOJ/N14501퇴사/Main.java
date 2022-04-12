package BOJ.N14501퇴사;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] t, p, dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        dp = new int[n + 2];
        t = new int[n + 2];
        p = new int[n + 2];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            t[i] = Integer.parseInt(stz.nextToken());
            p[i] = Integer.parseInt(stz.nextToken());
        }
        if (t[n - 1] == 1) {
            dp[n - 1] = p[n - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];
            if (i + t[i] - 1 >= n) {
                continue;
            }
            dp[i] = max(dp[i], p[i] + dp[t[i] + i]);
        }
        System.out.println(dp[0]);
    }

    static int top(int day) {
        if (day < 0) {
            return dp[0];
        }
        dp[day] = dp[day + 1];
        if (day + t[day] - 1 < n) {
            dp[day] = max(dp[day], p[day] + dp[t[day] + day]);
        }
        return top(day - 1);
    }
}
