package BOJ.N17069파이프옮기기2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] isWall = new boolean[33][33];
    static long[][][] dp = new long[3][33][33];
    static long[][][] d= new long[3][33][33];
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                isWall[i][j] = stz.nextToken().equals("1");
            }
        }
        dp[0][0][1] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j < n; j++) {
                if (isWall[i][j]) continue;
                for (int k = 0; k < 3; k++) {
                    if (k < 2) {
                        dp[0][i][j] += dp[k][i][j - 1];
                    }
                    if (i == 0) continue;
                    if (!isWall[i - 1][j] && !isWall[i][j - 1]) {
                        dp[1][i][j] += dp[k][i - 1][j - 1];
                    }
                    if (k > 0) {
                        dp[2][i][j] += dp[k][i - 1][j];
                    }
                }
            }
        }
        long ret = 0;
        for (int i = 0; i < 3; i++) {
            ret += dp[i][n - 1][n - 1];
        }
        System.out.println(ret);
    }
}
