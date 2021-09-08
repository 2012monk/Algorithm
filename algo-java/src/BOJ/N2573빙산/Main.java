package BOJ.N2573빙산;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] b, dt = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] v,melt;
    static int n,m;

    public static void main(String[] args) throws IOException {
        init();
        int piece;
        int res = 0;
        while (true) {
            piece = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (v[i][j]) continue;
                    v[i][j] = true;
                    dfs(i,j);
                    piece++;
                }
            }
            if (piece == 0) {
                res = 0;
                break;
            }
            if (piece > 1) break;
            clear();
            res++;
        }
        System.out.println(res);
    }
    static void clear() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                melt[i][j] = v[i][j] = b[i][j] == 0;
            }
        }
    }

    static void dfs(int x, int y) {
        for (int[] d : dt) {
            int dx = x+d[0];
            int dy = y+d[1];
            if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
            if (melt[dx][dy] && b[x][y] > 0) b[x][y]--;
            if (v[dx][dy]) continue;
            v[dx][dy] = true;
            dfs(dx, dy);
        }
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        v=new boolean[n][m];
        b=new int[n][m];
        melt = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                b[i][j] = Integer.parseInt(stz.nextToken());
                melt[i][j] = v[i][j] = b[i][j] == 0;
            }
        }
    }

}
