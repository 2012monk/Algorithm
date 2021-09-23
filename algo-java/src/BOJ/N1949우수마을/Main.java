package BOJ.N1949우수마을;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer stz;

    static int n;
    static int[] values;
    static boolean[] visited;
    static int[][] dp;
    static List<List<Integer>> tree = new ArrayList<>();

    static void find(int node) {
        for (Integer child : tree.get(node)) {
            if (visited[child]) continue;
            visited[child] = true;
            find(child);
            dp[0][node] += dp[1][child];
            dp[1][node] += Math.max(dp[0][child], dp[1][child]);
        }
        dp[0][node] += values[node];
    }

    public static void main(String[] args) throws IOException {
        n = Integer.parseInt(br.readLine());
        values = new int[n + 1];
        dp = new int[2][n + 1];
        visited = new boolean[n + 1];
        stz = new StringTokenizer(br.readLine());
        tree.add(new ArrayList<>());
        for (int i = 1; i < n + 1; i++) {
            values[i] = Integer.parseInt(stz.nextToken());
            tree.add(new ArrayList<>());
        }
        for (int i = 1; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(stz.nextToken());
            int v = Integer.parseInt(stz.nextToken());
            tree.get(u).add(v);
            tree.get(v).add(u);
        }
        visited[1] = true;
        find(1);
        System.out.println(Math.max(dp[1][1], dp[0][1]));
    }


}
