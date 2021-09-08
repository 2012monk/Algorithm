package BOJ.N1600말이되고픈원숭이;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int n, m, k;
    static boolean[][][] b;
    static int[][] dk = {{2, 1},{-2, 1},{1, 2},{-1, 2},{0,1},{1,0}};
    static Queue<Dot> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        init();
        q.offer(new Dot(0,0,0, 0));
        b[0][0][0] = true;
        int inverse = 1;
        while (!q.isEmpty()) {
            Dot cur = q.poll();
//            System.out.println(cur.x+"  "+cur.y);
            if (cur.k > k) continue;
            if (cur.x == n - 1 && cur.y == m - 1) {
                System.out.println(cur.d);
                return;
            }
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 6;j++) {
                    int dx = cur.x+(dk[j][0]*inverse);
                    int dy = cur.y+(dk[j][1]*inverse);
                    int c = j <= 3 ? 1 : 0;
                    if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                    if (b[dx][dy][cur.k+c]) continue;
                    b[dx][dy][cur.k+c] = true;
                    q.offer(new Dot(dx,dy,cur.k+c, cur.d+1));
                }
                inverse = -inverse;
            }
        }
        System.out.println(-1);
    }

    static void init() throws IOException {
        k = Integer.parseInt(br.readLine());
        stz = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stz.nextToken());
        n = Integer.parseInt(stz.nextToken());
        b = new boolean[n][m][32];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                if (stz.nextToken().equals("1")) {
                    Arrays.fill(b[i][j],true);
                }
            }
        }
    }

    static class Dot {
        int x;int y;int k;int d;
        public Dot(int x, int y, int k,int d) {
            this.x = x;this.y = y;this.k = k;this.d=d;
        }
    }

}
