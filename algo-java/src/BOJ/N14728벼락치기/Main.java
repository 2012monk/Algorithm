package BOJ.N14728벼락치기;

import static java.lang.Math.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] info, d;
    static int[] time, values;
    static int n,k;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        time = new int[n];
        values = new int[n];
        d = new int[k + 1][n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(stz.nextToken());
            values[i] = Integer.parseInt(stz.nextToken());
        }
        System.out.println(f(0, k));
    }

    static int f(int cur, int t) {
        if (cur >= n) return 0;
        if (d[t][cur] != 0) return d[t][cur];
        if (t >= time[cur]) {
            d[t][cur] = f(cur + 1, t - time[cur]) + values[cur];
        }
        return d[t][cur] = max(d[t][cur], f(cur + 1, t));
    }
}
