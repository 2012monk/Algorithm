package BOJ.N1533길의개수;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long[][] dist;
    static int n,s,e,t,MOD = 1_000_003;
    static int size;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        s = Integer.parseInt(stz.nextToken());
        e = Integer.parseInt(stz.nextToken());
        t = Integer.parseInt(stz.nextToken());
        size = 5 * n + 1;
        dist = new long[size][size];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for (int j = 1; j <= n; j++) {
                int v = s.charAt(j - 1) - '0';
                if (v == 0) continue;
                dist[i * 5][j * 5 - (v - 1)] = 1;
            }
            for (int j = 1; j <= 4; j++) {
                dist[(i - 1) * 5 + j][(i - 1) * 5 + j + 1] = 1;
            }
        }
        System.out.println(mpow(dist, t)[s * 5][e * 5]);
    }

    static long[][] mpow(long[][] a, int x) {
        long[][] r = new long[size][size];
        for (int i = 1; i < size; i++) {
            r[i][i] = 1;
        }
        while (x != 0) {
            if (x % 2 != 0) {
                r = mul(r, a);
            }
            x /= 2;
            a = mul(a, a);
        }
        return r;
    }

    static long[][] mul(long[][] a, long[][] b) {
        long[][] r = new long[size][size];
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                for (int k = 1; k < size; k++) {
                    r[i][j] += a[i][k] * b[k][j];
                    r[i][j] %= MOD;
                }
            }
        }
        return r;
    }
}
