package BOJ.N16198에너지모으기;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, ans;
    static int[] w;
    static boolean[] v;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        v = new boolean[n];
        w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = Integer.parseInt(stz.nextToken());
        }
        solve(0, 0);
        System.out.println(ans);
    }

    static void solve(int total, int count) {
        if (count == n - 2) {
            ans = max(ans, total);
            return;
        }
        for (int i = 1; i < n - 1; i++) {
            if (v[i]) {
                continue;
            }
            v[i] = true;
            solve(total + add(i), count + 1);
            v[i] = false;
        }
    }

    private static int add(int i) {
        int l =i,r = i;
        while (l>0 &&v[l]) l--;
        while (r<n-1&&v[r]) r++;
        return w[l]*w[r];
    }
}
