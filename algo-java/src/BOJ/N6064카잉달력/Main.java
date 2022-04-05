package BOJ.N6064카잉달력;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int t;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        for (int k = 0; k < t; k++) {
            stz = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(stz.nextToken());
            int M = Integer.parseInt(stz.nextToken());
            int i = Integer.parseInt(stz.nextToken());
            int j = Integer.parseInt(stz.nextToken());
            int result;
            if (N < M) {
                result = solve(N, M, i, j);
            } else {
                result = solve(M, N, j, i);
            }
            System.out.println(result);
        }
    }

    private static int gcd(int a, int b) {
        int tmp;
        while (b != 0) {
            tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    private static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    private static int solve(int n, int m, int i, int j) {
        int limit = lcm(n, m);
        for (int y = i; y <= limit; y += n) {
            if ((y - j) % m == 0) {
                return y;
            }
        }
        return -1;
    }
}
