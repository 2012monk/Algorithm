package BOJ.N5427불;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static Queue<Dot> Q = new ArrayDeque<>();
    static int n, m, t;
    static char[][] board;
    static int[][] dt = {{0,1},{0,-1},{1,0},{-1,0}};
    static Dot cur;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            init();
            sb.append(bfs()).append("\n");
        }
        System.out.println(sb);
    }

    static String bfs() {
        while (!Q.isEmpty()) {
            cur = Q.poll();
            char c = board[cur.x][cur.y];
            for (int[] d : dt) {
                int dx = cur.x + d[0];
                int dy = cur.y + d[1];

                if (dx < 0 || dx >= n || dy < 0 || dy >= m) {
                    if (c == '@') return String.valueOf(cur.d);
                    continue;
                }
                if (board[dx][dy] != '.') continue;
                board[dx][dy] = c;
                Q.offer(new Dot(dx,dy, cur.d+1));
            }
        }
        return "IMPOSSIBLE";
    }

    static void init() throws IOException {
        Q.clear();
        stz = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stz.nextToken());
        n = Integer.parseInt(stz.nextToken());
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '@') cur = new Dot(i,j,1);
                else if (board[i][j] == '*') Q.offer(new Dot(i,j,0));
            }
        }
        Q.offer(cur);
    }

    static class Dot{
        int x;int y;int d;
        public Dot(int x, int y, int d) {
            this.x = x;this.y = y;this.d = d;
        }
    }
}
