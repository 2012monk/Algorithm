package BOJ.N12872플레이리스트;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[][] d;
    static int n,m,p;
    static int MOD = 1000000007;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        p = Integer.parseInt(stz.nextToken());
        d = new long[101][101];
        for (long[] dd : d) {
            Arrays.fill(dd, -1);
        }
        System.out.println(f(0, 0));
    }

    static long f(int cur, int pick) {
        if (cur == p) {
            if (pick == n) return 1;
            return 0;
        }
        if (d[cur][pick] != -1) return d[cur][pick];
        d[cur][pick] = 0;
        if (pick < n) {
            d[cur][pick] += f(cur + 1, pick + 1) * (n - pick);
        }
        if (pick > m) {
            d[cur][pick] += f(cur + 1, pick) * (pick - m);
        }
        d[cur][pick] %= MOD;
        return d[cur][pick];
    }
}
