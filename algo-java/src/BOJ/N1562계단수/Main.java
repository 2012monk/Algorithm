package BOJ.N1562계단수;

import java.util.Scanner;

public class Main {

    static int n, full, mod = 1000000000;
    static int[][][] dp;

    public static void main(String[] args) {
        n = new Scanner(System.in).nextInt();
        dp = new int[101][10][4];
        dp[0][0][0] = 1;
        for (int i=1;i<9;i++) dp[0][i][1] = 1;
        dp[0][9][2] = 1;
        for (int i=1;i<n;i++) {
            for (int j=0;j<10;j++){
                if (j == 0) {
                    dp[i][0][3] = (dp[i-1][1][3]+dp[i-1][1][2])%mod;
                    dp[i][0][0] = (dp[i-1][1][0]+dp[i-1][1][1])%mod;
                }
                else if (j == 9) {
                    dp[i][9][3]=(dp[i-1][8][0]+dp[i-1][8][3])%mod;
                    dp[i][9][2]=(dp[i-1][8][1]+dp[i-1][8][2])%mod;
                }
                else{
                    for (int k=0;k<4;k++) dp[i][j][k]=(dp[i-1][j-1][k]+dp[i-1][j+1][k])%mod;
                }
            }
        }

        int res = 0;
        for (int i=1;i<10;i++) res = (res + dp[n-1][i][3]) % mod;
        System.out.println(res);
    }

}
