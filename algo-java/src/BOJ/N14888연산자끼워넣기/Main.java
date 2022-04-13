package BOJ.N14888연산자끼워넣기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] operation = new int[4], a;
    static int n;
    static long min = Long.MAX_VALUE, max = Long.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        a = new int[n];
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stz.nextToken());
        }
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] += Integer.parseInt(stz.nextToken());
        }
        solve(1, a[0]);
        System.out.println(max);
        System.out.println(min);
    }

    static void solve(int x, long current) {
        if (x == n) {
            min = Math.min(current, min);
            max = Math.max(current, max);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operation[i] == 0) continue;
            operation[i]--;
            solve(x + 1, cal(current, a[x], i));
            operation[i]++;
        }
    }

    private static long cal(long f, long b, int i) {
        if (i == 0) {
            return f+b;
        }
        if (i == 1) {
            return f - b;
        }
        if (i == 2) {
            return f * b;
        }
        return f / b;
    }
}
