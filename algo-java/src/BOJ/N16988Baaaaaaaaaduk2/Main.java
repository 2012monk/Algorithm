package BOJ.N16988Baaaaaaaaaduk2;

import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] visited = new boolean[21][21];
    static int[][] dp = new int[21][21];
    static int[][] grid = new int[21][21];
    static int[] nx = {1,-1,0,0}, ny = {0,0,1,-1};
    static int n,m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        System.out.println(comb(0,0));
    }

    static int comb(int p, int count) {
        int x = p / m, y = p % m;
        if (x >= n || count == 2) {
            return count();
        }
        if (grid[x][y] != 0) {
            return comb(p + 1, count);
        }
        grid[x][y] = 1;
        int ret = comb(p + 1, count + 1);
        grid[x][y] = 0;
        return max(ret , comb(p + 1, count));
    }

    static int count() {
        boolean[][] v = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] != 2 || v[i][j])  continue;
                count += bfs(i,j,v);
            }
        }
        return count;
    }

    static int bfs(int i, int j, boolean[][] v) {
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{i,j});
        v[i][j] = true;
        int count=1;
        boolean f = false;
        while (!q.isEmpty()) {
            int x = q.peek()[0], y = q.poll()[1];
            for (int k = 0; k < 4; k++) {
                int dx = nx[k] + x;
                int dy = ny[k] + y;
                if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
                if (v[dx][dy]) continue;
                f |= grid[dx][dy] == 0;
                if (grid[dx][dy] != 2) continue;
                v[dx][dy] = true;
                count++;
                q.offer(new int[]{dx,dy});
            }
        }
        if (f) return 0;
        return count;
    }

    static int dfs(int x, int y, List<int[]> e) {
        int count = 1;
        for (int k = 0; k < 4; k++) {
            int dx = nx[k] + x;
            int dy = ny[k] + y;
            if (dx < 0 || dx >= n || dy < 0 || dy >= m) continue;
            if (visited[dx][dy]) continue;
            if (grid[dx][dy] == 0) {
                visited[dx][dy] = true;
                e.add(new int[]{dx,dy});
            }
            if (grid[dx][dy] != 2) continue;
            visited[dx][dy] = true;
            count += dfs(dx,dy, e);
        }
        return count;
    }


    static void solve() {
        List<int[]> e = new ArrayList<>();
        List<int[]> c = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] || grid[i][j] != 2) continue;
                int count = dfs(i, j, e);
                if (e.size() > 2) {
                    e.clear();
                    continue;
                }
            }
        }
    }

    static void check(List<int[]> e, List<int[]> c, int count) {
        e.forEach(k -> visited[k[0]][k[1]] = false);
        if (e.size() > 2) {
            e.clear();
            return;
        }
        if (e.size() == 1) {
            
        }
    }
}
