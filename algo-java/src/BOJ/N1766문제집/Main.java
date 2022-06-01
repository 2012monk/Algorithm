package BOJ.N1766문제집;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    static int n,k;
    static List<Integer>[] g;
    static StringBuilder sb = new StringBuilder();
    static int[] degree;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz = new StringTokenizer(br.readLine());
        n = Integer.parseInt(stz.nextToken());
        k = Integer.parseInt(stz.nextToken());
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        degree = new int[n];
        for (int i = 0; i < k; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken()) - 1;
            int v = Integer.parseInt(stz.nextToken()) - 1;
            g[u].add(v);
            degree[v]++;
        }
        topologySort();
        System.out.println(sb);
    }

    static void topologySort() {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < g.length; i++) {
            if (degree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            sb.append(u+1).append(' ');
            for (Integer v : g[u]) {
                if (--degree[v] == 0) {
                    q.add(v);
                }
            }
        }
    }
}
