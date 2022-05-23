package BOJ.N4781사탕가게;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,k;
    static int[] calories, cost;
    static int[] d;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer stz = new StringTokenizer(br.readLine());
            n = Integer.parseInt(stz.nextToken());
            k = (int) (Double.parseDouble(stz.nextToken()) * 100 + 0.1);
            calories = new int[n];
            cost = new int[n];
            d = new int[k + 1];
            if (n == 0) break;
            for (int i = 0; i < n; i++) {
                stz = new StringTokenizer(br.readLine());
                int c = Integer.parseInt(stz.nextToken());
                int w = (int) (Double.parseDouble(stz.nextToken()) * 100 + 0.1);
                if (w > k) continue;
                for (int j = w; j <= k; j++) {
                    d[j] = Math.max(d[j], d[j - w] + c);
                }
            }
            sb.append(d[k]).append('\n');
        }
        System.out.println(sb);
    }
}
