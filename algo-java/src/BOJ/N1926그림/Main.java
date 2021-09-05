package BOJ.N1926그림;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static Queue<int[]> q = new ArrayDeque<>();
    static boolean[][] B = new boolean[501][501], V = new boolean[501][501];
    static int[][] dt = {
        {0, 1},
        {0, -1},
        {1, 0},
        {-1, 0}
    };
    static int n, m;

    public static void main(String[] args) throws IOException {
        init();
        bfsSolution();
    }

    static void bfsSolution() {
        int mx = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (V[i][j] || !B[i][j]) {
                    continue;
                }
                cnt++;
                mx = Math.max(mx, bfs(i, j));
            }
        }
        System.out.println(cnt);
        System.out.println(mx);
    }

    static int bfs(int x, int y) {
        q.offer(new int[]{x, y});
        int cnt = 0;
        V[x][y] = true;
        while (!q.isEmpty()) {
            int[] c = q.poll();
            cnt++;
            for (int[] t : dt) {
                int dx = c[0] + t[0];
                int dy = c[1] + t[1];
                if (dx < 0 || dx >= n || dy < 0 || dy >= m) {
                    continue;
                }
                if (V[dx][dy] || !B[dx][dy]) {
                    continue;
                }
                V[dx][dy] = true;
                q.offer(new int[]{dx, dy});
            }

        }
        return cnt;
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());

        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (Integer.parseInt(stz.nextToken()) == 1) {
                    B[i][j] = true;
                }
            }
        }
    }

}
