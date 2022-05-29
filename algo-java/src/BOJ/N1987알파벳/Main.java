package BOJ.N1987알파벳;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int r,c;
    static char[][] g;
    static int[][] d = { {0, 1}, {0, -1}, {1, 0}, {-1, 0} };
    static int[][] v = new int[21][21];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        r = Integer.parseInt(stz.nextToken());
        c = Integer.parseInt(stz.nextToken());
        g = new char[r][c];
        for (int i = 0; i < r; i++) {
            g[i] = br.readLine().toCharArray();
            Arrays.fill(v[i], -1);
        }
        System.out.println(f(0,0, 0));
    }

    static int f(int x, int y, int visit) {
        if (x < 0 || y < 0 || x >= r || y >= c) return 0;
        if (v[x][y] == visit || (visit & id(g[x][y])) > 0) return 0;
        int r = 0;
        v[x][y] = visit;
        for (int[] dd : d) {
            int dx = x + dd[0];
            int dy = y + dd[1];
            r = Math.max(r, f(dx, dy, visit | id(g[x][y])));

        }
        return r + 1;
    }

    static int id(char c) {
        return 1 << (c - 'A');
    }
}
