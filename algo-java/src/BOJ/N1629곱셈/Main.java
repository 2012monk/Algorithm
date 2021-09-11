package BOJ.N1629곱셈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static long a,b, mod;

    static long multiply(long a, long b){
        if (b == 1) return a%mod;
        long v = multiply(a,b/2)%mod;
        v = (v*v)%mod;
        if (b % 2 == 0) return v;
        return v*a%mod;
    }

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        a = Long.parseLong(stz.nextToken());
        b = Long.parseLong(stz.nextToken());
        mod = Long.parseLong(stz.nextToken());
        System.out.println(multiply(a,b));
    }


}
