package BOJ.N2583영역구하기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    static int n,m,k,x1,y1,x2,y2,result;
    static boolean[][] b;
    static int[][] dt = {{0,1},{0,-1},{1,0},{-1,0}};
    static ArrayList<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        init();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j]) continue;
                b[i][j] = true;
                res.add(dfs(i,j));
                result++;

            }
        }

        System.out.println(result);
        Collections.sort(res);
        for (Integer re : res) {
            System.out.printf("%d ", re);
        }
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        m = Integer.parseInt(stz.nextToken());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        b = new boolean[n][m];
        while (k-- > 0) {
            stz = new StringTokenizer(br.readLine());
            x1 = Integer.parseInt(stz.nextToken());
            y1 = Integer.parseInt(stz.nextToken());
            x2 = Integer.parseInt(stz.nextToken());
            y2 = Integer.parseInt(stz.nextToken());

            for (int i=x1; i < x2; i++) {
                for (int j = y1; j < y2; j++) {
                    b[i][j] = true;
                }
            }
        }
    }

    static int dfs(int x, int y){
        int r=1;
        for (int[] d : dt) {
            int dx = d[0] + x;
            int dy = d[1] + y;
            if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
            if (b[dx][dy]) continue;
            b[dx][dy] = true;
            r += dfs(dx, dy);
        }
        return r;
    }
}
