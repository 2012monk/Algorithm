package BOJ.N1992쿼드트리;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    static boolean[][] board;
    static int n;
    static long compress(int n, int sx, int sy, int ex, int ey){
        if (n == 1) return board[sx-1][sy-1]?1:0;
        n /= 2;
        long mask = (1L << (n*n))-1;
        long[] r = new long[4];
        r[0] = compress(n,sx,sy,ex-n,ey-n);
        r[1] = compress(n, sx,sy+n,ex-n,ey);
        r[2] = compress(n,sx+n,sy,ex,ey-n);
        r[3] = compress(n,sx+n,sy+n,ex,ey);
        for (int i = 0 ;i < 4 ; i++) {
            mask &= r[i] << (3-i);
        }
        return mask;
    }

    static String comp(int n, int sx, int sy, int ex, int ey){
        if (n == 1) return board[sx][sy]?"1":"0";
        n/=2;
        String[] b = new String[4];
        b[0] = comp(n,sx,sy,ex-n,ey-n);
        b[1] = comp(n, sx,sy+n,ex-n,ey);
        b[2] = comp(n,sx+n,sy,ex,ey-n);
        b[3] = comp(n,sx+n,sy+n,ex,ey);
        boolean f = b[0].length() == 1;
        if (f){
            for (int i=0;i<3;i++){
                f = f && b[i].equals(b[i+1]);
            }
        }
        if (f){
            if (b[0].charAt(0) == '0') return "0";
            return "1";
        }
        return "("+b[0]+b[1]+b[2]+b[3]+")";
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                if (s.charAt(j) == '1') board[i][j] = true;
            }
        }
        System.out.println(comp(n, 0,0,n,n));
    }


}
