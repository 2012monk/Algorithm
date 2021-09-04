package BOJ.N1915가장큰정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] dp;
    static boolean[][] board;
    static int n,m, r;

    public static void main(String[] args) throws IOException {
        init();
        for (int i=0;i<n;i++) {
            for (int j=0;j<m;j++) {
                r = Math.max(dfs(i,j), r);
            }
        }
        System.out.println(r*r);
    }

    static int dfs(int x, int y) {
        if (x >= n || y >= m) return 0;

        if (!board[x][y]) return 0;
        if (dp[x][y] != -1) return dp[x][y];

        int r = Math.min(dfs(x+1,y),dfs(x, y+1));
        r = Math.min(r, dfs(x+1,y+1));
        return dp[x][y] = r+1;
    }

    static void init() throws IOException {
        stz=new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        dp = new int[n+1][m+1];
        board = new boolean[n][m];
        for (int i=0;i<n;i++) {
            char[] c = br.readLine().toCharArray();
            for (int j = 0; j < c.length; j++) {
                dp[i][j] = -1;
                if (c[j] == '1') board[i][j] = true;
            }
        }
    }
}
