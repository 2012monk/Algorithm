package BOJ.N12026BOJ거리;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    static int n, INF = 1000*1000+1;
    static int[] d = new int[1001];
    static char[] a;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = br.readLine().toCharArray();
        Arrays.fill(d, INF);
        d[0] = 0;
        System.out.println(f());
    }

    static int f() {
        for (int i = 0; i < n - 1; i++) {
            char cur = a[i];
            char t = 'B';
            if (cur == 'O') t = 'J';
            if (cur == 'B') t = 'O';
            for (int j = i + 1; j < n; j++) {
                if (a[j] != t) continue;
                d[j] = Math.min(d[j], d[i] + (j - i) * (j - i));
            }
        }
        if (d[n - 1] == INF) return -1;
        return d[n - 1];
    }
}
