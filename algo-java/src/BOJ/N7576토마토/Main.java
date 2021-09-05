package BOJ.N7576토마토;

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

    static int[][] b = new int[1002][1002];
    static int n,m,result,cnt;
    static int[][] dt = {{0,1},{0,-1},{1,0},{-1,0}};

    public static void main(String[] args) throws IOException {
        init();
        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j] == -1) continue;
                if (b[i][j] == 1) q.offer(new int[]{i,j});
                else cnt++;
            }
        }

        while (!q.isEmpty()) {
            int s = q.size();
            while (s-- > 0) {
                int[] d = q.poll();
                for (int[] t:dt) {
                    int x = d[0] + t[0], y = d[1] + t[1];

                    if (x<0||x>=n||y<0||y>=m) continue;
                    if (b[x][y] != 0) continue;
                    b[x][y] = 1;
                    q.offer(new int[]{x,y});
                    cnt--;
                }
            }
            result++;
        }

        if (cnt > 0) {
            System.out.println(-1);
        }
        else{
            System.out.println(result-1);
        }
    }


    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stz.nextToken());
        n = Integer.parseInt(stz.nextToken());

        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                b[i][j] = Integer.parseInt(stz.nextToken());
            }
        }

    }
}
