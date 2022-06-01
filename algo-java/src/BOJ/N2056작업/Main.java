package BOJ.N2056작업;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static List<Integer>[] g;
    static int n;
    static int[] degree,t,dist;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        degree = new int[n];
        t = new int[n];
        g = new List[n];
        dist = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            dist[i] = t[i] = Integer.parseInt(stz.nextToken());
            int c = Integer.parseInt(stz.nextToken());
            for (int j = 0; j < c; j++) {
                int v = Integer.parseInt(stz.nextToken()) - 1;
                g[i].add(v);
                degree[v]++;
            }
        }
        System.out.println(time());
    }

    static int time() {
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] == 0) q.add(i);
        }
        while (!q.isEmpty()) {
            int u = q.poll();
            for (Integer v : g[u]) {
                dist[v] = Math.max(dist[v], dist[u] + t[v]);
                if (--degree[v] == 0)  q.add(v);
            }
        }
        return Arrays.stream(dist).max().orElse(0);
    }
}
