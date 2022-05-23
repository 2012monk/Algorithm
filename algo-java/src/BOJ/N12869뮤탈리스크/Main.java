package BOJ.N12869뮤탈리스크;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] o = {
        {9, 3, 1}, {9, 1, 3}, {1, 3, 9}, {1, 9, 3}, {3, 1, 9}, {3, 9, 1}
    };
    static int[][][] d;
    static int[] a;
    static int n;
    static int INF = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        a = new int[3];
        d = new int[61][61][61];
        for (int[][] dd : d) {
            for (int[] ints : dd) {
                Arrays.fill(ints, INF);
            }
        }
        stz = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(stz.nextToken());
        }
        d[0][0][0] = 0;
        System.out.println(find(a[0], a[1], a[2]));
    }

    static int find(int a, int b, int c) {
        int r = d[a][b][c];
        if (r != INF) return r;
        for (int[] order : o) {
            r = Math.min(r, find(sub(a, order[0]), sub(b, order[1]), sub(c, order[2])) + 1);
        }
        return d[a][b][c] = r;
    }

    static int sub(int a, int b) {
        if (a < b) return 0;
        return a -b;
    }
}
