package BOJ.n1937욕심쟁이판다;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int[][] board, visited;
    static int[] dx = {0,0,1,-1}, dy={1,-1,0,0};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        visited = new int[n][n];
        Arrays.stream(visited).forEach(i -> Arrays.fill(i, -1));

        StringTokenizer st;
        for (int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0;j<n;j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int r = 0;
        for (int i=0;i<n;i++) {
            for (int j=0;j<n;j++) {
                r = Math.max(dfs(i,j), r);
            }
        }
        System.out.println(r);

    }

    public static int dfs(int i, int j) {
        if (visited[i][j] != -1) return visited[i][j];

        int r = 0;
        for (int t=0;t<4;t++) {
            int x = dx[t] + i;
            int y = dy[t] + j;
            if (x >= 0 && x < n && y >= 0 && y < n && board[i][j] < board[x][y]) {
                r = Math.max(r, dfs(x, y));
            }
        }
        return visited[i][j] = r + 1;
    }

}
