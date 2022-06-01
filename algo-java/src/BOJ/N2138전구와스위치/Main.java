package BOJ.N2138전구와스위치;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int n;
    static int INF = 1000000;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        int[] a = new int[n];
        int[] a1 = new int[n];
        String s = br.readLine();
        for (int i = 0; i < n; i++) {
            a1[i] = a[i] = s.charAt(i) - '0';
        }
        a1[0] ^= 1;
        a1[1] ^= 1;
        s = br.readLine();
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = s.charAt(i) - '0';
        }
        int ans = Math.min(count(a,b),count(a1, b) + 1);
        if (ans >= INF) ans = -1;
        System.out.println(ans);
    }

    static int count(int[] a, int[] b) {
        int r = 0;
        for (int i = 1; i < n; i++) {
            if (a[i - 1] != b[i - 1]) {
                flip(a,i);
                r++;
            }
        }
        for (int i = 0; i < n; i++) {
            if (a[i] != b[i]) return INF;
        }
        return r;
    }

    static void flip(int[] a, int x) {
        a[x] ^= 1;
        if (x > 0) a[x - 1] ^= 1;
        if (x < n - 1) a[x + 1] ^= 1;
    }
}
