package BOJ.N14391종이조각;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] v;
    static int[] values;
    static int n, m, ans = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        v = new boolean[n * m];
        values = new int[n * m];

        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                values[i * m + j] = s.charAt(j) - '0';
            }
        }
        dfs(0);
        System.out.println(ans);
    }

    static void dfs(int p) {
        if (p == n * m) {
            count();
            return;
        }
        v[p] = true;
        dfs(p + 1);
        v[p] = false;
        dfs(p + 1);
    }

    private static void count() {
        int sum, total = 0;
        for (int i = 0; i < n * m; i += m) {
            sum = 0;
            for (int p = i; p < i + m; p++) {
                if (v[p]) {
                    sum = sum * 10 + values[p];
                } else {
                    total += sum;
                    sum = 0;
                }
            }
            total += sum;
        }
        for (int i = 0; i < m; i++) {
            sum = 0;
            for (int p = i; p < n * m; p += m) {
                if (!v[p]) {
                    sum = sum * 10 + values[p];
                } else {
                    total += sum;
                    sum = 0;
                }
            }
            total += sum;
        }
        ans = max(ans, total);
    }
}
