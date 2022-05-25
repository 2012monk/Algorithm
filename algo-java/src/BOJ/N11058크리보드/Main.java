package BOJ.N11058크리보드;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(br.readLine());
        long[] d = new long[102];
        for (int i = 0; i <= 6; i++) {
            d[i] = i;
        }
        for (int i = 7; i <= n; i++) {
            for (int k = 3; k < i; k++) {
                d[i] = Math.max(d[i], d[i - k] * (k - 1));
            }
        }
        System.out.println(d[n]);
    }
}
