package BOJ.N17435합성함수와쿼리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int MAX;
    static int[][] t;
    static int[] a;
    static int n,q;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        MAX = (int) Math.floor(Math.log(n));
        stz = new StringTokenizer(br.readLine());
        a = new int[n + 1];
        t = new int[MAX + 1][n + 1];
        for (int i = 1; i <= n; i++) {
            t[0][i] = Integer.parseInt(stz.nextToken());
        }
        build();
        q = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            stz = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(stz.nextToken());
            int x = Integer.parseInt(stz.nextToken());
            sb.append(query(n, x)).append('\n');
        }
        System.out.println(sb);
    }

    static int query(int n, int x) {
        for (int i = MAX; i >= 0; i--) {
            if ((n & (1<<i)) != 0) {
                x = t[i][x];
            }
        }
        return x;
    }

    static void build() {
        for (int i = 1; i <= MAX; i++) {
            for (int j = 1; j <= n; j++) {
                t[i][j] = t[i - 1][t[i - 1][j]];
            }
        }
    }
}
