package BOJ.N7579앱;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, k;
    static int[] d = new int[10001];
    static int[] c = new int[101], m = new int[101];

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        stz = new StringTokenizer(br.readLine());
        StringTokenizer s = new StringTokenizer(br.readLine());
        int total = 0;
        for (int i = 0; i < n; i++) {
            m[i] = Integer.parseInt(stz.nextToken());
            c[i] = Integer.parseInt(s.nextToken());
            total += c[i];
        }

        for (int i = 0; i < n; i++) {
            for (int j = total; j >= c[i]; j--) {
                d[j] = Math.max(d[j], d[j - c[i]] + m[i]);
            }
        }
        int ans = 0;
        while (d[ans] < k) ans++;
        System.out.println(ans);
    }
}
