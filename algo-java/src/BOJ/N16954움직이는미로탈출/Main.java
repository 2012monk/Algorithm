package BOJ.N16954움직이는미로탈출;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

    static boolean[][][] wall = new boolean[64][8][8];
    static int[][] d = {{0,1},{0,-1},{1,0},{-1,0},{1, 1}, {1, -1}, {-1, 1}, {-1, -1}};
    static int n = 8;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i < 8; i++) {
            char[] a = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                wall[0][i][j] = a[j] == '#';
            }
        }
        for (int t = 1; t < 8; t++) {
            for (int i = t; i < 8; i++) {
                System.arraycopy(wall[t - 1][i - 1], 0, wall[t][i], 0, 8);
            }
        }
        System.out.println(bfs());
    }

    static int bfs() {
        Queue<P> q = new LinkedList<>();
        q.add(new P(0, 7, 0));
        boolean[][][] v = new boolean[n*n][n][n];
        v[0][7][0] = true;
        while (!q.isEmpty()) {
            P p = q.poll();
            if (p.x == 0 && p.y == 7) return 1;
            if (wall[p.t][p.x][p.y]) continue;
            q.add(new P(p.t + 1, p.x, p.y));
            v[p.t + 1][p.x][p.y] = true;
            for (int[] dd : d) {
                int dx = p.x + dd[0];
                int dy = p.y + dd[1];
                if (dx <0 || dx >= n || dy < 0 || dy >= n) continue;
                if (wall[p.t][dx][dy] || v[p.t][dx][dy]) continue;
                v[p.t][dx][dy] = true;
                q.add(new P(p.t + 1, dx, dy));
            }
        }
        return 0;
    }

    static class P {
        int t,x,y;

        public P(int t, int x, int y) {
            this.t = t;
            this.x = x;
            this.y = y;
        }
    }
}
