package BOJ.N2616소형기관차;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] pre;
    static int[][] d;
    static int n,k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        k = Integer.parseInt(br.readLine());
        pre = new int[n + 1];
        d = new int[4][50001];
        for (int i = 1; i <= n; i++) {
            pre[i] = pre[i - 1] + Integer.parseInt(stz.nextToken());
        }
        System.out.println(ff());
    }

    static int ff() {
        for (int i = 1; i <= 3; i++) {
            for (int j = i * k; j <= n; j++) {
                d[i][j] = Math.max(d[i][j - 1], d[i - 1][j - k] + pre[j] - pre[j - k]);
            }
        }
        return d[3][n];
    }
}
