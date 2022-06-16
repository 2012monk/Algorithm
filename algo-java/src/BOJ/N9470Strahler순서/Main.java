package BOJ.N9470Strahler순서;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] g;
    static int tc,n,m;
    static int[] inDegree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            stz = new StringTokenizer(br.readLine());
            tc = Integer.parseInt(stz.nextToken());
            n = Integer.parseInt(stz.nextToken());
            m = Integer.parseInt(stz.nextToken());
            inDegree = new int[n + 1];
            g = new List[n + 1];
            for (int i = 0; i <= n; i++) g[i]= new ArrayList<>();
            for (int i = 0; i < m; i++) {
                stz = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(stz.nextToken());
                int v = Integer.parseInt(stz.nextToken());
                g[u].add(v);
                inDegree[v]++;
            }
            sb.append(tc).append(' ').append(solve()).append('\n');
        }
        System.out.println(sb);
    }

    static int solve() {
        Queue<Integer> q = new LinkedList<>();
        int[][] order = new int[n + 1][2];
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
                order[i] = new int[]{1, 1};
            }
        }

        while (!q.isEmpty()) {
            int x = q.poll();
            for (Integer c : g[x]) {
                if (order[c][0] == 0 || order[c][0] < order[x][0]) order[c] = new int[]{order[x][0], 1};
                else if (order[c][0] == order[x][0]) order[c][1]++;
                if (--inDegree[c] == 0) {
                    if (order[c][1] > 1) {
                        order[c] = new int[]{order[c][0] + 1, 1};
                    }
                    q.add(c);
                }
            }
        }
        return order[n][0];
    }
}
