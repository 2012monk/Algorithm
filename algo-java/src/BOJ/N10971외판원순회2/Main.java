package BOJ.N10971외판원순회2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static int FULL;
    static int n;
    static int[][] graph, dp;
    static int MAX = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stz;
        n = Integer.parseInt(br.readLine());
        graph = new int[n][n];
        FULL = (1 << n) - 1;
        dp = new int[n][1 << n];
        for (int i = 0; i < n; i++) {
            stz = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(stz.nextToken());
            }
        }
        for (int[] d : dp) {
            Arrays.fill(d, -1);
        }
        System.out.println(dfs(0, 1));
    }

    static int dfs(int node, int visited) {
        if (dp[node][visited] != -1) {
            return dp[node][visited];
        }
        if (visited == FULL) {
            return dp[node][visited] = graph[node][0] == 0 ? MAX : graph[node][0];
        }
        dp[node][visited] = MAX;
        for (int i = 0; i < n; i++) {
            int weight = graph[node][i];
            if (weight == 0 || (visited & (1 << i)) != 0) {
                continue;
            }
            dp[node][visited] = Math.min(dp[node][visited],
                weight + dfs(i, visited | (1 << i)));
        }
        return dp[node][visited];
    }
}
