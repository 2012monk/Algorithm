package BOJ.N55571학년;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static long[][] d;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        d = new long[21][2];
        stz = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(stz.nextToken());
        d[start][0] = 1;

        for (int i = 1; i < n - 1; i++) {
            int x = Integer.parseInt(stz.nextToken());
            for (int j = 0; j <= 20; j++) {
                long v = d[j][(i & 1) ^ 1];
                if (v == 0) continue;
                if (j + x <= 20) d[j + x][i&1] += v;
                if (j - x >= 0) d[j - x][i&1] += v;
                d[j][(i&1)^1]=0;
            }
        }
        int k = Integer.parseInt(stz.nextToken());
        System.out.println(d[k][n&1]);
    }
}
