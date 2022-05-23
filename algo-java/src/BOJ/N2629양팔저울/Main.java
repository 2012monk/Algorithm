package BOJ.N2629양팔저울;

import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n;
    static int[] a = new int[31];
    static boolean[][] d = new boolean[31][30*500+1];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        StringBuilder sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stz.nextToken());
        }
        f(0, 0);

        br.readLine();
        stz = new StringTokenizer(br.readLine());
        while (stz.hasMoreTokens()) {
            if (r(Integer.parseInt(stz.nextToken()))) {
                sb.append('Y');
            } else {
                sb.append('N');
            }
            sb.append(' ');
        }
        System.out.println(sb);
    }

    static boolean r(int k) {
        if (k > 30 * 500) return false;
        return d[n][k];
    }

    static void f(int i, int v) {
        if (i > n) return ;
        if (d[i][v]) return ;
        d[i][v] = true;
        f(i + 1, v + a[i]);
        f(i + 1, v);
        f(i + 1, abs(v - a[i]));
    }
}
