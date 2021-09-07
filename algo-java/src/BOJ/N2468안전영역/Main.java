package BOJ.N2468안전영역;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] h;
    static boolean[][] v;
    static int n,top;
    static int[][] dt = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    static void solve() {
        int m = 1;
        for (int w = 1; w <= top; w++) {
            clear(w);
            int r = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (!v[i][j]) continue;
                    v[i][j] = false;
                    dfs(i,j,w);
                    r++;
                }
            }
            m = Math.max(r, m);
        }
        System.out.println(m);
    }

    static void dfs(int x, int y, int w) {
        for (int[] d : dt) {
            int dx = x+d[0];
            int dy = y+d[1];
            if (dx < 0 || dx >= n || dy < 0 || dy >= n) continue;
            if (!v[dx][dy]) continue;
            v[dx][dy] = false;
            dfs(dx, dy, w);
        }
    }

    static void clear(int w){
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                v[i][j] =  w < h[i][j];
            }
        }
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        h =new int[n][n];
        v=new boolean[n][n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                h[i][j] = Integer.parseInt(stz.nextToken());
                top = Math.max(top, h[i][j]);
            }
        }
    }

}
