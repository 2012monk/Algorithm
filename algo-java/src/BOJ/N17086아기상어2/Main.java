package BOJ.N17086아기상어2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n,m;
    static int[][] dist, grid, d = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}
    };
    static Queue<P> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        grid=new int[n][m];
        dist=new int[n][m];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(stz.nextToken());
                if (grid[i][j] == 1) {
                    q.add(new P(i,j));
                    dist[i][j] = 1;
                }
            }
        }
        solve();
//        print();
    }

    static void print() {
        for (int[] ints : dist) {
            System.out.println(Arrays.toString(ints));
        }
    }

    static void solve(){
        List<P> tmp  =new ArrayList<>();
        int di = 2, res = 0;
        while (!q.isEmpty()) {
            while (!q.isEmpty()) {
                P p = q.poll();
                for (int[] dd : d) {
                    int dx = dd[0] + p.x;
                    int dy = dd[1] + p.y;
                    if (dx < 0 || dx >= n|| dy < 0 || dy >= m) {
                        continue;
                    }
                    if (dist[dx][dy] != 0) continue;
                    dist[dx][dy] = di;
                    res = di - 1;
                    tmp.add(new P(dx,dy));
                }
            }
            di++;
            q.addAll(tmp);
            tmp.clear();
        }
        System.out.println(res);
    }

    static class P {
        int x,y;

        public P(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
