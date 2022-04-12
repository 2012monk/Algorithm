package BOJ.N14889스타트와링크;

import static java.lang.Math.abs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, ans = Integer.MAX_VALUE;
    static int[] r, l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;

        n = Integer.parseInt(br.readLine());
        int total = 0;
        r = new int[n];
        l = new int[n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int t = Integer.parseInt(stz.nextToken());
                total += t;
                r[i] += t;
                l[j] += t;
            }
        }
        match(1, 1, total - r[0] - l[0]);
        System.out.println(ans);
    }

    static void match(int x, int count, int current) {
        if (count == n / 2) {
            ans = Math.min(ans, abs(current));
            return;
        }
        if (x == n) {
            return;
        }
        match(x + 1, count + 1, current - r[x] - l[x]);
        match(x + 1, count, current);
    }
}
