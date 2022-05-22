package BOJ.N10942펠린드롬;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] d;
    static int[] a;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        int n = Integer.parseInt(br.readLine());
        a = new int[n];
        d = new int[n][n];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stz.nextToken());
            d[i][i] = 1;
            if (i > 0 && a[i - 1] == a[i]) d[i - 1][i] = 1;
        }
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            stz = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(stz.nextToken()) - 1;
            int to = Integer.parseInt(stz.nextToken()) - 1;
            sb.append(dp(from,to)).append('\n');
        }
        System.out.println(sb);
    }

    static int dp(int i, int j) {
        if (d[i][j] == 1) return 1;
        if (a[i] != a[j]) return d[i][j] = 0;
        return d[i][j] = dp(i + 1, j - 1);
    }
}
