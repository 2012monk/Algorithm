package BOJ.N1948임계경로;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[][] g = new int[10001][10001];
    static int n,m;
    static int[] inDegree = new int[10001], d = new int[10001];
    static int[] revInDegree = new int[10001];
    static int departure, arrival;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            int w = Integer.parseInt(stz.nextToken());
            g[u][v] = w;
            inDegree[v]++;
            revInDegree[u]++;
        }
        stz = new StringTokenizer(br.readLine());
        departure = Integer.parseInt(stz.nextToken());
        arrival = Integer.parseInt(stz.nextToken());
        System.out.println(dist());
        System.out.println(count());
//        dijkstra();
    }
    static int dist() {
        Queue<Integer> q = new LinkedList<>();
        q.add(departure);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (g[cur][i] == 0) continue;
                d[i] = Math.max(d[i], d[cur] + g[cur][i]);
                if (--inDegree[i] != 0) continue;
                q.add(i);
            }
        }
        return d[arrival];
    }

    static int count() {
        Queue<Integer> q = new LinkedList<>();
        q.add(arrival);
        boolean[] v = new boolean[n + 1];
        v[arrival] = true;
        int count = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int i = 1; i <= n; i++) {
                if (g[i][cur] == 0) continue;
                if (v[cur] && d[cur] - d[i] == g[i][cur]) {
                    v[i] = true;
                    count++;
                }
                if (--revInDegree[i] != 0) continue;
                q.add(i);
            }
        }
        return count;
    }

    // TLE
    static void dijkstra() {
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(v -> v[1]));
        L[] visit = new L[n + 1];
        for (int i = 0; i < n + 1; i++) {
            visit[i] = new L();
        }
        q.add(new int[]{departure, 0});
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (visit[cur[0]].dist < cur[1]) continue;
            for (int i = 1; i <= n; i++) {
                int nextDist = g[cur[0]][i];
                if (nextDist == 0) continue;
                int w = -nextDist + cur[1];
                if (visit[i].dist == w) {
                    visit[i].last.add(cur[0]);
                }
                if (visit[i].dist > w) {
                    visit[i].last.clear();
                    visit[i].last.add(cur[0]);
                    visit[i].dist = w;
                    q.add(new int[]{i, w});
                }
            }
        }
        System.out.println(-visit[arrival].dist);
        System.out.println(countPath(visit, departure, arrival));
    }

    static int countPath(L[] visit, int s, int e) {
        Queue<Integer> q = new LinkedList<>();
        q.add(e);
        int ret = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (cur == s) return ret;
            ret += visit[cur].last.size();
            q.addAll(visit[cur].last);
        }
        return ret;
    }

    static class L {
        List<Integer> last = new ArrayList<>();
        int dist = 0;
    }
}
