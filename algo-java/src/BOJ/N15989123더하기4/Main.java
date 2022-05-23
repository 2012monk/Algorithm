package BOJ.N15989123더하기4;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int[][] d = new int[10001][10001];
    static int i = 4;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        d[1][1] = d[3][1] = d[3][2] = d[3][3] = d[2][1] = d[2][2] = 1;
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            sb.append(dp(k)).append('\n');
        }
        System.out.println(sb);
    }

    static int dp(int k) {
        for (; i <= k; i++) {
            d[i][1] = d[i - 1][1];
            d[i][2] = d[i - 2][1] + d[i - 2][2];
            d[i][3]= d[i - 3][1] + d[i - 3][2] + d[i - 3][3];
        }
        return d[k][1] + d[k][2] + d[k][3];
    }
}
