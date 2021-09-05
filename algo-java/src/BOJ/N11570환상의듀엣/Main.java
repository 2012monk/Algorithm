package BOJ.N11570환상의듀엣;

import java.util.Arrays;
import java.util.StringTokenizer;
import java.io.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int n;
    static int[] A, d;
    static int[][] D;


    public static void main(String[] args) throws IOException {
        init();
        D[1][0] = 0;
        D[0][1] = 0;

        for (int i = 2; i <= n; i++) {
            int x = Math.abs(A[i] - A[i - 1]);
            for (int j=0;j<i-1;j++) D[i][j] = D[i - 1][j] + x;
            D[i][i - 1] = D[i - 1][0];

            for (int j=0;j<i-1;j++) {
                D[i][i - 1] = Math.min(D[i][i-1], D[i-1][j] + Math.abs(A[i] - A[j]));
            }
        }
        int r = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            r = Math.min(r, D[n][i]);
        }

        System.out.println(r);
    }

    static void init() throws IOException {
        n =Integer.parseInt(br.readLine());
        A=new int[2010];
        D = new int[2010][2010];
        stz = new StringTokenizer(br.readLine());
        for (int i=1;i<=n;i++) A[i] = Integer.parseInt(stz.nextToken());
    }
}
