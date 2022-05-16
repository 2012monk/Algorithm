package BOJ.N16932모양만들기;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

    static int[][] grid, visit, d = {
        {0, 1}, {0, -1}, {1, 0}, {-1, 0}
    };
    static int[] size = new int[100000];
    static Set<Integer> used = new HashSet<>();
    static int n,m,ans;
    static List<int[]> z = new ArrayList<>(),o = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        grid = new int[n][m];
        visit = new int[n][m];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.parseInt(stz.nextToken());
                if (grid[i][j] == 0) {
                    z.add(new int[]{i,j});
                } else {
                    o.add(new int[]{i,j});
                }
            }
        }
        fill();
        count();
        System.out.println(ans);
    }

    static void fill() {
        int idx = 0;
        for (int[] c : o) {
            int i = c[0];
            int j = c[1];
            if (visit[i][j] != 0) continue;
            groupSize(i, j, ++idx);
        }
    }

    static void groupSize(int x, int y, int idx) {
        Queue<int[]> q = new LinkedList<>();
        int dx,dy,cnt = 1;
        q.add(new int[]{x,y});
        visit[x][y] = idx;
        while (!q.isEmpty()) {
            x = q.peek()[0];
            y = q.poll()[1];
            for (int[] dd : d) {
                dx = dd[0] + x;
                dy = dd[1] + y;
                if (dx < 0 || dx >= n|| dy < 0 || dy >= m)  continue;
                if (grid[dx][dy] == 0 || visit[dx][dy] != 0)  continue;
                q.add(new int[]{dx,dy});
                cnt++;
                visit[dx][dy] = idx;
            }
        }
        size[idx] = cnt;
    }

    static void count() {
        for (int[] c : z) {
            count(c[0], c[1]);
        }
    }

    static void count(int i, int j) {
        int cnt = 1;
        used.clear();
        for (int[] dd : d) {
            int dx = dd[0] + i;
            int dy = dd[1] + j;
            if (dx < 0 || dx >= n || dy < 0 || dy >= m)  continue;
            if (visit[dx][dy] == 0 || used.contains(visit[dx][dy]))  continue;
            used.add(visit[dx][dy]);
            cnt += size[visit[dx][dy]];
        }
        ans = Math.max(ans, cnt);
    }
}
