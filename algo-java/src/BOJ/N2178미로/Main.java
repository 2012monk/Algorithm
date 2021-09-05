package BOJ.N2178미로;

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

    static boolean[][] b = new boolean[102][102], V = new boolean[102][102];
    static int[][] dt = {{0,1},{0,-1},{1,0},{-1,0}};
    static int n, m;

    public static void main(String[] args) throws IOException {
        init();
        System.out.println(solve());
    }

    public static int solve() {
        q.offer(new int[]{1,1});
        b[1][1] = false;
        int result = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0){
                int[] t = q.poll();
                for (int[] d: dt) {
                    int x = d[0] + t[0], y = d[1] + t[1];
                    if (!b[x][y]) continue;
                    if (x == n && y == m) return result+1;
                    q.offer(new int[]{x,y});
                    b[x][y] = false;
                }
            }
            result++;
        }
        return result;
    }

    static void init() throws IOException {
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());

        for (int i = 1; i <= n; i++) {
            char[] s = br.readLine().toCharArray();
            for (int j = 1; j <= m; j++) {
                if (s[j-1] == '1') b[i][j] = true;
            }

        }
    }

}
