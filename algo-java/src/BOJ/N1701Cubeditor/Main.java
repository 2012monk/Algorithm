package BOJ.N1701Cubeditor;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static char[] t;

    public static void main(String[] args) throws Exception {
        t = new BufferedReader(new InputStreamReader(System.in)).readLine().toCharArray();
        System.out.println(solve());
    }

    static int solve() {
        int[] p = new int[t.length];
        int k, mx = 0;
        for (int i = 0; i < t.length; i++) {
            k = 0;
            for (int j = i + 1; j < t.length; j++) {
                while (k > 0 && t[j] != t[i + k]) k = p[k - 1];
                if (t[j] == t[i + k]) {
                    k++;
                    mx = Math.max(mx, k);
                }
                p[j - i] = k;
            }
        }
        return mx;
    }
}
