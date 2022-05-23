package BOJ.N10422괄호;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static long[] d = new long[5001];
    static long MOD = 1000000007L;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        f();
        while (t-->0)  {
            int n = Integer.parseInt(br.readLine());
            System.out.println(d[n]);
        }
    }

    static void f() {
        d[0] = 1;
        d[2] = 1;
        for (int i = 3; i <= 5000; i++) {
            for (int j = 2; j <= i; j++) {
                d[i] += d[j - 2] * d[i - j];
                d[i] %= MOD;
            }
        }
    }
}
