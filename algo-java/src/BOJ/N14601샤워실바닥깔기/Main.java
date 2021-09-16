package BOJ.N14601샤워실바닥깔기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] b;
    static int n,tag;
    static boolean isVoid(int x, int y, int size) {
        for (int i = x; i < x+size; i++) {
            for (int j = y; j < y+size; j++) {
                if (b[i][j] != 0) return false;
            }
        }
        return true;
    }

    static void tromino(int x, int y, int size) {
        ++tag;
        size>>=1;
        int midX = x + size;
        int midY = y + size;
        if (isVoid(x, y, size)) b[midX-1][midY-1] = tag;
        if (isVoid(x, midY, size)) b[midX-1][midY] = tag;
        if (isVoid(midX,y,size)) b[midX][midY-1] = tag;
        if (isVoid(midX,midY,size)) b[midX][midY] = tag;

        if (size << 1 == 2) return;

        tromino(x, y, size);
        tromino(x, midY, size);
        tromino(midX, y, size);
        tromino(midX,midY,size);
    }
    public static void main(String[] args) throws IOException {
        n = 1<<Integer.parseInt(br.readLine());
        b = new int[n][n];
        stz = new StringTokenizer(br.readLine());
        int x = Integer.parseInt(stz.nextToken());
        int y = Integer.parseInt(stz.nextToken());
        b[y-1][x-1] = -1;
        tromino(0,0, n);
        StringBuilder sb = new StringBuilder();
        for (int i = n-1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                sb.append(b[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
        // *# #*
        // ## ##

    }


}
