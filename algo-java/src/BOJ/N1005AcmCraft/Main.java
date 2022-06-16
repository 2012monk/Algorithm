package BOJ.N1005AcmCraft;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int n,m,w;
    static int[] inDegree, times;
    static List<Integer>[] g;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;
    public static void main(String[] args) throws Exception {
        int t = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            handleInput();
            sb.append(solve()).append('\n');
        }
        System.out.println(sb);
    }

    static int solve() {
        Queue<Integer> q = new LinkedList<>();
        int[] cost = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            if (inDegree[i] == 0)  q.add(i);
        }

        while (!q.isEmpty() && inDegree[w] > 0) {
            int x = q.poll();
            for (Integer c : g[x]) {
                cost[c] = Math.max(cost[c], cost[x] + times[x]);
                if (--inDegree[c] == 0) {
                    q.add(c);
                }
            }
        }
        return cost[w] + times[w];
    }

    static void handleInput() throws Exception{
        stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        m = Integer.parseInt(stz.nextToken());
        times = new int[n + 1];
        inDegree = new int[n + 1];
        g = new List[n + 1];
        stz = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            g[i] = new ArrayList<>();
            times[i] = Integer.parseInt(stz.nextToken());
        }
        for (int i = 0; i < m; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            g[u].add(v);
            inDegree[v]++;
        }
        w = Integer.parseInt(br.readLine());
    }
}
