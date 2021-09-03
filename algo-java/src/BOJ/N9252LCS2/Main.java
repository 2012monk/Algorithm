package BOJ.N9252LCS2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static String[][] cache;
    static char[] a, b;

    public static String lcs(int n, int m) {
        if (n == 0 || m == 0) {
            return "";
        }

        if (cache[n - 1][m - 1] != null) {
            return cache[n - 1][m - 1];
        }

        if (a[n - 1] == b[m - 1]) {

            cache[n - 1][m - 1] = lcs(n - 1, m - 1) + a[n-1];
        } else {
            String l = lcs(n-1,m);
            String r = lcs(n, m-1);
            cache[n - 1][m - 1] = l.length() > r.length() ? l : r;

        }
        return cache[n - 1][m - 1];
    }

    public static void main(String[] args) throws IOException {
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();
        cache = new String[a.length + 1][b.length + 1];

        String res = lcs(a.length,b.length);
        System.out.println(res.length());
        System.out.println(res);
    }
}
