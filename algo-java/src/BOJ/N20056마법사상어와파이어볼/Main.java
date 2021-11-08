package BOJ.N20056마법사상어와파이어볼;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static Fire[][] grid;
    static Queue<Fire> q = new ArrayDeque<>();
    static int[] dx = {-1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};
    static int N, M, K;

    static void split(int x, int y) {
        Fire f = grid[x][y];
        grid[x][y] = null;
        if (f.nested == 1) {
            q.offer(f);
            return;
        }
        if (f.m / 5 == 0)
            return;
        for (int i = 0; i < 4; i++) {
            q.offer(new Fire(x, y, f.m / 5, f.s / f.nested, (i * 2) + f.nd));
        }
    }

    static void move(Fire f) {
        Fire nf;
        f.x = ( f.x + dx[f.d] * f.s ) % N;
        f.y = ( f.y + dy[f.d] * f.s ) % N;
        if (f.x < 0)
            f.x += N;
        if (f.y < 0)
            f.y += N;
        nf = grid[f.x][f.y];
        if (nf == null)
            grid[f.x][f.y] = f;
        else {
            nf.m += f.m;
            nf.s += f.s;
            if (nf.nd == 0 && (nf.d % 2 != f.d % 2))
                nf.nd = 1;
            nf.d = f.d;
            nf.nested++;
        }
    }

    static void move() {
        while (!q.isEmpty())
            move(q.poll());

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (grid[i][j] == null)
                    continue;
                split(i, j);
            }
        }
    }

    static int solve() {
        int ret = 0;

        for (int i = 0; i < K; i++) {
            move();
        }
        while (!q.isEmpty())
            ret += q.poll().m;
        return ret;
    }

    public static void main(String[] args) throws IOException {
        stz = new StringTokenizer(br.readLine());
        N = Integer.parseInt(stz.nextToken());
        M = Integer.parseInt(stz.nextToken());
        K = Integer.parseInt(stz.nextToken());
        grid = new Fire[N][N];

        for (int i = 0; i < M; i++) {
            stz = new StringTokenizer(br.readLine());
            Fire f = new Fire(
                Integer.parseInt(stz.nextToken()) - 1,
                Integer.parseInt(stz.nextToken()) - 1,
                Integer.parseInt(stz.nextToken()),
                Integer.parseInt(stz.nextToken()),
                Integer.parseInt(stz.nextToken())
            );
            q.offer(f);
        }
        System.out.println(solve());
    }

    static class Fire {
        int x; int y; int d; int m; int s; int nested = 1; int nd = 0;

        public Fire(int x, int y, int m, int s, int d) {
            this.x = x; this.y = y; this.d = d; this.m = m; this.s = s;
        }
    }
}
