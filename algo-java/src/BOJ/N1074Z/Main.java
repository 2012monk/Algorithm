package BOJ.N1074Z;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int n, r, c;

    static int solve(int i, int j, int n) {
        if (n == 1) return 0;
        n >>= 1;
        if (i < n &&  j >= n) return n*n+solve(i,j-n,n);
        if (i >= n && j < n) return 2*n*n+solve(i-n,j,n);
        if (i >= n && j >= n) return 3*n*n+solve(i-n,j-n,n);
        return solve(i, j, n);
    }

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        r = Integer.parseInt(stz.nextToken());
        c = Integer.parseInt(stz.nextToken());
        System.out.println(solve(r,c,1<<n));
    }


}
