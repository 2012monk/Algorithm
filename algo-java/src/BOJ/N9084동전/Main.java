package BOJ.N9084동전;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer stz;
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            br.readLine();
            stz = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(br.readLine());
            sb.append(solve(k, stz)).append('\n');
        }
        System.out.println(sb);
    }

    static int solve(int k, StringTokenizer stz) {
        d = new int[k + 1];
        while (stz.hasMoreTokens()) {
            int v = Integer.parseInt(stz.nextToken());
            if (v > k) continue;
            d[v] += 1;
            for (int i = v; i <= k ; i++) {
                d[i] += d[i - v];
            }
        }
        return d[k];
    }
}
