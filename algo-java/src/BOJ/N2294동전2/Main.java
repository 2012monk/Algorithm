package BOJ.N2294동전2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    private static final int INF = 100001;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stz.nextToken());
        int k = Integer.parseInt(stz.nextToken());
        int[] d = new int[k + 1];
        Arrays.fill(d, INF);
        d[0] = 0;

        for (int i = 0; i < n; i++) {
            int p = Integer.parseInt(br.readLine());
            for (int j = p; j <= k; j++) {
                d[j] = Math.min(d[j], d[j - p] + 1);
            }
        }
        if (d[k] == INF) d[k] = -1;
        System.out.println(d[k]);
    }
}
