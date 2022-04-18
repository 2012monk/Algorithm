package BOJ.N16953AtoB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int n,m,ans=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        solve(n, 1);
        if (ans == Integer.MAX_VALUE) ans = -1;
        System.out.println(ans);
    }

    static void solve(long x, int total) {
        if (x > m) return;
        if (x == m) {
            ans = Math.min(ans, total);
        }
        solve(x*2,total+1);
        solve(x*10+1, total+1);
    }
}
