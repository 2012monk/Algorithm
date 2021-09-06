package BOJ.N7562나이트이동;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int[][] dt = {{2, 1},{-2, 1},{1, 2},{-1, 2}};
    static int[][] v;
    static int[] res;
    static int n, tx, ty, t, sx, sy;
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) throws IOException {
        t = Integer.parseInt(br.readLine());
        res = new int[t];
        while (t-- > 0) {
            init();
            res[t] = bfs(sx, sy);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = res.length - 1; i >= 0; i--) {
            sb.append(res[i]).append("\n");
        }
        System.out.println(sb);
    }

    static int bfs(int sx, int sy) {
        q.offer(new int[]{sx, sy});

        v[sx][sy] = 1;
        int inverse = 1;
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            if (x == tx && y == ty) {
                q.clear();
                return v[x][y] - 1;
            }
            for (int i = 0; i < 2; i++) {
                for (int[] d : dt) {
                    int dx = (d[0] * inverse) + x;
                    int dy = (d[1] * inverse) + y;
                    if (dx < 0 || dx >= n || dy < 0 || dy >= n) {
                        continue;
                    }
                    if (v[dx][dy] != 0) {
                        continue;
                    }
                    q.offer(new int[]{dx, dy});
                    v[dx][dy] = v[x][y] + 1;
                }
                inverse = -inverse;
            }
        }
        return 0;
    }

    static void init() throws IOException {
        n = Integer.parseInt(br.readLine());

        stz = new StringTokenizer(br.readLine());
        sx = Integer.parseInt(stz.nextToken());
        sy = Integer.parseInt(stz.nextToken());

        stz = new StringTokenizer(br.readLine());
        tx = Integer.parseInt(stz.nextToken());
        ty = Integer.parseInt(stz.nextToken());
        v = new int[n][n];
    }

}
