package BOJ.n9215LCS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int[][] cache;
    static char[] a, b;

    public static int lcs(int n, int m) {
        if (n == 0 || m == 0) return 0;

        if (cache[n - 1][m - 1] != -1) return cache[n - 1][m - 1];

        if (a[n - 1] == b[m - 1]) {
            cache[n - 1][m - 1] = lcs(n - 1,m-1) + 1;
        }
        else{
            cache[n - 1][m - 1] = Math.max(lcs(n - 1, m), lcs(n, m - 1));
        }
        return cache[n - 1][m - 1];
    }

    public static void init() {
        for (int[] i: cache) Arrays.fill(i, -1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        a = br.readLine().toCharArray();
        b = br.readLine().toCharArray();

        cache = new int[a.length + 1][b.length+1];

        for (int i=1; i < cache.length;i++) {
            for (int j = 1; j < cache[0].length; j++) {
                if (a[i-1] == b[j-1]){
                    cache[i][j] = cache[i - 1][j - 1] + 1;
                }
                else{
                    cache[i][j] += Math.max(cache[i - 1][j], cache[i][j - 1]);
                }

            }
        }

        System.out.println(cache[a.length][b.length]);
    }

}
