package BOJ.N2146다리만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] board,dist;
    static int n;
    static Queue<Dot> Q = new ArrayDeque<>();
    static int[] nx = {0,0,1,-1};
    static int[] ny = {1,-1,0,0};

    public static void main(String[] args) throws IOException {
        init();
        int l = 2;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 1) continue;
                board[i][j] = l;
                search(i,j,l);
                l++;
            }
        }
        int res = Integer.MAX_VALUE;
        while (!Q.isEmpty()) {
            Dot cur = Q.poll();
            for (int i = 0; i < 4; i++) {
                int dx = nx[i] + cur.x;
                int dy = ny[i] + cur.y;
                if (dx < 0 || dx >= n || dy < 0 || dy >= n) continue;
                if (board[dx][dy] == cur.l) continue;
                if (board[dx][dy] > 0 && board[dx][dy] != cur.l){
                    res = Math.min(dist[cur.x][cur.y]+dist[dx][dy], res);
                    continue;
                }
                if (board[dx][dy] == 0){
                    board[dx][dy] = cur.l;
                    dist[dx][dy] = dist[cur.x][cur.y]+1;
                    Q.offer(new Dot(dx,dy,cur.l));
                }
            }
        }
        System.out.println(res);
    }

    static void search(int x, int y, int land){
        for (int i = 0; i < 4; i++) {
            int dx = nx[i] + x;
            int dy = ny[i] + y;
            if (dx < 0 || dx >= n || dy < 0 || dy >= n) continue;
            if (board[dx][dy] == land) continue;
            if (board[dx][dy] == 0) {
                Q.offer(new Dot(x, y,land));
                continue;
            }
            board[dx][dy] = land;
            search(dx, dy, land);
        }
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        dist = new int[n][n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
    }
    static class Dot{
        int x;int y;int l;
        public Dot(int x, int y,int l) {
            this.x = x;this.y = y;this.l=l;
        }
    }
}
