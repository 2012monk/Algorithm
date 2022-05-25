package BOJ.n2293동전1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] dp;


    public static int solution(int[] arr, int total) {
        dp = new int[total+1];
        dp[0] = 1;

        for (int k : arr) {
            for (int j = k; j <= total; j++) {
                dp[j] += dp[j - k];
            }
        }

        return dp[total];


    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(br.readLine());
        }
        System.out.println(solution(a, k));

    }
}
