package BOJ.N2213트리의독립집합;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int N;
    static List<Integer>[] tree;
    static List<Integer> path = new ArrayList<>();
    static int[] weight;
    static int[][] d;
    static boolean[] v;

    static int dfs(int node, int able) {
        if (d[node][able] != -1) return d[node][able];
        d[node][able] = 0;
        if (able == 1) {
            int r1 = 0;
            int r2 = weight[node];
            for (Integer child : tree[node]) {
                r1 += dfs(child, 1);
                r2 += dfs(child, 0);
            }
            d[node][able] = Math.max(r1, r2);
        }
        else {
            for (Integer child : tree[node]) {
                d[node][able] += dfs(child, 1);
            }
        }
        return d[node][able];
    }

    static void recover(int root, int parent) {
        if (d[root][1] > d[root][0] && !v[parent]) {
            v[root] = true;
            path.add(root);
        }
        for (Integer child : tree[root]) {
            recover(child, root);
        }
    }

    static void make(int root, int parent, List<Integer>[] graph) {
        if (parent != -1) tree[parent].add(root);
        for (Integer child : graph[root]) if (child != parent) make(child, root, graph);
    }

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        weight = new int[N+1];
        d = new int[N+1][2];
        v = new boolean[N+1];
        for (int[] dd : d) Arrays.fill(dd, -1);

        tree = new ArrayList[N+1];
        List<Integer>[] tmp = new ArrayList[N+1];

        stz = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            weight[i] = Integer.parseInt(stz.nextToken());
            tree[i] = new ArrayList<>();
            tmp[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            tmp[u].add(v);
            tmp[v].add(u);
        }
        make(1, -1, tmp);
        StringBuilder sb = new StringBuilder();
        sb.append(Math.max(dfs(1, 0), dfs(1, 1))).append("\n");

        recover(1, 0);
        Collections.sort(path);
        for (Integer i : path) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }


}
