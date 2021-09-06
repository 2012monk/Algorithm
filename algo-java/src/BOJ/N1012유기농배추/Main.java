package BOJ.N1012유기농배추;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static Queue<int[]> q = new ArrayDeque<>();
    static int[][] dt = {{0,1},{0,-1},{1,0},{-1,0}};
    static boolean[][] b;
    static int n,m,k,t;

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        while (t-- > 0){
            init();
            int result = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!b[i][j]) continue;
//                    dfs(i,j);
                    bfs(i,j);
                    result++;
                }
            }
            System.out.println(result);
        }

    }

    static void bfs(int x, int y) {
        q.offer(new int[]{x,y});
        while (!q.isEmpty()) {
            int[] t = q.poll();
            for (int[] d: dt) {
                int dx = t[0] + d[0];
                int dy = t[1] + d[1];
                if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                if (!b[dx][dy]) continue;
                b[dx][dy] = false;
                q.offer(new int[]{dx,dy});
            }
        }
    }

    static void dfs(int x, int y){
        for (int[] d : dt) {
            int dx = d[0] + x;
            int dy = d[1] + y;
            if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
            if (!b[dx][dy]) continue;
            b[dx][dy] = false;
            dfs(dx, dy);
        }
    }

    static void init() throws IOException {
        b = new boolean[51][51];
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        for (int i = 0; i < k; i++) {
            stz = new StringTokenizer(br.readLine());
            b[Integer.parseInt(stz.nextToken())][Integer.parseInt(stz.nextToken())] = true;
        }
    }

}
