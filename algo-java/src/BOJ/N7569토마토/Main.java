package BOJ.N7569토마토;

import static java.lang.System.in;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(in));
    static StringTokenizer stz;
    static Queue<int[]> q = new ArrayDeque<>();

    static int[][][] box = new int[102][102][102];
    static int[][][] v = new int[102][102][102];
    static int[][] dt = {
        {0, 0,1},
        {0, 0,-1},
        {0,1,0},
        {0,-1,0},
        {1,0,0},
        {-1,0,0}
    };
    static int n,m,h,cnt;

    public static void main(String[] args) throws IOException {
        init();
        int mx = 0;
        while (!q.isEmpty()) {
            int[] c = q.poll();
            for (int[] dir: dt) {
                int h = c[0] + dir[0];
                int x = c[1] + dir[1];
                int y = c[2] + dir[2];
                if (v[h][x][y] != -1) continue;

                v[h][x][y] = v[c[0]][c[1]][c[2]] + 1;
                mx = Math.max(mx, v[h][x][y]);
                q.offer(new int[]{h,x,y});
                cnt--;
            }
        }

        mx = cnt > 0 ? -1 : mx;
        System.out.println(mx);
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stz.nextToken());
        n = Integer.parseInt(stz.nextToken());
        h = Integer.parseInt(stz.nextToken());

        for (int k = 1; k <= h; k++) {
            for (int i = 1; i <= n; i++) {
                stz = new StringTokenizer(br.readLine());
                for (int j = 1; j <= m; j++) {
                    box[k][i][j] = Integer.parseInt(stz.nextToken());
                    if (box[k][i][j] == 0) {
                        v[k][i][j] = -1;
                        cnt++;
                    }
                    if (box[k][i][j] == 1) q.offer(new int[]{k,i,j});
                }
            }
        }
    }
}
