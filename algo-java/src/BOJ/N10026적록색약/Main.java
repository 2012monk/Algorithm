package BOJ.N10026적록색약;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[][] b;
    static int[][] dt = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static int n;


    public static void main(String[] args) throws IOException {
        init();
        int blue = 0;
        int separated = 0;
        int integrated = 0;
        for (int d = 1; d <= 2; d++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (b[i][j] != d) continue;
                    separated++;
                    b[i][j] = 0;
                    dfs(i,j,d);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int c = b[i][j];
                if (c != 0 && c != 3) continue;
                b[i][j] = -1;
                if (c == 3) blue++;
                else integrated++;
                dfs(i, j, c);
            }
        }
        System.out.printf("%d %d", separated+blue,integrated+blue);
    }

    static int dfs(int x, int y, int color) {
        int r = 1;
        for (int[] d : dt) {
            int dx = d[0] + x;
            int dy = d[1] + y;
            if (dx < 0 || dx >= n || dy < 0 || dy >= n) continue;
            if (b[dx][dy] != color) continue;
            if (color == 2 || color == 1) {
                b[dx][dy] = 0;
            }else{
                b[dx][dy] = -1;
            }
            r += dfs(dx, dy, color);
        }
        return r;
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        b = new int[n][n];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if (c == 'R') b[i][j] = 1;
                if (c == 'G') b[i][j] = 2;
                if (c == 'B') b[i][j] = 3;
            }
        }
    }


}
