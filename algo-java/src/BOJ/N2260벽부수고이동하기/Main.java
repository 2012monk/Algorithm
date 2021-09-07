package BOJ.N2260벽부수고이동하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] v,b;
    static int[][][] vi;
    static Queue<Pos> q = new ArrayDeque<>();
    static int[][] dt = {{0,1},{0,-1},{1,0},{-1,0}};
    static int n,m;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(bfs());
    }

    static int bfs() {
        if (n == 1 && m == 1) return 1;
        q.offer(new Pos(0,0,0, 1));
        while (!q.isEmpty()) {
            Pos p = q.poll();
            for (int[] d : dt) {
                int x = p.x + d[0];
                int y = p.y + d[1];
                if (x == n-1 && y == m - 1) return p.d + 1;
                if (x < 0 || x >= n || y < 0 || y >= m ||
                    (p.t & b[x][y]) == 1 ||
                    (vi[x][y][p.t] != 0)) continue;

                vi[x][y][p.t |b[x][y]] = 1;
                q.offer(new Pos(x,y,p.t |b[x][y],p.d+1));
            }
        }
        return -1;
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        b = new int[n][m];
        v = new int[n][m];
        vi = new int[n][m][2];
        for (int i = 0; i < n; i++) {
            String s = br.readLine();
            for (int j = 0; j < m; j++) {
                if (s.charAt(j) == '1') b[i][j] = 1;
            }
        }
    }
    static class Pos {
        int x;int y;int t;int d;
        Pos(int xx,int yy,int tt,int dd) {
            x=xx;y=yy;t =tt;d=dd;
        }
    }
}
