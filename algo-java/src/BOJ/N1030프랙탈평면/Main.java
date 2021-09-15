package BOJ.N1030프랙탈평면;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] b;
    static int n, s, k, x1, y1, x2, y2, size;
    static StringBuilder[] res;

    static int draw(int size, int x, int y){
        if (size == 1) return 0;
        size /= n;
        if (x >= size * (n-k)/2 && x < size * (n+k)/2 &&
            y >= size * (n-k)/2 && y < size * (n+k)/2)
            return 1;
        return draw(size, x%size, y%size);

    }


    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        s = Integer.parseInt(stz.nextToken());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        x1 = Integer.parseInt(stz.nextToken());
        x2 = Integer.parseInt(stz.nextToken());
        y1 = Integer.parseInt(stz.nextToken());
        y2 = Integer.parseInt(stz.nextToken());
        size = (int) Math.pow(n, s);
        res = new StringBuilder[x2-x1+1];
        b = new int[n][n];
        for (int i = 0; i < x2-x1+1; i++) {
            res[i] = new StringBuilder();
        }

        for (int i = x1; i <= x2; i++) {
            for (int j = y1; j <= y2; j++) {
                res[i-x1].append(draw(size, i, j));
            }
        }

        for (StringBuilder re : res) {
            System.out.println(re);
        }
    }


}
