package BOJ.N12996Acka;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] perm = {
        {0, 0, 1}, {0, 1, 0}, {1, 0, 0}, {0, 1, 1}, {1, 0, 1}, {1, 1, 0}, {1, 1, 1}
    };
    static int[][][][] d;
    static int MOD = 1000000007, k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        k = Integer.parseInt(stz.nextToken());
        int a = Integer.parseInt(stz.nextToken());
        int b = Integer.parseInt(stz.nextToken());
        int c = Integer.parseInt(stz.nextToken());
        d = new int[51][51][51][51];
        for (int[][][] ddd : d) {
            for (int[][] dd : ddd) {
                for (int[] x : dd) {
                    Arrays.fill(x, -1);
                }

            }
        }
        d[0][0][0][0] = 1;
        System.out.println(f(a,b,c,k));
    }

    static int f(int a, int b, int c, int remain) {
        if (a < 0 || b < 0 || c < 0 || a + b +c < remain || remain < 0) return 0;
        int r = d[remain][a][b][c];
        if (r != -1) return r;
        r = 0;
        for (int[] p : perm) {
            r += f(a - p[0], b - p[1], c - p[2], remain - 1);
            r %= MOD;
        }
        return d[remain][a][b][c] = r;
    }
}
