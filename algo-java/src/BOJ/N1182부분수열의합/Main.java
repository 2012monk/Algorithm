package BOJ.N1182부분수열의합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k, ans;
    static int[] a;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        stz = new StringTokenizer(br.readLine());
        a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stz.nextToken());
        }
        ans = 0;
        solve(0, 0);
        if (k == 0) ans--; // 공집합 제거
        System.out.println(ans);
    }

    static void solve(int x, int total) {
        if (x == n) {
            if (total == k) {
                ans++;
            }
            return;
        }
        solve(x + 1, total + a[x]);
        solve(x + 1, total);
    }
}
