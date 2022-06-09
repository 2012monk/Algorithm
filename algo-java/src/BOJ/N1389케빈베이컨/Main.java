package BOJ.N1389케빈베이컨;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static boolean[][] g = new boolean[101][101];
    static int n,m;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            g[u][v] = g[v][u] = true;
        }
        int min = 100 * 100;
        int p = 0;
        for (int i = 1; i <= n; i++) {
            int r = bfs(i);
            if (r < min) {
                min = r;
                p = i;
            }
        }
        System.out.println(p);
    }

    static int bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        int[] dist = new int[n + 1];
        int d = 1, size;
        q.add(start);
        while (!q.isEmpty()) {
            size = q.size();
            while (size-- > 0) {
                int cur = q.poll();
                for (int i = 1; i <= n; i++) {
                    if (!g[cur][i] || dist[i] != 0) continue;
                    dist[i] = d;
                    q.add(i);
                }
            }
            d++;
        }
        return Arrays.stream(dist).sum();
    }
}
