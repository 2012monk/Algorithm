package BOJ.N13171A;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static long A, x;
    final static long MOD = 1000000007;
    static long pow(long a, long x) {
        if (x == 1) return a%MOD;
        long v = pow(a,x/2) % MOD;
        v = (v*v)%MOD;
        if (x % 2 != 0) v = (v*a)%MOD;
        return v%MOD;
    }

    public static void main(String[] args) throws IOException {
        A = Long.parseLong(br.readLine());
        x = Long.parseLong(br.readLine());
        System.out.println(pow(A%MOD, x));
    }
}
