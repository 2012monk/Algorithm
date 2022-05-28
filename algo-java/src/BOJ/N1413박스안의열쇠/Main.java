package BOJ.N1413박스안의열쇠;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n, m;
    static long[][] d = new long[21][21];
    // 원소가 n 개인 그래프를 사이클이 m 개 이하인 그래프로 만들수 있는 경우의 수
    // == 원소가 n 개인 집할을 m 개 이하로 분할 할수 있는 방법
    // s(n, m) = s(n - 1, m - 1) + (n - 1) * s(n - 1, m)
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        long nn = f(n, n);
        long nm = f(n, m);
        long r = gcd(nn, nm);
        System.out.printf("%d/%d", nm/r, nn/r);
    }

    static long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    static long f(int n, int k) {
        if (n == 0) return 1;
        if (k == 0) return 0;
        if (d[n][k] != 0) return d[n][k];
        return d[n][k] = f(n - 1, k - 1) + (n - 1) * f(n - 1, k);
    }
}